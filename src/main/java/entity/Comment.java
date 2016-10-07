package entity;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/27/16
 * TIME:8:51 PM
 */

/**
 * 留言类
 */
public class Comment {

    //留言信息字段
    private int ec_id;  //编号
    private String ec_reply;    //回复
    private String ec_content;  //内容
    private String ec_create_time;  //创建时间
    private String ec_reply_time;   //回复时间
    private String ec_nick_name;    //留言用户昵称

    /**
     * getter and setter
     */

    public int getEc_id() {
        return ec_id;
    }

    public void setEc_id(int ec_id) {
        this.ec_id = ec_id;
    }

    public String getEc_reply() {
        return ec_reply;
    }

    public void setEc_reply(String ec_reply) {
        this.ec_reply = ec_reply;
    }

    public String getEc_content() {
        return ec_content;
    }

    public void setEc_content(String ec_content) {
        this.ec_content = ec_content;
    }

    public String getEc_create_time() {
        return ec_create_time;
    }

    public void setEc_create_time(String ec_create_time) {
        this.ec_create_time = ec_create_time;
    }

    public String getEc_reply_time() {
        return ec_reply_time;
    }

    public void setEc_reply_time(String ec_reply_time) {
        this.ec_reply_time = ec_reply_time;
    }

    public String getEc_nick_name() {
        return ec_nick_name;
    }

    public void setEc_nick_name(String ec_nick_name) {
        this.ec_nick_name = ec_nick_name;
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
        return "id: " + getEc_id()
                + " reply: " + getEc_reply()
                + " content: " + getEc_content()
                + " createtime: " + getEc_create_time()
                + " replytime: " + getEc_reply_time()
                + " nickname: " + getEc_nick_name();
    }
}
