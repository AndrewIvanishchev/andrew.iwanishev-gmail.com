import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/andrew/IdeaProjects/JAVA JDK/webDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpReservedUserNameTest() {
        signUpPage.typeUserName("username");
        String userError = signUpPage.getUserNameErrorText();
        Assert.assertEquals("Username 'username' is unavailable.", userError);
    }

    @Test
    public void signUpNotAvailableUserNameTest() {
        signUpPage.typeUserName("user-");
        String userError2 = signUpPage.getUserNameErrorText();
        Assert.assertEquals("Username may only contain alphanumeric characters or single hyphens, and cannot begin or end with a hyphen. Username user- is not available.", userError2);
    }

    @Test
    public void checkHeading() {
        String headingText = signUpPage.getHeadingText();
        Assert.assertEquals("Create your account", headingText);
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
