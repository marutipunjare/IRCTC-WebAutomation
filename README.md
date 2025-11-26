🚆 IRCTC Web Automation – Selenium | Java | TestNG | POM

This project automates the IRCTC train search workflow — entering journey stations, selecting travel date, searching trains, and printing the available train list on the console.
It is built using Java, Selenium WebDriver, TestNG, and follows a well-structured Page Object Model (POM) with utilities, reporting, logging, and data-driven testing.

📌 Key Features

Automated IRCTC train search functionality

Page Object Model (POM) architecture

Data-driven testing using Excel

TestNG framework with DataProviders

Extent Reports integration (HTML reporting)

Log4j2 logging

Screenshot capture on failure

Config-driven URL, browser, and test data

WebDriverWait & reusable Action utilities

🚀 Tech Stack
Category	Tools / Technologies
Language	Java
Automation	Selenium WebDriver
Test Framework	TestNG
Build Tool	Maven
Reporting	Extent Reports
Logging	Log4j2
Data Handling	Apache POI (Excel)
Architecture	Page Object Model (POM)
📂 Project Folder Structure
IRCTC_WEB_Automation/
│
├── Results/
│   ├── logs/
│   ├── ExtentReport.html
│   └── Snapshots/
│
├── TestData/
│   └── TestData.xlsx
│
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   └── BaseTest.java
│   │   │
│   │   ├── locators/
│   │   │   └── HomePageLocators.java
│   │   │
│   │   ├── pages/
│   │   │   └── HomePage.java
│   │   │
│   │   └── utils/
│   │       ├── ActionUtils.java
│   │       ├── ConfigReader.java
│   │       ├── ExcelUtils.java
│   │       ├── ExtentManager.java
│   │       └── ScreenshotUtils.java
│   │
│   └── test/java/
│       ├── dataprovider/
│       │   └── DataProviders.java
│       │
│       └── test/
│           └── TrainSearchTest.java
│
├── resources/
│   ├── TrainData.xlsx
│   ├── config.properties
│   ├── log4j2.xml
│   └── testng.xml
│
├── target/
│
├── test-output/
│
└── pom.xml

🧪 Automated Test Scenario
Test Case: Search Trains Between Two Stations

Steps automated:

Launch IRCTC Web Portal

Enter "From" station

Enter "To" station

Select journey date from calendar

Click on Search

Extract available train details

Print train list on console

Log results + generate ExtentReport

Capture screenshots for failures

📊 Sample Console Output
Available Trains on 21-Jan-2025
--------------------------------------
1. 12124 - Deccan Queen | 17:10 → 20:25
2. 11007 - Deccan Express | 07:00 → 10:15
3. 22221 - Rajdhani Express | 16:00 → 19:10
...

⚙️ Run the Project
1️⃣ Prerequisites

JDK 8+

Maven

Chrome & matching ChromeDriver

IntelliJ / Eclipse

2️⃣ Run via Maven
mvn clean test

3️⃣ Run via TestNG XML
Right click → testng.xml → Run

📁 Configuration File (config.properties)

Contains environment and browser settings:

url=https://www.irctc.co.in/
browser=chrome
implicitWait=10
explicitWait=20

📝 Excel Test Data (TrainData.xlsx)

Contains station & date data used by DataProviders:

FromStation	ToStation	JourneyDate
PUNE	MUMBAI	22/01/2025
📈 Reports & Logs
✔ Extent Report

Generated after every execution at:

Results/ExtentReport.html

✔ Logs

Stored under:

Results/logs/

✔ Screenshots

Captured under:

Results/Snapshots/

🔧 Utilities Included
Utility File	Purpose
ActionUtils.java	Reusable Selenium actions
ConfigReader.java	Read config properties
ExcelUtils.java	Read Excel test data
ExtentManager.java	Setup Extent Reports
ScreenshotUtils.java	Capture screenshots
