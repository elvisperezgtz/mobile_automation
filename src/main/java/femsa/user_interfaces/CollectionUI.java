package femsa.user_interfaces;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
public class CollectionUI {
    public static final Target PURCHASE_ORDER_BUTTON  = Target.the("Purchase order button")
            .locatedForAndroid(By.xpath("(//android.widget.TextView)[5]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"COLLECT_CONCEPT_BTN\"]"));
    public static final Target ENTER_AMOUNT_TITLE  = Target.the("Title of the collection screen 'enter amount'")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Ingresa el monto']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"COLLECT_TITLE_LABEL\"]"));
    public static final Target PURCHASE_ORDER_TEXTEDIT  = Target.the("Purchase order text box")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeOther[@name=\"SALECONCEPT_CONCEPT_TEXTFIELD\"]/XCUIElementTypeTextField"));
    public static final Target SAVE_PURCHASE_ORDER  = Target.the("Button to save the purchase order text")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Guardar']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"SALECONCEPT_SAVE_BTN\"]"));
    public static final Target COLLECTION_BUTTON  = Target.the("Collection button with the value")
            .locatedForAndroid(By.xpath("(//android.view.View)[10]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"COLLECT_COLLECT_BTN\"]"));

}
