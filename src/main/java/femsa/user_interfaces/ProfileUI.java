package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProfileUI {

    public static final Target CLABE = Target.the("Clabe option")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@content-desc='TEXT_TITLE'])[2]"))
            .locatedForIOS(By.xpath("(//XCUIElementTypeButton[@name=\" \"])[2]"));

    public static final Target LOGO = Target.the("Logo")
            .locatedForAndroid(By.xpath("(//android.widget.TextView)[1]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"PROFILE_INITIALNAME_LABEL\"]"));

    public static final Target LEGAL_DOCUMENTS = Target.the("Legal documents button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Documentos legales']"))
            .locatedForIOS(By.name("Documentos legales"));

    public static final Target HELP = Target.the("Help button")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@content-desc='TEXT_TITLE'])[3]"))
            .locatedForIOS(By.xpath("(//XCUIElementTypeButton[@name=\" \"])[3]"));

    public static final Target PREGUNTAS_FRECUENTES = Target.the("titulo Preguntas Frecuentes")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@text='Preguntas frecuentes'])[2]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name='Preguntas frecuentes']"));

    public static final Target EDIT_INFORMATION = Target.the("Edit information")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Editar']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"Editar\"]"));

    public static final Target BUSINESS = Target.the("Business button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Negocio']"))
            .locatedForIOS(By.xpath("(//XCUIElementTypeButton[@name=\" \"])[1]"));

    public static final Target PROFILE_TITLE = Target.the("Profile title")
            .locatedForAndroid(By.xpath("(//android.widget.TextView)[2]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"PROFILE_USERNAME_LABEL\"]"));

    public static final Target PROFILE_PHONE_NUMBER = Target.the("Numero de telefono")
            .locatedForAndroid(By.xpath("(//android.widget.TextView)[3]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"PROFILE_USERNUMBER_LABEL\"]"));

    public static final Target AUTHORIZE_DEVICE = Target.the("Authorize device option")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@content-desc=\"TEXT_TITLE\"])[4]"))
            .locatedForIOS(By.name("Autorizar dispositivo"));

    public static final Target LOGOUT = Target.the("Logout")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Cerrar sesión']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"Cerrar sesión\"]"));

}
