# Contacts

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 9.1.12 and [Spring Boot](https://github.com/spring-projects/spring-boot) version 2.6.3.

# Development Environment - Instructions to download a working copy

The following steps are needed to download a working copy of the project.

**Database**

build and ru using intellij
build execution gradle INTELLIJ
create db schema named: crypto_history
set application properties# contacts

**Back-end**

For using IntelliJ IDE:
1. Download and install the latest version from: https://www.jetbrains.com/es-es/idea/download/
1. Clone the Crypto Tracker repository.
1. Go to File --> Open and navigate to the backend project's folder and import it.
1. Go to File --> Settings --> Build, Execution and Deployment --> Compiler
    *  Enable the Annotation Processing.
1. Go to Run ---> Edit Configurations... --> Add new Configuration:
    * Write a name for the profile.
    * In Build and run: Set your Java SDK, the main module and choose com.demo.cryptotracker.CryptoTrackerApplication as main class.
    * Click on Apply and Ok.
1. Go to File --> Settings --> Plugin
    * Install Lombok
1. Go to File --> Settings --> Tools --> Checkstyle
    * Chage the Checkstyle version to 8.16
    * Add we custom Checkstyle File located on: papers-with-code\backend\papers-with-code\src\main\resources\checkstyle
    * Put it as active file (and unique).
1. After the Build Success, run the application. This will run the app inside Spring Boot's embedded Tomcat server. By default the URL is: 'localhost:8080'.


