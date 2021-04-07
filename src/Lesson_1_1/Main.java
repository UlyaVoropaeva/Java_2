package Lesson_1_1;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {

        Object[] objects = {
                new Cat("Bonya"),
                new Cat("Bond"),
                new People("Ivan"),
                new Robot("Rb_1"),
                new People("Max")
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


        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (objects[i].getClass() == Cat.class) {
                    if (obstacles[j].getClass() == Treadmill.class) {
                        if (true == ((Cat) objects[i]).fleeTreadmill((Treadmill) obstacles[j])) {
                        } else break;
                    }
                    if (obstacles[j].getClass() == Wall.class) {
                        if (true == ((Cat) objects[i]).jumpWall((Wall) obstacles[j])) {
                        } else break;
                    }
                }

                if (objects[i].getClass() == People.class) {

                    if (obstacles[j].getClass() == Treadmill.class) {
                        if (true == ((People) objects[i]).fleeTreadmill((Treadmill) obstacles[j])) {
                        } else break;
                    }
                    if (obstacles[j].getClass() == Wall.class) {
                        if (true == ((People) objects[i]).jumpWall((Wall) obstacles[j])) {
                        } else break;
                    }
                }

                if (objects[i].getClass() == Robot.class) {
                    if (obstacles[j].getClass() == Treadmill.class) {
                        if (true == ((Robot) objects[i]).fleeTreadmill((Treadmill) obstacles[j])) {
                        } else break;
                    }
                    if (obstacles[j].getClass() == Wall.class) {
                        if (true == ((Robot) objects[i]).jumpWall((Wall) obstacles[j])) {
                        } else break;
                    }
                }
            }
        }
    }
}