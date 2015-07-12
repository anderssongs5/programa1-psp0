package co.edu.udea.pruebassoftware.psp.programa1.controller;

import co.edu.udea.pruebassoftware.psp.programa1.linkedlist.LinkedList;
import co.edu.udea.pruebassoftware.psp.programa1.process.Operation;

public class OperationController {

    private final Operation operation;

    public OperationController(LinkedList linkedList) {
        super();
        this.operation = new Operation(linkedList);
    }

    public double mean() {

        return this.operation.mean();
    }

    public double std() {

        return this.operation.std();
    }
}
