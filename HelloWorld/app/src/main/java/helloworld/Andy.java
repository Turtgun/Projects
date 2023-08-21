package helloworld;

public class Andy {
    public static void run() {
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
}
