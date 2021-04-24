package lesson_1;

public class Cat {
    private String name;
    final int lengthMax = 20;
    final double heightMax = 2.3;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
