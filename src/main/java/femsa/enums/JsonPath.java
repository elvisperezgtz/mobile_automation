package femsa.enums;

public enum JsonPath {
    USER_TEMPLATE("src/test/resources/data/api/json_templates/user_template.json"),

    CREDENTIALS("src/test/resources/data/api/credentials.json"),
    USERS_DATA("src/test/resources/data/api/users/users_data.json");


    private final String filePath;

    JsonPath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
