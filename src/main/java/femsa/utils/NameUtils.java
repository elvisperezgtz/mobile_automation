package femsa.utils;

public class NameUtils {

    public static String getInitials(String name, String surname) {
        char nameInitial = name.charAt(0);
        char surnameInitial = surname.charAt(0);
        return "" + nameInitial + surnameInitial;
    }

    public static String getFirstNameAndSurname(String fullName) {
        String[] names = fullName.split(" ");
        return names[0] + " " + names[1];
    }

}
