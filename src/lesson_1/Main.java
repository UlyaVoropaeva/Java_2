package lesson_1;

public class Main {

    public static void main(String[] args) {
        Object[] object = {
                new Cat("Bonya"),
                new People("Ivan"),
                new Robot("Rb_1"),
                new Cat ("Barsik"),
        };

        Object[] obstacles = {
                new Treadmill(5),
                new Wall(1),
                new Treadmill(20),
                new Wall(2),
                new Treadmill(30),
                new Wall(3),
                new Treadmill(50)
        };


        for (int i = 0; i < object.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (object[i].getClass() == Cat.class) {
                    if (obstacles[j].getClass() == Treadmill.class) {
                        if (true == ((Cat) object[i]).fleeTreadmill((Treadmill) obstacles[j])) {
                        } else break;
                    }
                    if (obstacles[j].getClass() == Wall.class) {
                        if (true == ((Cat) object[i]).jumpWall((Wall) obstacles[j])) {
                        } else break;
                    }
                }

                if (object[i].getClass() == People.class) {

                    if (obstacles[j].getClass() == Treadmill.class) {
                        if (true == ((People) object[i]).fleeTreadmill((Treadmill) obstacles[j])) {
                        } else break;
                    }
                    if (obstacles[j].getClass() == Wall.class) {
                        if (true == ((People) object[i]).jumpWall((Wall) obstacles[j])) {
                        } else break;
                    }
                }

                if (object[i].getClass() == Robot.class) {
                    if (obstacles[j].getClass() == Treadmill.class) {
                        if (true == ((Robot) object[i]).fleeTreadmill((Treadmill) obstacles[j])) {
                        } else break;
                    }
                    if (obstacles[j].getClass() == Wall.class) {
                        if (true == ((Robot) object[i]).jumpWall((Wall) obstacles[j])) {
                        } else break;
                    }
                }
            }
        }
    }
}