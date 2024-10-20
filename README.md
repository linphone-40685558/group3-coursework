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

## **⚙️ Project Setup**

### **Prerequisites**

- **Java** (JDK 17+)
- **Maven**
- **Docker**
- **Some Text**

---

## **🔍 Features and Queries**

This system supports the following 32 queries, offering detailed insights into population data at various levels.
32 requirements of 32 have been implemented, which is 100%.
Each evidence is shown as below:

### **Country Reports**

| ID | Name                                                                       | Met | Screenshot                  |
|----|----------------------------------------------------------------------------|-----|-----------------------------|
| 1  | All countries in the world organized by largest population to smallest.    | Yes | ![Image](./evidences/1.png) |
| 2  | All countries in a continent organized by largest population to smallest.  | Yes | ![Image](./evidences/2.png) |
| 3  | All countries in a region organized by largest population to smallest.     | Yes | ![Image](./evidences/3.png) |
| 4  | Top N populated countries in the world, where N is provided by the user.   | Yes | ![Image](./evidences/4.png) |
| 5  | Top N populated countries in a continent, where N is provided by the user. | Yes | ![Image](./evidences/5.png) |
| 6  | Top N populated countries in a region, where N is provided by the user.    | Yes | ![Image](./evidences/6.png) |

### **City Reports**

| ID | Name                                                                    | Met | Screenshot                   |
|----|-------------------------------------------------------------------------|-----|------------------------------|
| 7  | All cities in the world organized by largest population to smallest.    | Yes | ![Image](./evidences/7.png)  |
| 8  | All cities in a continent organized by largest population to smallest.  | Yes | ![Image](./evidences/8.png)  |
| 9  | All cities in a region organized by largest population to smallest.     | Yes | ![Image](./evidences/9.png)  |
| 10 | All cities in a country organized by largest population to smallest.    | Yes | ![Image](./evidences/10.png) |
| 11 | All cities in a district organized by largest population to smallest.   | Yes | ![Image](./evidences/11.png) |
| 12 | Top N populated cities in the world, where N is provided by the user.   | Yes | ![Image](./evidences/12.png) |
| 13 | Top N populated cities in a continent, where N is provided by the user. | Yes | ![Image](./evidences/13.png) |
| 14 | Top N populated cities in a region, where N is provided by the user.    | Yes | ![Image](./evidences/14.png) |
| 15 | Top N populated cities in a country, where N is provided by the user.   | Yes | ![Image](./evidences/15.png) |
| 16 | Top N populated cities in a district, where N is provided by the user.  | Yes | ![Image](./evidences/16.png) |

### **Capital City Reports**

| ID | Name                                                                            | Met | Screenshot                   |
|----|---------------------------------------------------------------------------------|-----|------------------------------|
| 17 | All capital cities in the world organized by largest population to smallest.    | Yes | ![Image](./evidences/17.png) |
| 18 | All capital cities in a continent organized by largest population to smallest.  | Yes | ![Image](./evidences/18.png) |
| 19 | All capital cities in a region organized by largest population to smallest.     | Yes | ![Image](./evidences/19.png) |
| 20 | Top N populated capital cities in the world, where N is provided by the user.   | Yes | ![Image](./evidences/20.png) |
| 21 | Top N populated capital cities in a continent, where N is provided by the user. | Yes | ![Image](./evidences/21.png) |
| 22 | Top N populated capital cities in a region, where N is provided by the user.    | Yes | ![Image](./evidences/22.png) |

### **Population Distribution**

| ID | Name                                                                          | Met | Screenshot                   |
|----|-------------------------------------------------------------------------------|-----|------------------------------|
| 23 | Population of people living in cities vs. not living in cities, by continent. | Yes | ![Image](./evidences/23.png) |
| 24 | Population of people living in cities vs. not living in cities, by region.    | Yes | ![Image](./evidences/24.png) |
| 25 | Population of people living in cities vs. not living in cities, by country.   | Yes | ![Image](./evidences/25.png) |

### **General Population Reports**

| ID | Name                           | Met | Screenshot                   |
|----|--------------------------------|-----|------------------------------|
| 26 | The population of the world.   | Yes | ![Image](./evidences/26.png) |
| 27 | The population of a continent. | Yes | ![Image](./evidences/27.png) |
| 28 | The population of a region.    | Yes | ![Image](./evidences/28.png) |
| 29 | The population of a country.   | Yes | ![Image](./evidences/29.png) |
| 30 | The population of a district.  | Yes | ![Image](./evidences/30.png) |
| 31 | The population of a city.      | Yes | ![Image](./evidences/31.png) |

### **Language Reports**

| ID | Name                                                                                                                                                                          | Met | Screenshot                   |
|----|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----|------------------------------|
| 32 | Number of people who speak the following languages, ranked from greatest to smallest, including percentage of the world population: Chinese, English, Hindi, Spanish, Arabic. | Yes | ![Image](./evidences/32.png) |

---