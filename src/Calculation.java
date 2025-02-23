import java.util.ArrayList;
import java.util.Locale;
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
    double calculateTrigonometry() {
        double ans=0.00;
        StringBuilder sb = new StringBuilder();

        try {
            System.out.println("Operator. (sin , cos , tan , cot , cosec , sec )");
            String operator = sc.nextLine().trim();
            System.out.println("Value (Degree): ");
            double temp1= sc.nextDouble();
            sc.nextLine();
            double value = Math.toRadians(temp1);
            sb.append(operator).append("( ").append(temp1).append(" ) = ");


            boolean isValid = true;

            switch (operator.toLowerCase(Locale.ROOT)){
                case "sin":
                    ans = Math.sin(value);
                    sb.append(ans);
                    break;
                case "cos":
                    ans = Math.cos(value);
                    sb.append(ans);
                    break;
                case "tan":
                    if (Math.abs(temp1 - 90) < 1e-6 || Math.abs(temp1 -270) < 1e-6){
                        System.out.println("Not defined");
                        sb.append("Not defined");
                        isValid = false;
                        break;
                    }
                    ans = Math.tan(value);
                    sb.append(ans);
                    break;
                case "cot":
                    if (Math.abs(temp1) < 1e-6 || Math.abs(temp1 -180) < 1e-6){
                        System.out.println("Not defined");
                        sb.append("Not defined");
                        isValid = false;
                        break;
                    }
                    ans = Math.cos(value)/Math.sin(value);
                    sb.append(ans);
                    break;
                case "cosec":
                    if (Math.abs(temp1) < 1e-6 || Math.abs(temp1 - 180)< 1e-6){
                        System.out.println("Not defined");
                        sb.append("Not defined");
//                        return -1;
                        isValid = false;
                        break;
                    }
                    ans = 1/ (Math.sin(value));
                    sb.append(ans);
                    break;
                case "sec":
                    if (Math.abs(temp1 - 90) < 1e-6 || Math.abs(temp1 - 270) < 1e-6){
                        System.out.println("Not defined");
                        sb.append("Not defined");
                        isValid = false;
                        break;
                    }
                    ans = 1/(Math.cos(value));
                    sb.append(ans);
                    break;

                default:
                    System.out.println("Invalid operator! Calculation terminated.");
                    sb.append("Invalid input value");
                    isValid = false;
                    break;
            }
            history.add(sb.toString());

            if (!isValid){
                return -1;
            }
        }catch (Exception e){
            System.out.println("Invalid input! ");
            return -1;
        }

        return ans;
    }

    // Welcome screen and operation options. || To take valid user input.
    int displayOption(){
        System.out.println("1. Basic Operations.\n     A. Addition(+)\n     B.Multiplication(*)\n     C.Subtraction(-)\n     D.Division(/)");
        System.out.println("\n2.Trigonometry Operations.\n     A. sin()  B. cos() C.tan() D.cot() E.Cosec  F.sec ");
        System.out.println("\n3.Logarithmic operations. \n     A. log(x)  B. ln(x)  c. log n(x)");
        System.out.println("\n4.exponential  5.n^x(Power)  6.SquareRoot\n");

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
                sc.nextLine();
            }
        }
        sc.nextLine();
        return userInput;
    }

    // To calculate basic arithmetic operations like - ( + , - , * , / ).
    double basicCalculation(){
        double ans = 0.0;

//        String currentCalculation = " "; // To store and add history of previous calculation.

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

        sc.nextLine();
        history.add(currentCalculation+" = "+ ans);
        return ans;
    }

    // to calculate square root. sqrt(x).
    double squareRoot(){
        double ans = 0.00;

        return ans;
    }

    // Logarithmic functions.
    double logarithmicCalculation(){
        double ans;
        StringBuilder sb = new StringBuilder();

        try {
            sc.nextLine();
            System.out.println("Operator ( log, ln, logN-->to cal.. log n(x) : ");
            String operator = sc.nextLine().trim();
            System.out.println("Value of 'x': ");
            double value = sc.nextDouble();
//            sc.nextLine();

//            sb.append(operator).append("( ").append(value).append(" ) = ");

            switch (operator.toLowerCase()){
                case "ln":
                    ans = Math.log(value);
                    sb.append("ln("+value).append(") = ");
                    break;
                case "log":
                    ans = Math.log10(value);
                    sb.append("log 10(").append(value).append(") = ");
                    break;
                case "logn":
                    System.out.println("Base: ");
                    int base = sc.nextInt();
                    ans = Math.log(value)/Math.log(base);
                    sb.append("log ").append(base).append("(").append(value).append(") = ");
                    break;
                default:
                    System.out.println("Invalid input! ");
                    return -1;

            }
        }catch (Exception e){
            System.out.println("Invalid input! ");
            return -1;
        }

        sb.append(ans);
        history.add(sb.toString());

        return ans;
    }

    // To calculate exponential calculations.
    double exponential(){

        double ans = 0.00;

        return ans;
    }

    // To calculate power- n^x.
    double powerofN(){
        double ans = 0.00;

        return ans;
    }
}