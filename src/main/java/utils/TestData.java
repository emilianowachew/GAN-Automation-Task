package utils;

public final class TestData {

    private TestData() {
    }

    public static String email() {
        return get("userEmail", "PUT_TEST_EMAIL_HERE");
    }

    public static String password() {
        return get("userPassword", "PUT_TEST_PASSWORD_HERE");
    }

    public static String uniqueEmail() {
        return "qa+" + System.currentTimeMillis() + "@example.com";
    }

    private static String get(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        return value.trim();
    }
}
