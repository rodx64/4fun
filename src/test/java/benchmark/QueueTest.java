package benchmark;

import org.junit.jupiter.api.*;

import java.util.*;

import static benchmark.setup.response.SetupResponseQueue.*;
import static benchmark.setup.response.SetupResponseQueue.readFirst;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static benchmark.setup.Constants.*;
import static benchmark.setup.ConsoleColors.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class QueueTest {

    @BeforeAll
    static void setUp(){
        printWelcome();
        printFunctions();
        printFaster();
        System.out.println();
    }

    @AfterAll
    static void cleaningUp(){
        clear();
    }

    private static void printWelcome() {
        System.out.printf(WHITE_BRIGHT + "::: QUEUE TESTS :::" + RESET + "%n" );
    }

    private static void printFunctions() {
        addingMap().forEach((key, value) -> System.out.printf((MESSAGE_ADDING_COLOR) + "%n", "Insert (Offer)", key, value));
        readFirst().forEach((key, value) -> System.out.printf((MESSAGE_CONTAINS_COLOR) + "%n", "Read Head (Peek)", key, value));
        removingMap().forEach((key, value) -> System.out.printf((MESSAGE_NEXT_COLOR) + "%n", "Removing", key, value));
        removingHeadMap().forEach((key, value) -> System.out.printf((MESSAGE_REMOVING_COLOR) + "%n", "Remove Head (Pool)", key, value));
    }

    private static void printFaster(){
        System.out.printf((MESSAGE_FASTER_COLOR) + "%n", "Adding", getFaster(addingMap()).getKey(), getFaster(addingMap()).getValue());
        System.out.printf((MESSAGE_FASTER_COLOR) + "%n", "Read Head (Peek)", getFaster(readFirst()).getKey(), getFaster(readFirst()).getValue());
        System.out.printf((MESSAGE_FASTER_COLOR) + "%n", "Removing", getFaster(removingMap()).getKey(), getFaster(removingMap()).getValue());
        System.out.printf((MESSAGE_FASTER_COLOR) + "%n", "Remove Head (Pool)", getFaster(removingHeadMap()).getKey(), getFaster(removingHeadMap()).getValue());
    }

    @Test
    @DisplayName("Adding - Validate that PriorityQueue is Faster")
    void whenAddingInQueue_shouldValidateThatPriorityQueueIsFaster(){
        assertEquals(PriorityQueue.class.getSimpleName(), getFaster(readFirst()).getKey());
    }

    @Test
    @DisplayName("Reading - Validate that PriorityQueue is Faster")
    void whenReadQueue_shouldValidateThatPriorityQueueIsFaster(){
        assertEquals(PriorityQueue.class.getSimpleName(), getFaster(readFirst()).getKey());
    }

    @Test
    @DisplayName("Removing - Validate that PriorityQueue is Faster")
    void whenRemovingFirstQueue_shouldValidateThatPriorityQueueIsFaster(){
        assertEquals(PriorityQueue.class.getSimpleName(), getFaster(removingHeadMap()).getKey());
    }

    private static void clear() {
        addingMap().clear();
        readFirst().clear();
        removingMap().clear();
        removingHeadMap().clear();
    }
}
