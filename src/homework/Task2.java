package homework;

import java.util.Arrays;

public class Task2 {

    public static int[] sum(int[] numbers, int sum) {
        int[] rsl = new int[2];

        for (int number : numbers) {
            for (int i : numbers) {
                if (number + i == sum) {
                    rsl[0] = i;
                    rsl[1] = number;
                    break;
                }
            }
        }
        return rsl;
    }


    public static void main(String[] args) {
        int[] rsl = sum(new int[]{3, 4, 2, 7}, 10);

        System.out.println(Arrays.toString(rsl));
    }
}
