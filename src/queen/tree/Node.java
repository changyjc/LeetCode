package queen.tree;

import java.util.Arrays;
import java.util.Comparator;


class Node<T extends Comparable<T>> {

    private T[] keys = null;
    private int keysSize = 0;
    private Node<T>[] children = null;
    private int childrenSize = 0;
    private Comparator<Node<T>> comparator = new Comparator<Node<T>>() {
        @Override
        public int compare(Node<T> arg0, Node<T> arg1) {
            return arg0.getKey(0).compareTo(arg1.getKey(0));
        }
    };

    protected Node<T> parent = null;

    private Node(Node<T> parent, int maxKeySize, int maxChildrenSize) {
        this.parent = parent;
        this.keys = (T[]) new Comparable[maxKeySize + 1];
        this.keysSize = 0;
        this.children = new Node[maxChildrenSize + 1];
        this.childrenSize = 0;
    }

    private T getKey(int index) {
        return keys[index];
    }

    private int indexOf(T value) {
        for (int i = 0; i < keysSize; i++) {
            if (keys[i].equals(value)) return i;
        }
        return -1;
    }

    private void addKey(T value) {
        keys[keysSize++] = value;
        Arrays.sort(keys, 0, keysSize);
    }

    private T removeKey(T value) {
        T removed = null;
        boolean found = false;
        if (keysSize == 0) return null;
        for (int i = 0; i < keysSize; i++) {
            if (keys[i].equals(value)) {
                found = true;
                removed = keys[i];
            } else if (found) {
                // shift the rest of the keys down
                keys[i - 1] = keys[i];
            }
        }
        if (found) {
            keysSize--;
            keys[keysSize] = null;
        }
        return removed;
    }

    private T removeKey(int index) {
        if (index >= keysSize)
            return null;
        T value = keys[index];
        for (int i = index + 1; i < keysSize; i++) {
            // shift the rest of the keys down
            keys[i - 1] = keys[i];
        }
        keysSize--;
        keys[keysSize] = null;
        return value;
    }

    private int numberOfKeys() {
        return keysSize;
    }

    private Node<T> getChild(int index) {
        if (index >= childrenSize)
            return null;
        return children[index];
    }

    private int indexOf(Node<T> child) {
        for (int i = 0; i < childrenSize; i++) {
            if (children[i].equals(child))
                return i;
        }
        return -1;
    }

    private boolean addChild(Node<T> child) {
        child.parent = this;
        children[childrenSize++] = child;
        Arrays.sort(children, 0, childrenSize, comparator);
        return true;
    }

    private boolean removeChild(Node<T> child) {
        boolean found = false;
        if (childrenSize == 0)
            return found;
        for (int i = 0; i < childrenSize; i++) {
            if (children[i].equals(child)) {
                found = true;
            } else if (found) {
                // shift the rest of the keys down
                children[i - 1] = children[i];
            }
        }
        if (found) {
            childrenSize--;
            children[childrenSize] = null;
        }
        return found;
    }

    private Node<T> removeChild(int index) {
        if (index >= childrenSize)
            return null;
        Node<T> value = children[index];
        children[index] = null;
        for (int i = index + 1; i < childrenSize; i++) {
            // shift the rest of the keys down
            children[i - 1] = children[i];
        }
        childrenSize--;
        children[childrenSize] = null;
        return value;
    }

    private int numberOfChildren() {
        return childrenSize;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("keys=[");
        for (int i = 0; i < numberOfKeys(); i++) {
            T value = getKey(i);
            builder.append(value);
            if (i < numberOfKeys() - 1)
                builder.append(", ");
        }
        builder.append("]\n");

        if (parent != null) {
            builder.append("parent=[");
            for (int i = 0; i < parent.numberOfKeys(); i++) {
                T value = parent.getKey(i);
                builder.append(value);
                if (i < parent.numberOfKeys() - 1)
                    builder.append(", ");
            }
            builder.append("]\n");
        }

        if (children != null) {
            builder.append("keySize=").append(numberOfKeys()).append(" children=").append(numberOfChildren()).append("\n");
        }

        return builder.toString();
    }
}
