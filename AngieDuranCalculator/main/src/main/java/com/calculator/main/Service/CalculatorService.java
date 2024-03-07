package com.calculator.main.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calculator.main.Entity.Operation;
import com.calculator.main.Exception.CustomException1;
import com.calculator.main.Repository.OperationRepository;

import java.util.Date;

@Service
@Transactional
public class CalculatorService {

    private final OperationRepository operationRepository;

    @Autowired
    public CalculatorService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public double addAndSaveOperation(String operationType, double operand1, double operand2) {
        double result = operand1 + operand2;
        saveOperation(operationType, operand1, operand2, result);
        return result;
    }

    public double subtractAndSaveOperation(String operationType, double operand1, double operand2) {
        double result = operand1 - operand2;
        saveOperation(operationType, operand1, operand2, result);
        return result;
    }

    public double multiplyAndSaveOperation(String operationType, double operand1, double operand2) {
        double result = operand1 * operand2;
        saveOperation(operationType, operand1, operand2, result);
        return result;
    }

    public double divideAndSaveOperation(String operationType, double operand1, double operand2) {
        if (operand2 == 0) {
            throw new CustomException1("Division by zero");
        }
        double result = operand1 / operand2;
        saveOperation(operationType, operand1, operand2, result);
        return result;
    }

    private void saveOperation(String operationType, double operand1, double operand2, double result) {
        Operation operation = new Operation();
        operation.setOperationType(operationType);
        operation.setOperand1(operand1);
        operation.setOperand2(operand2);
        operation.setResult(result);
        operation.setTimestamp(new Date());
        operationRepository.save(operation);
    }
}
