package project.managers;

import project.pages.ListProductsPage;
import project.pages.MainPage;

public class PageManager {

    private static PageManager pageManager;

    private MainPage mainPage;

    private ListProductsPage listProductsPage;

    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public ListProductsPage getListProductsPage() {
        if (listProductsPage == null) {
            listProductsPage = new ListProductsPage();
        }
        return listProductsPage;
    }
}
