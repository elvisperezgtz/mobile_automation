package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AdministracionPerilUI {

    public static final Target CLABE = Target.the("boton Clabe")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@content-desc='TEXT_TITLE'])[2]"))
            .locatedForIOS(By.xpath("(//XCUIElementTypeButton[@name=\" \"])[2]"));

    public static final Target DOCUMENTOS_LEGALES = Target.the("boton Documentos Legales")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Documentos legales']"))
            .locatedForIOS(By.xpath("(//XCUIElementTypeImage[@name=\"continuePurple\"])[2]"));

    public static final Target CERRAR_SESION = Target.the("boton cerrar sesion")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Cerrar sesión']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='Cerrar sesión']"));

    public static final Target CANCELAR = Target.the("boton cancelar cerrar sesion")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='CANCELAR']"))
            .locatedForIOS(By.xpath(""));

    public static final Target SI_CERRAR_SESION = Target.the("boton Si cerrar sesion")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='SÍ, CERRAR SESIÓN']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='Si, cerrar sesión']"));

    public static final Target AYUDA = Target.the("boton Ayuda")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@content-desc='TEXT_TITLE'])[3]"))
            .locatedForIOS(By.xpath("(//XCUIElementTypeButton[@name=\" \"])[3]"));

    public static final Target PREGUNTAS_FRECUENTES = Target.the("titulo Preguntas Frecuentes")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@text='Preguntas frecuentes'])[2]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name='Preguntas frecuentes']"));

    public static final Target EDITAR = Target.the("boton editar Datos Personales")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Editar']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name='Editar']"));

    public static final Target NEGOCIO = Target.the("boton Negocio")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Negocio']"))
            .locatedForIOS(By.xpath("(//XCUIElementTypeButton[@name=\" \"])[1]"));

}