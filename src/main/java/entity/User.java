package entity;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/27/16
 * TIME:8:41 PM
 */

/**
 * 用户类
 */
public class User {

    //用户信息字段
    private int     eu_user_id; //用户ID
    private String  eu_user_name; // 用户名
    private String  eu_password; //密码
    private int     eu_sex; //用户性别  0 表示男,1表示女
    private String  eu_birthday;    //生日
    private String  eu_identity_code;    //身份证号
    private String  eu_email;    //email
    private String  eu_mobile;   //手机
    private String  eu_address;  //地址
    private String  eu_headimage;   //用户头像
    private int     eu_status = 1;   //1 普通用户 2 管理员

    /**
     *     getter and setter
     */
    public int getEu_user_id() {
        return eu_user_id;
    }

    public void setEu_user_id(int eu_user_id) {
        this.eu_user_id = eu_user_id;
    }

    public String getEu_user_name() {
        return eu_user_name;
    }

    public void setEu_user_name(String eu_user_name) {
        this.eu_user_name = eu_user_name;
    }

    public String getEu_password() {
        return eu_password;
    }

    public void setEu_password(String eu_password) {
        this.eu_password = eu_password;
    }

    public int getEu_sex() {
        return eu_sex;
    }

    public void setEu_sex(int eu_sex) {
        this.eu_sex = eu_sex;
    }

    public String getEu_birthday() {
        return eu_birthday;
    }

    public void setEu_birthday(String eu_birthday) {
        this.eu_birthday = eu_birthday;
    }

    public String getEu_identity_code() {
        return eu_identity_code;
    }

    public void setEu_identity_code(String eu_identity_code) {
        this.eu_identity_code = eu_identity_code;
    }

    public String getEu_email() {
        return eu_email;
    }

    public void setEu_email(String eu_email) {
        this.eu_email = eu_email;
    }

    public String getEu_mobile() {
        return eu_mobile;
    }

    public void setEu_mobile(String eu_mobile) {
        this.eu_mobile = eu_mobile;
    }

    public String getEu_address() {
        return eu_address;
    }

    public void setEu_address(String eu_address) {
        this.eu_address = eu_address;
    }

    public String getEu_headimage() {
        return eu_headimage;
    }

    public void setEu_headimage(String eu_headimage) {
        this.eu_headimage = eu_headimage;
    }

    public int getEu_status() {
        return eu_status;
    }

    public void setEu_status(int eu_status) {
        this.eu_status = eu_status;
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
        return "id: " + getEu_user_id()
                + " name: " + getEu_user_name()
                + " password: " + getEu_password()
                + " sex: " + getEu_sex()
                + " birthday: " + getEu_birthday()
                + " identitycode: " + getEu_identity_code()
                + " email: " + getEu_email()
                + " mobile: " + getEu_mobile()
                + " address: " + getEu_address()
                + " headimage: " + getEu_headimage()
                + " status: " + getEu_status();
    }

}
