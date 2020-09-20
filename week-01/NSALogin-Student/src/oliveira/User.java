package oliveira;

public class User {
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private String salt;

    public String getHashedPassword() {
        return hash;
    }

    public void setHashedPassword(String hash) {
        this.hash = hash;
    }

    private String hash;

    //Constructor
    public User(String password){
        this.password = password;

    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}
