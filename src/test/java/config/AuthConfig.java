package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/auth.properties",
        "file:~/auth.properties",
        "file:./auth.properties"
})

public interface AuthConfig extends Config {
    String username();

    String password();
}
