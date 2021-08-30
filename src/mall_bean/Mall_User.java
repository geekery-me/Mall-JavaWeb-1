package mall_bean;

public class Mall_User {
    private String user_id;
    private String user_name;
    private String user_password ;
    private String user_sex;
    private String user_birthday;
    private String user_new_column;
    private String user_email;
    private String user_phone;
    private String user_address;
    private int user_status;



    @Override
    public String toString() {
        return "Mall_User{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_birthday=" + user_birthday +
                ", user_new_column='" + user_new_column + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_address='" + user_address + '\'' +
                ", user_status=" + user_status +
                '}';
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }


    public String getUser_new_column() {
        return user_new_column;
    }

    public void setUser_new_column(String user_new_column) {
        this.user_new_column = user_new_column;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }

    public Mall_User(String user_id, String user_name, String user_password, String user_sex, String user_birthday, String user_new_column, String user_email, String user_phone, String user_address, int user_status) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_sex = user_sex;
        this.user_birthday = user_birthday;
        this.user_new_column = user_new_column;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.user_address = user_address;
        this.user_status = user_status;
    }

    public Mall_User() {
    }
}
