public class Main {

    public static void main(String[] args) {
        while(true){
            mainMenu();
        }


    }


    public static void mainMenu() {

        String[] animatedWelcome = new String[]{"\r ---------------------- ", "\r  Welcome to my Casino ", "\r     Atri Hegde©  "};
        for(String x : animatedWelcome){
            System.out.print(x);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        while(true){
//            System.out.print("hey");
//        }








    }

}
