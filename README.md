IRCTC Web Automation – Selenium | Java | TestNG

This project automates the IRCTC train search process — selecting stations, choosing a date, searching for trains, and printing available trains on the console.
It uses Selenium WebDriver, Java, TestNG, and follows a Page Object Model structure.

Key Features

Automates train search flow on IRCTC

Page Object Model (POM) structure

Data-driven testing using Excel

TestNG DataProviders

Extent HTML reporting

Log4j2 logging

Screenshot capture on test failure

Config-driven browser and test settings

Project Folder Structure
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
│   │   ├── locators/
│   │   │   └── HomePageLocators.java
│   │   ├── pages/
│   │   │   └── HomePage.java
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
│       └── test/
│           └── TrainSearchTest.java
│
├── resources/
│   ├── TrainData.xlsx
│   ├── config.properties
│   ├── log4j2.xml
│   └── testng.xml
│
└── pom.xml

Automated Test Scenario

Search trains between two stations

Steps covered:

Launch IRCTC application

Enter "From" and "To" stations

Select journey date

Click Search

Extract and print available train list

Generate Extent Report

Capture screenshots for failure

Sample Console Output
Available Trains:
1. 12124 - Deccan Queen
2. 11007 - Deccan Express
3. 22221 - Rajdhani Express

How to Run
Prerequisites

JDK 8+

Maven

Chrome browser & ChromeDriver

IntelliJ / Eclipse

Run Using Maven
mvn clean test

Run Using TestNG

Right-click testng.xml → Run

Configuration (config.properties)
url=https://www.irctc.co.in/
browser=chrome
implicitWait=10
explicitWait=20

Test Data (TrainData.xlsx)

Example:

FromStation	ToStation	JourneyDate
PUNE	MUMBAI	22/01/2025
Reports & Logs

Extent Report: Results/ExtentReport.html

Logs: Results/logs/

Screenshots: Results/Snapshots/
