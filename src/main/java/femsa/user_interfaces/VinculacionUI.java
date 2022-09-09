package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VinculacionUI {
    public static final Target MIENTRAS_LA_APP_ESTA_EN_USO = Target.the("boton Mientras la app esta en uso")
            .locatedForAndroid(By.xpath("//android.widget.Button[@text='Mientras la app est\u00E1 en uso']"))
            .locatedForIOS(By.xpath(""));

    public static final Target SOLO_ESTA_VEZ = Target.the("boton Solo esta vez")
            .locatedForAndroid(By.xpath("//android.widget.Button[@text='Solo esta vez']"))
            .locatedForIOS(By.xpath(""));

    public static final Target DENEGAR = Target.the("boton Denegar")
            .locatedForAndroid(By.xpath("//android.widget.Button[@text='Denegar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target BUSCANDO_DISPOSITIVOS = Target.the("mensaje buscando dispositivos")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Buscando Dispositivo…']"))
            .locatedForIOS(By.xpath(""));

    public static final Target DISPOSITIVOS_ENCONTRADOS = Target.the("mensaje dispositivos encontrados")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Dispositivos encontrados:']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CONECTAR_MPOS = Target.the("boton Conectar")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='BOTTOMSHEET_BUTTON_CONNECT']"))
            .locatedForIOS(By.xpath(""));

    public static final Target VINCULAR_BT = Target.the("boton Vincular Bluetooth")
            .locatedForAndroid(By.id("android:id/button1"))
            .locatedForIOS(By.xpath(""));

    public static final Target CANCELAR_VINCULAR_BT = Target.the("boton Cancelar Vincular Bluetooth")
            .locatedForAndroid(By.id("android:id/button2"))
            .locatedForIOS(By.xpath(""));

    public static final Target VINCULACION_EXITOSA = Target.the("Conexion exitosa")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Conexión exitosa']"))
            .locatedForIOS(By.xpath(""));

    public static final Target BATERIA = Target.the("bateria")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@text='Batería']/following::android.widget.TextView)[1]"))
            .locatedForIOS(By.xpath(""));

    public static final Target NUMERO_SERIE = Target.the("numero de serie")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@text='Número de serie']/following::android.widget.TextView)[1]"))
            .locatedForIOS(By.xpath(""));

    public static final Target VERSION = Target.the("version")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@text='Versión']/following::android.widget.TextView)[1]"))
            .locatedForIOS(By.xpath(""));

    public static final Target BOTON_CONTINUAR = Target.the("boton continuar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Continuar']"))
            .locatedForIOS(By.xpath(""));

}
