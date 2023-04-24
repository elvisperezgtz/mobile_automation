package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EditBankAccountUI {
    public static final Target ACCOUNT_HOLDER = Target.the("Holer name")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(By.xpath("(//XCUIElementTypeTextField)[1]"));

    public static final Target CLABE = Target.the("Clabe")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[2]"))
            .locatedForIOS(By.xpath("(//XCUIElementTypeTextField)[2]"));

    public static final Target CONTINUAR = Target.the("boton Continuar")
            .locatedForAndroid(By.xpath("(//android.widget.Button)[1]"))
            .locatedForIOS(By.xpath(""));


    public static final Target CANCELAR = Target.the("boton Cancelar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'Cancelar')]"))
            .locatedForIOS(By.xpath(""));

    public static final Target ACEPTAR = Target.the("boton Aceptar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'Aceptar')]"))
            .locatedForIOS(By.xpath(""));

    public static final Target TITULO = Target.the("titulo Ya casi terminas")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'Ya casi')]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CONFIRMAR = Target.the("boton Confirmar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'CONFIRMAR')]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CLABE_MUST_HAVE_18_DIGITS =Target.the("The CLABE must have 18 digits")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text,'La Clabe debe tener 18 dígitos']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"La CLABE debe tener 18 dígitos\"]"));
}
