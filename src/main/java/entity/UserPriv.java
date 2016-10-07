package entity;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/27/16
 * TIME:9:20 PM
 */

/**
 * 用户权限枚举类
 */
public enum UserPriv {

    ORDINARYUSER(1),    //普通用户
    ADMIN(2);   //管理员

    private int priv;

    private UserPriv(int priv) {
        this.priv = priv;
    }

    public int getPriv(){
        return priv;
    }
}
