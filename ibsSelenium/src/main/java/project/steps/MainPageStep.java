package project.steps;

import io.cucumber.java.ru.И;
import project.managers.PageManager;

public class MainPageStep {

    PageManager pageManager = PageManager.getPageManager();

    @И("^Навести курсор мыши на меню меню \"([^\"]*)\"")
    public void selectMenu(String name){
        pageManager.getMainPage().selectMenu(name);
    }

    @И("Кликнуть на меню 'Командировки'")
    public void clickBusinessTrip(){
        pageManager.getMainPage().clickBusinessTrip();
    }
}
