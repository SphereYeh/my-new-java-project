package com.sphereyeh.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CalculatorService 的單元測試
 * 
 * @author SphereYeh
 * @version 1.0.0
 */
@DisplayName("計算器服務測試")
class CalculatorServiceTest {
    
    private CalculatorService calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new CalculatorService();
    }
    
    @Test
    @DisplayName("測試加法運算")
    void testAdd() {
        // Given
        int a = 5;
        int b = 3;
        int expected = 8;
        
        // When
        int result = calculator.add(a, b);
        
        // Then
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("測試加法運算 - 負數")
    void testAddWithNegativeNumbers() {
        assertEquals(-2, calculator.add(-5, 3));
        assertEquals(-8, calculator.add(-5, -3));
        assertEquals(2, calculator.add(5, -3));
    }
    
    @Test
    @DisplayName("測試減法運算")
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-2, calculator.subtract(3, 5));
        assertEquals(8, calculator.subtract(5, -3));
    }
    
    @Test
    @DisplayName("測試乘法運算")
    void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));
        assertEquals(0, calculator.multiply(5, 0));
        assertEquals(-15, calculator.multiply(-5, 3));
        assertEquals(15, calculator.multiply(-5, -3));
    }
    
    @Test
    @DisplayName("測試除法運算")
    void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3), 0.001);
        assertEquals(1.666666, calculator.divide(5, 3), 0.001);
        assertEquals(-2.0, calculator.divide(-6, 3), 0.001);
    }
    
    @Test
    @DisplayName("測試除法運算 - 除數為零")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(5, 0);
        });
    }
    
    @Test
    @DisplayName("測試平方運算")
    void testSquare() {
        assertEquals(25, calculator.square(5));
        assertEquals(0, calculator.square(0));
        assertEquals(25, calculator.square(-5));
    }
    
    @Test
    @DisplayName("測試平方根運算")
    void testSqrt() {
        assertEquals(5.0, calculator.sqrt(25), 0.001);
        assertEquals(0.0, calculator.sqrt(0), 0.001);
        assertEquals(2.236, calculator.sqrt(5), 0.001);
    }
    
    @Test
    @DisplayName("測試平方根運算 - 負數")
    void testSqrtWithNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.sqrt(-1);
        });
    }
}