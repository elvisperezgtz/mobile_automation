package femsa.user_interfaces.wallet;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IntroTutorialUI {

    private IntroTutorialUI() {
    }

    public static final Target CONTINUE = Target.the("Continue intro")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Continuar']"))
            .locatedForIOS(By.name(""));

    public static final Target START = Target.the("Start intro")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Iniciar']"))
            .locatedForIOS(By.name(""));

    public static final Target TITLE = Target.the("Intro title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Conoce tu app']"))
            .locatedForIOS(By.name(""));

    public static final Target SALES_OF_THE_DAY = Target.the("Intro subtitle")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@text='Ventas del dia'])[2]"))
            .locatedForIOS(By.name(""));

    public static final Target SALES_OF_THE_DAY_EXPLANATION = Target.the("Sales of the day explanation")
            .locatedForAndroid(By.xpath("//android.widget.ScrollView[@content-desc=\"ONBOARDING_TEXT_SUBTITLE\"]"))
            .locatedForIOS(By.name(""));

    public static final Target IN_TRANSIT_TO_BANK_ACCOUNT = Target.the("In transit to bank account title")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ONBOARDING_COLUMN_PAGES\"]/android.widget.TextView[2]"))
            .locatedForIOS(By.name(""));

    public static final Target IN_TRANSIT_TO_BANK_ACCOUNT_EXPLANATION = Target.the("In transit to bank account explanation")
            .locatedForAndroid(By.xpath("//android.widget.ScrollView[@content-desc=\"ONBOARDING_TEXT_SUBTITLE\"]"))
            .locatedForIOS(By.name(""));


    public static final Target GROW_YOUR_BUSINESS = Target.the("Grow your business title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"ONBOARDING_TEXT_SUBTITLE\"]"))
            .locatedForIOS(By.name(""));

    public static final Target GROW_YOUR_BUSINESS_EXPLANATION = Target.the("Grow your business explanation")
            .locatedForAndroid(By.xpath("//android.widget.ScrollView[@content-desc=\"ONBOARDING_TEXT_SUBTITLE\"]"))
            .locatedForIOS(By.name(""));

}
