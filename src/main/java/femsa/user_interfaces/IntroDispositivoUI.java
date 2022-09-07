package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IntroDispositivoUI {
    public static final Target YA_LO_TENGO = Target.the("boton Ya lo tengo")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Ya lo tengo']"))
            .locatedForIOS(By.xpath(""));

 public static final Target AUN_NO_LO_TENGO = Target.the("boton Aun no lo tengo")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Aún no lo tengo']"))
            .locatedForIOS(By.xpath(""));

 public static final Target TITULO = Target.the("titulo Ya cuentas con tu dispositivo de cobro?")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc='TEXT_TITLE']"))
            .locatedForIOS(By.xpath(""));

 public static final Target ENCIENDE_DISPOSITIVO = Target.the("titulo Enciende tu dispositivo")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc='TEXT_TITLE']"))
            .locatedForIOS(By.xpath(""));

 public static final Target CONECTAR_DISPOSITIVO = Target.the("boton Conectar mi dispositivo")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Conectar mi dispositivo']"))
            .locatedForIOS(By.xpath(""));

 public static final Target CONECTAR_MAS_TARDE = Target.the("boton Conectar más tarde")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Conectar más tarde']"))
            .locatedForIOS(By.xpath(""));

 public static final Target TIENDA_EN_LINEA = Target.the("boton Tienda en linea")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='DONGLE_BUTTON_GETIT_SHOP_ONLINE']"))
            .locatedForIOS(By.xpath(""));

 public static final Target HACERLO_MAS_TARDE = Target.the("boton Hacerlo más tarde")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='DONGLE_BUTTON_GETIT_LATER']"))
            .locatedForIOS(By.xpath(""));

 public static final Target TITULO_SOLICITUD_ACTIVACION_BT = Target.the("titulo solicitud enciende Bluetooth")
            .locatedForAndroid(By.id("android:id/message"))
            .locatedForIOS(By.xpath(""));

 public static final Target PERMITIR_ACTIVACION_BT = Target.the("boton Permitir")
            .locatedForAndroid(By.id("android:id/button1"))
            .locatedForIOS(By.xpath(""));

 public static final Target TITULO_PERMITIR_UBICACION = Target.the("mensaje activar ubicacion")
            .locatedForAndroid(By.id("com.android.permissioncontroller:id/permission_message"))
            .locatedForIOS(By.xpath(""));

}
