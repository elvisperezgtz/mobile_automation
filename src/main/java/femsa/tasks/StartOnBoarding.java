package femsa.tasks;

import femsa.models.User;
import femsa.utils.Decoder;
import femsa.utils.database.Read;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import java.sql.SQLException;
import java.util.Objects;

import static femsa.user_interfaces.EnterYourPhoneNumberUI.SEND_CODE;

public class StartOnBoarding implements Task {

    private User user;


    public StartOnBoarding(User user) {
        this.user = user;
    }

    @Override
    @Step("{0} starts his on boarding ")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                FillOutTheFormEnterYourPhoneNumber
                        .with()
                        .phoneNumber(Objects.requireNonNull(user).getPhoneNumber())
                        .acceptTermsAndCondition(true),
                Click.on(SEND_CODE)
        );
        try {
            actor.attemptsTo(
                    EnterThe
                            .verificationCodeWith()
                            .verificationCode(Read.otpFromDataBase(user.getPhoneNumber()))

            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                CompleteTheCreateYouPassword
                        .with()
                        .password(Decoder.decode(user.getCredentials().getPassword()))
                        .passwordDisplayButton(true)
                        .continueButton(true)
        );
        actor.remember("password",Decoder.decode(user.getCredentials().getPassword()));
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser(user.getFirstName())
                        .lastNameUser(user.getLastName())
                        .emailUser(user.getEmail())
                        .businessName(user.getMerchantInfo().getMerchantName())
                        .businessActivity(user.getMerchantInfo().getMerchantActivity())
                        .zipCode(user.getMerchantInfo().getPostalCode())
                        .continueButton(true)
        );
        actor.attemptsTo(
                Skip.linkingDeviceProcess()
        );
        actor.attemptsTo(
                Add
                        .bankAccountInformationWith()
                        .holder(user.getBankInformation().getAccountHolder())
                        .interbankClabe(user.getBankInformation().getClabe())
                        .andContinueSaving(true)
                        .addConfirmContinueSaving(true)
        );


    }

    public static StartOnBoarding withHisInformation(User user) {
        return Tasks.instrumented(StartOnBoarding.class, user);
    }

}
