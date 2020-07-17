package keyValue;

import java.util.*;

/**
 * Test client for the <code>KeyValuePair</code> class. Demonstrates the use of a generic class and generic methods.
 *
 * @author Zachary Olpin
 */
public class TestClient {

    /**
     * Entry point to the program. Creates generic collections containing <code>KeyValuePairs</code>and operates
     * on them with methods in the <code>Collections</code> interface.
     *
     * @param args Command line argumets.
     */
    public static void main(String[] args) {

        // PART 1
        System.out.println("Part 1\n------");

        KeyValuePair<String, Integer> p1 =  new KeyValuePair<>("SLC", 189899);
        KeyValuePair<String, Integer> p2 =  new KeyValuePair<>("NY", 8244910);

        System.out.println("p1: " + p1 + "\n" + "p2: " + p2);
        System.out.printf("p1.equals(p2): %s\n", p1.equals(p2));

        KeyValuePair<String, Integer> p3 = p2;

        System.out.println("\np3: " + p3);
        System.out.printf("p2.equals(p3): %s\n\n", p2.equals(p3));


        // PART 2
        System.out.println("Part 2\n------");

        KeyValuePair<String, Integer> p4 = new KeyValuePair<>("LA", 3819702);
        KeyValuePair<String, Integer> p5 = new KeyValuePair<>("SF", 812826);

        var cities = new ArrayList<>(List.of(p1, p2, p3, p4, p5));

        System.out.println("Original list:");
        cities.forEach(System.out::println);

        Collections.sort(cities);
        System.out.println("\nSorted List:");
        cities.forEach(System.out::println);


        // PART 3
        System.out.println("\nPart 3\n------");

        System.out.println("Cities with margin 5:");
        printWithMargin(cities, 5);

        Set<KeyValuePair<Integer, String>> countryCodes = new HashSet<>(Set.of
                ( new KeyValuePair<>(30, "Greece")
                , new KeyValuePair<>(33, "France")
                , new KeyValuePair<>(43, "Austria")
                )
        );

        System.out.println("\nCountry codes with margin 3:");
        printWithMargin(countryCodes, 3);

    }

    /**
     * Prints a <code>Collection</code>, element by element separated by newlines and indented with
     * n=<code>indentation</code> spaces.
     *
     * @param collection A <code>Collection</code>.
     * @param indentation The number of spaces to indent each line.
     */
    public static <T> void printWithMargin(Collection<T> collection, int indentation) {
        collection.forEach(e -> System.out.println(" ".repeat(indentation) + e));
    }
}
