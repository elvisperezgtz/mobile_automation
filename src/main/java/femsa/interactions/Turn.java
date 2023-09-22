package femsa.interactions;

import net.serenitybdd.screenplay.Tasks;

public class Turn {
    public static OnTheWifi onTheWifi(String deviceName) {
        return Tasks.instrumented(OnTheWifi.class, deviceName);
    }

    public static OffTheWifi offTheWifi (String deviceName){
        return Tasks.instrumented(OffTheWifi.class, deviceName);
    }
}
