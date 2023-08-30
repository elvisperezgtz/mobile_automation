package femsa.utils;

import femsa.enums.SwipeDirection;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class W3CSwipeUtils {

    private static final Logger LOGGER = Logger.getLogger(W3CSwipeUtils.class.getName());
    public static final int BORDER_X = 30;
    public static final int BORDER_Y = 30;

    static PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    public static void swipe(SwipeDirection direction ) {

        AppiumDriver driver = null;

        if (Boolean.TRUE.equals(Validate.isAndroid())){
            driver = GetProxiesDriver.forAndroid();
        }else if (Boolean.TRUE.equals(Validate.isIOS())){
            driver = GetProxiesDriver.forIos();
        }
        Sequence swipe = new Sequence(finger, 1);

        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;

        switch (direction) {
            case SWIPE_RIGHT -> {
                LOGGER.info("Executing swipe right");
                startX = BORDER_X;
                startY = driver.manage().window().getSize().getHeight() / 2;
                endX = driver.manage().window().getSize().getWidth() - BORDER_X;
                endY = driver.manage().window().getSize().getHeight() / 2;
            }
            case SWIPE_LEFT -> {
                LOGGER.info("Executing swipe left");
                startX = driver.manage().window().getSize().getWidth() - BORDER_X;
                startY = driver.manage().window().getSize().getHeight() / 2;
                endX = BORDER_X;
                endY = driver.manage().window().getSize().getHeight() / 2;
            }
            case SWIPE_DOWN -> {
                LOGGER.info("Executing swipe down");
                startX = driver.manage().window().getSize().getWidth() / 2;
                startY = BORDER_Y;
                endX = driver.manage().window().getSize().getWidth() / 2;
                endY = driver.manage().window().getSize().getHeight() - BORDER_Y;
            }
            case SWIPE_UP -> {
                LOGGER.info("Executing swipe up");
                startX = driver.manage().window().getSize().getWidth() / 2;
                startY = driver.manage().window().getSize().getHeight() - BORDER_Y;
                endX = driver.manage().window().getSize().getWidth() / 2;
                endY = BORDER_Y;
            }
            default -> LOGGER.info("Fail executing swipe");
        }
        swipe.addAction(
                finger.createPointerMove(Duration.ofSeconds(0),
                PointerInput.Origin.viewport(), startX, startY)
        );
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(swipe));
    }

    public void tap(int x, int y) {
        AppiumDriver driver = GetProxiesDriver.forAndroid();
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(tap));
    }

}