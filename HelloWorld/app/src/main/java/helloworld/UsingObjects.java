package helloworld;

import java.util.Scanner;

/**
 * Write a description of class UsingObjects here.
 *
 * @author Turtgun
 * @version 0.0.1
 */
public class UsingObjects
{
    /*
     * Method will prompt the user on how many times to roll a dice object
     * and display the value of each roll
     */
    public static void rollDice()
    {
        Scanner kybd = new Scanner(System.in);
        System.out.print("Enter the number of rolls: ");
        int rolls = kybd.nextInt();
        Dice michael = new Dice();
        int totalRollResult = 0;
        int result;
        for (int i = 0; i < rolls; i++) {
            result = michael.roll();
            System.out.println("Result: " + result);
            totalRollResult += result;
        }
        System.out.println("Average result of rolls: " + (double)totalRollResult/rolls + " from " + rolls + " rolls.");
        kybd.close();
    }
}