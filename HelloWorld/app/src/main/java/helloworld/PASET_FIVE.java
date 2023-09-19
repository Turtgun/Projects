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
public class PASET_FIVE {
    public static class Point {
        public int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static class MathMethods
    {
        /** complete the following methods as described below **/
        
        /*
        * Return the distance between Point objects
        */
        public static double distance(Point pt01, Point pt02)
        {
            return Math.sqrt(Math.pow((pt02.x - pt01.x), 2) + Math.pow(pt02.y - pt01.y, 2));  
        }
        
        /*
        * Return the distance between the Point object and the origin
        */
        public static double distance(Point pt)
        {
            
            return 0.0;
        }
        
        /*
        * Generate a random number between [low, high)
        */
        public static int randIntGen(int low, int high)
        {
            
            return 0;
        }
        
        /*
        * Generate a random number between [0, high)
        */
        public static int randIntGen(int high)
        {
            
            return 0;
        }
        
        /*
        * Generate a random number between [low, high]
        */
        public static int randIntGenInclusive(int low, int high)
        {
            
            return 0;
        }
        
        /** Do not modify the code below **/
        public static void run() throws IOException
        {
            /******************************************************/
            
            System.out.println("\n/****** Random Integer Numbers Range ******/");
            File file = new File("random.dat");
            Scanner tFile = new Scanner(file);
            while(tFile.hasNext())
            {
                /* read in the integer values from the text file
                * file stores values as follows:
                * 3 110
                * 7 41
                */
                int low = tFile.nextInt();
                int high = tFile.nextInt();
                
                //calc random number and display
                int rand = randIntGen(low, high);
                System.out.printf("A random number [" + low + ", " + high + "): %d\n", rand);
            }
            tFile.close();

            /******************************************************/
            
            System.out.println("\n/****** Random Integer Numbers from 0 ******/");
            file = new File("randomUpper.dat");
            tFile = new Scanner(file);
            while(tFile.hasNext())
            {
                /* read in the integer values from the text file
                * file stores values as follows:
                * 100
                * 4
                */
                int high = tFile.nextInt();
                
                //calc random number and display
                int rand = randIntGen(high);
                System.out.printf("A random number [0, " + high + "): %d\n", rand);
            }
            tFile.close();

            /******************************************************/
            
            System.out.println("\n/****** Random Integer Numbers Inclusive ******/");
            file = new File("randomInclusive.dat");
            tFile = new Scanner(file);
            while(tFile.hasNext())
            {
                /* read in the integer values from the text file
                * file stores values as follows:
                * 0 100
                * 7 43
                */
                int low = tFile.nextInt();
                int high = tFile.nextInt();
                
                //calc random number and display
                int rand = randIntGen(low, high);
                System.out.printf("A random number [" + low + ", " + high + "]: %d\n", rand);
            }
            tFile.close();


            /******************************************************/
            
            System.out.println("\n/****** Distance Between Points ******/");
            file = new File("distBetween.dat");
            tFile = new Scanner(file);
            while(tFile.hasNext())
            {
                /* read in the integer values from the text file
                * file stores values as follows:
                * 3 8 10 -3
                * 7 1 4 1
                */
                int x1 = tFile.nextInt();
                int y1 = tFile.nextInt();
                int x2 = tFile.nextInt();
                int y2 = tFile.nextInt();

                //create two Point objects
                Point ptA = new Point(x1, y1);
                Point ptB = new Point(x2, y2);;
                
                //calc distance and display - no need to change
                double dist = distance(ptA, ptB);
                System.out.printf("Distance between "+ ptA + " and " + ptB + " is %.3f\n", dist);
            }
            tFile.close();

            /******************************************************/
            
            System.out.println("\n/****** Distance From Origin ******/");
            file = new File("distOrigin.dat");
            tFile = new Scanner(file);
            while(tFile.hasNext())
            {
                /* read in the integer values from the text file
                * file stores values as follows:
                * 3 8
                * 7 1
                */
                int x1 = tFile.nextInt();
                int y1 = tFile.nextInt();
                
                //create two Point objects
                Point ptA = new Point(x1, y1);
                
                //calc distance and display - no need to change
                double dist = distance(ptA);
                System.out.printf("Distance between "+ ptA + " and (0, 0) is %.3f\n", dist);
            }
            tFile.close();


        }
    }
    public static class StringMethodsPart2
        {
            /** complete the following methods as described below **/
            
            /*
            * Given a string with name and ID, e.g., "Bob Smith 7569", 
            * return an login id with first initials, the first 3 letters
            * of last name, and id number → "BSmi7569".
            * 
            * Ex:
            *    login("Bob Smith 7569") → "BSmi7569"
            *    login("Alice Jones 8967") → "AJon8967"
            */
            public static String login(String str)
            {
                String[] pieces = str.split(" ");
                return pieces[0].substring(0,1) + pieces[1].substring(0,3) + pieces[2]; //modify to return the proper value
            }
        
            /*
            * Given a phrase, e.g., “Fortune favors the bold.”,  
            * return the phrase without any vowels → "Frtn fvrs th bld."
            * 
            * Ex:
            *    removeVowels("Fortune favors the bold.") → "Frtn fvrs th bld."
            *    removeVowels("Practice makes perfect.") → "“Prctc mks prfct."
            */
            public static String removeVowels(String str)
            {   
                return str.replace("a", ""); //modify to return the proper value
            }
            
            
            /** Do not modify the code below **/
            public static void run() throws IOException
            {
                /******************************************************/
                
                System.out.println("\n/****** Login ******/");
                File file = new File("login.dat");
                Scanner tFile = new Scanner(file);
                while(tFile.hasNext())
                {
                    String str = tFile.nextLine();
                    String loginName = login(str);
                    System.out.println("Login for " + str +": " + loginName);
                }
                tFile.close();
                
                /******************************************************/
                
                System.out.println("\n/****** Remove Vowels ******/");
                file = new File("phrases.dat");
                tFile = new Scanner(file);
                while(tFile.hasNext())
                {
                    String str = tFile.nextLine();
                    String removed = removeVowels(str);
                    System.out.println(str +": " + removed);
                }
                tFile.close();
            }
        }
};