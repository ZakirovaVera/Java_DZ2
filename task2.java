// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации 
// запишите в лог-файл.
import java.util.Arrays;
import java.util.logging.*;

public class task2 {
    public static void main(String[] args) {
        int [] array = {2, 11, 4, 0, 9, 15};
        System.out.println(Arrays.toString(array));
        SortArray(array);
        System.out.println(Arrays.toString(array));
        // Log();
    }

    public static int [] SortArray(int [] arr) {
            
        boolean isSorted = false;
        int temp;
        while(isSorted == false) {
        isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                Log(Arrays.toString(arr));
                if(arr[i] > arr[i+1]){
                    isSorted = false;
    
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
                
            }
        }
        return arr;
    }
    public static void Log(String text) {
        Logger logger = Logger.getLogger(task2.class.getName());
        ConsoleHandler ch = new ConsoleHandler();
        // logger.addHandler(ch);

        SimpleFormatter sFormat = new SimpleFormatter();
        ch.setFormatter(sFormat);
        logger.info(text);
    }
}

