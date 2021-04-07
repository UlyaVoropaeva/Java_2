package Lesson_1_1;

public class Robot implements JumpWall, FleeTreadmill, Jump, Flee {

    private String name;
    private boolean flee;
    private boolean jump;
    private Wall wall;

    final int lengthMax = 100;
    final double heightMax = 0.50;

    public Robot(String name) {
        this.name = name;

    }

    @Override
    public boolean fleeTreadmill(Treadmill treadmill) {
        flee = treadmill.lengthInfo(name, lengthMax);
        return flee;
    }

    @Override
    public boolean jumpWall(Wall wall) {
        jump = wall.lengthInfo(name, heightMax);
        return jump;
    }


    @Override
    public void jump() {
            if(jump){
                System.out.printf("%s подпрыгнул %n", name);
            } else
                System.out.printf("%s  не подпрыгнул %n", name);

    }

    @Override
    public void flee() {
          if (flee){
                System.out.printf("%s побежал %n", name);
            } else
                System.out.printf("%s не побежал %n", name);
        }

}
