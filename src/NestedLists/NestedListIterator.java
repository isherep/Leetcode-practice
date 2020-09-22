package NestedLists;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedListIterator implements Iterator<Integer> {

    List<NestedInteger> nestedList;
    Stack<NestedInteger> s;

    // have a starting
    public NestedListIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        s = new Stack<>();
    }

    @Override
    public Integer next() {
        if (hasNext()) return s.pop().getInteger();
        else return null;
    }

    @Override
    public boolean hasNext() {
        // flatten the list untill all the lists are flattened
        while (!s.isEmpty() && !s.peek().isInteger()) {
            fillStack(s.pop().getList());
        }
        return false;
    }

    public void fillStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            s.push(nestedList.get(i));
        }
    }
}
