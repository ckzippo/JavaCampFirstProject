package entity;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/27/16
 * TIME:8:58 PM
 */

/**
 * 订单类
 */
public class Order {

    //订单信息字段
    private int     eo_id;  //编号
    private int     eo_user_id; //用户ID
    private String  eo_user_name;   //用户名
    private String  eo_user_address;    //用户地址
    private String  eo_create_time; //创建时间
    private String  eo_cost;    //金额
    private int     eo_status;  //状态。1 下单 2 审核通过 3 配货 4 送货中 5 收货并确认
    private int     eo_type;    //付款方式。1 货到付款   2 网上支付

    /**
     * getter and setter
     */

    public int getEo_id() {
        return eo_id;
    }

    public void setEo_id(int eo_id) {
        this.eo_id = eo_id;
    }

    public int getEo_user_id() {
        return eo_user_id;
    }

    public void setEo_user_id(int eo_user_id) {
        this.eo_user_id = eo_user_id;
    }

    public String getEo_user_name() {
        return eo_user_name;
    }

    public void setEo_user_name(String eo_user_name) {
        this.eo_user_name = eo_user_name;
    }

    public String getEo_user_address() {
        return eo_user_address;
    }

    public void setEo_user_address(String eo_user_address) {
        this.eo_user_address = eo_user_address;
    }

    public String getEo_create_time() {
        return eo_create_time;
    }

    public void setEo_create_time(String eo_create_time) {
        this.eo_create_time = eo_create_time;
    }

    public String getEo_cost() {
        return eo_cost;
    }

    public void setEo_cost(String eo_cost) {
        this.eo_cost = eo_cost;
    }

    public int getEo_status() {
        return eo_status;
    }

    public void setEo_status(int eo_status) {
        this.eo_status = eo_status;
    }

    public int getEo_type() {
        return eo_type;
    }

    public void setEo_type(int eo_type) {
        this.eo_type = eo_type;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "id: " + getEo_id()
                + " userid: " + getEo_user_id()
                + " username: " + getEo_user_name()
                + " useraddress: " + getEo_user_address()
                + " createtime: " + getEo_create_time()
                + " cost: " + getEo_cost()
                + " status: " + getEo_status()
                + " type: " + getEo_type();
    }
}
