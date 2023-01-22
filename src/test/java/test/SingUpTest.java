package test;

import com.github.javafaker.Faker;
import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.FakeMessageGenerator;
import utils.PropertyManager;

import static constants.Urls.REGISTER_FORM_URL;

public class SingUpTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //Open Chrome browser
        PropertyManager propertyManager = new PropertyManager();
        propertyManager.loadData();
        System.setProperty("webdriver.chrome.driver", propertyManager.get("PATH_TO_DRIVER"));
        driver = new ChromeDriver();
    }
    private void sendZipCode(String zipCode) {
        //Open url of zipcode page
        driver.get(Urls.REGISTER_FORM_URL);
        //Input 4 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys(zipCode);
        //Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
    }
    @Test
    public void fiveZipCodeTest() {
        sendZipCode(FakeMessageGenerator.generateFiveZipCode());
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        Assert.assertTrue(registerButton.isDisplayed(), "'Register' button isn't displayed");
    }
    @Test
    public void fourZipCodeTest() {
        sendZipCode(FakeMessageGenerator.generateFourZipCode());
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Error message isn't displayed");
    }
    @Test
    public void sixZipCodeTest() throws NoSuchElementException {
        sendZipCode(FakeMessageGenerator.generateSixZipCode());
        //Add check
        try {
            WebElement errorMessage = driver.findElement(By.className("error_message"));
            boolean isErrorDisplayed = errorMessage.isDisplayed();
            Assert.assertTrue(isErrorDisplayed, "Error message isn't displayed");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void registrationInputAllValueTest() {
        sendZipCode(FakeMessageGenerator.generateFiveZipCode());
        //Input first name
        driver.findElement(By.name("first_name")).sendKeys(FakeMessageGenerator.generateFirstName());
        //Input last name
        driver.findElement(By.name("last_name")).sendKeys(FakeMessageGenerator.generateLastName());
        //Input email
        driver.findElement(By.name("email")).sendKeys(FakeMessageGenerator.generateEmail());
        //Input password
        String password = FakeMessageGenerator.generatePassword();
        driver.findElement(By.name("password1")).sendKeys(password);
        //Input confirm password
        driver.findElement(By.name("password2")).sendKeys(password);
        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement createdMessage = driver.findElement(By.className("confirmation_message"));
        Assert.assertTrue(createdMessage.isDisplayed(), "'Account is created");
    }
    @Test
    public void registrationFirstNameEmpty() {
        sendZipCode(FakeMessageGenerator.generateFiveZipCode());
        //Input first name
        driver.findElement(By.name("first_name")).sendKeys("");
        //Input last name
        driver.findElement(By.name("last_name")).sendKeys(FakeMessageGenerator.generateLastName());
        //Input email
        driver.findElement(By.name("email")).sendKeys(FakeMessageGenerator.generateEmail());
        //Input password
        String password = FakeMessageGenerator.generatePassword();
        driver.findElement(By.name("password1")).sendKeys(password);
        //Input confirm password
        driver.findElement(By.name("password2")).sendKeys(password);
        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Error message isn't displayed");
    }
    @Test
    public void registrationLastNameEmpty() {
        sendZipCode(FakeMessageGenerator.generateFiveZipCode());
        //Input first name
        driver.findElement(By.name("first_name")).sendKeys(FakeMessageGenerator.generateFirstName());
        //Input last name
        driver.findElement(By.name("last_name")).sendKeys("");
        //Input email
        driver.findElement(By.name("email")).sendKeys(FakeMessageGenerator.generateEmail());
        //Input password
        String password = FakeMessageGenerator.generatePassword();
        driver.findElement(By.name("password1")).sendKeys(password);
        //Input confirm password
        driver.findElement(By.name("password2")).sendKeys(password);
        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement createdMessage = driver.findElement(By.className("confirmation_message"));
        Assert.assertTrue(createdMessage.isDisplayed(), "'Account is created");
    }
    @Test
    public void registrationEmailEmpty() {
        sendZipCode(FakeMessageGenerator.generateFiveZipCode());
        //Input first name
        driver.findElement(By.name("first_name")).sendKeys(FakeMessageGenerator.generateFirstName());
        //Input last name
        driver.findElement(By.name("last_name")).sendKeys(FakeMessageGenerator.generateLastName());
        //Input email
        driver.findElement(By.name("email")).sendKeys("");
        //Input password
        String password = FakeMessageGenerator.generatePassword();
        driver.findElement(By.name("password1")).sendKeys(password);
        //Input confirm password
        driver.findElement(By.name("password2")).sendKeys(password);
        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Error message isn't displayed");
    }
    @Test
    public void registrationPasswordsNotEqual() {
        sendZipCode(FakeMessageGenerator.generateFiveZipCode());
        //Input first name
        driver.findElement(By.name("first_name")).sendKeys(FakeMessageGenerator.generateFirstName());
        //Input last name
        driver.findElement(By.name("last_name")).sendKeys(FakeMessageGenerator.generateLastName());
        //Input email
        driver.findElement(By.name("email")).sendKeys(FakeMessageGenerator.generateEmail());
        //Input password
        driver.findElement(By.name("password1")).sendKeys(FakeMessageGenerator.generatePassword());
        //Input confirm password
        driver.findElement(By.name("password2")).sendKeys(FakeMessageGenerator.generatePassword());
        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        Assert.assertTrue(isErrorDisplayed, "'Register' button isn't displayed");
    }
    @Test
    public void registrationPasswordlessFour() {
        sendZipCode(FakeMessageGenerator.generateFiveZipCode());
        //Input first name
        driver.findElement(By.name("first_name")).sendKeys(FakeMessageGenerator.generateFirstName());
        //Input last name
        driver.findElement(By.name("last_name")).sendKeys(FakeMessageGenerator.generateLastName());
        //Input email
        driver.findElement(By.name("email")).sendKeys(FakeMessageGenerator.generateEmail());
        //Input password
        String password = FakeMessageGenerator.generatePasswordLessFour();
        driver.findElement(By.name("password1")).sendKeys(password);
        //Input confirm password
        driver.findElement(By.name("password2")).sendKeys(password);
        //Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        Assert.assertTrue(isErrorDisplayed, "'Register' button isn't displayed");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
