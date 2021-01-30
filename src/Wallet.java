public class Wallet {

    public float money;
    public float debt;

    public Wallet(float money, float debt){
        this.money = money;
        this.debt = debt;
    }


    public void printAnimatedWallet(){
        String[] animatedWallet = new String[]{"\r Your current balance is","\r      " + this.money , "\r Your current debt is", "\r      " + this.debt};
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
