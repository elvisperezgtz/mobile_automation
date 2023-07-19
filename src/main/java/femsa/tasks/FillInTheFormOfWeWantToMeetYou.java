package femsa.tasks;

import femsa.interactions.Hide;
import femsa.interactions.SelectFromDropDown;
import femsa.interactions.SwipeFrom;
import femsa.user_interfaces.WeWantToMeetYouUI;
import femsa.utils.Validate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillInTheFormOfWeWantToMeetYou implements Task {
    private String namesUser;
    private String lastnameUser;
    private String emailUser;
    private String businessName;
    private String businessActivity;
    private String zipCode;
    private boolean continueButton;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(WeWantToMeetYouUI.TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Click.on(WeWantToMeetYouUI.NAMES).then(Enter.theValue(namesUser).into(WeWantToMeetYouUI.NAMES)),
                Hide.theKeyboard(),
                Click.on(WeWantToMeetYouUI.LASTNAMES).then(Enter.theValue(lastnameUser).into(WeWantToMeetYouUI.LASTNAMES)),
                Hide.theKeyboard(),
                Click.on(WeWantToMeetYouUI.EMAIL).then(Enter.theValue(emailUser).into(WeWantToMeetYouUI.EMAIL)),
                Hide.theKeyboard()
        );
        actor.attemptsTo(
                Click.on(WeWantToMeetYouUI.BUSINESS_NAME).then(Enter.theValue(businessName).into(WeWantToMeetYouUI.BUSINESS_NAME)),
                Hide.theKeyboard(),
                Check.whether(Validate.isAndroid())
                        .andIfSo(SelectFromDropDown.byVisibleText(WeWantToMeetYouUI.BUSINESS_ACTIVITY, businessActivity))
                        .otherwise(Click.on(WeWantToMeetYouUI.BUSINESS_ACTIVITY).then(Hide.theKeyboard())),
                Click.on(WeWantToMeetYouUI.ZIP_CODE).then(Enter.theValue(zipCode).into(WeWantToMeetYouUI.ZIP_CODE)),
                Hide.theKeyboard()
        );
        actor.attemptsTo(
                SwipeFrom.upToDown(),
                Check.whether(continueButton)
                        .andIfSo(Click.on(WeWantToMeetYouUI.CONTINUE))
        );
    }
    public static FillInTheFormOfWeWantToMeetYou with() {
        return Tasks.instrumented(FillInTheFormOfWeWantToMeetYou.class);
    }

    public FillInTheFormOfWeWantToMeetYou namesUser (String namesUser){
        this.namesUser = namesUser;
        return this;
    }
    public FillInTheFormOfWeWantToMeetYou lastnameUser (String lastnameUser){
        this.lastnameUser = lastnameUser;
        return this;
    }
    public FillInTheFormOfWeWantToMeetYou emailUser (String emailUser){
        this.emailUser = emailUser;
        return this;
    }
    public FillInTheFormOfWeWantToMeetYou businessActivity (String businessActivity){
        this.businessActivity = businessActivity;
        return this;
    }
    public FillInTheFormOfWeWantToMeetYou businessName (String businessName){
        this.businessName = businessName;
        return this;
    }
    public FillInTheFormOfWeWantToMeetYou zipCode (String zipCode){
        this.zipCode = zipCode;
        return this;
    }
    public FillInTheFormOfWeWantToMeetYou continueButton (boolean continueButton){
        this.continueButton = continueButton;
        return this;
    }

}
