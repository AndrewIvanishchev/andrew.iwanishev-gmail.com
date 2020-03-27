import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
   private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

   private By LoginField = By.xpath("//input[@id='login_field']");
   private By PasswordField = By.xpath("//input[@id='password']");
   private By SignInButton = By.xpath("//input[@type='submit']");
   private By heading = By.xpath("//div[contains(@class, 'auth-form-header p-0')]/h1");
   private By error = By.xpath("//div[@id='js-flash-container']//div[@class='container-lg px-2']");
   private By createAnAccout = By.xpath("//a[text()='Create an account']");

   public LoginPage typeUserName(String username) {
       driver.findElement(LoginField).sendKeys(username);
       return this;
   }

    public LoginPage typePassword(String password) {
        driver.findElement(PasswordField).sendKeys(password);
        return this;
    }

    public LoginPage clickSignInButton() {
        driver.findElement(SignInButton).click();
        return this;
    }

    public LoginPage loginWithInvalidCreds(String username, String password) {
       this.typeUserName(username);
       this.typePassword(password);
       this.clickSignInButton();
       return new LoginPage(driver);
    }

    public String getHeadingText(){
       return driver.findElement(heading).getText();
    }

    public String getErrorText(){
       return  driver.findElement(error).getText();
    }

    public SignUpPage createAccount(){
       driver.findElement(createAnAccout).click();
       return new SignUpPage(driver);
    }
}
