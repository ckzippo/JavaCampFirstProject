package entity;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/27/16
 * TIME:8:57 PM
 */

/**
 * 商品分类信息类
 */
public class ProductCategory {

    //商品分类信息字段
    private int     epc_id; //编号
    private String  epc_name;    //名字
    private int     epc_parent_id;  //父分类

    /**
     * getter and setter
     */

    public int getEpc_id() {
        return epc_id;
    }

    public void setEpc_id(int epc_id) {
        this.epc_id = epc_id;
    }

    public String getEpc_name() {
        return epc_name;
    }

    public void setEpc_name(String epc_name) {
        this.epc_name = epc_name;
    }

    public int getEpc_parent_id() {
        return epc_parent_id;
    }

    public void setEpc_parent_id(int epc_parent_id) {
        this.epc_parent_id = epc_parent_id;
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
        return "epc_id: " + getEpc_id()
                + " epc_name: " + getEpc_name()
                + " epc_parent_id: " + getEpc_parent_id();
    }
}
