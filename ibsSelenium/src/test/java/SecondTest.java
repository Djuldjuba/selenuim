import basetest.BaseTests;
import extension.AllureExtension;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static project.utils.PropConst.LOGIN;
import static project.utils.PropConst.PASSWORD;

@DisplayName("Сценарий для allure репорта")
@ExtendWith(AllureExtension.class)
public class SecondTest extends BaseTests {

    @Test
    @DisplayName("Проверка создания командировки без добавления командируемых сотрудников")
    @Severity(SeverityLevel.NORMAL)
    @Link("http://training.appline.ru/user/login")
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
