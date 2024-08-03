package domain.my_implementation;

import domain.my_implementation._Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class _StackTest {

    @Test
    void validateMyStack() {
        _Stack stack = new _Stack(4);
        assertEquals(4, stack.top.value);
        assertEquals(1, stack.height);
        stack.printStack();
    }

    @Test
    void validateMyPush() {
        _Stack stack = new _Stack(3);
        assertEquals(3, stack.top.value);
        assertEquals(1, stack.height);

        stack.push(2);
        assertEquals(2, stack.top.value);
        assertEquals(2, stack.height);

        stack.push(1);
        assertEquals(1, stack.top.value);
        assertEquals(3, stack.height);
    }

    @Test
    void validateMyPop() {
        _Stack stack = new _Stack(3);
        assertEquals(3, stack.top.value);
        assertEquals(1, stack.height);

        stack.push(2);
        assertEquals(2, stack.top.value);
        assertEquals(2, stack.height);

        stack.push(1);
        assertEquals(1, stack.top.value);
        assertEquals(3, stack.height);

        stack.pop();
        assertEquals(2, stack.top.value);
        assertEquals(2, stack.height);

        stack.pop();
        assertEquals(3, stack.top.value);
        assertEquals(1, stack.height);

        stack.pop();
        assertNull(stack.top);
        assertEquals(0, stack.height);
    }
}