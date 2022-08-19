package my.task.exercises.projects;

import java.util.Random;

public class PlayCube {
    public static void main(String[] args) {

        Random random = new Random();

        int resultCubes, playerFirstThrow, playerSecondThrow;
        int playerMoney = 100;
        int numbersRound = 0;

        System.out.println("\nStart game\n" + "In the beginning the player has " + playerMoney + " moneys\n");
        System.out.println("First throw this cube");
        playerFirstThrow = 1 + random.nextInt(6);
        System.out.println("First throw equals = " + playerFirstThrow);
        System.out.println("\nSecond throw this cube");
        playerSecondThrow = 1 + random.nextInt(6);
        System.out.println("Second throw equals = " + playerSecondThrow);
        resultCubes = playerFirstThrow + playerSecondThrow;
        System.out.println("\nResult throws equals = " + resultCubes);

        if (resultCubes == 7 || resultCubes == 11) {
            numbersRound++;
            System.out.println("\nRound: " + numbersRound);
            System.out.println("\nPlayer has drawn number " + resultCubes + " and one is winner the game " +
                    "-> plus 20 moneys");
            playerMoney = playerMoney + 20;
            System.out.println("Player has " + playerMoney + " moneys present\n");

            while(numbersRound <= 10 - 1 || playerMoney <= 0) {

                System.out.println("Next throw this cube");
                playerFirstThrow = 1 + random.nextInt(6);
                System.out.println("Next throw equals = " + playerFirstThrow);
                System.out.println("\nSecond next throw this cube");
                playerSecondThrow = 1 + random.nextInt(6);
                System.out.println("Second next throw equals = " + playerSecondThrow);
                resultCubes = playerFirstThrow + playerSecondThrow;
                System.out.println("\nResult next throws equals = " + resultCubes);

                if (resultCubes == 7 || resultCubes == 2 || resultCubes == 3 || resultCubes == 12) {
                    numbersRound++;
                    System.out.println("\nRound: " + numbersRound + "\n\nPlayer has drawn number " + resultCubes +
                            " and one is loser the game -> minus 30 moneys");
                    playerMoney = playerMoney - 30;
                    System.out.println("Player has " + playerMoney + " moneys present\n");
                } else if (resultCubes == 11) {
                    numbersRound++;
                    System.out.println("\nRound: " + numbersRound + "\n\nPlayer has drawn number " + resultCubes +
                            " and one is winner the game -> plus 20 moneys\n");
                    playerMoney = playerMoney + 20;
                    System.out.println("Player has " + playerMoney + " moneys present\n");
                } else {
                    numbersRound++;
                    System.out.println("\nRound: " + numbersRound + "\n\nThe total becomes the player's points" +
                            "\nPlayer has drawn number " + resultCubes + "\nPlayer's total money equals " +
                            playerMoney + "\n");
                }
            }

        } else if (resultCubes == 2 || resultCubes == 3 || resultCubes == 12) {
            numbersRound++;
            System.out.println("\nRound: " + numbersRound);
            System.out.println("\n\nPlayer has drawn number " + resultCubes + " and one is loser the game " +
                    "-> minus 30 moneys\n");
            playerMoney = playerMoney - 30;
            System.out.println("Player has " + playerMoney + " moneys present\n");

            while(numbersRound <= 10 - 1 || playerMoney <= 0) {

                System.out.println("Next throw this cube");
                playerFirstThrow = 1 + random.nextInt(6);
                System.out.println("Next throw equals = " + playerFirstThrow);
                System.out.println("\nSecond next throw this cube");
                playerSecondThrow = 1 + random.nextInt(6);
                System.out.println("Second next throw equals = " + playerSecondThrow);
                resultCubes = playerFirstThrow + playerSecondThrow;
                System.out.println("\nResult next throws equals = " + resultCubes);

                if (resultCubes == 7 || resultCubes == 2 || resultCubes == 3 || resultCubes == 12) {
                    numbersRound++;
                    System.out.println("\nRound: " + numbersRound + "\n\nPlayer has drawn number " + resultCubes +
                            " and one is loser the game -> minus 30 moneys\n");
                    playerMoney = playerMoney - 30;
                    System.out.println("Player has " + playerMoney + " moneys present\n");
                } else if (resultCubes == 11) {
                    numbersRound++;
                    System.out.println("\nRound: " + numbersRound + "\n\nPlayer has drawn number " + resultCubes +
                            " and one is winner the game -> plus 20 moneys\n");
                    playerMoney = playerMoney + 20;
                    System.out.println("Player has " + playerMoney + " moneys present\n");
                } else {
                    numbersRound++;
                    System.out.println("\nRound: " + numbersRound + "\n\nThe total becomes the player's points" +
                            "\nPlayer has drawn number " + resultCubes + "\nPlayer's total money equals " +
                            playerMoney + "\n");
                }
            }

        } else {
            numbersRound++;
            System.out.println("\nRound: " + numbersRound + "\n\nThe total becomes the player's points" +
                    "\nPlayer has drawn number " + resultCubes + "\nPlayer's total money equals " +
                    playerMoney + "\n");

            while(numbersRound <= 10 - 1 || playerMoney <= 0) {

                System.out.println("Next throw this cube");
                playerFirstThrow = 1 + random.nextInt(6);
                System.out.println("Next throw equals = " + playerFirstThrow);
                System.out.println("\nSecond next throw this cube");
                playerSecondThrow = 1 + random.nextInt(6);
                System.out.println("Second next throw equals = " + playerSecondThrow);
                resultCubes = playerFirstThrow + playerSecondThrow;
                System.out.println("\nResult next throws equals = " + resultCubes);

                if (resultCubes == 7 || resultCubes == 2 || resultCubes == 3 || resultCubes == 12) {
                    numbersRound++;
                    System.out.println("\nRound: " + numbersRound + "\n\nPlayer has drawn number " + resultCubes +
                            " and one is loser the game -> minus 30 moneys\n");
                    playerMoney = playerMoney - 30;
                    System.out.println("Player has " + playerMoney + " moneys present\n");
                } else if (resultCubes == 11) {
                    numbersRound++;
                    System.out.println("\nRound: " + numbersRound + "\n\nPlayer has drawn number " + resultCubes +
                            " and one is winner the game -> plus 20 moneys\n");
                    playerMoney = playerMoney + 20;
                    System.out.println("Player has " + playerMoney + " moneys present\n");
                } else {
                    numbersRound++;
                    System.out.println("\nRound: " + numbersRound + "\n\nThe total becomes the player's points" +
                            "\nPlayer has drawn number " + resultCubes + "\nPlayer's total money equals " +
                            playerMoney + "\n");
                }
            }
        }
    }
}