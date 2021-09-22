package Util;

public class Aux {

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isBoolean(String str) {
        return ( str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false") );
    }


}
