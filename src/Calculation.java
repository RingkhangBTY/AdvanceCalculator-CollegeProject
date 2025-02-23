import java.util.ArrayList;
import java.util.Scanner;

public class Calculation {
    private ArrayList<String> history = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    static String currentCalculation = " ";


    // To store and retrieve data
    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }
    public ArrayList<String> getHistory() {
        return history;
    }

    // To calculate trigonometry functions.
    double calculateTrigonometry(){
        double ans =0.00;


        try {

        }catch (Exception e){
            System.out.println("Invalid operators.");
        }

        return ans;
    }

    // Welcome screen and operation options. || To take valid user input.
    int displayOption(){
        System.out.println("1. Basic Operations.\n     A. Addition(+)\n     B.Multiplication(*)\n     C.Subtraction(-)\n     D.Division(/)");
        System.out.println("\n2.Trigonometry Operations.\n     A. sin()  B. cos() C.tan() D.cot() E.Cosec  F.sec ");
        System.out.println("\n3.log()  4.ln()  5.exponential  6.n^x(Power)  7.SquareRoot\n");

        Scanner sc = new Scanner(System.in);
        int userInput ;
        System.out.println("-----Enter your choice- (1 to 7)-----");

        while (true){ // To take valid user input.
            try {
                userInput = sc.nextInt();
                if (userInput >7 || userInput ==0){
                    System.out.println("Invalid option plz try again. ");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("Not an integer number. Enter integer number between 1 to 7 ");
                sc.next();
            }
        }
        return userInput;
    }

    // To calculate basic arithmetic operations like - ( + , - , * , / ).
    double basicCalculation(){
        double ans = 0.0;

        String currentCalculation = " "; // To store and add history of previous calculation.

        try {
            System.out.print("Value: ");
            ans = sc.nextDouble();
            currentCalculation = String.valueOf(ans);
            while (true) {
                System.out.print("Operator(+,-,*,/): ");
                String operator = sc.next().trim();

                if (operator.equals("=")) {
                    break;
                }

                System.out.print("Value: ");
                double num = sc.nextDouble();

                currentCalculation += " "+ operator+ " "+ num;

                switch (operator) {
                    case "+":
                        ans += num;
                        break;
                    case "-":
                        ans -= num;
                        break;
                    case "*":
                        ans *= num;
                        break;
                    case "/":
                        if (num == 0) {
                            System.out.println("Error: Division by zero!");
                            return ans;
                        }
                        ans /= num;
                        break;
                    default:
                        System.out.println("Invalid operator! Calculation terminated.");
                        history.add(currentCalculation+ " = Invalid operator.");
                        return ans;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        history.add(currentCalculation+" = "+ ans);
        return ans;
    }
}