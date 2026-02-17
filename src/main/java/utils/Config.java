package utils;

public final class Config {

    private Config() {
    }

    public static String baseUrl() {
        return get("baseUrl", "https://jackentertainment.lv-stg.gameaccount.com/");
    }

    public static String browser() {
        return get("browser", "chrome").toLowerCase();
    }

    public static boolean headless() {
        return Boolean.parseBoolean(get("headless", "false"));
    }

    public static int timeoutSeconds() {
        return Integer.parseInt(get("timeout", "15"));
    }

    private static String get(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        return value.trim();
    }
}
