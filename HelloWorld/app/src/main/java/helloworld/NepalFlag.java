package helloworld;

public class NepalFlag {
    public static void run() {
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
}
