package usingobjects;

import java.util.Scanner;

public class PASET_TWO {
    private static Scanner scan = new Scanner(System.in);
    public static void convertFtoC() {
        try {
            System.out.print("Enter temperature in Fahrenheit: ");
            double f = scan.nextDouble();
            System.out.println(f + " F = " + (5*(f-32)/9) + " C");
        } catch (Exception e) { System.out.println("TU ERES ESTUPIDO"); }
    }
    public static void circle() {
        try {
            System.out.print("Enter the radius: ");
            double r = scan.nextDouble();
            System.out.println("Radius of the circle: " + r);
            System.out.println("Circumference of the circle: " + 2*Math.PI*r);
            System.out.println("Area of the circle: " + Math.PI*r*r);
        } catch (Exception e) { System.out.println("TU ERES ESTUPIDO"); }
    }
    public static void change() {
        try {
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
        } catch (Exception e) { System.out.println("TU ERES ESTUPIDO"); }
    }
    public static void time() {
        try {
            System.out.print("Enter the seconds: ");
            int s = scan.nextInt();
            int ss = s;
            int h = ss/3600;
            ss %= 3600;
            int m = ss/60;
            ss %= 60;
            System.out.println(s +" seconds is " + h + " hours, " + m + " minutes, and " + ss + " seconds");
        } catch (Exception e) { System.out.println("TU ERES ESTUPIDO"); }
    }
    public static void sumDigits() {
        try {
            System.out.print("Enter a positive two-digit integer: ");
            String n = scan.next();
            int f = Character.getNumericValue(n.charAt(0));
            int l = Character.getNumericValue(n.charAt(1));
            System.out.println(f+l);
        } catch (Exception e) { System.out.println("TU ERES ESTUPIDO " + e.getMessage()); }
    }
}
