package ASSIGNMENT;

import java.util.*;

public class CyclicSubstringMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String s = sc.nextLine();

        int n = s.length();
        String doubled = s + s; // handle cyclic case

        Set<Character> set = new HashSet<>();

        int left = 0;
        int sum = 0;
        int maxSum = 0;

        for (int right = 0; right < doubled.length(); right++) {
            char ch = doubled.charAt(right);

            
            while (set.contains(ch) || (right - left + 1) > n) {
                char leftChar = doubled.charAt(left);
                sum -= (leftChar - 'a' + 1);
                set.remove(leftChar);
                left++;
            }

           
            set.add(ch);
            sum += (ch - 'a' + 1);

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
} 