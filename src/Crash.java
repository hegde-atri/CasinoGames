import java.util.Random;

public class Crash extends Wallet{
    private float multiplier;
    Random randint = new Random();

    public void play(){
        calculateCrash();
        printMultiplier();
        for (float i = 0; i <= multiplier; i += 0.01) {
            String formattedString = String.format("%.02f", i);
            System.out.print("multiplier: " + formattedString + "% " +"\r");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Multiplier: " + multiplier);
    }
    // while loop generating random number and then randomly stop the loop with a random value
    public void calculateCrash(){
        int firstBase = 0;
        int secondBase = 0;
//        int crashLimit;

        int limiter1 = randint.nextInt(10000000);
        for(int x=0; x<limiter1; x++){
            firstBase = randint.nextInt(10000);
        }
        if(firstBase <= 6500) {
            secondBase = randint.nextInt(100);
            multiplier = 1 + (float) secondBase / 100F;
        }else if(firstBase <=9750){
            secondBase = randint.nextInt(100);
            multiplier = 1 + (float)secondBase/50F;
        }else{
            multiplier = 1 + (float)firstBase/100F;
        }



        System.out.println(multiplier);
        System.out.println(firstBase);
        System.out.println(secondBase);
    }

    public void printMultiplier(){
        for(float x = 0; x < multiplier; x++){
            System.out.println(multiplier);
        }
    }

    public  void main(String[] args) {
        char[] animationChars = new char[]{'|', '/', '-', '\\'};

        for (int i = 0; i <= 100; i++) {
            System.out.print("Processing: " + i + "% " + animationChars[i % 4] + "\r");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Processing: Done!          ");
    }
}
