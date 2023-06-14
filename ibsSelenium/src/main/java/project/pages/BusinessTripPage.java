package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessTripPage extends BasePage {

    @FindBy(xpath = "//a[.='Создать командировку']")
    private WebElement buttonCreateBusinessTrip;

    public CreateBusinessTripPage clickCreateBusinessTrip() {
        buttonCreateBusinessTrip.click();
        loading();
        return pageManager.getCreateBusinessTripPage();
    }
}
