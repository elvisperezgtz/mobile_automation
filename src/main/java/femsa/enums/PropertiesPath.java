package femsa.enums;



public enum PropertiesPath {

    CREDENTIALS("src/test/resources/properties/credentials.properties"),
    MAIL("src/test/resources/properties/gmail.properties")
    ;
    private final String filePath;
    PropertiesPath(String filePath) {
        this.filePath = filePath;
    }
    public String getFilePath(){
        return filePath;
    }

    public static void main(String[] args) {
        System.out.println(CREDENTIALS.getFilePath());
    }
}
