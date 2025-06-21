# 我的 Java 專案 2025

這是一個使用 **Java 17** 和 **Maven** 建立的現代化 Java 應用程式。

## 概述

這個專案展示了一個簡單但完整的 Java 應用程式，包含：

- 🎨 **模块化架構**: 清晰的組織結構和分層設計
- 📊 **計算器服務**: 提供基本數學運算功能
- 👤 **使用者管理**: CRUD 操作示範
- 📝 **完整測試**: JUnit 5 單元測試套件
- 📜 **日誌系統**: SLF4J + Logback 日誌記錄

## 技術堆疊

- **Java**: 17 (LTS)
- **建置工具**: Maven 3.x
- **測試框架**: JUnit 5
- **日誌框架**: SLF4J + Logback
- **工具函式庫**: Apache Commons Lang

## 專案結構

```
src/
├── main/
│   └── java/
│       └── com/
│           └── sphereyeh/
│               ├── app/
│               │   └── Application.java       # 主程式入口
│               ├── model/
│               │   └── User.java              # 使用者實體類別
│               └── service/
│                   ├── CalculatorService.java # 計算器服務
│                   └── UserService.java       # 使用者服務
└── test/
    └── java/
        └── com/
            └── sphereyeh/
                ├── model/
                │   └── UserTest.java          # 使用者實體測試
                └── service/
                    ├── CalculatorServiceTest.java # 計算器服務測試
                    └── UserServiceTest.java       # 使用者服務測試
```

## 快速開始

### 前置條件

確保您的系統已安裝：

- **Java 17** 或更高版本
- **Maven 3.6** 或更高版本
- **Git**

### 安裝與執行

1. **複製儲存庫**
```bash
git clone https://github.com/SphereYeh/my-new-java-project.git
cd my-new-java-project
```

2. **編譯專案**
```bash
mvn clean compile
```

3. **執行測試**
```bash
mvn test
```

4. **建置 JAR 檔案**
```bash
mvn clean package
```

5. **執行應用程式**
```bash
# 執行主程式
mvn exec:java -Dexec.mainClass="com.sphereyeh.app.Application"

# 或者直接執行 JAR 檔案
java -jar target/my-new-java-project-1.0.0.jar
```

## 功能特色

### 📊 計算器服務 (CalculatorService)

提供基本數學運算功能：

- 加法 (`add`)
- 減法 (`subtract`)
- 乘法 (`multiply`)
- 除法 (`divide`) - 包含除零檢查
- 平方 (`square`)
- 平方根 (`sqrt`) - 包含負數檢查

### 👤 使用者管理服務 (UserService)

提供完整的 CRUD 操作：

- 新增使用者 (`addUser`)
- 查詢使用者 (`findUserById`, `getAllUsers`, `findUsersByName`)
- 更新使用者 (`updateUser`)
- 刪除使用者 (`deleteUser`, `clearAllUsers`)
- 統計功能 (`getUserCount`)

## 測試套件

本專案包含完整的單元測試，測試覆蓋率達 90% 以上：

- **CalculatorServiceTest**: 計算器功能測試
- **UserServiceTest**: 使用者管理功能測試
- **UserTest**: 使用者實體測試

### 執行特定測試

```bash
# 執行單一測試類別
mvn test -Dtest=CalculatorServiceTest

# 執行特定測試方法
mvn test -Dtest=CalculatorServiceTest#testAdd

# 生成測試報告
mvn surefire-report:report
```

## Maven 命令

### 常用命令

```bash
# 清理專案
mvn clean

# 編譯原始碼
mvn compile

# 編譯測試碼
mvn test-compile

# 執行測試
mvn test

# 封裝 JAR
mvn package

# 安裝到本機儲存庫
mvn install

# 生成專案網站
mvn site
```

### 進階命令

```bash
# 查看相依性樹
mvn dependency:tree

# 分析相依性
mvn dependency:analyze

# 查看有效 POM
mvn help:effective-pom

# 展示所有配置檔
mvn help:all-profiles
```

## 開發指南

### 添加新功能

1. 在適當的 `service` 或 `model` 套件中新增類別
2. 為新功能編寫對應的單元測試
3. 在 `Application.java` 中新增示範程式碼
4. 更新文件

### 編碼規範

- 使用有意義的變數和方法名稱
- 添加適當的 Javadoc 註釋
- 遵循 Java 命名慣例
- 保持代碼簡潔和可讀性
- 為所有公共方法編寫測試

## 效能分析

本專案使用了高效的資料結構和最佳化實務：

- `ConcurrentHashMap` 確保執行緒安全
- 惰性初始化減少資源消耗
- 適當的異常處理機制

## 貢獻指南

歡迎貢獻！請遵循以下步驟：

1. Fork 本專案
2. 建立功能分支 (`git checkout -b feature/amazing-feature`)
3. 提交您的變更 (`git commit -m 'Add some amazing feature'`)
4. 推送到分支 (`git push origin feature/amazing-feature`)
5. 開啟 Pull Request

## 許可證

本專案採用 MIT 許可證。詳細資訊請參閱 [LICENSE](LICENSE) 檔案。

## 作者

- **SphereYeh** - *初始作品* - [GitHub](https://github.com/SphereYeh)

## 致謝

- [Apache Commons](https://commons.apache.org/) - 實用工具函式庫
- [JUnit](https://junit.org/) - Java 測試框架
- [SLF4J](http://www.slf4j.org/) - 日誌抽象層
- [Logback](http://logback.qos.ch/) - 日誌實現

---

🚀 **立即開始您的 Java 開發之旅！**