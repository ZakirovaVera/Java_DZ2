// К калькулятору из предыдущего дз добавить логирование.
import java.util.Scanner;
import java.util.logging.*;


public class task4{
    static Scanner iScanner;

    public static void main(String[] args) {
        iScanner = new Scanner(System.in);

        var userCommand = StartProgramm();
        while(userCommand.equals("start")){
            NumberUserFromCalc();
            System.out.print("\n");
            userCommand = StartProgramm();
            
        }

        iScanner.close();
    }
    private static String StartProgramm() {
        
        System.out.print("Введите start для запуска или любую клавишу для завершения программы: ");
        String textUser = iScanner.next();
        return textUser;
    }
    private static void NumberUserFromCalc() {
        System.out.print("Введите первое число: ");
        int number1 = iScanner.nextInt();
        System.out.print("Введите второе число: ");
        int number2 = iScanner.nextInt();
        System.out.print("Введите тип операции(+ - * /): ");
        String operationCalc = iScanner.next();
        float resultCalc = Calc(number1, number2, operationCalc);
        //System.out.printf("%d %s %d = %.3f", number1, operationCalc, number2, resultCalc);
        
        String result = String.format("%d %s %d = %.3f", number1, operationCalc, number2, resultCalc);
        System.out.print(result);
        Log(result);
    }
    public static float Calc(int num1, int num2, String oper) {
        float res = 0;
        switch(oper){
             
            case "+": 
                res = num1 + num2;
                break;
            case "-": 
                res = num1 - num2;
                break;
            case "*": 
                res = num1 * num2;
                break;
            case "/": 
                res = (float) num1 / (float) num2;
                break;
            default:
                System.out.println("Error");
        }
        return res;
    }
    public static void Log(String text) {
        Logger logger = Logger.getLogger(task4.class.getName());

        ConsoleHandler ch = new ConsoleHandler();
        // logger.addHandler(ch);
        SimpleFormatter sFormat = new SimpleFormatter();
        ch.setFormatter(sFormat);

        System.out.print("\n");
        logger.info(text);
    }
}
