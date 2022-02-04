package written.com.kuaishou;

import java.util.Scanner;

public class Second {
    public static int solve(int[] nums, int find) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[nums.length - 1] < find)
            return nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == find)
                return mid;
            else if (nums[mid] < find) {
                left = mid + 1;
                if (left >= right)
                    return right;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int find = Integer.valueOf(scanner.nextLine());
        scanner.close();

        String[] strings = line.split(" ");
        int len = strings.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.valueOf(strings[i]);
        }

        System.out.println(solve(nums, find));

    }
}
