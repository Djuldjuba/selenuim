package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(css = ".nav-multilevel > .dropdown")
    private List<WebElement> menuName;

    @FindBy(xpath = "//span[.='Командировки']")
    private WebElement buttonBusinessTrip;

    public MainPage selectMenu(String name) {
        for (WebElement menuItem : menuName) {
            if (menuItem.getText().equalsIgnoreCase(name)) {
                action.moveToElement(menuItem).perform();
                return pageManager.getMainPage();
            }
        }
        return pageManager.getMainPage();
    }

    public BusinessTripPage clickBusinessTrip() {
        buttonBusinessTrip.click();
        loading();
        return pageManager.getBusinessTripPage();
    }
}
