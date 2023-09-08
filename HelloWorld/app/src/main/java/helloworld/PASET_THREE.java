package helloworld;

public class PASET_THREE {
    public static class Vector2 {
        int x,y = 0;
        Vector2(int x, int y) {
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
        Entity robot;
        public World(Entity[] entities) {
            update(entities);
            System.out.println("Starting Position.");
            print();
        }
        public void update(Entity[] entities) {
            for (int e = 0; e < grid.length; e++) {
                for (int a = 0; a < grid[0].length; a++) {
                    grid[e][a] = Objects.NULL;
                }
            }
            for (Entity ent : entities) {
                if (ent instanceof Robot) {
                    grid[10-ent.pos.y][ent.pos.x-1] = Objects.ROBOT;
                    robot = ent;
                } else if (!ent.held) {grid[10-ent.pos.y][ent.pos.x-1] = Objects.BEEPER;}
            }
        }
        public void print() {
            for (Objects[] e: grid) {
                for (Objects a : e) {
                    switch (a) {
                        case NULL:
                            System.out.print(". ");
                            break;
                        case BEEPER:
                            System.out.print("X ");
                            break;
                        case ROBOT:
                            switch (robot.dir) {
                                case NORTH:
                                    System.out.print("A ");
                                    break;
                                case EAST:
                                    System.out.print("> ");
                                    break;
                                case SOUTH:
                                    System.out.print("V ");
                                    break;
                                case WEST:
                                    System.out.print("< ");
                                    break;
                                default:
                                    System.out.println("\nError! Robot has a NULL direction.");
                                    System.exit(1);
                                    break;
                            }
                            break;
                    }
                }
                System.out.print("\n");
            }
        }
    }
    private static class Entity {
        Vector2 pos = new Vector2(1, 1);
        Direction dir = Direction.NULL;
        boolean held = false;
        Entity(int x, int y) {pos = new Vector2(x, y);}
    }
    private static class Robot extends Entity {
        public Beeper heldBeeper = b1;
        private int heldBeeperID;
        Robot(int x, int y) {super(x,y);}
        public void move() {
            pos.x += ((dir == Direction.EAST)?1:0) - ((dir == Direction.WEST)?1:0);
            pos.y += ((dir == Direction.NORTH)?1:0) - ((dir == Direction.SOUTH)?1:0);
            if (heldBeeper!=null) {heldBeeper.pos.x=pos.x; heldBeeper.pos.y = pos.y;}
        }
        public void turnLeft() {
            switch (dir) {
                case NORTH:
                    dir = Direction.WEST;
                    break;
                case EAST:
                    dir = Direction.NORTH;
                    break;
                case SOUTH:
                    dir = Direction.EAST;
                    break;
                case WEST:
                    dir = Direction.SOUTH;
                    break;
                default:
                    System.out.println("\nError! Robot has a NULL direction.");
                    System.exit(1);
                    break;
            }
        }
        public void pickBeeper(Beeper b, int beepID) {
            if (pos.x != b.pos.x || pos.y != b.pos.y) {return;}
            heldBeeper = b;
            heldBeeperID = beepID;
            toggleBeep(beepID);
        }
        public void putBeeper() {
            if (heldBeeper==null) {return;}
            switch (heldBeeperID) {
                case 1:
                    b1.pos = heldBeeper.pos;
                    break;
                case 2:
                    b2.pos = heldBeeper.pos;
                    break;
                case 3:
                    b3.pos = heldBeeper.pos;
                    break;
                case 4:
                    b4.pos = heldBeeper.pos;
                    break;
                case 5:
                    b5.pos = heldBeeper.pos;
                    break;
            }
            heldBeeper = null;
            toggleBeep(heldBeeperID);
        }
    }

    private static class Beeper extends Entity {
        Beeper(int x, int y) {super(x,y);}
        public void toggleHeld(){held=!held;}
    }
    private static void toggleBeep(int beepID) {
        switch (beepID) {
            case 1:
                b1.toggleHeld();
                break;
            case 2:
                b2.toggleHeld();
                break;
            case 3:
                b3.toggleHeld();
                break;
            case 4:
                b4.toggleHeld();
                break;
            case 5:
                b5.toggleHeld();
                break;
        }
    }

