package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CobroUI {
    public static final Target MONTO = Target.the("campo monto")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath(""));

    public static final Target ESCRIBE_EL_CONCEPTO = Target.the("boton Escribe el concepto")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name='Escribe el concepto']"));

    public static final Target CONCEPTO_VENTA = Target.the("campo Concepto")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath("//XCUIElementTypeTextField[@name='SALECONCEPT_CONCEPT_TEXTFIELD']"));

    public static final Target GUARDAR = Target.the("boton guardar")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='SALECONCEPT_SAVE_BUTTON']"));

    public static final Target COBRAR = Target.the("boton Cobrar")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='COLLECT_COLLECT_BUTTON']"));

    public static final Target TARJETA_BLOQUEADA = Target.the("titulo Tarjeta bloquada")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name='Tarjeta bloqueada']"));

    public static final Target VOLVER_A_INTENTAR = Target.the("boton Volver a intentar")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='Volver a intentar']"));

    public static final Target CANCELAR = Target.the("boton Cancelar")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name='Cancelar']"));


}
