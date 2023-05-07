# Gestion_absence_V3
## Gestion d'etudiant et d'absence  (spring-boot/angular)


This project is a web application designed to help teachers manage the absences of their students. With this application, teachers can easily add student absences,
view their absences, and validate justifications for those absences. Students can also view their own absences and add justifications for any missed classes.
This project uses Angular for the front-end, MySQL for the database, and Spring Boot for the back-end.

### Installation:

  1- Clone the project repository.
  2- Make sure you have Node.js and Angular CLI installed on your system.
  3- Create a MySQL database and import the database.sql file included in the project.
  4- Update the database credentials in the application.properties file located in the backend/src/main/resources directory.
  5- Navigate to the frontend directory and run the command "npm install" to install the necessary dependencies.
  6- Start the back-end server by navigating to the backend directory and running the command "mvn spring-boot:run".
  7- Start the front-end server by navigating to the frontend directory and running the command "ng serve --open".

## Usage:
  1- Once the project is installed and the servers are running, teachers can access the application by visiting the URL of the project in their web browser.
  2- Teachers must log in using their username and password.
  3- After logging in, teachers can add student absences by selecting the appropriate course, date, and student from the dropdown menus.
  4- Teachers can view all student absences by selecting the "View Absences" option from the menu.
  5- Teachers can validate justifications for absences by selecting the "Validate Justifications" option from the menu and selecting the appropriate absence and      justification.
  6- Students can access the application by visiting the same URL in their web browser and logging in using their own username and password.
  7- After logging in, students can view their own absences and add justifications for any missed classes.

## Note:
This project is intended as a demonstration of Angular, MySQL, and Spring Boot integration and is not intended for production use.
