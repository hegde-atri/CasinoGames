import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class HigherLower {
    protected int userChoice;
    private Random randint = new Random();
    protected float multiplier, transfer;
    protected String currentSuit, oldSuit;
    protected int currentCard, oldCard;
    protected String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace", "Joker"};

    public int cardNumber(){
        return randint.nextInt(14);
    }

    public String cardSuit(int cardNumber){
        if(cardNumber > 13){
            return "";
        }else{
            int a = randint.nextInt(4);
            switch(a){
                case 0:
                    //spades
                    return "\u2660";
                case 1:
                    //hearts
                    return "\u2661";
                case 2:
                    //clubs
                    return "\u2663";
                case 3:
                    //diamonds
                    return "\u2662";
                default:
                    //this is logically not needed however, it doesn't compile without it since it doesnt know int a has definite limits
                    return "";
            }
        }

    }

    public void userChoose(){
        Scanner sc = new Scanner(System.in);
        //we need to make sure there is a way for the user to leave with his profits when he is happy.
        System.out.println("Higher(1) or lower(2)      [to leave with profit use 0]");
        int x = sc.nextInt();
        switch(x){
            case 1:
                userChoice = 1;
                break;
            case 2:
                userChoice = 2;
                break;
            default:
                userChoice = 0;
                break;
        }
    }

    public boolean takeBet(Wallet userWallet){
        Scanner sc = new Scanner(System.in);
        System.out.print("How much money would you like to bet: ");
        this.transfer = sc.nextFloat();
        if(this.transfer <= 0){
            System.out.println("input cannot be equal to or less than 0");
            System.out.println("!!No money has been bet!!");
            this.transfer = 0;
            return false;
        }else {
            String formattedString = String.format("%.02f", this.transfer);
            System.out.println("Your bet of £" + formattedString + " has been placed");
            userWallet.money -= this.transfer;
            return true;
        }

    }


}
