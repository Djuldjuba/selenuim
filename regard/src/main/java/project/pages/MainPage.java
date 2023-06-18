package project.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[.='Каталог']")
    private WebElement buttonCatalog;

    @FindBy(css = "[class^='CatalogPanel_wrap']")
    private WebElement catalogPanel;

    @FindBy(css = "a[class^='Catalog_mainCategory']")
    private List<WebElement> menuName;

    @FindBy(xpath = "//div[starts-with(@class, 'NestedCategories_wrap')]")
    private WebElement submenu;

    @FindBy(tagName = "h1")
    private WebElement header;

    public MainPage clickButtonCatalog() {
        buttonCatalog.click();
        waitUtilElementToBeVisible(catalogPanel);
        return this;
    }

    public MainPage selectMenu(String name) {
        for (WebElement menuItem : menuName) {
            if (menuItem.getText().equalsIgnoreCase(name)) {
                action.moveToElement(menuItem).perform();
                return this;
            }
        }
        return this;
    }
    public ListProductsPage clickSubMenu(String nameSubMenu) {
        submenu.findElement(By.xpath(String.format("//a[.='%s']", nameSubMenu))).click();
        waitUtilElementToBeVisible(header);
        Assertions.assertEquals(nameSubMenu, header.getText(), "выполнен переход не неверную страницу");
        return pageManager.getListProductsPage();
    }
}
