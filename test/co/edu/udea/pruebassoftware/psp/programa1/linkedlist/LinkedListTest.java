package co.edu.udea.pruebassoftware.psp.programa1.linkedlist;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedListTest {

    @Test()
    public void isEmptyTest1() {
        LinkedList linkedList = new LinkedList();

        assertTrue(linkedList.isEmpty());
    }

    @Test()
    public void isEmptyTest2() {
        LinkedList linkedList = new LinkedList();
        linkedList.link(98);

        assertTrue(!linkedList.isEmpty());
    }

    @Test()
    public void getLastNodeTest1() {
        LinkedList linkedList = new LinkedList();

        assertTrue(linkedList.getLastNode() == null);
    }

    @Test()
    public void gestLastNodeTest2() {
        LinkedList linkedList = new LinkedList();
        linkedList.link(86.9);

        assertTrue(linkedList.getLastNode().getValue() == 86.9);
    }

    @Test()
    public void gestLastNodeTest3() {
        LinkedList linkedList = new LinkedList();
        linkedList.link(86.9);
        linkedList.link(98.3);

        assertTrue(linkedList.getLastNode().getValue() == 98.3);
    }

    @Test()
    public void gestLastNodeTest4() {
        LinkedList linkedList = new LinkedList();
        linkedList.link(5.6);
        linkedList.link(58.6);
        linkedList.link(55);
        linkedList.link(95);
        linkedList.link(3);

        assertTrue(linkedList.getLastNode().getValue() == 3);
    }

    @Test()
    public void getFirstNodeTest1() {
        LinkedList linkedList = new LinkedList();

        assertTrue(linkedList.getFirstNode() == null);
    }

    @Test()
    public void getFirstNodeTest2() {
        LinkedList linkedList = new LinkedList();
        linkedList.link(3);

        assertTrue(linkedList.getFirstNode().getValue() == 3);
    }

    @Test()
    public void getFirstNodeTest3() {
        LinkedList linkedList = new LinkedList();
        linkedList.link(3);
        linkedList.link(8);

        assertTrue(linkedList.getFirstNode().getValue() == 3);
    }

    @Test()
    public void linkTest1() {
        LinkedList linkedList = new LinkedList();
        double value = 9;
        Node node = linkedList.link(value);

        assertTrue(value == node.getValue());
    }

    @Test()
    public void linkTest2() {
        LinkedList linkedList = new LinkedList();
        double value = 9;
        linkedList.link(value);

        assertTrue(value == linkedList.getFirstNode().getValue());
    }

    @Test()
    public void linkTest3() {
        LinkedList linkedList = new LinkedList();
        linkedList.link(5.6);
        linkedList.link(58.6);

        assertTrue(linkedList.getLastNode().getValue() == 58.6);
    }

    @Test()
    public void linkTest4() {
        LinkedList linkedList = new LinkedList();
        linkedList.link(5.6);
        linkedList.link(58.6);
        linkedList.link(55);
        linkedList.link(95);

        assertTrue(linkedList.getFirstNode().getValue() == 5.6
                && linkedList.getLastNode().getValue() == 95);
    }

    @Test()
    public void deleteTest1() {
        LinkedList linkedList = new LinkedList();
        linkedList.delete();

        assertTrue(linkedList.getLastNode() == null);
    }

    @Test()
    public void deleteTest2() {
        LinkedList linkedList = new LinkedList();
        linkedList.link(5.6);

        linkedList.delete();

        assertTrue(linkedList.getFirstNode() == null
                && linkedList.getLastNode() == null);
    }

    @Test()
    public void deleteTest3() {
        LinkedList linkedList = new LinkedList();
        linkedList.link(5.6);
        linkedList.link(58.6);
        linkedList.link(55);
        linkedList.link(95);

        linkedList.delete();

        assertTrue(linkedList.getLastNode().getValue() == 55);
    }

    @Test()
    public void getAmountTest1() {
        LinkedList linkedList = new LinkedList();

        assertTrue(linkedList.getAmount() == 0);
    }

    @Test()
    public void getAmountTest2() {
        LinkedList linkedList = new LinkedList();
        linkedList.link(5.6);

        assertTrue(linkedList.getAmount() == 1);
    }

    @Test()
    public void getAmountTest3() {
        LinkedList linkedList = new LinkedList();
        linkedList.link(5.6);
        linkedList.link(58.6);
        linkedList.link(55);
        linkedList.link(95);

        assertTrue(linkedList.getAmount() == 4);
    }

    @Test()
    public void getAmountTest4() {
        LinkedList linkedList = new LinkedList();
        linkedList.link(5.6);
        linkedList.link(58.6);
        linkedList.link(55);
        linkedList.link(95);

        linkedList.delete();
        linkedList.delete();

        assertTrue(linkedList.getAmount() == 2);
    }
}
