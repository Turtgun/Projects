package helloworld;

public class Abril {
    public static void run() {
        System.out.print("    SEM 2023\n  Java Program\n     Launch!\n================\n       ^\n       ^\n");
        for (int i = 0; i < 3; i++) {
            for (int v = 0; v < 7-i; v++) {
                System.out.print(" ");
            }
            System.out.print("|");
            if (i != 0) {
                for (int v = 0; v < ((i<2)? i:i+1); v++) {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.print("\n");
        }
        for (int i = 0; i < 11; i++) {
            System.out.print("    |");
            switch (i){
                case 0:
                    System.out.print("_____");
                    break;
                case 3:
                    System.out.print("  S  ");
                    break;
                case 4:
                    System.out.print("  E  ");
                    break;
                case 5:
                    System.out.print("  M  ");
                    break;
                case 7:
                    System.out.print("  T  ");
                    break;
                case 8:
                    System.out.print("  X  ");
                    break;
                default:
                    System.out.print("     ");
                    break;
            }
            System.out.println("|");
        }
        System.out.print("    [-----]\n     |###|\n      |#|\n       #\n      <#>\n     (###)\n    {~~~~~}\n   {~~} {~~}\n  {~~}   {~~}\n {~~~~} {~~~~}\n{~~~~~} {~~~~~}");
    }
}
