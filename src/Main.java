import java.util.*;

public class Main {

    //username = Atri, password = myProgram
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<User> userList = new ArrayList<>();
    

    public static void main(String[] args){
        SlotMachine x = new SlotMachine();
        x.printNums();


//        mainMenu(new User("Atri", "2004", "25000"));

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


        while(game){
            System.out.println("\n" + x.cards[x.currentCard] + " " + x.currentSuit);
            String formattedString = String.format("%.02f", x.multiplier);
            System.out.println("Current Multiplier: " + formattedString);
            x.userChoose();
            x.oldCard = x.currentCard;
            x.oldSuit = x.currentSuit;
            x.currentCard = x.cardNumber();
            x.currentSuit = x.cardSuit(x.currentCard);

            if(x.userChoice == 0){
                System.out.println("Starting money: " + x.transfer);
                System.out.println("Current amount: " + (x.multiplier * x.transfer));
                System.out.println("-------------------\n");
                userWallet.money += (x.multiplier * x.transfer);
                game = false;
            }else if((x.currentCard > x.oldCard) && x.userChoice == 1) {
                System.out.println("+0.2x");
                x.multiplier += 0.2;
            }else if((x.currentCard < x.oldCard) && x.userChoice == 2){
                System.out.println("+0.2x");
                x.multiplier += 0.2;
            }else if(x.currentCard == x.oldCard){
                x.multiplier += 0.1;
                System.out.println("The next card had the same value, +0.1x !");
            }else{
                System.out.println("You guessed wrong, the next card was: " + x.cards[x.currentCard]+" "+x.currentSuit);
                System.out.println("You have lost " + x.transfer);
                game = false;
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
//        return passwordArray
//    }





}
