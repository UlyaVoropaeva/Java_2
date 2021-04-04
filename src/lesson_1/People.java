package lesson_1;

public class People {
    private String name;
    ;
    final int lengthMax = 1000;
    final double heightMax = 2.50;

    public People(String name) {
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
