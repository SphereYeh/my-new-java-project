package com.sphereyeh.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * User 實體類別的單元測試
 * 
 * @author SphereYeh
 * @version 1.0.0
 */
@DisplayName("使用者實體測試")
class UserTest {
    
    @Test
    @DisplayName("測試使用預設建構子建立使用者")
    void testDefaultConstructor() {
        User user = new User();
        
        assertNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getEmail());
    }
    
    @Test
    @DisplayName("測試使用參數建構子建立使用者")
    void testParameterizedConstructor() {
        Long id = 1L;
        String name = "張三";
        String email = "zhang.san@example.com";
        
        User user = new User(id, name, email);
        
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
    }
    
    @Test
    @DisplayName("測試 Getter 和 Setter 方法")
    void testGettersAndSetters() {
        User user = new User();
        
        Long id = 2L;
        String name = "李四";
        String email = "li.si@example.com";
        
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
    }
    
    @Test
    @DisplayName("測試 equals 方法")
    void testEquals() {
        User user1 = new User(1L, "張三", "zhang.san@example.com");
        User user2 = new User(1L, "張三", "zhang.san@example.com");
        User user3 = new User(2L, "李四", "li.si@example.com");
        
        assertEquals(user1, user2);
        assertNotEquals(user1, user3);
        assertNotEquals(user1, null);
        assertEquals(user1, user1); // reflexive
    }
    
    @Test
    @DisplayName("測試 hashCode 方法")
    void testHashCode() {
        User user1 = new User(1L, "張三", "zhang.san@example.com");
        User user2 = new User(1L, "張三", "zhang.san@example.com");
        
        assertEquals(user1.hashCode(), user2.hashCode());
    }
    
    @Test
    @DisplayName("測試 toString 方法")
    void testToString() {
        User user = new User(1L, "張三", "zhang.san@example.com");
        String toString = user.toString();
        
        assertTrue(toString.contains("User{"));
        assertTrue(toString.contains("id=1"));
        assertTrue(toString.contains("name='張三'"));
        assertTrue(toString.contains("email='zhang.san@example.com'"));
    }
    
    @Test
    @DisplayName("測試處理 null 值")
    void testHandleNullValues() {
        User user1 = new User(null, null, null);
        User user2 = new User(null, null, null);
        
        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
        
        String toString = user1.toString();
        assertTrue(toString.contains("id=null"));
        assertTrue(toString.contains("name=null"));
        assertTrue(toString.contains("email=null"));
    }
}