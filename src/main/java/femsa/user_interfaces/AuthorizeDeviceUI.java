package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AuthorizeDeviceUI {
    public static final Target START = Target.the("start button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Comenzar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target DEVICES_FOUND = Target.the("Devices found modal title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Dispositivos encontrados:']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CONNECT = Target.the("connect device button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Conectar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target SEARCH_AGAIN = Target.the("Search again button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Buscar de nuevo']"))
            .locatedForIOS(By.xpath(""));

    public static final Target LINKED_DEVICE = Target.the("Linked device title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Dispositivo vinculado']"))
            .locatedForIOS(By.xpath(""));

    public static final Target BATTERY = Target.the("Battery")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Batería']"))
            .locatedForIOS(By.xpath(""));

    public static final Target SERIAL_NUMBER = Target.the("Serial number")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Número de serie']"))
            .locatedForIOS(By.xpath(""));

    public static final Target VERSION = Target.the("Version")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Versión']"))
            .locatedForIOS(By.xpath(""));

    public static final Target AUTHORIZE_DEVICE_BUTTON = Target.the("Authorize device button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Autorizar dispositivo']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CLOSE = Target.the("Close button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Cerrar']"))
            .locatedForIOS(By.xpath(""));
}
