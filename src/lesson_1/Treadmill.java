package lesson_1;

public class Treadmill {
    private double length;

    public Treadmill(double length) {
        this.length = length;
    }


    public boolean lengthInfo(String name, double lengthMax) {
        if (length <= lengthMax) {
            System.out.printf("%s пробежал по беговой дорожке %s метров %n", name, length);
            return true;
        } else {
            System.out.printf("%s не смог пробежать по беговой дорожке %s метров %n", name, length);
            return false;
        }

    }
}
