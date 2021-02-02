import java.util.*;

public class SlotMachine {

    protected Scanner sc = new Scanner(System.in);
    private float bet;
    private int num1;
    private int num2;
    private int num3;

    public int getNum() {
        Random randint = new Random();
        return randint.nextInt(7);

    }

    public void takeBet(Wallet userWallet){
        System.out.print("How much money would you like to bet: ");
        bet = sc.nextFloat();
        if(bet <= 0){
            System.out.println("input cannot be equal to or less than 0");
            System.out.println("!!No money has been bet!!");
            bet = 0;
        }else if(bet > userWallet.money){
            System.out.println("You don't have the money fool!");
            bet = 0;
        }
        String formattedString = String.format("%.02f", bet);
        System.out.println("Your bet of £" + formattedString + " has been placed");
        userWallet.money -= bet;
    }

    public void printNums() {
        num1 = getNum();
        num2 = getNum();
        num3 = getNum();

        for (int i = 1; i <= 100; i++) {
            if (i < 100) {
                System.out.print("\r " + getNum() + " " + getNum() + " " + getNum());
            } else {
                System.out.print("\r " + num1 + " " + num2 + " " + num3);
            }
            try {
                long timeToSleep = (long) (10 * (Math.pow(2.7, i / 24)));
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkValue(Wallet userWallet){
        if(num1==num2 && num2==num3){
            System.out.println("2x multiplier woooooooooo");
            userWallet.money += (bet * 2);
        }else if(num2 <= (num3+2) && (num1-2) <=2){
            System.out.println("1.3x multiplier, cool ");
            userWallet.money += (bet*1.3);
        }else{
            System.out.println("No luck this time :/");
            System.out.println("Get trolled noob lmao");
        }
    }


}

