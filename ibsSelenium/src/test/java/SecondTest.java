import basetest.BaseTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static project.utils.PropConst.LOGIN;
import static project.utils.PropConst.PASSWORD;

public class SecondTest extends BaseTests {

    @DisplayName("Первый тест")
    @Test
    public void test() {
        app.getLoginPage()
                .enterLoginAndPassword(props.getProperty(LOGIN), props.getProperty(PASSWORD))
                .submitClick()
                .selectMenu("Расходы")
                .clickBusinessTrip()
                .clickCreateBusinessTrip()
                .inputSubdivisionField("Бухгалтерия")
                .chooseOrganizationFromList("(Опера)Призрачная Организация Охотников")
                .inputDepartureCity("Нижний Новгород")
                .inputArrivalCity("Москва")
                .inputDepartureDate("01.09.2023")
                .inputReturnDate("01.10.2023")
                .clickCheckboxBookingOfTickets()
                .clickSaveAndExitWithError()
                .checkErrorListOfSecondedEmployees();
    }
}
