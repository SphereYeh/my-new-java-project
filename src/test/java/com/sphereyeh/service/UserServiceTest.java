package com.sphereyeh.service;

import com.sphereyeh.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UserService 的單元測試
 * 
 * @author SphereYeh
 * @version 1.0.0
 */
@DisplayName("使用者服務測試")
class UserServiceTest {
    
    private UserService userService;
    private User testUser1;
    private User testUser2;
    
    @BeforeEach
    void setUp() {
        userService = new UserService();
        testUser1 = new User(1L, "張三", "zhang.san@example.com");
        testUser2 = new User(2L, "李四", "li.si@example.com");
    }
    
    @Test
    @DisplayName("測試新增使用者")
    void testAddUser() {
        // When
        userService.addUser(testUser1);
        
        // Then
        assertEquals(1, userService.getUserCount());
        assertEquals(testUser1, userService.findUserById(1L));
    }
    
    @Test
    @DisplayName("測試新增重複 ID 的使用者")
    void testAddDuplicateUser() {
        // Given
        userService.addUser(testUser1);
        
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            userService.addUser(new User(1L, "王五", "wang.wu@example.com"));
        });
    }
    
    @Test
    @DisplayName("測試新增 null 使用者")
    void testAddNullUser() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.addUser(null);
        });
    }
    
    @Test
    @DisplayName("測試新增 ID 為 null 的使用者")
    void testAddUserWithNullId() {
        User userWithNullId = new User(null, "王五", "wang.wu@example.com");
        
        assertThrows(IllegalArgumentException.class, () -> {
            userService.addUser(userWithNullId);
        });
    }
    
    @Test
    @DisplayName("測試查找使用者")
    void testFindUserById() {
        // Given
        userService.addUser(testUser1);
        userService.addUser(testUser2);
        
        // When & Then
        assertEquals(testUser1, userService.findUserById(1L));
        assertEquals(testUser2, userService.findUserById(2L));
        assertNull(userService.findUserById(999L));
    }
    
    @Test
    @DisplayName("測試查找不存在的使用者")
    void testFindNonExistentUser() {
        assertNull(userService.findUserById(999L));
        assertNull(userService.findUserById(null));
    }
    
    @Test
    @DisplayName("測試獲取所有使用者")
    void testGetAllUsers() {
        // Given
        userService.addUser(testUser1);
        userService.addUser(testUser2);
        
        // When
        List<User> allUsers = userService.getAllUsers();
        
        // Then
        assertEquals(2, allUsers.size());
        assertTrue(allUsers.contains(testUser1));
        assertTrue(allUsers.contains(testUser2));
    }
    
    @Test
    @DisplayName("測試更新使用者")
    void testUpdateUser() {
        // Given
        userService.addUser(testUser1);
        User updatedUser = new User(1L, "張三豐", "zhang.sanfeng@example.com");
        
        // When
        userService.updateUser(updatedUser);
        
        // Then
        assertEquals(updatedUser, userService.findUserById(1L));
        assertEquals("張三豐", userService.findUserById(1L).getName());
    }
    
    @Test
    @DisplayName("測試更新不存在的使用者")
    void testUpdateNonExistentUser() {
        User nonExistentUser = new User(999L, "不存在的使用者", "nonexistent@example.com");
        
        assertThrows(IllegalArgumentException.class, () -> {
            userService.updateUser(nonExistentUser);
        });
    }
    
    @Test
    @DisplayName("測試刪除使用者")
    void testDeleteUser() {
        // Given
        userService.addUser(testUser1);
        userService.addUser(testUser2);
        
        // When
        boolean deleted = userService.deleteUser(1L);
        
        // Then
        assertTrue(deleted);
        assertEquals(1, userService.getUserCount());
        assertNull(userService.findUserById(1L));
        assertNotNull(userService.findUserById(2L));
    }
    
    @Test
    @DisplayName("測試刪除不存在的使用者")
    void testDeleteNonExistentUser() {
        assertFalse(userService.deleteUser(999L));
        assertFalse(userService.deleteUser(null));
    }
    
    @Test
    @DisplayName("測試根據姓名搜尋使用者")
    void testFindUsersByName() {
        // Given
        userService.addUser(testUser1); // 張三
        userService.addUser(testUser2); // 李四
        userService.addUser(new User(3L, "張三豐", "zhang.sanfeng@example.com"));
        
        // When
        List<User> zhangUsers = userService.findUsersByName("張");
        List<User> liUsers = userService.findUsersByName("李");
        List<User> noMatch = userService.findUsersByName("王");
        
        // Then
        assertEquals(2, zhangUsers.size());
        assertEquals(1, liUsers.size());
        assertEquals(0, noMatch.size());
    }
    
    @Test
    @DisplayName("測試獲取使用者總數")
    void testGetUserCount() {
        assertEquals(0, userService.getUserCount());
        
        userService.addUser(testUser1);
        assertEquals(1, userService.getUserCount());
        
        userService.addUser(testUser2);
        assertEquals(2, userService.getUserCount());
        
        userService.deleteUser(1L);
        assertEquals(1, userService.getUserCount());
    }
    
    @Test
    @DisplayName("測試清空所有使用者")
    void testClearAllUsers() {
        // Given
        userService.addUser(testUser1);
        userService.addUser(testUser2);
        assertEquals(2, userService.getUserCount());
        
        // When
        userService.clearAllUsers();
        
        // Then
        assertEquals(0, userService.getUserCount());
        assertTrue(userService.getAllUsers().isEmpty());
    }
}