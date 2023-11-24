package com.example.homework22.service;

import com.example.homework22.exceptions.BadRequestException;
import com.example.homework22.exceptions.BadRequestIllegalArgumentException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public String plus(int num1, int num2) {
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    @Override
    public String minus(int num1, int num2) {
        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    @Override
    public String multiply(int num1, int num2) {
        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    @Override
    public String divide(int num1, int num2) {
        if (num2 == 0f)
            throw new BadRequestIllegalArgumentException();

        return num1 + " / " + num2 + " = " + (num1 / num2);
    }
}
