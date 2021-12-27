
package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class AbstractTest {

    static WebDriver webDriver;

    @BeforeEach
    public void setWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assertions.assertDoesNotThrow(() -> webDriver.navigate().to("https://www.livejournal.com/"),
                "The page is unavailable");
    }

    @AfterEach
    public void exit(){
        if(webDriver != null) webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }
}
