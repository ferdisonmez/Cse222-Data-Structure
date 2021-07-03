public class User implements Userinterface {
    private String UserId;
    private String password;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userId, String password) {
        UserId = userId;
        this.password = password;
    }
}
