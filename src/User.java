public class User {

    public String username;
    public String password;
    public Wallet UserWallet;

    public User(String username, String password, String userWallet) {
        this.username = username;
        this.password = password;
        this.UserWallet = new Wallet(userWallet);
    }


}
