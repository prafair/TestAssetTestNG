package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class LogoPage {

    @FindBy(xpath = "//button/span[.='Сохранить']")
    public WebElement buttonSave;

    public LogoPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void uploadLogo() throws AWTException, InterruptedException {
        StringSelection ss = new StringSelection("C:\\Users\\user\\IdeaProjects\\FirstSeleniumTestNGExample\\src\\test\\java\\logo.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        // Imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);
    }

    public void saveLogo(){
        buttonSave.click();
    }

}