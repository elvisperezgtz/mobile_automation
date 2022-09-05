package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PasswordUI {
    public static final Target CONTRASENIA = Target.the("Campo contrasenia")
            .locatedForAndroid(By.className("android.widget.EditText"))
            .locatedForIOS(By.xpath(""));

   public static final Target TITULO = Target.the("Campo contrasenia")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Crea tu contrase\u00F1a']"))
            .locatedForIOS(By.xpath(""));

    public static final Target VALIDACION_8_CARACTERES = Target.the("validacion 8 caracteres")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath("//android.widget.TextView[@text='8 caracteres (letras y números)']"));

    public static final Target VALIDACION_NUMERO = Target.the("validacion numeros")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Un número']"))
            .locatedForIOS(By.xpath(""));

    public static final Target VALIDACION_MAYUSCULA = Target.the("validacion mayuscula")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Una mayúscula']"))
            .locatedForIOS(By.xpath(""));

    public static final Target VALIDACION_MINUSCULA = Target.the("validacion minuscula")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Una minúscula']"))
            .locatedForIOS(By.xpath(""));

    public static final Target BOTON_REVELAR = Target.the("boton revelar contraseña")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='CREATEPASSWORD_COLUMN']/android.widget.EditText/android.view.View[2]/android.widget.CheckBox"))
            .locatedForIOS(By.xpath(""));

    public static final Target BOTON_CONTINUAR = Target.the("boton continuar")
            .locatedForAndroid(By.className("android.widget.Button"))
            .locatedForIOS(By.xpath(""));

    public static final Target VALIDACIONES = Target.the("check validaciones")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='CREATEPASSWORD_COLUMN']/android.view.View[2]/android.widget.ImageView"))
            .locatedForIOS(By.xpath(""));

}
