package Sliding_window;
import java.util.*;
public class count_distnict_element_in_k_size {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList( 2, 1, 2, 3, 2, 1, 4, 5 );
        int k = 5;

        findDistinctCount(input, k);
    }
    public static void findDistinctCount(List<Integer> input, int k)
    {
        // loop through the list
        for (int i = 0; i < input.size() - (k - 1); i++)
        {
            Set<Integer> distinct = new HashSet<>();
            distinct.addAll(input.subList(i, i + k));

            System.out.println("The count of distinct elements in "
                    + "subarray [" + i + ", " + (i + k - 1) + "] is "
                    + distinct.size());
        }
    }
}
