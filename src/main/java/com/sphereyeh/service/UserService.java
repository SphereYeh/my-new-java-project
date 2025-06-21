package com.sphereyeh.service;

import com.sphereyeh.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用者服務類別
 * 提供使用者管理功能 (CRUD 操作)
 * 
 * @author SphereYeh
 * @version 1.0.0
 */
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    
    // 使用 ConcurrentHashMap 確保執行緒安全
    private final Map<Long, User> users = new ConcurrentHashMap<>();
    
    /**
     * 新增使用者
     * 
     * @param user 要新增的使用者
     * @throws IllegalArgumentException 當使用者為 null 或 ID 已存在時拋出
     */
    public void addUser(User user) {
        if (user == null) {
            logger.error("使用者不能為 null");
            throw new IllegalArgumentException("使用者不能為 null");
        }
        
        if (user.getId() == null) {
            logger.error("使用者 ID 不能為 null");
            throw new IllegalArgumentException("使用者 ID 不能為 null");
        }
        
        if (users.containsKey(user.getId())) {
            logger.error("使用者 ID {} 已存在", user.getId());
            throw new IllegalArgumentException("使用者 ID " + user.getId() + " 已存在");
        }
        
        users.put(user.getId(), user);
        logger.info("成功新增使用者: {}", user);
    }
    
    /**
     * 根據 ID 查找使用者
     * 
     * @param id 使用者 ID
     * @return 找到的使用者，如果不存在則返回 null
     */
    public User findUserById(Long id) {
        if (id == null) {
            logger.warn("使用者 ID 不能為 null");
            return null;
        }
        
        User user = users.get(id);
        if (user != null) {
            logger.debug("找到使用者: {}", user);
        } else {
            logger.debug("未找到 ID 為 {} 的使用者", id);
        }
        
        return user;
    }
    
    /**
     * 獲取所有使用者
     * 
     * @return 所有使用者的列表
     */
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>(users.values());
        logger.debug("獲取所有使用者，共 {} 個", userList.size());
        return userList;
    }
    
    /**
     * 更新使用者資訊
     * 
     * @param user 要更新的使用者
     * @throws IllegalArgumentException 當使用者不存在時拋出
     */
    public void updateUser(User user) {
        if (user == null || user.getId() == null) {
            logger.error("使用者或使用者 ID 不能為 null");
            throw new IllegalArgumentException("使用者或使用者 ID 不能為 null");
        }
        
        if (!users.containsKey(user.getId())) {
            logger.error("使用者 ID {} 不存在", user.getId());
            throw new IllegalArgumentException("使用者 ID " + user.getId() + " 不存在");
        }
        
        users.put(user.getId(), user);
        logger.info("成功更新使用者: {}", user);
    }
    
    /**
     * 刪除使用者
     * 
     * @param id 要刪除的使用者 ID
     * @return 是否成功刪除
     */
    public boolean deleteUser(Long id) {
        if (id == null) {
            logger.warn("使用者 ID 不能為 null");
            return false;
        }
        
        User removedUser = users.remove(id);
        if (removedUser != null) {
            logger.info("成功刪除使用者: {}", removedUser);
            return true;
        } else {
            logger.warn("未找到 ID 為 {} 的使用者，無法刪除", id);
            return false;
        }
    }
    
    /**
     * 根據姓名搜尋使用者
     * 
     * @param name 使用者姓名
     * @return 匹配的使用者列表
     */
    public List<User> findUsersByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            logger.warn("姓名不能為空");
            return new ArrayList<>();
        }
        
        List<User> matchingUsers = users.values().stream()
                .filter(user -> user.getName() != null && user.getName().contains(name))
                .toList();
        
        logger.debug("找到 {} 個姓名包含 '{}' 的使用者", matchingUsers.size(), name);
        return matchingUsers;
    }
    
    /**
     * 獲取使用者總數
     * 
     * @return 使用者總數
     */
    public int getUserCount() {
        int count = users.size();
        logger.debug("目前使用者總數: {}", count);
        return count;
    }
    
    /**
     * 清空所有使用者
     */
    public void clearAllUsers() {
        int count = users.size();
        users.clear();
        logger.info("已清空所有使用者，共清除 {} 個使用者", count);
    }
}