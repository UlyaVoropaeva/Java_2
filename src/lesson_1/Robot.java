package lesson_1;

public class Robot {
    private String name;

    final int lengthMax = 100;
    final double heightMax = 0.50;

    public Robot(String name) {
        this.name = name;

    }

    public void flee() {
        System.out.printf("%s побежал %n", name);
    }

    public void jump() {
        System.out.printf("%s подпрыгнул %n", name);
    }

    public boolean fleeTreadmill(Treadmill treadmill) {
        if (treadmill.lengthInfo(name, lengthMax) == true) {
            return true;
        } else return false;
    }

    public boolean jumpWall(Wall wall) {
        if (wall.lengthInfo(name, heightMax) == true) {
            return true;
        } else return false;
    }
}
