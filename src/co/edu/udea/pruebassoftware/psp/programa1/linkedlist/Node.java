package co.edu.udea.pruebassoftware.psp.programa1.linkedlist;

public class Node {

    private Node next;
    private double value;

    public Node(double value) {
        this.value = value;
    }

    Node() {
        super();
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
