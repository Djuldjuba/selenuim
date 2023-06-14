package project.steps;

import io.cucumber.java.ru.И;
import project.managers.PageManager;

public class BusinessPageStep {
    PageManager pageManager = PageManager.getPageManager();

    @И("Кликнуть 'Cоздать командировку'")
    public void clickCreateBusinessTrip(){
        pageManager.getBusinessTripPage().clickCreateBusinessTrip();
    }
}
