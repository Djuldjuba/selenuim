package project.steps;

import io.cucumber.java.ru.И;
import project.managers.PageManager;

public class MainPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @И("Кликнуть на кнопку 'Каталог'")
    public void clickButtonCatalog() {
        pageManager.getMainPage().clickButtonCatalog();
    }

    @И("^Навести курсор мыши на меню: \"([^\"]*)\"$")
    public void selectMenu(String name) {
        pageManager.getMainPage().selectMenu(name);
    }

    @И("^Кликнуть на подменю: \"([^\"]*)\"$")
    public void clickSubMenu(String name) {
        pageManager.getMainPage().clickSubMenu(name);
    }
}
