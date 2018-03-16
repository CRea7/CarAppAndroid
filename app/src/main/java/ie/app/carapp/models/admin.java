package ie.app.carapp.models;



public class admin {

    private String name;
    private String password;
    private String email;
    private String phone;
    private int auth;

    public admin() {
    }

    public admin(String name, String password, String email, String phone, int auth) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.auth = auth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "admin{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", auth=" + auth +
                '}';
    }
}
