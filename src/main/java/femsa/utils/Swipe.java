package femsa.utils;

import femsa.enums.Orientation;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Swipe {

    private Swipe() {
    }

    private static final Logger LOGGER = Logger.getLogger(Swipe.class.getName());

    public static void mobileSwipe(WebDriver facade, Orientation direccion) throws InterruptedException {
        final int ANIMATION_TIME = 500;
        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10;
        PointOption pointOptionStart, pointOptionEnd;


        final HashMap<String, String> scrollObject = new HashMap<String, String>();
        switch (direccion) {
            case DOWN:
                scrollObject.put("direction", "down");
                break;
            case UP:
                scrollObject.put("direction", "up");
                break;
            case LEFT:
                scrollObject.put("direction", "left");
                break;
            case RIGHT:
                scrollObject.put("direction", "right");
                break;
            default:
                throw new IllegalArgumentException("mobileSwipeScreenIOS(): dir: '" + direccion + "' NOT supported");

        }

        if (Validate.isIOS()) {
            try {
                ((WebDriverFacade) facade).executeScript("mobile:swipe", scrollObject);
                Thread.sleep(ANIMATION_TIME);

            } catch (Exception e) {
                LOGGER.severe("mobileSwipeScreenIOS(): FAILED\n" + e.getMessage());
                return;
            }
        } else if (Validate.isAndroid()) {
            WebDriver driver = ((WebDriverFacade) facade).getProxiedDriver();
            Dimension dims = driver.manage().window().getSize();
            pointOptionStart = PointOption.point(((dims.width / 1) - 100), dims.height / 2);

            switch (direccion) {
                case DOWN:
                    pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                    break;
                case UP:
                    pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                    break;
                case LEFT:
                    pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                    break;
                case RIGHT:
                    pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                    break;
                default:
                    throw new IllegalArgumentException("swipeScreen(): dir: '" + direccion + "' NOT supported");
            }
            try {
                new TouchAction((PerformsTouchActions) driver)
                        .press(pointOptionStart)
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                        .moveTo(pointOptionEnd)
                        .release().perform();
            } catch (Exception e) {
                LOGGER.severe("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
                return;
            }
            try {
                Thread.sleep(ANIMATION_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
                LOGGER.log(Level.WARNING,"Interrupted!", e);
                Thread.currentThread().interrupt();
            }
            LOGGER.info("Executing Swipe on Android...");
        }

    }


}
