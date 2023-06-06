package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//form[@id='login-form']")
    private WebElement loginFormWindow;

    @FindBy(xpath = "//input[@name='_username']")
    private WebElement loginRow;

    @FindBy(xpath = "//input[@name='_password']")
    private WebElement passwordRow;

    @FindBy(xpath = "//button[@id='_submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement subTitle;

    public LoginPage enterLoginAndPassword(String login, String password) {
        wait.until(visibilityOf(loginFormWindow));
        loginRow.sendKeys(login);
        passwordRow.sendKeys(password);
        return this;
    }

    public MainPage submitClick() {
        submitButton.click();
        wait.until(visibilityOf(subTitle));
        return pageManager.getMainPage();
    }
}
