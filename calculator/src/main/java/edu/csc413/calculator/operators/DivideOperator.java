package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class DivideOperator extends Operator {

    @Override
    public int priority () {
        return 2;
    }

    @Override
    public Operand execute (Operand operand1, Operand operand2) {
        Operand result = new Operand(operand1.getValue() / operand2.getValue());
        return result;
    }
}
