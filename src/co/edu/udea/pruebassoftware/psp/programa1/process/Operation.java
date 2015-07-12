package co.edu.udea.pruebassoftware.psp.programa1.process;

import co.edu.udea.pruebassoftware.psp.programa1.linkedlist.LinkedList;
import co.edu.udea.pruebassoftware.psp.programa1.linkedlist.Node;
import static java.lang.Double.NaN;
import java.text.DecimalFormat;

public class Operation {

    public static String DECIMAL_FORMAT = "#.######";

    private final LinkedList linkedList;
    private final DecimalFormat decimalFormat;

    public Operation(LinkedList linkedList) {
        this.linkedList = linkedList;
        this.decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
    }

    public double sum() {
        double total = 0.0;
        if (linkedList != null) {

            Node node = linkedList.getFirstNode();
            while (node != null) {
                total += node.getValue();
                node = node.getNext();
            }
        }

        return total;
    }

    public double mean() {
        double mean = NaN;
        if (linkedList != null && linkedList.getFirstNode() != null) {
            double amount = linkedList.getAmount();
            double sum = this.sum();

            mean = sum / amount;

            return Double.parseDouble(this.decimalFormat.format(mean).
                    replace(",", "."));
        }

        return mean;
    }

    public double std() {
        double std = NaN;
        if (linkedList != null && linkedList.getFirstNode() != null) {
            double amount = linkedList.getAmount();
            if (amount == 1) {

                return NaN;
            }
            double mean = this.mean();
            double sum = 0.0;
            Node n = linkedList.getFirstNode();
            while (n != null) {
                sum += Math.pow((n.getValue() - mean), 2.0);
                n = n.getNext();
            }

            std = Math.sqrt(sum / (amount - 1));

            return Double.parseDouble(this.decimalFormat.format(std).replace(",",
                    "."));
        }
        
        return std;
    }
}
