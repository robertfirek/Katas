package org.kata.stack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StackTest {

    private static final Object OBJECT_TO_STORE = new Object();
    private static final Object ANOTHER_OBJECT_TO_STORE = "";
    private static final Object THIRD_OBJECT_TO_STORE = new Object[]{};
    private Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack();
    }

    @Test
    public void canStoreObjectsAndReadObjects() throws Exception {
        stack.push(OBJECT_TO_STORE);

        assertThat(stack.pop(), is(OBJECT_TO_STORE));
    }

    @Test
    public void shouldReadObjectWhichWasAddedAsLastOne() throws Exception {
        stack.push(OBJECT_TO_STORE);
        stack.push(ANOTHER_OBJECT_TO_STORE);

        assertThat(stack.pop(), is(ANOTHER_OBJECT_TO_STORE));
    }

    @Test
    public void afterReadingLastObjectShouldReadObjectWhichWasAddedBeforeLastObject() throws Exception {
        stack.push(OBJECT_TO_STORE);
        stack.push(ANOTHER_OBJECT_TO_STORE);
        stack.push(THIRD_OBJECT_TO_STORE);

        assertThat(stack.pop(), is(THIRD_OBJECT_TO_STORE));
        assertThat(stack.pop(), is(ANOTHER_OBJECT_TO_STORE));
        assertThat(stack.pop(), is(OBJECT_TO_STORE));
    }

    @Test(expected = StackIsEmptyException.class)
    public void shouldNotReadObjectsWhenItEmpty() throws Exception {
        stack.push(OBJECT_TO_STORE);
        stack.push(ANOTHER_OBJECT_TO_STORE);
        stack.push(THIRD_OBJECT_TO_STORE);

        assertThat(stack.pop(), is(THIRD_OBJECT_TO_STORE));
        assertThat(stack.pop(), is(ANOTHER_OBJECT_TO_STORE));
        assertThat(stack.pop(), is(OBJECT_TO_STORE));
        stack.pop();
    }
}