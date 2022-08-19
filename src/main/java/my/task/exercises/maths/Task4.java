package my.task.exercises.maths;

public class Task4 {

    public static void main(String[] args) {

        double litersOfWater = 1.5;
        int year = 1;
        for(int i = 0; i < 25 - 1; i++){
            year++;
            litersOfWater = litersOfWater + 1.5;

            System.out.println("Year: " + year +  " liter of water equals " +  litersOfWater );
        }
    }
}