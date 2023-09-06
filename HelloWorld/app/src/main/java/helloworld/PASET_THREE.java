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
                            System.out.print("# ");
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
        Vector2 pos = new Vector2(0, 0);
        Direction dir = Direction.NULL;
        boolean held = false;
        Entity(int x, int y) {pos = new Vector2(x, y);}
    }
    private static class Robot extends Entity {
        private Beeper heldBeeper;
        private int heldBeeperID;
        Robot(int x, int y) {super(x,y);}
        public void move() {
            pos.x += ((dir == Direction.EAST)?1:0) - ((dir == Direction.WEST)?1:0);
            pos.y += ((dir == Direction.NORTH)?1:0) - ((dir == Direction.SOUTH)?1:0);
            if (heldBeeper!=null) {heldBeeper.pos=pos;}
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
                    b1 = heldBeeper;
                    break;
                case 2:
                    b2 = heldBeeper;
                    break;
                case 3:
                    b3 = heldBeeper;
                    break;
                case 4:
                    b4 = heldBeeper;
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
        }
    }

    private static Robot urRobot = new Robot(0, 0);  
    private static Beeper b1 = new Beeper(0,0);
    private static Beeper b2 = new Beeper(0,0);
    private static Beeper b3 = new Beeper(0,0);
    private static Beeper b4 = new Beeper(0,0);
    public static void run1() {
        urRobot.dir = Direction.EAST;
        urRobot.pos = new Vector2(7,2);
        b1.pos = new Vector2(5, 2);
        World w = new World(new Entity[] {urRobot, b1});

        // CODE
        urRobot.turnLeft();
        urRobot.turnLeft();
        urRobot.move();
        urRobot.move();
        urRobot.pickBeeper(b1, 1);
        
        System.out.println("World Snapshot");
        w.update(new Entity[] {urRobot, b1});
        w.print();

        urRobot.turnLeft();
        urRobot.turnLeft();
        urRobot.move();
        urRobot.move();
        urRobot.putBeeper();
        //

        System.out.println("Ending Position.");
        w.update(new Entity[] {urRobot, b1});
        w.print();

        System.out.print("\n\n\n");
    }
    public static void run2() {
        urRobot.dir = Direction.EAST;
        urRobot.pos = new Vector2(4, 5);
        World w = new World(new Entity[] {urRobot});

        //CODE
        for (int i = 0; i < 4; i++) {
            urRobot.move();
            urRobot.move();
            urRobot.move();
            urRobot.turnLeft();
            System.out.println("World Snapshot");
            w.update(new Entity[]{urRobot});
            w.print();
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
        urRobot.turnLeft();
        urRobot.turnLeft();
        urRobot.turnLeft();

        for (int i = 0; i < 3; i++) {
            System.out.println("World Snapshot");
            w.update(new Entity[]{urRobot, b1});
            w.print();
            urRobot.move();
            urRobot.move();
            urRobot.turnLeft();
        }
        urRobot.move();
        urRobot.pickBeeper(b1, 1);
        System.out.println("World Snapshot");
        w.update(new Entity[]{urRobot, b1});
        w.print();
        urRobot.turnLeft();
        urRobot.turnLeft();
        urRobot.move();
        System.out.println("World Snapshot");
        w.update(new Entity[]{urRobot, b1});
        w.print();
        for (int i = 0; i < 3; i++) {
            urRobot.turnLeft();
            urRobot.turnLeft();
            urRobot.turnLeft();
            urRobot.move();
            urRobot.move();
            
            System.out.println("World Snapshot");
            w.update(new Entity[]{urRobot, b1});
            w.print();
        }
        urRobot.putBeeper();
        System.out.println("Ending Position");
        w.update(new Entity[]{urRobot, b1});
        w.print();

        System.out.print("\n\n\n");
    }
    public static void run4() {
        
    }
}