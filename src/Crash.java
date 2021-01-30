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
        int secondBase = 0;
//        int crashLimit;
        int limiter1 = randint.nextInt(10000000);
        for(int x=0; x<limiter1; x++){
            firstBase = randint.nextInt(10000);
        }
        if(firstBase <= 250){
            secondBase = randint.nextInt(10)       ;
            multiplier = 1 + (float)secondBase / 100F;
        }else if(firstBase <= 6500) {
            secondBase = randint.nextInt(100);
            multiplier = 1 + (float)secondBase / 100F;
        }else if(firstBase <=9750){
            secondBase = randint.nextInt(100);
            multiplier = 1 + (float)secondBase/50F;
        }else{
            multiplier = 1 + (float)firstBase/100F;
        }
    }

    public void printMultiplier(){
        for (float i = 1; i <= multiplier; i += 0.01) {
            String formattedString = String.format("%.02f", i);
            System.out.print("multiplier: " + formattedString + "\r");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Multiplier: " + multiplier);
    }

    public void takeBet(Wallet userWallet){
        System.out.print("How much money would you like to bet: ");
        transfer = sc.nextFloat();
        if(transfer <= 0){
            System.out.println("input cannot be equal to or less than 0");
            System.out.println("!!No money has been bet!!");
            transfer = 0;
        }
        String formattedString = String.format("%.02f", transfer);
        System.out.println("Your bet of £" + formattedString + " has been placed");
        userWallet.money -= transfer;
    }

    public void userMultiplier(){
        System.out.print("When do you think it will crash: ");
        userGuess = sc.nextFloat();
        if(userGuess < 1){
            System.out.println("Multiplier cannot be less than 1");
            System.out.println("Your multiplier for this round has been set to 1x");
            userGuess = 1;
        }
    }

    public void didUserWin(Wallet userWallet){
        if(userGuess == multiplier){
            System.out.println("Bang on the multiplier !!!");
            userWallet.money += (userGuess*transfer);
            System.out.println("Amount won: " +((userGuess*transfer)-userGuess));
        }else if(userGuess <= multiplier){
            System.out.println("You have won!!");
            userWallet.money += (userGuess*transfer);
            System.out.println("Amount won: " +((userGuess*transfer)-userGuess));
        }else{
            System.out.println("You have lost: " + transfer);
        }

    }

    public float getUserGuess(){
        return userGuess;
    }

    public float getTransfer(){
        return transfer;
    }
}
