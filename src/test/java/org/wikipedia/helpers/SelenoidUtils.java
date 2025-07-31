package org.wikipedia.helpers;

import java.util.Map;

public class SelenoidUtils {

    public static Map<String, Object> getSelenoidCapabilities() {
        return Map.of(
                "enableVNC", true,
                "enableVideo", true
        );
    }

}
