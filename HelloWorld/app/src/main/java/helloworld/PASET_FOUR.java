package helloworld;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Write a description of class StringMethods here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PASET_FOUR
{
    /** complete the following methods as described below **/
    
    /*
     * Given a string name, e.g., "Bob", return a greeting of the form "Hello Bob!".
     * 
     * Ex:
     *    helloName("Bob") → "Hello Bob!"
     *    helloName("Alice") → "Hello Alice!"
     *    helloName("X") → "Hello X!"
     */
    public static String hello(String str)
    {
        return "Hello " + str + "!"; //modify to return the proper value
    }
        
    /*
     * Initials will return the initials of a name based on first 
     * initial and last initial.
     * 
     * Ex: given the String "Donna Winter", the method will return "DW".
     *     initials("Donna Winter") → "DW"
     */
    public static String initials(String str)
    {
        char char1 = str.charAt(0);
        char char2 = str.charAt(str.indexOf(" ") + 1);
        return new StringBuilder().append(char1).append(char2).toString(); //modify to return the proper value
    }
    
    /*
     * Given a string of odd length, return the string length 3 from its middle, 
     * so "Candy" yields "and". The string length will be at least 3.
     * 
     * Ex:
     *    middleThree("Candy") → "and"
     *    middleThree("and") → "and"
     *    middleThree("solving") → "lvi"
     */
    public static String middleThree(String str)
    {
        int start = (str.length()-3)/2;
        
        return str.substring(start, start+3); //modify to return the proper value
    }
    
    /*
     * Given three integer values, return the average of the three values 
     * as a double 
     * 
     * Ex:
     *    average(2, 6, 10) → 6.0
     *    average(1, 5, 2) → 2.6666666666
     */
    public static double average(int num1, int num2, int num3)
    {   
        return (num1 + num2 + num3)/3.0; //modify to return the proper value
    }
    
       
    
    
    /** Do not modify the code below **/
    public static void run() throws IOException
    {
        /******************************************************/
        
        System.out.println("\n/****** Hello ******/");
        File file = new File(".\\hello.dat");
        Scanner tFile = new Scanner(file);
        while(tFile.hasNext())
        {
            String str = tFile.nextLine();
            String hello = hello(str);
            System.out.println(hello);
        }
        tFile.close();
        
        /******************************************************/
        
        System.out.println("\n/****** Initials ******/");
        file = new File("initials.dat");
        tFile = new Scanner(file);
        while(tFile.hasNext())
        {
            String str = tFile.nextLine();
            String initials = initials(str);
            System.out.println(str + ": " + initials);
        }
        tFile.close();
        
        /******************************************************/
        
        System.out.println("\n/****** Middle Three ******/");
        file = new File("middle.dat");
        tFile = new Scanner(file);
        while(tFile.hasNext())
        {
            String str = tFile.nextLine();
            String midThree = middleThree(str);
            System.out.println(str + ": " + midThree);
        }
        tFile.close();
        
        /******************************************************/
        
        System.out.println("\n/****** Average ******/");
        file = new File("average.dat");
        tFile = new Scanner(file);
        while(tFile.hasNext())
        {
            int num1 = tFile.nextInt();
            int num2 = tFile.nextInt();
            int num3 = tFile.nextInt();
            tFile.nextLine();
            double avg = average(num1, num2, num3);
            System.out.println("( " + num1 + " + " + num2 + " + " + num3 + ") / 3 = " 
                               + avg);
        }
        tFile.close();

    }
}
