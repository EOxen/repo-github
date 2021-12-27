package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NewNotePage extends AbstractPage {

    @FindBy(xpath = "//div[@id='content']/div/div/div[2]/textarea")
    private WebElement heading;

    @FindBy(css = ".public-DraftStyleDefault-block")
    private WebElement content;

    @FindBy(xpath = "//button[@class='_11q _11s _11v _124 _12l']")
    private WebElement visibleEveryone;

    @FindBy(xpath = "//li[4]/label")
    private WebElement visibleOnlyMe;

    @FindBy(xpath = "//button[@class ='_11q _11s _11v _124 _127 _12l']")
    private WebElement configAndPublish;

    @FindBy(xpath = "//footer/div/button/span")
    private WebElement publish;

    public NewNotePage(WebDriver driver) {
        super(driver);
    }

    public NewNotePage entry(String heading, String content) {
        Actions entry = new Actions(getDriver());
        entry.sendKeys(this.heading, heading)
                .sendKeys(this.content, content)
                .build().perform();
        return this;
    }

    public NewNotePage setVisibleEveryone() {
        visibleEveryone.click();
        return this;
    }

    public NewNotePage setVisibleOnlyMe() {
        visibleOnlyMe.click();
        return this;
    }

    public NewNotePage setConfigAndPublish() {
        configAndPublish.click();
        return this;
    }

    public NewNotePage setPublish() {
        publish.click();
        return this;
    }
}
