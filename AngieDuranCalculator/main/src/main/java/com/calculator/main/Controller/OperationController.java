package com.calculator.main.Controller;

import com.calculator.main.Entity.Operation;
import com.calculator.main.Service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/operation")
public class OperationController {
    private final OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping()
    public List<Operation> getAll() {
        return operationService.getAll();
    }

    @GetMapping("/{id}")
    public Operation getById(@PathVariable Long id) {
        return operationService.getById(id);
    }

}
