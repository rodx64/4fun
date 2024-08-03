package benchmark;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.LinkedList;

import static benchmark.setup.ConsoleColors.RESET;
import static benchmark.setup.ConsoleColors.WHITE_BRIGHT;
import static benchmark.setup.Constants.MESSAGE_ADDING_COLOR;
import static benchmark.setup.Constants.MESSAGE_FASTER_COLOR;
import static benchmark.setup.Constants.MESSAGE_READING_COLOR;
import static benchmark.setup.Constants.MESSAGE_REMOVING_COLOR;
import static benchmark.setup.response.Response.getFaster;
import static benchmark.setup.response.SetupResponseList.addingAll;
import static benchmark.setup.response.SetupResponseList.addingByIndex;
import static benchmark.setup.response.SetupResponseList.lookingByIndex;
import static benchmark.setup.response.SetupResponseList.lookingByValue;
import static benchmark.setup.response.SetupResponseList.removingFirst;
import static benchmark.setup.response.SetupResponseList.removingLast;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ListTest {

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
        System.out.printf(WHITE_BRIGHT + "::: LIST TESTS :::" + RESET + "%n");
    }

    private static void printFunctions() {
        addingAll().forEach((key, value) -> System.out.printf((MESSAGE_ADDING_COLOR) + "%n", "Appending", key, value));
        addingByIndex().forEach((key, value) -> System.out.printf((MESSAGE_ADDING_COLOR) + "%n", "Prepending", key, value));
        lookingByIndex().forEach((key, value) -> System.out.printf((MESSAGE_READING_COLOR) + "%n", "Looking by Index", key, value));
        lookingByValue().forEach((key, value) -> System.out.printf((MESSAGE_READING_COLOR) + "%n", "Looking by Value", key, value));
        removingFirst().forEach((key, value) -> System.out.printf((MESSAGE_REMOVING_COLOR) + "%n", "Removing::First", key, value));
        removingLast().forEach((key, value) -> System.out.printf((MESSAGE_REMOVING_COLOR) + "%n", "Removing::Last", key, value));
    }

    private static void printFaster() {
        System.out.printf((MESSAGE_FASTER_COLOR) + "%n", "Appending", getFaster(addingAll()).getKey(), getFaster(addingAll()).getValue());
        System.out.printf((MESSAGE_FASTER_COLOR) + "%n", "Prepending", getFaster(addingByIndex()).getKey(), getFaster(addingByIndex()).getValue());
        System.out.printf((MESSAGE_FASTER_COLOR) + "%n", "Looking by Index", getFaster(lookingByIndex()).getKey(), getFaster(lookingByIndex()).getValue());
        System.out.printf((MESSAGE_FASTER_COLOR) + "%n", "Looking by Value", getFaster(lookingByValue()).getKey(), getFaster(lookingByValue()).getValue());
        System.out.printf((MESSAGE_FASTER_COLOR) + "%n", "Removing First", getFaster(removingFirst()).getKey(), getFaster(removingFirst()).getValue());
        System.out.printf((MESSAGE_FASTER_COLOR) + "%n", "Removing Last", getFaster(removingLast()).getKey(), getFaster(removingLast()).getValue());
    }

    @Test
    @DisplayName("Adding - Validate that LinkedList is Faster adding in First")
    void whenAddingInFirstPositionList_shouldValidateThatLinkedListIsFaster() {
        assertEquals(LinkedList.class.getSimpleName(), getFaster(addingByIndex()).getKey());
    }

    @Test
    @DisplayName("Looking By Index - Validate that ArrayList is Faster")
    void whenGettingInList_shouldValidateThatArrayListIsFaster() {
        assertEquals(ArrayList.class.getSimpleName(), getFaster(lookingByIndex()).getKey());
    }

    @Test
    @DisplayName("Removing First - Validate that LinkedList is Faster")
    void whenRemovingFirstInList_shouldValidateThatLinkedListIsFaster() {
        assertEquals(LinkedList.class.getSimpleName(), getFaster(removingFirst()).getKey());
    }

    @Test
    @DisplayName("Removing Last - Validate that ArrayList is Faster")
    void whenRemovingLastInList_shouldValidateThatLinkedListIsFaster() {
        assertEquals(ArrayList.class.getSimpleName(), getFaster(removingLast()).getKey());
    }


    private static void clear() {
        addingByIndex().clear();
        lookingByIndex().clear();
        lookingByValue().clear();
        removingFirst().clear();
        removingLast().clear();
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

    }
}
