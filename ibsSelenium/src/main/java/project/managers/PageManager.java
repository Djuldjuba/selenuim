package project.managers;

import project.pages.BusinessTripPage;
import project.pages.CreateBusinessTripPage;
import project.pages.LoginPage;
import project.pages.MainPage;

public class PageManager {

    private static PageManager pageManager;
    private MainPage mainPage;
    private LoginPage loginPage;
    private CreateBusinessTripPage createBusinessTripPage;
    private BusinessTripPage businessTripPage;

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


    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public CreateBusinessTripPage getCreateBusinessTripPage() {
        if (createBusinessTripPage == null) {
            createBusinessTripPage = new CreateBusinessTripPage();
        }
        return createBusinessTripPage;
    }

    public BusinessTripPage getBusinessTripPage() {
        if (businessTripPage == null) {
            businessTripPage = new BusinessTripPage();
        }
        return businessTripPage;
    }
}
