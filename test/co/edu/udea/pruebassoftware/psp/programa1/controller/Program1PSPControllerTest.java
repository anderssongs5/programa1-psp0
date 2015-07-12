package co.edu.udea.pruebassoftware.psp.programa1.controller;

import co.edu.udea.pruebassoftware.psp.programa1.linkedlist.LinkedList;
import java.io.File;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Program1PSPControllerTest {

    private static final String PATH = "C:\\Users\\Andersson\\Desktop\\";
    private final Program1PSPController controller = new Program1PSPController();

    @Test()
    public void checkFileTest1() {
        File file = null;
        boolean expResult = false;
        boolean result = this.controller.checkFile(file);
        assertEquals(expResult, result);
    }

    @Test()
    public void checkFileTest2() {
        File file = new File("test.txt");
        boolean expResult = false;
        boolean result = this.controller.checkFile(file);
        assertEquals(expResult, result);
    }

    @Test()
    public void checkFileTest3() {
        File file = new File(PATH + "Numbers");
        boolean expResult = false;
        boolean result = this.controller.checkFile(file);
        assertEquals(expResult, result);
    }

    @Test()
    public void checkFileTest4() {
        File file = new File(PATH + "Numbers.txt");
        boolean expResult = true;
        boolean result = this.controller.checkFile(file);
        assertEquals(expResult, result);
    }

    @Test()
    public void readFileTest1() throws Exception {
        File file = new File(PATH + "Numbers1.txt");

        LinkedList result = this.controller.readFile(file);
        assertTrue(result == null);
    }

    @Test()
    public void readFileTest2() throws Exception {
        File file = new File(PATH + "Numbers2.txt");

        LinkedList result = this.controller.readFile(file);
        assertTrue(result != null && result.getFirstNode() != null
                && result.getLastNode() != null && result.getAmount() == 5);
    }

    @Test()
    public void readFileTest3() throws Exception {
        File file = new File(PATH + "Numbers.txt");

        LinkedList result = this.controller.readFile(file);
        assertTrue(result != null && result.getFirstNode() != null
                && result.getLastNode() != null && result.getAmount() == 5);
    }

    @Test()
    public void readLinesTest1() throws Exception {
        File selectedFile = new File(PATH + "Numbers4.txt");

        List<StringBuilder> result = this.controller.readLines(selectedFile);
        assertEquals(0, result.size());
    }

    @Test()
    public void readLinesTest2() throws Exception {
        File selectedFile = new File(PATH + "Numbers5.txt");

        List<StringBuilder> result = this.controller.readLines(selectedFile);
        assertEquals(1, result.size());
    }

    @Test()
    public void readLinesTest3() throws Exception {
        File selectedFile = new File(PATH + "Numbers6.txt");

        List<StringBuilder> result = this.controller.readLines(selectedFile);
        assertEquals(3, result.size());
    }

    @Test()
    public void readLinesTest4() throws Exception {
        File selectedFile = new File(PATH + "Numbers.txt");

        List<StringBuilder> result = this.controller.readLines(selectedFile);
        assertEquals(2, result.size());
    }
}
