package my.task.exercises;

public class ReverseWords {
    public static void main(String[] args) {

        System.out.println();
        String name = " My mother is very good for me";
        StringBuilder nul = new StringBuilder();
        String[] a = name.split(" ");

        for (String s : a) {
            System.out.print(s + " ");
        }

        for (int i = a.length - 1; i > 0; i--){
            nul.append(a[i]).append(" ");
        }
        System.out.print("\n" + " " + nul + "\n");
    }
}