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
- [Docker](https://www.docker.com/) + Docker Compose (for PostgreSQL + PostGIS database)

---
## ⚙️ Environment Setup

Before running the backend services, create a `.env` file in the project root with:

```bash
POSTGRES_PASSWORD=your_password_here
POSTGRES_PORT=5432


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
## 🐳 Database Setup with Docker

We use **Docker Compose** to run PostgreSQL with PostGIS enabled.
Hibernate will automatically create tables based on the @Entity models

### 1. Start the database container
from the `poc/backend/infra/docker` directory:

```bash
docker compose up -d
```

### 2. Connect to the Database via terminal

To connect to the `hikerzuser` database:

```bash
docker exec -it hikerz-db psql -U postgres -d hikerzuser
```

To connect to the `hikerzactivity` database:

```bash
docker exec -it hikerz-db psql -U postgres -d hikerzactivity
```

After connecting you can run:

```pgsql
\l               -- list all databases  
\c dbname        -- connect to a database  
\dt              -- list all tables  
\d table_name    -- describe a table  
\du              -- list all users/roles  
\q               -- quit psql  
```

### 3. Or use any PostgreSQL client with the following credentials (like pgAdmin)

```bash
Host: localhost  
Port: 5432  
User: postgres  
Password: postgres  
Database: hikerzuser or hikerzactivity
```

### 4. Stop the database container

```bash
docker compose down -v
```

This will remove all data in the tables. To persist data, you can remove the `-v` flag.