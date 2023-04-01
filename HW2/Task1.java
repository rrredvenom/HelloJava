import java.io.FileWriter;
import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int[] arr = {5, 7, -1, 0, 11, 18, 8, 3, 9, 2};
        int temp;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                sb.append(Arrays.toString(arr)).append("\n");
                try {
                    FileWriter fw = new FileWriter("log_task1.txt", false);
                    fw.write(sb.toString());
                    fw.close();
                } catch (Exception e) {
                    System.out.println("ERROR!");
                }  
            }
        }
    }
}