package com.sphereyeh.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sphereyeh.service.CalculatorService;
import com.sphereyeh.service.UserService;
import com.sphereyeh.model.User;

/**
 * 主應用程式類別
 * 
 * @author SphereYeh
 * @version 1.0.0
 */
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    /**
     * 主程式入口點
     * 
     * @param args 命令列參數
     */
    public static void main(String[] args) {
        logger.info("🚀 啟動 Java 應用程式...");
        
        try {
            // 建立服務實例
            CalculatorService calculator = new CalculatorService();
            UserService userService = new UserService();
            
            // 示範計算器功能
            demonstrateCalculator(calculator);
            
            // 示範使用者服務功能
            demonstrateUserService(userService);
            
            logger.info("✅ 應用程式執行完成！");
            
        } catch (Exception e) {
            logger.error("❌ 應用程式執行時發生錯誤: {}", e.getMessage(), e);
            System.exit(1);
        }
    }
    
    /**
     * 示範計算器功能
     */
    private static void demonstrateCalculator(CalculatorService calculator) {
        logger.info("📊 測試計算器功能:");
        
        int a = 10;
        int b = 5;
        
        logger.info("{} + {} = {}", a, b, calculator.add(a, b));
        logger.info("{} - {} = {}", a, b, calculator.subtract(a, b));
        logger.info("{} × {} = {}", a, b, calculator.multiply(a, b));
        logger.info("{} ÷ {} = {}", a, b, calculator.divide(a, b));
    }
    
    /**
     * 示範使用者服務功能
     */
    private static void demonstrateUserService(UserService userService) {
        logger.info("👤 測試使用者服務功能:");
        
        // 建立使用者
        User user1 = new User(1L, "張三", "zhang.san@example.com");
        User user2 = new User(2L, "李四", "li.si@example.com");
        
        // 添加使用者
        userService.addUser(user1);
        userService.addUser(user2);
        
        // 顯示所有使用者
        logger.info("所有使用者: {}", userService.getAllUsers());
        
        // 查找使用者
        User foundUser = userService.findUserById(1L);
        if (foundUser != null) {
            logger.info("找到使用者: {}", foundUser);
        }
        
        // 更新使用者
        User updatedUser = new User(1L, "張三豐", "zhang.sanfeng@example.com");
        userService.updateUser(updatedUser);
        logger.info("更新後的使用者: {}", userService.findUserById(1L));
        
        // 刪除使用者
        userService.deleteUser(2L);
        logger.info("刪除使用者後，剩餘使用者: {}", userService.getAllUsers());
    }
}