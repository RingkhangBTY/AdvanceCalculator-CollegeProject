import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        double ans; // To hold the final calculateTrigonometry.
        System.out.println("\n-----Welcome to my advance calculator-----\n");
        int count = 0;
        Calculation cal = new Calculation();

        while (true){
            int userInput = cal.displayOption();

            if (userInput==1){
                ans = cal.basicCalculation();
                System.out.println("Ans: "+ans);

            }

            if (userInput==2){
                float ans1 = (float) cal.calculateTrigonometry();
                if (ans1 !=-1){
                    System.out.println("Ans: "+ ans1);
                }
            }

            if (userInput==3){
                ans = cal.logarithmicCalculation();
                if (ans!=-1){
                    System.out.println("Ans: "+ans);
                }
            }

            // To Ask the user for further calculations.
            System.out.println("want to calculate more? (Y/N)");
            try {
                char res = sc.next().charAt(0);
                if (res=='n'||res=='N'){
                    break;
                } else if (res=='y' || res =='Y') {
                    continue;
                }else {
                    break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }

        // To display the calculation  history
        System.out.println("Do you want to show calculation history?. (Y/N)");
        while (true){
            try {
                char res = sc.next().charAt(0);
                if (res=='n'||res=='N'){
                    break;
                } else if (res=='y' || res =='Y') {
                    if (cal.getHistory().isEmpty()){
                        System.out.println(" No, Such history!! ");
                        break;
                    }
                    for (String entry : cal.getHistory()){
                        System.out.println(entry);
                    }
                    break;
                }else {
                    System.out.println("Invalid input plz try again!");
                    continue;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }

        System.out.println("\n--------Thanks for using--------");
    }
}