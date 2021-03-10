package config;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;

public class TestBase {
    final static WebConfig config = ConfigFactory.create(WebConfig.class,System.getProperties());
    @BeforeAll
    static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.startMaximized = true;
        Configuration.browser = config.searchBrowser();
        Configuration.browserVersion = config.searchVersion();

        if (config.searchRemote() != null) {
            // config for Java + Selenide
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = config.searchRemote();

        }
    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if (config.videoStorage() != null)
            attachVideo();
        closeWebDriver();
    }


}



