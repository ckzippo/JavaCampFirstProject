package entity;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/27/16
 * TIME:9:16 PM
 */

/**
 * 订单状态枚举类
 */
public enum OrderStatus {

    ORDERED(1), //下单
    VERIFIED(2),    //审核通过
    ALLOCATION(3),  //配货
    ONDELIVERY(4),  //送货中
    CONFIRMED(5);  //收货并确认

    private int status;
    private OrderStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
