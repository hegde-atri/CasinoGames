import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;


public class Main {

    //username = atri, password = myProgram
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<User> userList = new ArrayList<>();
    

    public static void main(String[] args){
        mainMenu(new User("Atri", "2004", "25000"));
    }



    public static void mainMenu(User currentUser) {

        String[] animatedWelcome = new String[]{"\r ---------------------- ", "\r  Welcome to my Casino ", "\r From the beginning you will have £25,000", "\r As soon as your balance hits 0, you lose", "\r \"True luck consists not\""};
        for (String x : animatedWelcome) {
            System.out.print(x);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            System.out.print("\rWhat game would you like to play? \n");
            System.out.println("1. Play crash");
            System.out.println("2. Higher or Lower");
            System.out.println("3. View wallet balance");
            System.out.println("9. Save and Exit");
            System.out.println("0. Quit");
            System.out.print(": ");
            int userChoice = sc.nextInt();
            switch (userChoice) {
                case 1:
                    playCrash(currentUser.UserWallet);
                    break;
                case 2:
                    playHigherLower(currentUser.UserWallet);
                    break;
                case 3:
                    currentUser.UserWallet.printAnimatedWallet();
                    break;
                case 9:
                    //FileHandler.writeFile(userList);
                    System.exit(1);
                default:
                    System.exit(0);
                    break;


            }
            if(currentUser.UserWallet.getMoney() <= 0){
                System.out.println("You have run out of money and have lost!!");
            }
        }
    }

    public static void playCrash(Wallet userWallet) {
        Crash playSomeCrash = new Crash();
        playSomeCrash.takeBet(userWallet);
        playSomeCrash.userMultiplier();
        System.out.println("Bet of " + playSomeCrash.getTransfer() + " has been placed for " + playSomeCrash.getUserGuess() + "x");
        System.out.println(userWallet.toString() + "\n");
        playSomeCrash.calculateCrash();
        playSomeCrash.printMultiplier();
        playSomeCrash.didUserWin(userWallet);


    }

    public static void playHigherLower(Wallet userWallet){

        HigherLower x = new HigherLower();
        boolean game = x.takeBet(userWallet);

        x.multiplier = 1;
        x.currentCard = x.cardNumber();
        x.currentSuit = x.cardSuit(x.currentCard);
        System.out.println(x.cards[x.currentCard] + " " + x.currentSuit);

        while(game){
            x.userChoose();
            x.oldCard = x.currentCard;
            x.oldSuit = x.currentSuit;
            x.currentCard = x.cardNumber();
            x.currentSuit = x.cardSuit(x.currentCard);

            if((x.currentCard > x.oldCard) && x.userChoice == 1) {
                System.out.println("+0.2x");
                x.multiplier += 0.2;
            }else if((x.currentCard < x.oldCard) && x.userChoice == 2){
                System.out.println("+0.2x");
                x.multiplier += 0.2;
            }else if(x.currentCard == x.oldCard){
                System.out.println("The next card had the same value, +0.1x !");
            }else{
                System.out.println("You guessed wrong, the next card was: " + x.cards[x.currentCard]+" "+x.currentSuit);
                System.out.println("");
            }
        }



    }





//    public static User authenticater() {
//        boolean done = false;
//        String username = "Atri";
//        while(!done) {
//            System.out.print("Enter first name: ");
//            String userName = sc.nextLine();
//            if (userName.equals(username)) {
//                String pin = "2004";
//                System.out.println("Enter year of birth: ");
//                String userPin = sc.next();
//                if (userPin.equals(pin)) {
//                    done = true;
//                } else {
//                    System.out.println("Incorrect password");
//                }
//            } else {
//                System.out.println("Incorrect username");
//            }
//        }
//    }





//    public static char[] getPassword() {
//        Console cnsl = null;
//        char[] passwordArray = new char[9];
//        try {
//            cnsl = System.console();
//            passwordArray = cnsl.readPassword("Enter Password: ");
//        } catch (Exception e) {
//            System.out.println("Error: " + e);
//        }
//
//        return passwordArray;
//    }



}
