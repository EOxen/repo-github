package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage
{
    @FindBy(css = ".s-header-item__link--login")
    private WebElement enter;

    @FindBy(css = "#user")
    private WebElement login;

    @FindBy(css = "#lj_loginwidget_password")
    private WebElement password;

    @FindBy(css = ".b-loginform-btn--auth")
    private WebElement auth;

    @FindBy(css = ".s-header-item-post")
    private WebElement writeToBlog;

    @FindBy(xpath = "//a[@title='ev_ox']/div")
    private WebElement myJournal;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void Authorization(String login,String password) {
        Actions auth = new Actions(getDriver());
        auth.click(this.enter).sendKeys(this.login,login).click(this.password).sendKeys(password)
                .click(this.auth).build().perform();
    }

    public void goToNewEntryPage() {
        writeToBlog.click();
    }

    public void goToNewNotePage() {
        writeToBlog.click();
    }

    public MainPage goToMyJournalPage() {
        myJournal.click();
        return this;
    }
}
