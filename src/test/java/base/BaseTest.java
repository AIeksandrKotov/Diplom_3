package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    public WebDriver driver;

    @Before
    public void setUp() {
        // У меня опять ошибка с chrome, не запускается и все, все тесты выполнял на edge браузере


       /* WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\bin\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver.manage().window().maximize();
        LoginPage objMainPage = new LoginPage(driver);*/


        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options);
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
