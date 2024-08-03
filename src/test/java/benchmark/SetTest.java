package benchmark;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.LinkedHashSet;
import java.util.TreeSet;

import static benchmark.setup.ConsoleColors.RESET;
import static benchmark.setup.ConsoleColors.WHITE_BRIGHT;
import static benchmark.setup.Constants.MESSAGE_ADDING_COLOR;
import static benchmark.setup.Constants.MESSAGE_CONTAINS_COLOR;
import static benchmark.setup.Constants.MESSAGE_FASTER_COLOR;
import static benchmark.setup.Constants.MESSAGE_NEXT_COLOR;
import static benchmark.setup.Constants.MESSAGE_REMOVING_COLOR;
import static benchmark.setup.response.SetupResponseSet.addingMap;
import static benchmark.setup.response.SetupResponseSet.containsMap;
import static benchmark.setup.response.SetupResponseSet.getFaster;
import static benchmark.setup.response.SetupResponseSet.getSlower;
import static benchmark.setup.response.SetupResponseSet.next;
import static benchmark.setup.response.SetupResponseSet.removingMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
class SetTest {

    @BeforeAll
    static void setUp() {
        printWelcome();
        printFunctions();
        printFaster();
        System.out.println();
    }

    @AfterAll
    static void cleaningUp() {
        clear();
    }

    private static void printWelcome() {
        System.out.printf(WHITE_BRIGHT + "::: SET TESTS :::" + RESET + "%n");
    }

    private static void printFunctions() {
        addingMap().forEach((key, value) -> System.out.printf((MESSAGE_ADDING_COLOR) + "%n", "Adding", key, value));
        containsMap().forEach((key, value) -> System.out.printf((MESSAGE_CONTAINS_COLOR) + "%n", "Contains", key, value));
        next().forEach((key, value) -> System.out.printf((MESSAGE_NEXT_COLOR) + "%n", "Finding Next", key, value));
        removingMap().forEach((key, value) -> System.out.printf((MESSAGE_REMOVING_COLOR) + "%n", "Removing", key, value));
    }

    private static void printFaster() {
        System.out.printf((MESSAGE_FASTER_COLOR) + "%n", "Adding", getFaster(addingMap()).getKey(), getFaster(addingMap()).getValue());
        System.out.printf((MESSAGE_FASTER_COLOR) + "%n", "Contains", getFaster(containsMap()).getKey(), getFaster(containsMap()).getValue());
        System.out.printf((MESSAGE_FASTER_COLOR) + "%n", "Finding Next", getFaster(next()).getKey(), getFaster(next()).getValue());
        System.out.printf((MESSAGE_FASTER_COLOR) + "%n", "Removing", getFaster(removingMap()).getKey(), getFaster(removingMap()).getValue());
    }

    @Test
    @DisplayName("Adding - Validate that TreeSet is Slower than HashSet/LinkedHashSet")
    void whenAddingInSet_shouldValidateThatTreeSetIsSlower() {
        assertEquals(TreeSet.class.getSimpleName(), getSlower(addingMap()).getKey());
    }

    @Test
    @DisplayName("Contains - Validate that LinkedHashSet is Faster")
    void whenContainsSet_shouldValidateThatLinkedHashSetIsFaster() {
        assertEquals(LinkedHashSet.class.getSimpleName(), getFaster(containsMap()).getKey());
    }

    @Test
    @DisplayName("Removing - Validate that TreeSet is Slower than HashSet/LinkedHashSet")
    void whenRemovingInSet_shouldValidateThatTreeSetIsSlower() {
        assertEquals(TreeSet.class.getSimpleName(), getSlower(removingMap()).getKey());
    }

    @Test
    @DisplayName("Finding Next - Validate that LinkedHashSet is Faster")
    void whenFindingNextSet_shouldValidateThatLinkedHashSetIsFaster() {
        assertEquals(LinkedHashSet.class.getSimpleName(), getFaster(next()).getKey());
    }

    private static void clear() {
        addingMap().clear();
        containsMap().clear();
        next().clear();
        removingMap().clear();
    }

}
