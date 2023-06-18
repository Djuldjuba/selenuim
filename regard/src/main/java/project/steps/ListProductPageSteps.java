package project.steps;

import io.cucumber.java.ru.И;
import project.managers.PageManager;

public class ListProductPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @И("^Ввод в поле 'Минимальная цена' значения: \"([^\"]*)\"$")
    public void inputMinPrice(String price) {
        pageManager.getListProductsPage().inputMinPrice(price);
    }

    @И("^Проверка что фильтр \"([^\"]*)\" применился$")
    public void checkFilterTag(String price) {
        pageManager.getListProductsPage().checkFilterTag(price);
    }

    @И("^Кликнуть на чекбокс: \"([^\"]*)\"$")
    public void clickOnCheckbox(String nameCheckbox) throws InterruptedException {
        pageManager.getListProductsPage().clickOnCheckbox(nameCheckbox);
    }

    @И("^Проверка, что на странице отображается \"([^\"]*)\" товара$")
    public void checkPaginationCount(String count) {
        pageManager.getListProductsPage().checkPaginationCount(count);
    }

    @И("^Выполнить поиск товара № (\\d+) из списка выданных товаров, проверить что в поисковой выдачи ровно 1 товар и его наименование соответствует сохраненному значению$")
    public void checkSavedProductSearch(int count) throws InterruptedException {
        pageManager.getListProductsPage().checkSavedProductSearch(count);
    }
}
