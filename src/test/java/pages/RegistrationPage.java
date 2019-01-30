package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.GenerateEmailClass.generateEmail;
import static utils.GenerateEmailClass.gen_email;

public class RegistrationPage {

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@type='password'][1]")
    public WebElement passwordField1;

    @FindBy(xpath = "//input[@type='password'][2]")
    public WebElement passwordField2;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    public RegistrationPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterGeneratedEmail() {
        generateEmail();
        emailField.sendKeys(gen_email);
    }

    public void enterPassword() {
        passwordField1.sendKeys("Password");
        passwordField2.sendKeys("Password");
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }


}