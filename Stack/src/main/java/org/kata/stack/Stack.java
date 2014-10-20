package org.kata.stack;

import java.util.ArrayList;

public class Stack {
    private ArrayList<Object> objects = new ArrayList<Object>();

    public void push(Object object) {
        this.objects.add(object);
    }

    public Object pop() throws StackIsEmptyException {
        if (this.objects.isEmpty()) {
            throw new StackIsEmptyException();
        }
        return this.objects.remove(this.objects.size() - 1);
    }
}
