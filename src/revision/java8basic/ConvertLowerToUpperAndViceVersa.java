package revision.java8basic;

public class ConvertLowerToUpperAndViceVersa {
    public static void main(String[] args) {
        String s = "aPp12Le";
        System.out.println(convert(s));
    }

    private static String convert(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
