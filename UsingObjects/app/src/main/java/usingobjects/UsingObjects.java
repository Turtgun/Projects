package usingobjects;

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
    }
    
    /**
     * Method will prompt the user for the coordinates of two point 
     * objects, create them and then calculate the distance betweeen them
     */
    public static void calcDistance()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the cents: ");
        int change = scan.nextInt();
        int penn = change;
        int quart = penn/25;
        penn %= 25;
        int dime = penn/10;
        penn %= 10;
        int nick = penn/5;
        penn %= 5;
        System.out.println("The coins for " + change + " cents will be " + quart + " quarters, " + dime + " dimes, " + nick + " nickels, and " + penn + " pennies.");
    }
    
}