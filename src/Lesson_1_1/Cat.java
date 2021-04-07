package Lesson_1_1;

public class Cat implements JumpWall,  FleeTreadmill, Flee, Jump{
    private String name;
    private  boolean flee;
    private boolean jump;

    final int lengthMax = 20;
    final double heightMax = 2.3;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    public boolean fleeTreadmill(Treadmill treadmill) {
        flee = treadmill.lengthInfo(name, lengthMax);

        return flee;
    }

    @Override
    public boolean jumpWall(Wall wall) {
        jump = wall.lengthInfo(name,heightMax);
        return  jump;
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
