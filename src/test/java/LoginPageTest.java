import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/andrew/IdeaProjects/JAVA JDK/webDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyCredsTest(){
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("", "");
        String mainError = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", mainError);
    }

    @Test
    public void loginWithIncorrectCredsTest(){
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("ibragim", "hyumorjoviyy");
        String mainError = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", mainError);
    }

    @Test
    public void goToSingUpPageTest(){
        SignUpPage signUpPage = loginPage.createAccount();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Create your account", heading);

    }

    @After
    public void tearDown(){
        driver.close();
    }
}
