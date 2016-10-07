package entity;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/27/16
 * TIME:8:48 PM
 */

/**
 * 新闻类
 */
public class News {

    // 新闻信息字段
    private int     en_id; //编号
    private String  en_title;    //标题
    private String  en_content;  //内容
    private String  en_create_time;  //录入日期

    /**
     * getter and setter
     */
    public int getEn_id() {
        return en_id;
    }

    public void setEn_id(int en_id) {
        this.en_id = en_id;
    }

    public String getEn_title() {
        return en_title;
    }

    public void setEn_title(String en_title) {
        this.en_title = en_title;
    }

    public String getEn_content() {
        return en_content;
    }

    public void setEn_content(String en_content) {
        this.en_content = en_content;
    }

    public String getEn_create_time() {
        return en_create_time;
    }

    public void setEn_create_time(String en_create_time) {
        this.en_create_time = en_create_time;
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
        return "id: " + getEn_id()
                + " title: " + getEn_title()
                + " content: " + getEn_content()
                + " createtime: " + getEn_create_time();
    }
}
