package streams;

import java.util.*;
import java.util.function.Consumer;

public class Streams
{
    public static void main(String[] args)
    {
        List<Integer> numbers;
        
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        
        // get the sum of all odd Ns multiplied by themselves + 2
        int res = numbers.stream()
            .filter(e -> e % 2 == 0)
            .mapToInt(e -> e)
            .sum();
        
        System.out.println(res);
    }
    
}
