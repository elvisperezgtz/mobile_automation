package femsa.enums;

public enum CredentialsProperties {
    USERNAME("username"),
    PASSWORD("password"),
    ;

    private final String propertyName;

    CredentialsProperties(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName(){
        return propertyName;
    }
}
