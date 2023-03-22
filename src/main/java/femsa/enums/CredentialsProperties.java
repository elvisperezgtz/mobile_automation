package femsa.enums;

public enum CredentialsProperties {
    PHONE_NUMBER("phoneNumber"),
    PASSWORD("password"),
    EMAIL("email"),
    ;

    private final String propertyName;

    CredentialsProperties(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName(){
        return propertyName;
    }
}
