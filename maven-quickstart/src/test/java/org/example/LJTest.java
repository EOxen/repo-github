package org.example;

import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.slf4j.LoggerFactory.getLogger;

public class LJTest extends AbstractTest {

    private static final Logger logger = (Logger) getLogger(LJTest.class);

    @Test
    void authSuccessful(){
        new MainPage(getWebDriver()).Authorization("EV_Ox","ggN5P9b");
        Assertions.assertNotNull(webDriver.findElement(By.cssSelector(".s-header-item-post")));
    }

    @Test
    void authUnsuccessful(){
        new MainPage(getWebDriver()).Authorization("EV_Ox","1234");
        Assertions.assertNotNull(webDriver.findElement(By.xpath("//span[@class='b-loginform-field__errorMsg ng-binding']")));
    }

    @Test
    void authAndNewEntry(){
        new MainPage(getWebDriver()).Authorization("EV_Ox","ggN5P9b");
        Assertions.assertNotNull(webDriver.findElement(By.xpath("//a[@title='ev_ox']/div")));
        new MainPage(getWebDriver()).goToNewNotePage();
        Assertions.assertEquals("Новая запись",webDriver.getTitle());
        new NewNotePage(getWebDriver()).entry("New note","Entry ");
        new NewNotePage(getWebDriver())
                .setVisibleEveryone()
                .setVisibleOnlyMe()
                .setConfigAndPublish()
                .setPublish();
        //ожидание кнопки "добавить комментарий"
        Assertions.assertNotNull(webDriver.findElement(By.xpath("//div[@class='mdspost-comments__addcomment']")));
    }

    @Test
    void authAndRedact(){
        new MainPage(getWebDriver()).Authorization("EV_Ox","ggN5P9b");
        Assertions.assertNotNull(webDriver.findElement(By.xpath("//a[@title='ev_ox']/div")));
        new MainPage(getWebDriver()).goToMyJournalPage();
        new MyJournalPage(getWebDriver()).goToNote();
        Assertions.assertEquals("Редактирование записи",webDriver.getTitle());
        new NewNotePage(getWebDriver()).entry(" This is edited","This is edited")
                .setConfigAndPublish().setPublish();
        //ожидание кнопки "добавить комментарий"
        Assertions.assertNotNull(webDriver.findElement(By.xpath("//div[@class='mdspost-comments__addcomment']")));
    }


}
