package org.kata.stack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StackTest {
    @Test
    public void canStoreObjectsAndReadObjects() throws Exception {
        Stack stack = new Stack();
        Object objectToStore = new Object();

        stack.push(objectToStore);

        assertThat(stack.pop(), is(objectToStore));
    }

    @Test
    public void shouldReadObjectWhichWasAddedAsLastOne() throws Exception {
        Stack stack = new Stack();
        Object objectToStore = new Object();
        Object anotherObjectToStore = new String();

        stack.push(objectToStore);
        stack.push(anotherObjectToStore);

        assertThat(stack.pop(),is(anotherObjectToStore));
    }

    @Test
    public void afterReadingLastObjectShouldReadObjectWhichWasAddedBeforeLastObject() throws Exception {
        Stack stack = new Stack();
        Object objectToStore = new Object();
        Object anotherObjectToStore = new String();
        Object thirdObjectToStore = new Object[]{};

        stack.push(objectToStore);
        stack.push(anotherObjectToStore);
        stack.push(thirdObjectToStore);

        assertThat(stack.pop(),is(thirdObjectToStore));
        assertThat(stack.pop(),is(anotherObjectToStore));
        assertThat(stack.pop(),is(objectToStore));
    }

    @Test(expected = StackIsEmptyException.class)
    public void shouldNotReadObjectsWhenItEmpty() throws Exception {
        Stack stack = new Stack();
        Object objectToStore = new Object();
        Object anotherObjectToStore = new String();
        Object thirdObjectToStore = new Object[]{};

        stack.push(objectToStore);
        stack.push(anotherObjectToStore);
        stack.push(thirdObjectToStore);

        assertThat(stack.pop(),is(thirdObjectToStore));
        assertThat(stack.pop(),is(anotherObjectToStore));
        assertThat(stack.pop(),is(objectToStore));
        stack.pop();
    }
}