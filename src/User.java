public class User {

    public String username;
    public String password;
    public Wallet UserWallet;

    public User(String username, String password, String userWallet) {
        this.username = username;
        this.password = password;
        this.UserWallet = new Wallet(userWallet);
    }

    public String toString(){
        return username + "," + password + "," + UserWallet;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Wallet getUserWallet() {
        return this.UserWallet;
    }

    public void setUserWallet(Wallet userWallet) {
        UserWallet = userWallet;
    }
}
