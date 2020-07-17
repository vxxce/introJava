package collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Demonstrates the uses of generics and the Collections class.
 *
 * @author Zachary Olpin
 */
public class GenericCollections {

    /**
     * Creates a List of Strings from a List of Characters. Characters that are non-alphanumeric
     * are filtered, each character is converted to a String where the character is lowercase,
     * wrapped in parentheses, and prepended with an L, U, or N depending on whether the character
     * is lowercase, uppercase, or numeric, respectively. The List of strings is then reversed and returned.
     *
     * @param list the character list.
     * @return the new list of strings.
     */
    public static List<String> lettersAndNumbers(List<Character> list) {
        if (list == null) return null;
        if (list.isEmpty()) return Collections.emptyList();

        List<String> l = list.stream()
                .filter(Character::isLetterOrDigit)
                .map(GenericCollections::format)
                .collect(Collectors.toList());
        Collections.reverse(l);

        return l;
    }

    /**
     * Mutates the argument list of Integers by removing all multiples of 3, adding the first 5 multiples of
     * 4, 5, and 6, and then sorting the entire list.
     *
     * @param list the list of Integers to be modified.
     * @return The number of unique integers in the final mutated list.
     */
    public static int modify(List<Integer> list) {
        if (list == null) throw new NullPointerException("List must not be null.");
        if (list.contains(null)) throw new NullPointerException("List must not contain null values");

        list.removeIf(v -> v % 3 == 0);
        list.addAll(IntStream.range(4, 7)
                .mapToObj(v -> List.of(v, v * 2, v * 3, v * 4, v * 5))
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
        Collections.sort(list);

        return Set.copyOf(list).size();
    }

    /**
     * Removes every <code>n</code>th elements from <code>list</code>. Mutates the original list.
     *
     * @param list the list to be modified.
     * @param n the integer specifying which nth elements are to be removed.
     */
    public static void removeEveryNthElement(List<?> list, int n) {
        if (list == null) throw new NullPointerException("List cannot be null");
        if (n <= 0) throw new IllegalArgumentException("n must be positive number.");

        var iter = list.listIterator();
        while(iter.nextIndex() <= list.size() - n) {
            for (int i = 0; i < n; i++) iter.next();
            iter.remove();
        }
    }

    /**
     * Formats a string based on the case and alphanumeric status of <code>c</code>. Lowercase <code>c</code>
     * -> "L(c)", uppercase -> "U(c)", numeric -> "N(c)".
     *
     * @param c The character to be formatted as a string/
     * @return The formatted string.
     */
    public static String format(Character c) {
        if (Character.isDigit(c)) return "N(" + c + ")";
        else if (Character.isLowerCase(c)) return "L(" + c + ")";
        else return "U(" + Character.toLowerCase(c) + ")";
    }

    /**
     * The entry point to the program.
     *
     * @param args Command Line arguments.
     */
    public static void main(String[] args) { }
}
