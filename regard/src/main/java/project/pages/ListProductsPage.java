package project.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ListProductsPage extends BasePage {

    @FindBy(xpath = "(//input[@name='min'])[1]")
    private WebElement fieldInputMinPrice;

    @FindBy(css = "[class^='FilterTags_title']")
    private List<WebElement> filterTag;

    @FindBy(xpath = "//label[starts-with(@class, 'Checkbox')]")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//button[contains (@class, 'Pagination_countSetter')]/div")
    private WebElement paginationCount;

    @FindBy(xpath = "//button[contains (@class, 'Pagination_countSetter')]")
    private WebElement buttonPagination;

    @FindBy(tagName = "h6")
    private List<WebElement> titlesOfProducts;

    @FindBy(xpath = "//input[@aria-label='Поиск']")
    private WebElement searchField;

    public ListProductsPage inputMinPrice(String price) {
        fieldInputMinPrice.sendKeys(price);
        return this;
    }

    public ListProductsPage checkFilterTag(String name) {
        for (WebElement tagItem : filterTag) {
            if (tagItem.getText().contains(name)) {
                Assertions.assertTrue(tagItem.isDisplayed(), "фильтр " + name + " не применился" );
                return this;
            }
        }
        return this;
    }

    public ListProductsPage clickOnCheckbox(String nameCheckbox) {
        for (WebElement checkboxItem : checkboxes) {
            if (checkboxItem.getText().equalsIgnoreCase(nameCheckbox)) {
                checkboxItem.click();
            }
        }
        return this;
    }

    public ListProductsPage checkPaginationCount(String count) {
        scrollToElement(paginationCount);
        Assertions.assertTrue(paginationCount.getText().equals("Товаров на странице: по " + count), "отображается неверное количество товаров");
        return this;
    }

    public ListProductsPage checkSavedProductSearch(int productNumber) throws InterruptedException {
        String title = titlesOfProducts.get(productNumber - 1).getText();
        searchField.sendKeys(title);
        searchField.sendKeys(Keys.ENTER);
        waitUntilSpinnerInvisible();
        checkFilterTag("Поиск: ");
        Assertions.assertAll(
                () -> Assertions.assertTrue(titlesOfProducts.size() < 2, "количество отображенных товаров более одного"),
                () -> Assertions.assertEquals(titlesOfProducts.get(0).getText(), title, "сохраненных заголовок и заголовок в поиске отличаются")
        );
        return this;
    }

    public void waitUntilSpinnerInvisible() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'ListingFilters_loading')]")));
    }
}
