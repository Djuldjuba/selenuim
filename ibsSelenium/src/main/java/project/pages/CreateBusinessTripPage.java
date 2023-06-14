package project.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateBusinessTripPage extends BasePage {

    @FindBy(name = "crm_business_trip[businessUnit]")
    private WebElement subdivisionField;

    @FindBy(id = "company-selector-show")
    private WebElement buttonListOfOrganization;

    @FindBy(xpath = "//span[.='Укажите организацию']")
    private WebElement buttonSpecifyOrganization;

    @FindBy(css = "ul.select2-results")
    private WebElement dropdownListOfOrganization;

    @FindBy(xpath = "//div[@class='select2-result-label']")
    private List<WebElement> organization;

    @FindBy(xpath = "//span[@class='select2-chosen']")
    private WebElement chosenOrganization;

    @FindBy(xpath = "//input[@data-name='field__departure-city']")
    private WebElement departureCity;

    @FindBy(xpath = "//input[@data-name='field__arrival-city']")
    private WebElement arrivalCity;

    @FindBy(css = ".control-group-date:nth-of-type(1) .datepicker-input")
    private WebElement departureDate;

    @FindBy(css = ".control-group-date:nth-of-type(2) .datepicker-input")
    private WebElement returnDate;

    @FindBy(css = ".action-button:not(.main-group)")
    private WebElement saveAndExit;

    @FindBy(xpath = "//span[.='Командированные сотрудники']/../..//span[@class='validation-failed']")
    private WebElement errorListOfSecondedEmployees;

    @FindBy(xpath = "(//*[@type='checkbox'])[1]")
    private WebElement checkboxBookingOfTickets;

    public CreateBusinessTripPage inputSubdivisionField(String text) {
        Select subdivision = new Select(subdivisionField);
        subdivision.selectByVisibleText(text);
        Assertions.assertEquals(text, subdivision.getFirstSelectedOption().getText(),
                "Поле Подразделение заполнено неверно");
        return this;
    }

    public CreateBusinessTripPage chooseOrganizationFromList(String name) {
        buttonListOfOrganization.click();
        waitUtilElementToBeClickable(buttonSpecifyOrganization);
        buttonSpecifyOrganization.click();
        waitUtilElementToBeVisible(dropdownListOfOrganization);
        for (WebElement menuItem : organization) {
            if (menuItem.getText().equalsIgnoreCase(name)) {
                menuItem.click();
                Assertions.assertEquals(name, chosenOrganization.getText(),
                        "Поле Укажите организацию заполнено неверно");
                return this;
            }
        }
        return this;
    }

    public CreateBusinessTripPage inputDepartureCity(String nameCity) {
        departureCity.clear();
        departureCity.sendKeys(nameCity);
        Assertions.assertEquals(nameCity, departureCity.getAttribute("value"),
                "поле Город выбытия заполнен неверно");
        return this;
    }

    public CreateBusinessTripPage inputArrivalCity(String nameCity) {
        arrivalCity.clear();
        arrivalCity.sendKeys(nameCity);
        Assertions.assertEquals(nameCity, arrivalCity.getAttribute("value"),
                "Поле Город прибытия заполнен неверно");
        return this;
    }

    public CreateBusinessTripPage inputDepartureDate(String date) {
        departureDate.clear();
        departureDate.sendKeys(date);
        departureDate.sendKeys(Keys.ESCAPE);
        Assertions.assertEquals(date, departureDate.getAttribute("value"),
                "Поле Планируемая дата вылета заполнено неверно");
        return this;
    }

    public CreateBusinessTripPage inputReturnDate(String date) {
        returnDate.clear();
        returnDate.sendKeys(date);
        departureDate.sendKeys(Keys.ESCAPE);
        Assertions.assertEquals(date, returnDate.getAttribute("value"),
                "Поле Планируемая дата возвращения заполнено неверно");
        return this;
    }

    public CreateBusinessTripPage clickSaveAndExitWithError() {
        saveAndExit.click();
        loading();
        return this;
    }

    public CreateBusinessTripPage checkErrorListOfSecondedEmployees() {
        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым",
                errorListOfSecondedEmployees.getText(), "Ошибка отображается неверно");
        return this;
    }

    public CreateBusinessTripPage clickCheckboxBookingOfTickets() {
        waitUtilElementToBeClickable(checkboxBookingOfTickets);
        checkboxBookingOfTickets.click();
        return this;
    }
}
