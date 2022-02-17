# Contacts

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 13.2.3 and [Spring Boot](https://github.com/spring-projects/spring-boot) version 2.6.3.

# Development Environment - Instructions to download a working copy

The following steps are recommended to download a working copy of the project.

**Front-end**

1. Download and install the latest stable version of Node.js from: https://nodejs.org
1. Install the Angular CLI using the following npm command: npm install -g @angular/cli
1. Clone the Contact repository
1. Open a terminal and navigate to the Angular project's folder, namely: "contacts" (inside the 'frontend' directory)
1. Install all the project dependencies running the following npm command: npm install
1. Run the following command to start the app in a browser window: ng serve -o

**Local Database**

Using MySQL Workbench:
1. (Optional for generating data) Go to File --> New Query Tab
    * Run the script: 'script.sql' located in src/main/resources/db/script.sql
1. Go to src/main/resources/application.propeties and set your connection credentials in 'spring.datasource.username' and 'spring.datasource.password'

**Back-end**

Using IntelliJ IDEA:
1. Download and install the latest version from: https://www.jetbrains.com/es-es/idea/download/
1. Clone the Contacts repository.
1. Go to File --> Open and navigate to the backend project's folder and import it.
1. Go to File --> Settings --> Build, Execution and Deployment --> Compiler
    *  Enable the Annotation Processing.
1. Go to File --> Settings --> Build, execution, Deployment --> Gradle
    * Set Build and run using: Intellij IDEA
1. Go to File --> Settings --> Plugin
    * Install Lombok
1. After the Build Success, run the application. This will run the app inside Spring Boot's embedded Tomcat server. By default the URL is: 'localhost:8080'.


