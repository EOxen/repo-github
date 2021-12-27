package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyJournalPage extends AbstractPage
{
    public MyJournalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//article[@id='entry-ev_ox-3261']/footer[@class='entryunit__footer']/div/ul/li[@class='controls-entryunit__item controls-entryunit__item--edit_entry']")
    private WebElement pen;

    @FindBy(xpath = "//time[@datetime='2021-12-27']")
    private WebElement note;

    public MyJournalPage goToNote() {
        note.click();
        pen.click();
        return this;
    }
}
