package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:config/${deviceHost}.properties",
        "classpath:config/browserstack.properties",
        "file:~/config/${deviceHost}.properties",
        "file:~/config/browserstack.properties"
})
public interface BrowserStackDriverConfig extends Config {

    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String browserstackApp();

    @DefaultValue("Google Pixel 7")
    String browserstackDevice();

    @DefaultValue("13.0")
    String browserstackPlatform();

    String automationName();

    String platformName();

    String appLanguage();

    String appLocale();

    Boolean appFullReset();

    String browserstackUrl();
}
