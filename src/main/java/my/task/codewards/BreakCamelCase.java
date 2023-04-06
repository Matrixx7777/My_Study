package my.task.codewards;

public class BreakCamelCase {
    public static String camelCase(String input) {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            String a = Character.toString(input.charAt(i));

            if (a.equals(a.toUpperCase()))  {
                out.append(" ");
            }
            out.append(a);
        }
        System.out.println(out);
        return out.toString();
    }

    public static void main(String[] args) {
        BreakCamelCase.camelCase("camelCasing");
        BreakCamelCase.camelCase("camelCasingTest");
        BreakCamelCase.camelCase("camelcasingtest");
    }
}
