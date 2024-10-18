![workflow](https://github.com/linphone-40685558/group3-coursework/actions/workflows/main.yml/badge.svg)
![Master Branch](https://img.shields.io/github/actions/workflow/status/linphone-40685558/group3-coursework/main.yml?branch=master&label=Master%20Build)
![Develop Branch](https://img.shields.io/github/actions/workflow/status/linphone-40685558/group3-coursework/main.yml?branch=develop&label=Develop%20Build)
[![LICENSE](https://img.shields.io/github/license/linphone-40685558/group3-coursework.svg?style=flat-square)](https://github.com/linphone-40685558/group3-coursework/blob/master/LICENSE)
[![Releases](https://img.shields.io/github/release/linphone-40685558/group3-coursework/all.svg?style=flat-square)](https://github.com/linphone-40685558/group3-coursework/releases)
[![codecov](https://codecov.io/gh/linphone-40685558/group3-coursework/branch/develop/graph/badge.svg?token=93OR750VW8)](https://codecov.io/gh/linphone-40685558/group3-coursework)

# **🚀 Population Information Reporting System**

## **📖 Project Overview**

This project focuses on developing a **Population Information Reporting System** that provides various reports based on
population data from an SQL database. The system will allow the organization to generate reports on population data at
different levels, including by country, continent, and region.

Key features include:

- **Population Reports**: Generate reports from an SQL database on various population statistics.
- **Top N Reports**: Retrieve the top N populated countries or cities globally, by continent, or by region, as defined
  by the user.
- **Continuous Integration**: Set up CI pipelines for testing and building with Maven and Docker.

---

## **🔍 Features and Queries**

This system supports the following 32 queries, offering detailed insights into population data at various levels:

### **Country Reports**

1. **All countries in the world** organized by largest population to smallest.
2. **All countries in a continent** organized by largest population to smallest.
3. **All countries in a region** organized by largest population to smallest.
4. **Top N populated countries in the world**, where N is provided by the user.
5. **Top N populated countries in a continent**, where N is provided by the user.
6. **Top N populated countries in a region**, where N is provided by the user.

### **City Reports**

7. **All cities in the world** organized by largest population to smallest.
8. **All cities in a continent** organized by largest population to smallest.
9. **All cities in a region** organized by largest population to smallest.
10. **All cities in a country** organized by largest population to smallest.
11. **All cities in a district** organized by largest population to smallest.
12. **Top N populated cities in the world**, where N is provided by the user.
13. **Top N populated cities in a continent**, where N is provided by the user.
14. **Top N populated cities in a region**, where N is provided by the user.
15. **Top N populated cities in a country**, where N is provided by the user.
16. **Top N populated cities in a district**, where N is provided by the user.

### **Capital City Reports**

17. **All capital cities in the world** organized by largest population to smallest.
18. **All capital cities in a continent** organized by largest population to smallest.
19. **All capital cities in a region** organized by largest population to smallest.
20. **Top N populated capital cities in the world**, where N is provided by the user.
21. **Top N populated capital cities in a continent**, where N is provided by the user.
22. **Top N populated capital cities in a region**, where N is provided by the user.

### **Population Distribution**

23. **Population of people** living in cities vs. not living in cities, by continent.
24. **Population of people** living in cities vs. not living in cities, by region.
25. **Population of people** living in cities vs. not living in cities, by country.

### **General Population Reports**

26. The **population of the world**.
27. The **population of a continent**.
28. The **population of a region**.
29. The **population of a country**.
30. The **population of a district**.
31. The **population of a city**.

### **Language Reports**

32. **Number of people who speak** the following languages, ranked from greatest to smallest, including percentage of
    the world population:

- Chinese
- English
- Hindi
- Spanish
- Arabic

---

## **⚙️ Project Setup**

### **Prerequisites**

- **Java** (JDK 17+)
- **Maven**
- **Docker**
- **Some Text**

---