package collections;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class GenericCollectionsTest {

    @Test
    void test_lettersAndNumbers_doesNotMutatePassed() {
        List<Character> list = new ArrayList<>(Arrays.asList('1', ' ', 'a', 'B'));
        int h  = list.hashCode();
        GenericCollections.lettersAndNumbers(list);
        assertEquals(h, list.hashCode());
    }

    @Test
    void test_lettersAndNumbers_emptyList_returnsEmptyList() {
        var r = GenericCollections.lettersAndNumbers(Collections.emptyList());
        assertEquals(0, r.size());
    }

    @Test
    void test_lettersAndNumbers_null_returnsNull() {
        assertNull(GenericCollections.lettersAndNumbers(null));
    }

    @Test
    void test_lettersAndNumbers_nonAlphanumericsIgnored() {
        List<Character> inList = new ArrayList<>(Arrays.asList('?', 'a', '^', ' ', 'b', '#', '1'));
        List<String> expected = new ArrayList<>(Arrays.asList("N(1)", "L(b)", "L(a)"));
        var actual = GenericCollections.lettersAndNumbers(inList);
        assertEquals(expected, actual);
    }

    @Test
    void test_lettersAndNumbers_specialCharactersIgnored() {
        List<Character> inList = new ArrayList<>(Arrays.asList('\n', Character.MIN_VALUE, '\\', 'b', '\uFFFF', 'a'));
        List<String> expected = new ArrayList<>(Arrays.asList("L(a)", "L(b)"));
        var actual = GenericCollections.lettersAndNumbers(inList);
        assertEquals(expected, actual);
    }

    @Test
    void test_lettersAndNumbers_returnsReversedOrder() {
        List<Character> inList = new ArrayList<>(Arrays.asList('1', ' ', 'a', 'B'));
        List<String> expected = new ArrayList<>(Arrays.asList("U(b)", "L(a)", "N(1)"));
        assertEquals(expected, GenericCollections.lettersAndNumbers(inList));
    }

    @Test
    void test_lettersAndNumbers_alphaNumericFormatted() {
        List<Character> inList = new ArrayList<>(Arrays.asList('a', 'B', '1'));
        List<String> expected = new ArrayList<>(Arrays.asList("N(1)", "U(b)", "L(a)"));
        var actual = GenericCollections.lettersAndNumbers(inList);
        assertEquals(expected, actual);
    }

    @Test
    void test_lettersAndNumbers_allElementsNonAlphaNumeric_returnsEmptyList() {
        List<Character> inList = new ArrayList<>(Arrays.asList('?', 'a', '*', ' ', 'b', '#', '1'));
        List<String> expected = new ArrayList<>(Arrays.asList("N(1)", "L(b)", "L(a)"));
        var actual = GenericCollections.lettersAndNumbers(inList);
        assertEquals(expected, actual);
    }

    @Test
    void test_lettersAndNumbers_mixedCharacterTypes() {
        List<Character> inList = new ArrayList<>(Arrays.asList('?', 'a', '_', ' ', 'b', '#', '1'));
        List<String> expected = new ArrayList<>(Arrays.asList("N(1)", "L(b)", "L(a)"));
        var actual = GenericCollections.lettersAndNumbers(inList);
        assertEquals(expected, actual);
    }


    @Test
    void test_modify_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> GenericCollections.modify(null));
    }

    @Test
    void test_modify_inputListIsMutatedAtRunTime() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,12, 2, 3));
        int h  = list.hashCode();
        GenericCollections.modify(list);
        int modH = list.hashCode();
        assertNotEquals(h, modH);
    }

    @Test
    void test_modify_emptyList_returnsNOfDistinctFirst5MultiplesOf4And5And6() {
        var n = GenericCollections.modify(new ArrayList<>());
        Set<Integer> s = new HashSet<>();
        for (int i = 4; i < 7; i++) {
            for (int j = 1; j < 6; j++) s.add(i * j);
        }
        assertEquals(s.size(), n);
    }

    @Test
    void test_modify_allMultiplesOfThree_returnsNOfDistinctFirst5MultiplesOf4And5And6() {
        var n = GenericCollections.modify(new ArrayList<>(Arrays.asList(3, 6, 9, 12, 15, 18, 102, 105)));
        Set<Integer> s = new HashSet<>();
        for (int i = 4; i < 7; i++) {
            for (int j = 1; j < 6; j++) s.add(i * j);
        }
        assertEquals(s.size(), n);
    }

    @Test
    void test_modify_allFirst5MultiplesOf4And5And6InModifiedList() {
        List<Integer> l = new ArrayList<>(Arrays.asList(1, 500, 1000));
        Set<Integer> s = new HashSet<>();
        for (int i = 4; i < 7; i++) {
            for (int j = 1; j < 6; j++) s.add(i * j);
        }
        GenericCollections.modify(l);
        assertTrue(l.containsAll(s));
    }

    @Test
    void test_modify_modifiedListIsSortedAscending() {
        var l = new ArrayList<>(Arrays.asList(-301, 602, 301));
        GenericCollections.modify(l);
        var l2 = new ArrayList<>(l);
        l2.sort(null);
        assertEquals(l, l2);
    }

    @Test
    void test_modify_duplicatesStrippedFromResultSetYieldingReturnValue() {
        List<Integer> l = new ArrayList<>(Arrays.asList(1, 1, 3, 3, 3, 50, 50, 50, 50, 1000, 1000));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1, 3, 50, 1000));
        var count = GenericCollections.modify(l);
        var count2 = GenericCollections.modify(l2);
        assertEquals(count, count2);
    }

    @Test
    void test_modify_inputListContainsNullValues_throwsNullPointerException() {
        List<Integer> l = new ArrayList<>(Arrays.asList(null, 3, 10, null));
        assertThrows(NullPointerException.class, () -> GenericCollections.modify(l));
    }

    @Test
    void test_removeEveryNthElement_listIsNull_throwsNullPointerException() {
        assertThrows(
                NullPointerException.class
                , () ->GenericCollections.removeEveryNthElement(null, 1)
        );
    }

    @Test
    void test_removeEveryNthElement_nIsNotPositive_throwsIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class
                , () -> GenericCollections.removeEveryNthElement(new ArrayList<>(Arrays.asList(1,2,3)), 0)
        );
    }

    @Test
    void test_removeEveryNthElement_nIsPositiveAndLessThanOrEqualLengthOfArgumentList_originalListModified() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("okay", "well", "alright"));
        GenericCollections.removeEveryNthElement(list, 2);
        assertEquals(Arrays.asList("okay", "alright"), list);
    }

    @Test
    void test_removeEveryNthElement_nIsGreaterThanListLength_noModificationsMade() {
        var list = new ArrayList<>(Arrays.asList(new Object(), new Object()));
        var copy = new ArrayList<>(list);
        GenericCollections.removeEveryNthElement(list, 3);
        assertEquals(copy, list);
    }

    @Test
    void test_removeEveryNthElement_modifiedListIsLengthOriginalListLengthMinusFloorDivN() {
        var list = IntStream.range(0,100).boxed().collect(Collectors.toList());
        var copy = new ArrayList<>(list);
        var every = 13;
        GenericCollections.removeEveryNthElement(list, every);
        assertEquals(copy.size() - copy.size() / every, list.size());
    }

    @Test
    void test_removeEveryNthElement_nIsOne_EveryElementIsRemoved() {
        var list = IntStream.range(0,100).boxed().collect(Collectors.toList());
        GenericCollections.removeEveryNthElement(list, 1);
        assertTrue(list.isEmpty());
    }

    @Test
    void test_removeEveryNthElement_ListContainsObjectsOfMixedTypes() {
        var id = UUID.randomUUID();
        var map = new HashMap<String, Integer>();
        List<?> list = new ArrayList<>(Arrays.asList("1", '1', 1, map, id, id, map));
        var expected = new ArrayList<>(Arrays.asList("1", 1, id, map));
        GenericCollections.removeEveryNthElement(list, 2);
        assertEquals(expected, list);
    }
}