import java.util.Random;
import java.util.Scanner;

public class Crash {

    protected Wallet userWallet;
    private float multiplier;
    private float userGuess;
    private float transfer;
    Random randint = new Random();
    protected Scanner sc = new Scanner(System.in);


    // while loop generating random number and then randomly stop the loop with a random value
    public void calculateCrash(){
        int firstBase = 0;
        int secondBase;
//        int crashLimit;
        int limiter1 = randint.nextInt(10000000);
        for(int x=0; x<limiter1; x++){
            firstBase = randint.nextInt(10000);
        }
        if(firstBase <= 250){
            secondBase = randint.nextInt(10)       ;
            this.multiplier = 1 + (float)secondBase / 100F;
        }else if(firstBase <= 6500) {
            secondBase = randint.nextInt(100);
            this.multiplier = 1 + (float)secondBase / 100F;
        }else if(firstBase <=9750){
            secondBase = randint.nextInt(100);
            this.multiplier = 1 + (float)secondBase/50F;
        }else{
            this.multiplier = 1 + (float)firstBase/100F;
        }
    }

    public void printMultiplier(){
        for (float i = 1; i <= this.multiplier; i += 0.01) {
            String formattedString = String.format("%.02f", i);
            System.out.print("multiplier: " + formattedString + "\r");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Multiplier: " + this.multiplier);
    }

    public void takeBet(Wallet userWallet){
        System.out.print("How much money would you like to bet: ");
        this.transfer = sc.nextFloat();
        if(this.transfer <= 0){
            System.out.println("input cannot be equal to or less than 0");
            System.out.println("!!No money has been bet!!");
            this.transfer = 0;
        }
        String formattedString = String.format("%.02f", this.transfer);
        System.out.println("Your bet of £" + formattedString + " has been placed");
        userWallet.money -= this.transfer;
    }

    public void userMultiplier(){
        System.out.print("When do you think it will crash: ");
        this.userGuess = sc.nextFloat();
        if(this.userGuess < 1){
            System.out.println("Multiplier cannot be less than 1");
            System.out.println("Your multiplier for this round has been set to 1x");
            this.userGuess = 1;
        }
    }

    public void didUserWin(Wallet userWallet){
        if(this.userGuess == this.multiplier){
            System.out.println("Bang on the multiplier !!!");
            userWallet.money += (this.userGuess*this.transfer);
            System.out.println("Amount won: " +((this.userGuess*this.transfer)-this.userGuess));
        }else if(this.userGuess <= this.multiplier){
            System.out.println("You have won!!");
            userWallet.money += (this.userGuess*this.transfer);
            System.out.println("Amount won: " +((this.userGuess*this.transfer)-this.userGuess));
        }else{
            System.out.println("You have lost: " + this.transfer);
        }

    }

    public float getUserGuess(){
        return this.userGuess;
    }

    public float getTransfer(){
        return this.transfer;
    }
}
