package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

//todo Mapear los objetos
public class DatosPersonalesUI {

    public static final Target TITULO = Target.the("titulo Queremos conocerte")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Queremos conocerte']"))
            .locatedForIOS(By.xpath(""));

    public static final Target NOMBRES = Target.the("campo nombres")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(By.xpath(""));

    public static final Target PRIMER_APELLIDO = Target.the("campo primer apellido")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target EMAIL = Target.the("campo email")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[3]"))
            .locatedForIOS(By.xpath(""));

    public static final Target NOMBRE_DE_TU_NEGOCIO = Target.the("campo nombre de tu negocio")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[4]"))
            .locatedForIOS(By.xpath(""));

    public static final Target ACTIVIDAD_DE_TU_NEGOCIO = Target.the("dropdown actividad de tu negocio")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[5]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CODIGO_POSTAL = Target.the("campo codigo postal")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[6]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CONTINUAR = Target.the("boton continuar")
            .locatedForAndroid(By.className("android.widget.Button"))
            .locatedForIOS(By.xpath(""));
}
