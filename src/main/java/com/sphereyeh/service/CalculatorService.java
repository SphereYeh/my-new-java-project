package com.sphereyeh.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 計算器服務類別
 * 提供基本的數學運算功能
 * 
 * @author SphereYeh
 * @version 1.0.0
 */
public class CalculatorService {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);
    
    /**
     * 加法運算
     * 
     * @param a 第一個數字
     * @param b 第二個數字
     * @return 加法結果
     */
    public int add(int a, int b) {
        int result = a + b;
        logger.debug("執行加法: {} + {} = {}", a, b, result);
        return result;
    }
    
    /**
     * 減法運算
     * 
     * @param a 被減數
     * @param b 減數
     * @return 減法結果
     */
    public int subtract(int a, int b) {
        int result = a - b;
        logger.debug("執行減法: {} - {} = {}", a, b, result);
        return result;
    }
    
    /**
     * 乘法運算
     * 
     * @param a 第一個數字
     * @param b 第二個數字
     * @return 乘法結果
     */
    public int multiply(int a, int b) {
        int result = a * b;
        logger.debug("執行乘法: {} × {} = {}", a, b, result);
        return result;
    }
    
    /**
     * 除法運算
     * 
     * @param a 被除數
     * @param b 除數
     * @return 除法結果
     * @throws IllegalArgumentException 當除數為 0 時拋出
     */
    public double divide(int a, int b) {
        if (b == 0) {
            logger.error("除數不能為零");
            throw new IllegalArgumentException("除數不能為零");
        }
        
        double result = (double) a / b;
        logger.debug("執行除法: {} ÷ {} = {}", a, b, result);
        return result;
    }
    
    /**
     * 計算平方
     * 
     * @param number 要計算平方的數字
     * @return 平方結果
     */
    public int square(int number) {
        int result = number * number;
        logger.debug("計算平方: {}² = {}", number, result);
        return result;
    }
    
    /**
     * 計算平方根
     * 
     * @param number 要計算平方根的數字
     * @return 平方根結果
     * @throws IllegalArgumentException 當數字為負數時拋出
     */
    public double sqrt(double number) {
        if (number < 0) {
            logger.error("不能計算負數的平方根");
            throw new IllegalArgumentException("不能計算負數的平方根");
        }
        
        double result = Math.sqrt(number);
        logger.debug("計算平方根: √{} = {}", number, result);
        return result;
    }
}