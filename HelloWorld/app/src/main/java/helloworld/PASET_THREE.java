package helloworld;

public class PASET_THREE {
    public static class Vector2 {
        double x,y = 0;
        Vector2(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    public static enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST,
        NULL
    }
    public static enum Objects {
        NULL,
        BEEPER,
        ROBOT
    }
    private static class World {
        Objects[][] grid = new Objects[10][10];
        public static void init() {}
    }
    private static class Entity {
        Vector2 pos = new Vector2(0, 0);
        Direction dir = Direction.NULL;
        Entity(int x, int y) {pos = new Vector2(x, y);}
    }
    private static class Robot extends Entity {
        Robot(int x, int y) {super(x,y);}
    }
    private static class Beeper extends Entity {
        Beeper(int x, int y) {super(x,y);}
    }

    private static Robot urRobot = new Robot(0, 0);
    public static void run1() {
        urRobot.dir = Direction.EAST;
        urRobot.pos = new Vector2(7,2);
        Beeper b1 = new Beeper(5,2);
        World.init();
    }
}