import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();



    }




    public static void mainMenu() {
        Wallet userWallet = new Wallet(25000, 0);

        String[] animatedWelcome = new String[]{"\r ---------------------- ", "\r  Welcome to my Casino ", "\r From the beginning you will have £25,000", "\r As soon as your balance hits 0, you lose", "\r \"True luck consists not\""};
            for (String x : animatedWelcome) {
                System.out.print(x);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        while(true){
            System.out.print("\rWhat game would you like to play? \n");
            System.out.println("1. Play crash");
            System.out.println("2. View wallet balance");
            System.out.println("0. Exit");
            int userChoice = sc.nextInt();
            switch(userChoice){
                case 1:
                    playCrash(userWallet);
                    break;
                case 2:
                    System.out.println(userWallet.toString());
                    break;
                case 3:

                    break;
                default:
                    System.exit(0);
                    break;


            }
        }
    }

    public static void playCrash(Wallet userWallet){
        Crash playSomeCrash = new Crash();
        playSomeCrash.takeBet(userWallet);
        playSomeCrash.userMultiplier();
        System.out.println("Bet of " + playSomeCrash.getTransfer() + " has been placed for " + playSomeCrash.getUserGuess() + "x");
        System.out.println(userWallet.toString() + "\n");
        playSomeCrash.calculateCrash();
        playSomeCrash.printMultiplier();
        playSomeCrash.didUserWin(userWallet);


    }
}
