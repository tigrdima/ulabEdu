package homework;

import java.util.Arrays;

public class Task2 {

    public static int[] sum(int[] numbers, int sum) {
        Arrays.sort(numbers);
        int[] rsl = new int[2];
        int first = 0;
        int second = numbers.length - 1;

        while (first < second) {
            int s = numbers[first] + numbers[second];
            if (s == sum) {
                rsl[0] = numbers[first];
                rsl[1] = numbers[second];
                break;
            } else {
                if (s < sum) first++;
                else second--;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sum(new int[]{0, 4, 7, 6, 8, 9}, 10)));
    }
}
