package project.steps;

import io.cucumber.java.ru.И;
import project.managers.PageManager;

public class CreateBusinessTripPageStep {

    PageManager pageManager = PageManager.getPageManager();
    @И("^Заполнить поле 'Подразделение' подразделением: \"([^\"]*)\"$")
    public void inputSubdivisionField(String text){
        pageManager.getCreateBusinessTripPage().inputSubdivisionField(text);
    }

    @И("^Заполнить поле 'Выбрать организацию из списка' значением: \"([^\"]*)\"$")
    public void chooseOrganizationFromList(String name){
        pageManager.getCreateBusinessTripPage().chooseOrganizationFromList(name);
    }

    @И("^Заполнить поле 'Город выбытия' значением: \"([^\"]*)\"$")
    public void inputDepartureCity(String namecity){
        pageManager.getCreateBusinessTripPage().inputDepartureCity(namecity);
    }

    @И("^Заполнить поле 'Город прибытия' значением: \"([^\"]*)\"$")
    public void inputArrivalCity(String namecity){
        pageManager.getCreateBusinessTripPage().inputArrivalCity(namecity);
    }

    @И("^Заполнить поле 'Планируемая дата выезда' значением: \"([^\"]*)\"$")
    public void inputDepartureDate(String date){
        pageManager.getCreateBusinessTripPage().inputDepartureDate(date);
    }

    @И("^Заполнить поле 'Планируемая дата возвращения' значением: \"([^\"]*)\"$")
    public void inputReturnDate(String date){
        pageManager.getCreateBusinessTripPage().inputReturnDate(date);
    }

    @И("Кликнуть на кнопку 'Сохранить и выйти'")
    public void clickSaveAndExitWithError(){
        pageManager.getCreateBusinessTripPage().clickSaveAndExitWithError();
    }

    @И("Проверить отображение ошибки 'Список командируемых сотрудников не может быть пустым'")
    public void checkErrorListOfSecondedEmployees(){
        pageManager.getCreateBusinessTripPage().checkErrorListOfSecondedEmployees();
    }

    @И("Кликнуть на чекбокс 'Заказ билетов'")
    public void clickCheckboxBookingOfTickets(){
        pageManager.getCreateBusinessTripPage().clickCheckboxBookingOfTickets();
    }

}
