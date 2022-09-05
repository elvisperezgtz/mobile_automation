package femsa.utils;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

public class Swipe {

    public static void down(WebDriver facade) {

        WebDriver driver = ((WebDriverFacade) facade).getProxiedDriver();
        TouchAction actions = new TouchAction((PerformsTouchActions) driver);

        int puntoInicialX = facade.manage().window().getSize().width / 2;
        int puntoInicialY = (int) (facade.manage().window().getSize().height * 0.8);
        int puntoFinalY = facade.manage().window().getSize().height / 2;

        actions
                .longPress(PointOption.point(puntoInicialX, puntoInicialY))
                .moveTo(PointOption.point(puntoInicialX, puntoFinalY))
                .release()
                .perform();

    }

    public static void up(WebDriver facade) {

        WebDriver driver = ((WebDriverFacade) facade).getProxiedDriver();
        TouchAction actions = new TouchAction((PerformsTouchActions) driver);

        int puntoInicialX = facade.manage().window().getSize().width / 2;
        int puntoInicialY = facade.manage().window().getSize().height / 2;
        int puntoFinalY = (int) (facade.manage().window().getSize().height * 0.8);

        actions
                .longPress(PointOption.point(puntoInicialX, puntoInicialY))
                .moveTo(PointOption.point(puntoInicialX, puntoFinalY))
                .release()
                .perform();

    }

    public static void leftToRight(WebDriver facade) {

        WebDriver driver = ((WebDriverFacade) facade).getProxiedDriver();
        TouchAction actions = new TouchAction((PerformsTouchActions) driver);

        int puntoInicialX = (int) (facade.manage().window().getSize().width -50);
        int puntoInicialY = facade.manage().window().getSize().height /2;
        int puntoFinalX = (int) (facade.manage().window().getSize().width * 0.1);;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions
                .press(PointOption.point(puntoInicialX, puntoInicialY))
                .moveTo(PointOption.point(puntoFinalX, puntoInicialY))
                .release()
                .perform();

    }

}
