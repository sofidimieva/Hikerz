# Hikerz Backend – How to Run

This project consists of two Spring Boot microservices:

- **Activity Microservice** – manages hiking activities  
- **User Microservice** – manages user-related data  

You can run the services either in **VS Code** or **IntelliJ IDEA**.

---

## 🔧 Prerequisites
- Java **21** (or the required JDK version)  
- [Maven](https://maven.apache.org/) (if running outside the IDE)  
- [Git](https://git-scm.com/) (to clone the repository)  

---

## ▶️ Running in VS Code
1. Install **Java 21** (or the version required).  
2. Install the following extensions:  
   - [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)  
   - [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack)  
3. Run the microservices:
   - **Activity Microservice**:  
     Open  
     ```
     /poc/backend/hikerzactivity/src/main/java/com/hikerzactivity/hikeractivity/HikersActivityApplication.java
     ```  
     and click **Run** on the `main` function.  
   - **User Microservice**:  
     Open  
     ```
     /poc/backend/hikerzuser/src/main/java/com/hikerzuser/hikerzuser/HikerzUserApplication.java
     ```  
     and click **Run** on the `main` function.  

---

## ▶️ Running in IntelliJ IDEA
1. Install **Java 21** (or the version required).  
2. Open the project and link the Maven modules:  
   - Right-click `poc/backend/hikerzactivity/pom.xml` → **Add as Maven Project**  
   - Right-click `poc/backend/hikerzuser/pom.xml` → **Add as Maven Project**  
3. When prompted, install the **Lombok plugin**.  
4. Run the microservices:
   - **Activity Microservice**:  
     Open  
     ```
     /poc/backend/hikerzactivity/src/main/java/com/hikerzactivity/hikeractivity/HikersActivityApplication.java
     ```  
     and click **Run** on the `main` function.  
   - **User Microservice**:  
     Open  
     ```
     /poc/backend/hikerzuser/src/main/java/com/hikerzuser/hikerzuser/HikerzUserApplication.java
     ```  
     and click **Run** on the `main` function.  

---