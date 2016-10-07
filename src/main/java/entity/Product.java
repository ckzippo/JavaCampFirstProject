package entity;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/27/16
 * TIME:8:53 PM
 */

/**
 * 商品信息类
 */
public class Product {

    //商品信息字段
    private int     ep_id;  //编号
    private String  ep_name; //名字
    private String  ep_description;  //描述
    private String  ep_price;    //价格
    private String  ep_stock;    //库存
    private int     epc_id; //分类ID
    private int     epc_child_id;   //二级分类ID
    private String  ep_file_name;    //文件名
    private String  ep_barcode; //条形码

    /**
     * getter and setter
     */

    public int getEp_id() {
        return ep_id;
    }

    public void setEp_id(int ep_id) {
        this.ep_id = ep_id;
    }

    public String getEp_name() {
        return ep_name;
    }

    public void setEp_name(String ep_name) {
        this.ep_name = ep_name;
    }

    public String getEp_description() {
        return ep_description;
    }

    public void setEp_description(String ep_description) {
        this.ep_description = ep_description;
    }

    public String getEp_price() {
        return ep_price;
    }

    public void setEp_price(String ep_price) {
        this.ep_price = ep_price;
    }

    public String getEp_stock() {
        return ep_stock;
    }

    public void setEp_stock(String ep_stock) {
        this.ep_stock = ep_stock;
    }

    public int getEpc_id() {
        return epc_id;
    }

    public void setEpc_id(int epc_id) {
        this.epc_id = epc_id;
    }

    public int getEpc_child_id() {
        return epc_child_id;
    }

    public void setEpc_child_id(int epc_child_id) {
        this.epc_child_id = epc_child_id;
    }

    public String getEp_file_name() {
        return ep_file_name;
    }

    public void setEp_file_name(String ep_file_name) {
        this.ep_file_name = ep_file_name;
    }

    public String getEp_barcode() {
        return ep_barcode;
    }

    public void setEp_barcode(String ep_barcode) {
        this.ep_barcode = ep_barcode;
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
        return "id: " + getEp_id()
                + " name: " + getEp_name()
                + " description: " + getEp_description()
                + " price: " + getEp_price()
                + " stock: " + getEp_stock()
                + " ic: " + getEpc_id()
                + " child_id: " + getEpc_child_id()
                + " filename: " + getEp_file_name()
                + " barcode: " + getEp_barcode();
    }


}
