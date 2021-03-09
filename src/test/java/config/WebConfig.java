package config;

import com.codeborne.selenide.Config;
import org.aeonbits.owner.Config.Key;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:${env}.properties")
public interface WebConfig extends Config {
    @Key("search.browser")
    String searchBrowser();

    @Key("search.version")
    String searchVersion();

    @Key("search.remote")
    String searchRemote();

    @Key("video.storage")
    String videoStorage();

}
