public class Wallet {

    public float money;

    public Wallet(String money){
        this.money = Float.parseFloat(money);
    }


    public void printAnimatedWallet(){
        String[] animatedWallet = new String[]{"\r Your current balance is","\r      " + this.money};
        for(int i = 0; i < 2; i++) {
            for (String x : animatedWallet) {
                System.out.print(x);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Balance remaining: " + money;
    }

    public float getMoney(){
        return this.money;
    }

    public void setMoney(float newMoney){
        this.money = newMoney;
    }



}
