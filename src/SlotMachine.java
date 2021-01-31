import java.util.Random;

public class SlotMachine {

    private float bet;

    public void takeBet(Wallet userWallet){

    }

    public int getNum(){
        Random randint = new Random();
        return randint.nextInt(9);

    }

    public void printNums(){
        int num1 = getNum();
        int num2 = getNum();
        int num3 = getNum();

        for (int i = 1; i <= 100; i ++) {

            if(i < 100 ){
                System.out.print("\r " + getNum() + " " + getNum() + " " + getNum());
            }else{
                System.out.print("\r " + num1 + " " + num2 + " " + num3);
            }

            try {
                 long timeToSleep = (long)(10 * (Math.pow(2.7, i/24)));
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }



}
