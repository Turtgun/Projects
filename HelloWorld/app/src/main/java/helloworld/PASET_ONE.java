package helloworld;

public class PASET_ONE {
    public static void nepalFlag() {
        int c = 6;
        boolean looped = false;
        for (int z = 0; z < 2; z++) {
            for (int i = 0; i < c; i++) {
                if (!(looped && i == 0))
                    System.out.print("|");
                for (int v = 1; v < i; v++) {
                    System.out.print("#");
                    if (!looped)
                        System.out.print("#");
                }
                if (i != 0) {
                    System.out.print("#");
                    if (looped)
                        System.out.print("#");
                    System.out.print("\\");
                }
                if (!(looped && i == 0))
                    System.out.print("\n");
            }
            c = 8;
            looped = true;
        }
    }
    public static void andy() {
        int x = 3;
        for (int i = 0; i < 4; i++) {
            for (int v = 0; v < x; v++) {
                System.out.print(" ");
            }
            System.out.print("ooooo");
            for (int v = 0; v < 4-x; v++) {
                System.out.print("+");
            }
            System.out.print("\n");
            x--;
        }
        x = 4;
        for (int i = 0; i < 4; i++) {
            System.out.print("xxxxx");
            for (int v = 0; v < x; v++) {
                System.out.print("+");
            }
            System.out.print("\n");
            x--;
        }
    }
    public static void abril() {
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
        System.out.print("    [-----]\n     |###|\n      |#|\n       #\n      <#>\n     (###)\n    {~~~~~}\n   {~~} {~~}\n  {~~}   {~~}\n {~~~~} {~~~~}\n{~~~~~} {~~~~~}\n");
    }
}