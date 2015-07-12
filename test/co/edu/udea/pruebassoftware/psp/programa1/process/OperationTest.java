package co.edu.udea.pruebassoftware.psp.programa1.process;

import co.edu.udea.pruebassoftware.psp.programa1.linkedlist.LinkedList;
import static java.lang.Double.NaN;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class OperationTest {
    
    @Test()
    public void sumTest1() {
        Operation operation = new Operation(new LinkedList());

        assertTrue(operation.sum() == 0);
    }

    @Test()
    public void sumTest2() {
        LinkedList linkedList = new LinkedList();
        linkedList.link(5.6);
        Operation operation = new Operation(linkedList);

        assertTrue(operation.sum() == 5.6);
    }

    @Test()
    public void sumTest3() {
        LinkedList linkedList = new LinkedList();
        linkedList.link(5.6);
        linkedList.link(58.6);
        linkedList.link(55);
        linkedList.link(95);
        Operation operation = new Operation(linkedList);

        assertTrue(operation.sum() == 214.2);
    }
    
    @Test()
    public void sumTest4() {
        Operation operation = new Operation(null);

        assertTrue(operation.sum() == 0);
    }
    
    @Test()
    public void meanTest1(){
        Operation operation = new Operation(null);
        
        assertTrue(Double.compare(NaN, operation.std()) == 0);
    }
    
    @Test()
    public void meanTest2(){
        Operation operation = new Operation(new LinkedList());
        
        assertTrue(Double.compare(NaN, operation.std()) == 0);
    }
    
    @Test()
    public void meanTest3(){
        LinkedList linkedList = new LinkedList();
        linkedList.link(5.6);
        Operation operation = new Operation(linkedList);
        
        assertTrue(operation.mean() == 5.6);
    }
    
    @Test()
    public void meanTest4(){
        LinkedList linkedList = new LinkedList();
        linkedList.link(5);
        linkedList.link(1.2);
        Operation operation = new Operation(linkedList);
        
        assertTrue(operation.mean() == 3.1);
    }
    
    @Test()
    public void meanTest5(){
        LinkedList linkedList = new LinkedList();
        linkedList.link(5);
        linkedList.link(1);
        linkedList.link(3);
        linkedList.link(90);
        linkedList.link(-83);
        linkedList.link(-37);
        linkedList.link(51);
        Operation operation = new Operation(linkedList);
        
        assertTrue(operation.mean() == 4.285714);
    }
    
    @Test()
    public void stdTest1(){
        Operation operation = new Operation(null);
        Double d = operation.std();
        
        assertTrue(Double.compare(NaN, operation.std()) == 0);
    }
    
    @Test()
    public void stdTest2(){
        Operation operation = new Operation(new LinkedList());
        
        assertTrue(Double.compare(NaN, operation.std()) == 0);
    }
    
    @Test()
    public void stdTest3(){
        LinkedList linkedList = new LinkedList();
        linkedList.link(5.6);
        Operation operation = new Operation(linkedList);
        
        assertTrue(Double.compare(NaN, operation.std()) == 0);
    }
    
    @Test()
    public void stdTest4(){
        LinkedList linkedList = new LinkedList();
        linkedList.link(5);
        linkedList.link(1.2);
        Operation operation = new Operation(linkedList);
        
        assertTrue(operation.std() == 2.687006);
    }
}
