package my.task.monte_carlo;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class AA {

    public static void main(String[] args) {
        getPi(10000);
        getPi(100000);
        getPi(1000000);
        getPi(10000000);
        getPi(100000000);

    }
    public static void getPi(int numThrows){
        int inCircle= 0;
        double result;
        for(int i= 0;i < numThrows;i++){
            //a square with a side of length 2 centered at 0 has
            //x and y range of -1 to 1
            double randX= (Math.random() * 2) - 1;//range -1 to 1
            double randY= (Math.random() * 2) - 1;//range -1 to 1
            //distance from (0,0) = sqrt((x-0)^2+(y-0)^2)
            double dist= Math.sqrt(randX * randX + randY * randY);
            //^ or in Java 1.5+: double dist= Math.hypot(randX, randY);
            if(dist < 1){//circle with diameter of 2 has radius of 1
                inCircle++;
            }
        }
        result = 4.0 * inCircle / numThrows;
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(df.format(result));
    }
}