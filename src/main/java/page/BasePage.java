package page;

import api.Endpoints;
import org.openqa.selenium.WebDriver;

public class BasePage extends Endpoints {
    private static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}

