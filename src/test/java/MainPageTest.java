import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/andrew/IdeaProjects/JAVA JDK/webDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest(){
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerFailTest() {
        SignUpPage signUpPage = mainPage.register("afadvs", "testemail", "password1234567");
        String mainErrorText = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", mainErrorText);
    }
  /*

  Тут кароч нужно подредачить Хпас для userNameError а то оно его не находит и из за этого тест не срабатывает
   */
    @Test
    public void signUpEmptyUserNameTest(){
        SignUpPage signUpPage = mainPage.register("", "ghbn@.com", "pppppppp2345");
        String userNameError = signUpPage.getEmptyUserNameErrorText();
        Assert.assertEquals("Username can't be blank", userNameError);
    }



    @After
    public void tearDown(){
        driver.close();
    }
}
