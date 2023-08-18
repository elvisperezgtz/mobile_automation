package femsa.tasks;

import femsa.interactions.Hide;
import femsa.user_interfaces.EditBankAccountUI;
import femsa.utils.Validate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;

import static femsa.user_interfaces.CommonsUI.CONTINUE;
import static femsa.user_interfaces.CommonsUI.SAVE;
import static femsa.user_interfaces.EditBusinessDataUI.EDIT;

public class EditBankAccountInformation implements Task {

    private String holder;
    private String clabe;
    private String password;
    private boolean saveChanges;
    private boolean confirmSaveChanges;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(EDIT));
        actor.attemptsTo(Confirm.thePassword(password));
        actor.attemptsTo(
                Check.whether(!holder.isEmpty())
                        .andIfSo(Enter.theValue(holder).into(EditBankAccountUI.ACCOUNT_HOLDER))
        );
        actor.attemptsTo(
                Check.whether(!clabe.isEmpty())
                        .andIfSo(Enter.theValue(clabe).into(EditBankAccountUI.CLABE))
        );
        actor.attemptsTo(
                Check.whether(saveChanges)
                        .andIfSo(
                                Check.whether(Validate.isIOS())
                                        .andIfSo(Hide.theKeyboard()),
                                Click.on(SAVE))
        );
        actor.attemptsTo(
                Check.whether(confirmSaveChanges)
                        .andIfSo(Click.on(CONTINUE))
        );
    }

    public static EditBankAccountInformation with() {
        return Tasks.instrumented(EditBankAccountInformation.class);
    }

    public EditBankAccountInformation confirmPasswordFirst() {
        this.password = OnStage.theActorInTheSpotlight().recall("password");
        return this;
    }

    public EditBankAccountInformation badPassword() {
        this.password = "BadPass123";
        return this;
    }

    public EditBankAccountInformation changingTheHolderFor(String holder) {
        this.holder = holder;
        return this;
    }

    public EditBankAccountInformation withoutChangingTheHolder() {
        this.holder = "";
        return this;
    }

    public EditBankAccountInformation changingTheClabeFor(String clabe) {
        this.clabe = clabe;
        return this;
    }

    public EditBankAccountInformation withoutChangingTheClabe() {
        this.clabe = "";
        return this;
    }

    public EditBankAccountInformation saveChanges(boolean saveChanges) {
        this.saveChanges = saveChanges;
        return this;
    }

    public EditBankAccountInformation confirmSaveChanges(boolean confirmSaveChanges) {
        this.confirmSaveChanges = confirmSaveChanges;
        return this;
    }

}