    private static Robot urRobot = new Robot(0, 0);  
    private static Beeper b1 = new Beeper(0,0);
    private static Beeper b2 = new Beeper(0,0);
    private static Beeper b3 = new Beeper(0,0);
    private static Beeper b4 = new Beeper(0,0);
    private static Beeper b5 = new Beeper(0,0);
    public static void updater(World w, Entity[] entities) {
        System.out.println("World Snapshot");
        w.update(entities);
        w.print();
    }
    public static void turnRight() {
        urRobot.turnLeft();
        urRobot.turnLeft();
        urRobot.turnLeft();
    }
    public static void move(int v) {
        for (int i = 0;i<v;i++){
            urRobot.move();
        }
    }
    public static void run1() {
        urRobot.dir = Direction.EAST;
        urRobot.pos = new Vector2(7,2);
        b1.pos = new Vector2(5, 2);
        World w = new World(new Entity[] {urRobot, b1});

        // CODE
        urRobot.turnLeft();
        urRobot.turnLeft();
        move(2);
        urRobot.pickBeeper(b1, 1);
        
        updater(w, new Entity[] {urRobot, b1});

        urRobot.turnLeft();
        urRobot.turnLeft();
        move(2);
        urRobot.putBeeper();
        //

        System.out.println("Ending Position.");
        updater(w, new Entity[] {urRobot, b1});

        System.out.print("\n\n\n");
    }
    public static void run2() {
        urRobot.dir = Direction.EAST;
        urRobot.pos = new Vector2(4, 5);
        World w = new World(new Entity[] {urRobot});

        //CODE
        for (int i = 0; i < 4; i++) {
            move(3);
            urRobot.turnLeft();
            updater(w, new Entity[] {urRobot});
        }
        //

        System.out.print("\n\n\n");
    }
    public static void run3() {
        urRobot.dir = Direction.WEST;
        urRobot.pos = new Vector2(4, 3);
        b1.pos = new Vector2(3, 3);
        World w = new World(new Entity[] {urRobot, b1});

        //CODE
        turnRight();

        for (int i = 0; i < 3; i++) {
            updater(w, new Entity[] {urRobot, b1});
            move(2);
            urRobot.turnLeft();
        }
        urRobot.move();
        urRobot.pickBeeper(b1, 1);
        updater(w, new Entity[] {urRobot, b1});
        urRobot.turnLeft();
        urRobot.turnLeft();
        urRobot.move();
        updater(w, new Entity[] {urRobot, b1});
        for (int i = 0; i < 3; i++) {
            turnRight();
            move(2);
            updater(w, new Entity[] {urRobot, b1});
        }
        urRobot.putBeeper();
        System.out.println("Ending Position");
        updater(w, new Entity[] {urRobot, b1});

        System.out.print("\n\n\n");
    }
    public static void run4() {
        urRobot.pos = new Vector2(2, 1);
        urRobot.dir = Direction.EAST;
        b1.pos = new Vector2(2, 1);
        urRobot.pickBeeper(b1, 1);

        World w = new World(new Entity[] {urRobot, b1});

        for (int i = 0; i < 2; i++) {
            urRobot.move();
            urRobot.turnLeft();
            move(2);
            turnRight();
            updater(w, new Entity[] {urRobot, b1});
        }
        urRobot.move();
        urRobot.putBeeper();
        updater(w, new Entity[] {urRobot, b1});
        for (int i = 0; i < 2; i++) {
            urRobot.move();
            turnRight();
            move(2);
            urRobot.turnLeft();
            updater(w, new Entity[] {urRobot, b1});
        }
        urRobot.move();
        System.out.println("Ending Position");
        updater(w, new Entity[] {urRobot, b1});
        
        System.out.print("\n\n\n");
    }
    public static void run5() {
        urRobot.pos = new Vector2(7,5);
        urRobot.dir = Direction.EAST;
        b1.pos = new Vector2(5, 5);
        b2.pos = new Vector2(4, 6);
        b3.pos = new Vector2(3, 7);
        b4.pos = new Vector2(3, 8);

        World w = new World(new Entity[] {urRobot,b1,b2,b3,b4});
        urRobot.turnLeft();
        urRobot.turnLeft();
        move(2);
        urRobot.pickBeeper(b1, 1);
        updater(w, new Entity[] {urRobot,b1,b2,b3,b4});
        turnRight();
        urRobot.move();
        urRobot.turnLeft();
        urRobot.move();
        urRobot.pickBeeper(b2, 2);
        updater(w, new Entity[] {urRobot,b1,b2,b3,b4});
        turnRight();
        urRobot.move();
        urRobot.turnLeft();
        urRobot.move();
        urRobot.pickBeeper(b3, 3);
        updater(w, new Entity[] {urRobot,b1,b2,b3,b4});
        turnRight();
        urRobot.move();
        urRobot.turnLeft();
        urRobot.turnLeft();
        urRobot.pickBeeper(b4, 4);
        updater(w, new Entity[] {urRobot,b1,b2,b3,b4});
        urRobot.move();

        for (int i = 0; i < 2; i++) {
            urRobot.turnLeft();
            urRobot.move();
            turnRight();
            urRobot.move();
            updater(w, new Entity[] {urRobot,b1,b2,b3,b4});
        }
        urRobot.turnLeft();
        move(2);
        
        System.out.println("Ending Position");
        updater(w, new Entity[] {urRobot, b1});
        urRobot.putBeeper();
        
        System.out.print("\n\n\n");
    }
    public static void run6() {
        urRobot.pos = new Vector2(3, 4);
        urRobot.dir = Direction.EAST;
        b1.pos = new Vector2(5, 6);b1.held=false;
        b2.pos = new Vector2(5, 5);b2.held=false;
        b3.pos = new Vector2(5, 4);b3.held=false;
        b4.pos = new Vector2(5, 3);b4.held=false;
        b5.pos = new Vector2(5, 2);b5.held=false;

        World w = new World(new Entity[] {urRobot,b1,b2,b3,b4,b5});
        move(2);
        urRobot.turnLeft();
        move(2);
        urRobot.pickBeeper(b1, 1);
        updater(w, new Entity[] {urRobot,b1,b2,b3,b4,b5});
        urRobot.turnLeft();
        urRobot.turnLeft();
        move(2);
        turnRight();
        move(2);
        urRobot.putBeeper();
        urRobot.turnLeft();
        urRobot.turnLeft();
        updater(w, new Entity[] {urRobot,b1,b2,b3,b4,b5});
        move(2);
        urRobot.turnLeft();
        urRobot.move();
        urRobot.pickBeeper(b2, 2);
        updater(w, new Entity[] {urRobot,b1,b2,b3,b4,b5});
        urRobot.turnLeft();
        urRobot.move();
        urRobot.turnLeft();
        urRobot.move();
        urRobot.putBeeper();
        updater(w, new Entity[] {urRobot,b1,b2,b3,b4,b5});
        urRobot.move();
        urRobot.turnLeft();
        urRobot.move();
        urRobot.pickBeeper(b4, 4);
        updater(w, new Entity[] {urRobot,b1,b2,b3,b4,b5});
        urRobot.move();
        urRobot.turnLeft();
        urRobot.move();
        urRobot.turnLeft();
        urRobot.putBeeper();
        updater(w, new Entity[] {urRobot,b1,b2,b3,b4,b5});
        urRobot.move();
        urRobot.turnLeft();
        move(2);
        urRobot.pickBeeper(b5, 5);
        updater(w, new Entity[] {urRobot,b1,b2,b3,b4,b5});
        urRobot.turnLeft();
        urRobot.turnLeft();
        move(2);
        turnRight();
        move(2);
        urRobot.putBeeper();
        updater(w, new Entity[] {urRobot,b1,b2,b3,b4,b5});
        urRobot.turnLeft();
        urRobot.turnLeft();
        move(2);
        urRobot.turnLeft();
        move(2);
        urRobot.turnLeft();
        urRobot.turnLeft();
        
        System.out.println("Ending Position");
        updater(w, new Entity[] {urRobot,b1,b2,b3,b4,b5});
        
        System.out.print("\n\n\n");
    }
    public static void run7() {
        urRobot.pos = new Vector2(5, 3);
        urRobot.dir = Direction.NORTH;
        b1.pos = new Vector2(5, 4);
        b2.pos = new Vector2(5, 6);
        World w = new World(new Entity[] {urRobot,b1,b2});

        urRobot.turnLeft();
        urRobot.move();
        updater(w, new Entity[] {urRobot,b1,b2});
        for (int i = 0; i < 2; i++) {turnRight(); move(2);
            updater(w, new Entity[] {urRobot,b1,b2});}
        for (int i = 0; i < 4; i++) {urRobot.turnLeft(); move(2);
            updater(w, new Entity[] {urRobot,b1,b2});}
        turnRight();
        move(2);
        updater(w, new Entity[] {urRobot,b1,b2});
        turnRight();
        urRobot.move();
        turnRight();
        System.out.println("Ending Position");
        updater(w, new Entity[] {urRobot,b1,b2});
    }
}