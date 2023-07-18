package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
public class WeWantToMeetYouUI {
    public static final Target TITLE = Target.the("Title of the We want to meet you screen")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Queremos conocerte']"))
            .locatedForIOS(By.xpath(""));
    public static final Target NAMES = Target.the("Text edit box to enter the user's name")
            .locatedForAndroid(By.xpath("//android.widget.ScrollView[@content-desc=\"REGISTERDATA_COLUMN_CONTAINER\"]/android.widget.EditText[1]"))
            .locatedForIOS(By.xpath(""));
    public static final Target LASTNAMES = Target.the("Text edit box to enter the user's lastname")
            .locatedForAndroid(By.xpath("//android.widget.ScrollView[@content-desc=\"REGISTERDATA_COLUMN_CONTAINER\"]/android.widget.EditText[2]"))
            .locatedForIOS(By.xpath(""));
    public static final Target EMAIL = Target.the("Text edit box to enter the user's email")
            .locatedForAndroid(By.xpath("//android.widget.ScrollView[@content-desc=\"REGISTERDATA_COLUMN_CONTAINER\"]/android.widget.EditText[3]"))
            .locatedForIOS(By.xpath(""));
    public static final Target BUSINESS_NAME = Target.the("Text edit box for entering the user's business name")
            .locatedForAndroid(By.xpath("//android.widget.ScrollView[@content-desc=\"REGISTERDATA_COLUMN_CONTAINER\"]/android.widget.EditText[4]"))
            .locatedForIOS(By.xpath(""));
    public static final Target BUSINESS_ACTIVITY = Target.the("Text edit box for entering the user's business activity")
            .locatedForAndroid(By.xpath("(//android.view.View[@content-desc=\"REGISTERDATA_DROPDOWNMENU_BUSINESS\"])[1]/android.widget.EditText/android.view.View[2]"))
            .locatedForIOS(By.xpath(""));
    public static final Target ZIP_CODE = Target.the("Text edit box for entering the user's ZIP CODE")
            .locatedForAndroid(By.xpath("//android.widget.ScrollView[@content-desc=\"REGISTERDATA_COLUMN_CONTAINER\"]/android.widget.EditText[5]"))
            .locatedForIOS(By.xpath(""));
    public static final Target CONTINUE = Target.the("Continue button of the We want to meet you screen")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"REGISTERDATA_BUTTON_CONTINUE\"]"))
            .locatedForIOS(By.xpath(""));
}
