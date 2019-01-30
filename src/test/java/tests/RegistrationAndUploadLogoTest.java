package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LogoPage;
import pages.RegistrationPage;

import java.awt.*;

import static utils.GenerateEmailClass.gen_email;
import static utils.newClickClass.retryingFindClick;

/*****************************************************************************
 * Description: Tests for registration on http://iknow.travel using generated email
 *              and upload logo picture of profile on that site.
 *******************************************************************************/

public class RegistrationAndUploadLogoTest {

    //-----------------------------------Variables-----------------------------------
    public static WebDriver driver;
    public static RegistrationPage ObjRegistrationPage;
    public static LogoPage ObjLogoPage;
    public String testURL = "http://iknow.travel";

    //-----------------------------------Test Setup-----------------------------------
    @BeforeClass (description = "Test Setup: Open http://iknow.travel and go to registration page")
    public void setupTest () {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
                "\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(testURL);
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertEquals(title, "iknow.travel", "Title assertion is failed");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='b-navbar__hamburger']")));
        retryingFindClick(driver, By.xpath("//a[@class='b-navbar__hamburger']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/login']")));
        retryingFindClick(driver, By.xpath("//a[@href='/login']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/registration']")));
        retryingFindClick(driver, By.xpath("//a[@href='/registration']"));

        wait.until(ExpectedConditions.titleIs("Регистрация — iknow.travel"));

        ObjRegistrationPage = new RegistrationPage(driver);
        ObjLogoPage = new LogoPage(driver);
    }

    //-----------------------------------Tests-----------------------------------
    @Test (description = "Test for registration using generated email")
    public void registrationTest() {

        ObjRegistrationPage.enterGeneratedEmail();
        ObjRegistrationPage.enterPassword();
        ObjRegistrationPage.clickOnSubmitButton();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("iknow.travel"));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='br-icon-hamburger']")));
        retryingFindClick(driver, By.xpath("//i[@class='br-icon-hamburger']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("b-side-menu__side-menu-link")));
        retryingFindClick(driver, By.className("b-side-menu__side-menu-link"));

        String actual_email = wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//input[@placeholder='Ваш e-mail']")))
                .getAttribute("value");

        System.out.println("Actual Email: " + actual_email);
        System.out.println("Expected Email: " + gen_email);
        Assert.assertEquals(actual_email, gen_email, "E-mails don't match.");
    }

    @Test (description = "Test for upload logo")
    public void uploadLogoTest() throws InterruptedException, AWTException {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Обложка и аватар")));
        retryingFindClick(driver, By.linkText("Обложка и аватар"));

        wait.until(ExpectedConditions.elementToBeClickable(By.className("dz-default")));
        retryingFindClick(driver, By.className("dz-default"));

        ObjLogoPage.uploadLogo();
        ObjLogoPage.saveLogo();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".b-full-user__portrait")));
        System.out.println("Logo is visible");
    }

    //-----------------------------------Test Teardown-----------------------------------
    @AfterClass
    public void teardownTest (){
        driver.quit();
    }
}