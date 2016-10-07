package entity;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/28/16
 * TIME:7:54 AM
 */
public enum Sex {
    MALE(0),    //男
    FEMALE(1);  //女

    private int sex;

    private Sex(int sex) {
        this.sex = sex;
    }

    public int getSex() {
        return sex;
    }
}
