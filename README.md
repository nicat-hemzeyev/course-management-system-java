# Course Management System JAVA

A simple **Java console-based application** for managing courses, students, and enrollments.  
This project demonstrates core backend development skills with **Java SE** and **PostgreSQL** integration.

---

## 🚀 Features
- [CRUD Operations](ca://s?q=CRUD_operations_explanation) for courses and students
- [Database Integration](ca://s?q=PostgreSQL_database_integration) with PostgreSQL
- [User-friendly Console UI](ca://s?q=Java_console_UI_design)
- Modular structure for scalability

---

## 🛠️ Languages & Tools
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white)

---
## 📂 Project Structure
```markdown
src/coursemanagement/
 ├── commond/
 │    ├── DbConnection.java   # Database bağlantısı
 │    └── User.java           # Ümumi user modeli
 │
 ├── course/
 │    ├── entity/             # Kurs entity-ləri
 │    └── service/            # Kurs servisləri
 │
 ├── dao/
 │    ├── CourseDAO.java      # Kurs məlumatları üçün DAO
 │    ├── StudentDAO.java     # Tələbə məlumatları üçün DAO
 │    └── TeacherDAO.java     # Müəllim məlumatları üçün DAO
 │
 ├── main/
 │    └── Main.java           # Proqramın giriş nöqtəsi
 │
 ├── menu/
 │    ├── MainMenu.java       # Əsas menyu
 │    ├── CourseMenu.java     # Kurs əməliyyatları menyusu
 │    ├── StudentMenu.java    # Tələbə əməliyyatları menyusu
 │    └── TeacherMenu.java    # Müəllim əməliyyatları menyusu
 │
 ├── student/
 │    ├── entity/             # Student entity-ləri
 │    └── service/            # Student servisləri
 │
 └── teacher/
      ├── entity/             # Teacher entity-ləri
      └── service/            # Teacher servisləri
 ```
