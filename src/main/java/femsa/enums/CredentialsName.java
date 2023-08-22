package femsa.enums;

public enum CredentialsName {
    ELVIS("Elvis"),
    NICOLE("Nicole"),
    LUIS("Luis"),
    KOF("kof_user"),
    VALID_CREDENTIAL("valid_credential"),
    EMPTY_PASSWORD("password empty"),
    EMPTY_USERNAME("password empty"),
    ;

    private final String name;

    CredentialsName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
