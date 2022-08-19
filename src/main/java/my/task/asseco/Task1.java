package my.task.asseco;

public class Task1 {
    public static String createPicture(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int a,b,c;
        a=2*n-2;

        for(b=0; b<2*n-1; b++) {
            for(c=0; c<2*n-1; c++) {
                stringBuilder = stringBuilder.append((b>c)&&(a+1>c) ? n-c : ((b>=n)&&(c<=b) ? b-n+2 : (c>a ? c-n+2 : n-b))) ;
            }
            a-- ;
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        System.out.println(createPicture(4));
    }
}