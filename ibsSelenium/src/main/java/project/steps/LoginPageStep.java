package project.steps;

import io.cucumber.java.ru.И;
import project.managers.PageManager;

public class LoginPageStep {

    PageManager pageManager = PageManager.getPageManager();

    @И("^Ввод логина \"([^\"]*)\" и пароля \"([^\"]*)\"$")
    public void enterLoginAndPassword(String login, String password){
        pageManager.getLoginPage().enterLoginAndPassword(login, password);
    }

    @И("^Кликнуть на кнопку 'Войти'")
    public void submitClick(){
        pageManager.getLoginPage().submitClick();
    }
}
