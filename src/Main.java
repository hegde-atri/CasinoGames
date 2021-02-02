import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<User> userList = new ArrayList<>();



    public static void main(String[] args) {
        userList = FileHandler.readFile();
        mainMenu();
    }

    public static void innerMenu(User currentUser) {
        userList = FileHandler.readFile();

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
            boolean userLogOut = false;
            System.out.print("\rWhat game would you like to play? \n");
            System.out.println("1. Play crash");
            System.out.println("2. Higher or Lower");
            System.out.println("3. View wallet balance");
            System.out.println("9. Save and Exit");
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
                case 5:
                    userLogOut = true;
                    break;
                default:
                    FileHandler.writeFile(userList);
                    System.exit(1);
                    break;
            }
            if (currentUser.UserWallet.getMoney() <= 0) {
                System.out.println("You have run out of money and have lost!!");
            }
            if(userLogOut){
                System.out.println("\nSuccessfully Logged out\n");
                break;
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

    public static void playHigherLower(Wallet userWallet) {

        HigherLower x = new HigherLower();
        boolean game = x.takeBet(userWallet);
        if (!game) {
            System.out.println("Exiting to main menu due to invalid input!");
        }

        x.multiplier = 1;
        x.currentCard = x.cardNumber();
        x.currentSuit = x.cardSuit(x.currentCard);


        while (game) {
            System.out.println("\n" + x.cards[x.currentCard] + " " + x.currentSuit);
            String formattedString = String.format("%.02f", x.multiplier);
            System.out.println("Current Multiplier: " + formattedString);
            x.userChoose();
            x.oldCard = x.currentCard;
            x.oldSuit = x.currentSuit;
            x.currentCard = x.cardNumber();
            x.currentSuit = x.cardSuit(x.currentCard);

            if (x.userChoice == 0) {
                System.out.println("Starting money: " + x.transfer);
                System.out.println("Current amount: " + (x.multiplier * x.transfer));
                System.out.println("-------------------\n");
                userWallet.money += (x.multiplier * x.transfer);
                game = false;
            } else if ((x.currentCard > x.oldCard) && x.userChoice == 1) {
                System.out.println("+0.2x");
                x.multiplier += 0.2;
            } else if ((x.currentCard < x.oldCard) && x.userChoice == 2) {
                System.out.println("+0.2x");
                x.multiplier += 0.2;
            } else if (x.currentCard == x.oldCard) {
                x.multiplier += 0.1;
                System.out.println("The next card had the same value, +0.1x !");
            } else {
                System.out.println("You guessed wrong, the next card was: " + x.cards[x.currentCard] + " " + x.currentSuit);
                System.out.println("You have lost " + x.transfer);
                game = false;
            }
        }


    }

    public static void playSlot(Wallet userWallet) {
        SlotMachine x = new SlotMachine();
        x.takeBet(userWallet);
        x.printNums();
        System.out.println();
        x.checkValue(userWallet);

    }

    public static void mainMenu() {
        while(true) {
            System.out.println("------------------");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.println("------------------");
            int userChoice = sc.nextInt();
            switch (userChoice) {
                case 1:
                    logIn();

                    break;
                case 2:
                    createNew();
                    break;
                default:
                    System.exit(1);

            }
        }
    }

    public static void logIn() {
        System.out.print("Enter your username: ");
        String username = sc.next();
        System.out.print("\rEnter your birth year: ");
        String password = sc.next();
        for (User x : userList) {
            if (username.equals(x.username)) {
                if (password.equals(x.password)) {
                    System.out.println("login successful!");
                    innerMenu(x);
                }
            }
        }
    }

    public static void createNew() {
        System.out.print("Enter your username: ");
        String setUsername = sc.next();
        System.out.print("Enter your birth year: ");
        String setPassword = sc.next();
        System.out.println("Choose how much money you start with: ");
        System.out.println("1. 5000");
        System.out.println("2. 10,000");
        System.out.println("3. 25,000");
        int userChoice = sc.nextInt();
        switch (userChoice) {
            case 1:
                userList.add(new User(setUsername, setPassword, "5000"));
                break;
            case 2:
                userList.add(new User(setUsername, setPassword, "10000"));
                break;
            default:
                userList.add(new User(setUsername, setPassword, "25000"));
                break;
        }
        System.out.println("\n User account successfully created!\n");

        logIn();


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
