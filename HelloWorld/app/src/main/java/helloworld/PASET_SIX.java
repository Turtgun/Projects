package helloworld;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PASET_SIX {
    /** complete the following methods as described below **/
    
    /*
     * Complete the method sumInts that will find the smallest positive 
     * integer N such that the sum 1 + 2 + ... + N exceeds the parameter 
     * value.  For example, sumInts(25) would return 7 for N.  This is 
     * because 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28 and it is the first sum 
     * greater than 25. 
     * 
     * Ex:
     *    sumInts(25) → 7
     *    sumInts(9) → 4
     */
    public static int sumInts(int value)
    {
        int sum = 1;
        int i = 2;
        while (sum <= value) {
            sum+=i;
            i++;
        }
        
        return i-1; //modify to return the proper value
    }
  
    /*
     * The Greatest Common Divisor (GCD) of two integers a and b is a 
     * positive integer c such that c divides a, c divides b, and for 
     * any other common divisor d of a and b, d is less than or equal 
     * to c.  For example, the GCD of 18 and 45 is 9.  One method of 
     * finding the GCD of two positive integers (a, b) is to begin 
     * with the smaller a and determine if it is a divisor of the 
     * larger b.  If it is, then the smaller is the GCD.  If it is not, 
     * find the next largest divisor of a and see if it is a divisor of b.  
     * Continue this until you find a divisor of both a and b.  This is 
     * the GCD of a and b.  Complete the method to calculate the GCD 
     * given two positive integers.   
     * 
     * Ex:
     *    gcd(18, 45) → 9
     *    gcd(17, 13) → 1
     */
    public static int gcd(int a, int b)
    {
        return (b==0) ? a : gcd(b,a%b); //modify to return the proper value
    }

    
    /*
     * The Least Common Multiple (LCM) of two positive integers a and b 
     * is positive integer c such that c is a multiple of both a and b 
     * and for any other multiple m of a and b, c is a divisor of m.  
     * For example, the LCM of 12 and 8 is 24.  Complete the method to 
     * calculate the LCM of two positive integers. 
     * 
     * Ex:
     *    lcm(12, 8) → 24
     *    gcd(24, 36) → 72
     */
    public static int lcm(int a, int b)
    {        
        return (a*b)/gcd(a, b); //modify to return the proper value
    }

    /** Do not modify the code below **/
    public static void run1() throws IOException
    {
        /******************************************************/
        
        System.out.println("\n/****** SumInts ******/");
        File file = new File("sumints.dat");
        Scanner tFile = new Scanner(file);
        while(tFile.hasNext())
        {
            int num = tFile.nextInt();
            int value = sumInts(num);
            System.out.println("Sum of integers 1 + ... + " + value + 
                               " is larger than " + num);
        }
        tFile.close();
        
        /******************************************************/
        
        System.out.println("\n/****** GCD ******/");
        file = new File("gcd.dat");
        tFile = new Scanner(file);
        while(tFile.hasNext())
        {
            int a = tFile.nextInt();
            int b = tFile.nextInt();
            int gcd = gcd(a, b);
            System.out.println("The GCD of " + a + " and " + b + 
                               " is " + gcd);
        }
        tFile.close();
        
        /******************************************************/
        
        System.out.println("\n/****** LCM ******/");
        file = new File("lcm.dat");
        tFile = new Scanner(file);
        while(tFile.hasNext())
        {
            int a = tFile.nextInt();
            int b = tFile.nextInt();
            int lcm = lcm(a, b);
            System.out.println("The LCM of " + a + " and " + b + 
                               " is " + lcm);
        }
        tFile.close();
    }

    /*** To be completed ***/

    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
     */
    public static int numberOfLeapYears(int year1, int year2)
    { 
        return ((year2)/4-(year2/100)+(year2/400))-(((year1-1)/4)-((year1-1)/100)+((year1-1)/400));
    }

    /** Returns the value representing the day of the week for the given date
     *    (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ...,
     *    and 6 denotes Saturday.
     *    Precondition: The date represented by month, day, year is a valid date.
     */
    public static int dayOfWeek(int month, int day, int year)
    { 
        /* to be implemented */

        return -1;
    }

    /** Returns the String representing the day of the week for the given 
     *    numerical value of the day of the week date, where 0 denotes Sunday, 
     *    1 denotes Monday, ..., and 6 denotes Saturday.
     */
    public static String dayOfWeekString(int dayWeek)
    { 
        /* to be implemented */

        return null;
    }

    /** Do not modify the code below **/

    /** Returns true if year is a leap year and false otherwise. */ 
    private static boolean isLeapYear(int year)
    { 
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    /** Returns the value representing the day of the week for the first day of year,
     * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
     */
    private static int firstDayOfYear(int year)
    { 
        return (3 + 365*(year - 1800) + numberOfLeapYears(1800, year-1)) % 7;
    }

    /** Returns n, where month, day, and year specify the nth day of the year.
     *    Returns 1 for January 1 (month = 1, day = 1) of any year.
     *    Precondition: The date represented by month, day, year is a valid date.
     */
    private static int dayOfYear(int month, int day, int year)
    { 
        final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int n = day;
        int mth  = 1;

        while (mth < month)
        {
            n += daysInMonth[mth - 1];
            mth++;
        }

        if (mth > 2 && isLeapYear(year))
            n++;

        return n;
    }

    public static void run2() throws IOException
    {
        
       /******************************************************/
        
        System.out.println("\n/****** SumInts ******/");
        File file = new File("leapyears.dat");
        Scanner tFile = new Scanner(file);
        while(tFile.hasNext())
        {
            int year1 = tFile.nextInt();
            int year2 = tFile.nextInt();
            int value = numberOfLeapYears(year1, year2);
            System.out.println("The number of leap years between " + year1 + " and " 
                               + year2 + " is " +value);
        }
        tFile.close();
         
        
        System.out.println("\n/****** Day of the Week ******/");
        file = new File("dayofweek.dat");
        tFile = new Scanner(file);
        while(tFile.hasNext())
        {
            int month = tFile.nextInt();
            int day = tFile.nextInt();
            int year = tFile.nextInt();
            int value = dayOfWeek(month, day, year);
            String dayWeek = dayOfWeekString(value);
            System.out.println(month + "/" + day + "/" + year + " returned a " + value 
                               + " which is a " + dayWeek);
        }
        tFile.close();

    }

};