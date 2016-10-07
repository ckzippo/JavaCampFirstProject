package entity;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/27/16
 * TIME:9:09 PM
 */

/**
 * 付款方式枚举类
 */
public enum PayMethod {
    CASHONDELIVERY(1),  //货到付款
    PAYONNET(2);        //网上付款

    private int pay;

    private PayMethod(int payMethod) {
        this.pay = payMethod;
    }

    public int getPay() {
        return pay;
    }
}
