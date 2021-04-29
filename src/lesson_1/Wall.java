package lesson_1;

public class Wall {

    private double height;

    public Wall(double height) {
        this.height = height;

    }

    public boolean lengthInfo(String name, double heightMax) {

        if(height <= heightMax) {
            System.out.printf("%s прыгнул в высоту %s метров %n", name, height);
            return true;
        }else {
            System.out.printf("%s не смог прыгнуть в высоту  %s метров %n", name, height);
            return false;
        }
    }
}
