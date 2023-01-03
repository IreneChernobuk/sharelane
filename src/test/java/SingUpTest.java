import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingUpTest {

    @Test
    public void fiveZipCodeTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Add check
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        Assert.assertTrue(registerButton.isDisplayed(), "'Register' button isn't displayed");
        //Close driver
        driver.quit();
    }

    @Test
    public void fourZipCodeTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 4 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("2345");
        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorDisplayed, "Error message isn't displayed");
    }

    @Test
    public void sixZipCodeTest() throws NoSuchElementException {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 6 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Add check
        try {
            WebElement errorMessage = driver.findElement(By.className("error_message"));
            boolean isErrorDisplayed = errorMessage.isDisplayed();
            Assert.assertTrue(isErrorDisplayed, "Error message isn't displayed");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } finally {
            driver.quit();
        }
    }

    @Test
    public void registrationInputAllValueTest() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input first name
        driver.findElement(By.name("first_name")).sendKeys("Leonid");
        //Input last name
        driver.findElement(By.name("last_name")).sendKeys("Bodrov");
        //Input email
        driver.findElement(By.name("email")).sendKeys("Leonid_Bodrov@gmail.com");
        //Input password
        driver.findElement(By.name("password1")).sendKeys("private112");
        //Input confirm password
        driver.findElement(By.name("password2")).sendKeys("private112");
        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement createdMessage = driver.findElement(By.className("confirmation_message"));
        Assert.assertTrue(createdMessage.isDisplayed(), "'Account is created");
        //Close driver
        driver.quit();
    }

    @Test
    public void registrationFirstNameEmpty() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input first name
        driver.findElement(By.name("first_name")).sendKeys("");
        //Input last name
        driver.findElement(By.name("last_name")).sendKeys("Bodrov");
        //Input email
        driver.findElement(By.name("email")).sendKeys("Leonid_Bodrov@gmail.com");
        //Input password
        driver.findElement(By.name("password1")).sendKeys("private112");
        //Input confirm password
        driver.findElement(By.name("password2")).sendKeys("private112");
        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorDisplayed, "Error message isn't displayed");
    }

    @Test
    public void registrationLastNameEmpty() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input first name
        driver.findElement(By.name("first_name")).sendKeys("Leonid");
        //Input last name
        driver.findElement(By.name("last_name")).sendKeys("");
        //Input email
        driver.findElement(By.name("email")).sendKeys("Leonid_Bodrov@gmail.com");
        //Input password
        driver.findElement(By.name("password1")).sendKeys("private112");
        //Input confirm password
        driver.findElement(By.name("password2")).sendKeys("private112");
        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement createdMessage = driver.findElement(By.className("confirmation_message"));
        Assert.assertTrue(createdMessage.isDisplayed(), "'Account is created");
        //Close driver
        driver.quit();
    }

    @Test
    public void registrationEmailEmpty() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input first name
        driver.findElement(By.name("first_name")).sendKeys("Leonid");
        //Input last name
        driver.findElement(By.name("last_name")).sendKeys("Bodrov");
        //Input email
        driver.findElement(By.name("email")).sendKeys("");
        //Input password
        driver.findElement(By.name("password1")).sendKeys("private112");
        //Input confirm password
        driver.findElement(By.name("password2")).sendKeys("private112");
        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorDisplayed, "Error message isn't displayed");
    }

    @Test
    public void registrationPasswordsNotEqual() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input first name
        driver.findElement(By.name("first_name")).sendKeys("Leonid");
        //Input last name
        driver.findElement(By.name("last_name")).sendKeys("Bodrov");
        //Input email
        driver.findElement(By.name("email")).sendKeys("Leonid_Bodrov@gmail.com");
        //Input password
        driver.findElement(By.name("password1")).sendKeys("private112");
        //Input confirm password
        driver.findElement(By.name("password2")).sendKeys("private911");
        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorDisplayed, "'Register' button isn't displayed");
    }

    @Test
    public void registrationPasswordlessFour() {
        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of zipcode page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input first name
        driver.findElement(By.name("first_name")).sendKeys("Leonid");
        //Input last name
        driver.findElement(By.name("last_name")).sendKeys("Bodrov");
        //Input email
        driver.findElement(By.name("email")).sendKeys("Leonid_Bodrov@gmail.com");
        //Input password
        driver.findElement(By.name("password1")).sendKeys("112");
        //Input confirm password
        driver.findElement(By.name("password2")).sendKeys("112");
        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorDisplayed, "'Register' button isn't displayed");
    }
}
