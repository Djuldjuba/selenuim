package project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessTripPage extends BasePage {

    @FindBy(xpath = "//a[.='Создать командировку']")
    private WebElement buttonCreateBusinessTrip;

    @Step("Кликнуть \"Создать командировку\"")
    public CreateBusinessTripPage clickCreateBusinessTrip() {
        buttonCreateBusinessTrip.click();
        loading();
        return pageManager.getCreateBusinessTripPage();
    }
}
