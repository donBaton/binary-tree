import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class Tree<T> {
    private int size;
    private Node<T> root = null;
    Consumer<Node<T>> payload;

    Tree(ArrayList<T> input) {
        if (input == null || input.isEmpty()) {
            root = null;
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        T tempValue = input.getFirst();
        if (tempValue != null) {
            root = new Node<>(tempValue);
            size++;
        }
        queue.add(root);
        int index = 1;
        int inputSize = input.size();
        while (true) {
            if (index < inputSize) {
                if (queue.isEmpty()) {
                    throw new IllegalArgumentException("Illegal input argument");
                }
                Node<T> currentNode = queue.poll();
                tempValue = input.get(index);
                Node<T> tempNode = null;
                if (currentNode == null && tempValue != null) {
                    throw new IllegalArgumentException("Illegal input argument");
                }
                if (tempValue != null) {
                    tempNode = new Node<>(tempValue);
                    currentNode.setLeft(tempNode);
                    size++;
                }
                queue.add(tempNode);
                index++;
                if (index < inputSize) {
                    tempValue = input.get(index);
                    tempNode = null;
                    if (currentNode == null && tempValue != null) {
                        throw new IllegalArgumentException("Illegal input argument");
                    }
                    if (tempValue != null) {
                        tempNode = new Node<>(tempValue);
                        currentNode.setRight(tempNode);
                        size++;
                    }
                    queue.add(tempNode);
                    index++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    int size() {
        return this.size;
    }

    public void dfsPreOrder(Consumer<Node<T>> payload) {
        this.payload = payload;
        dfsPreOrder(root);
    }

    private void dfsPreOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        payload.accept(node);
        dfsPreOrder(node.getLeft());
        dfsPreOrder(node.getRight());
    }

    public void dfsPostOrder(Consumer<Node<T>> payload) {
        this.payload = payload;
        dfsPostOrder(root);
    }

    private void dfsPostOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        dfsPostOrder(node.getLeft());
        dfsPostOrder(node.getRight());
        payload.accept(node);
    }

    public void dfsInOrder(Consumer<Node<T>> payload) {
        this.payload = payload;
        dfsInOrder(root);
    }

    private void dfsInOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        dfsInOrder(node.getLeft());
        payload.accept(node);
        dfsInOrder(node.getRight());
    }

    static class Node<T> {
        private final T value;
        private Node<T> left;
        private Node<T> right;

        Node(T value) {
            this.value = value;
        }

        void setLeft(Node<T> left) {
            this.left = left;
        }

        void setRight(Node<T> right) {
            this.right = right;
        }

        T getValue() {
            return this.value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> getRight() {
            return right;
        }
    }
}
