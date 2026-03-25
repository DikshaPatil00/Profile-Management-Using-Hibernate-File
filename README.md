# Profile-Management-Using-Hibernate-File
A specialized Java application designed to handle user profile creation, focusing on Binary Data Management and Hibernate ORM. This project demonstrates the ability to process image files and store profile metadata efficiently.

# Features
* File I/O Operations: Implements java.nio.file to read, validate, and write image bytes to a local server directory.
* Data Validation: Includes logic for file size constraints (max 5MB) and MIME type validation (ensuring only images are uploaded).
* Hibernate Persistence: Maps profile entities to the database while managing the physical storage of associated image assets.
* Directory Management: Automated creation of upload directories using Files.createDirectories.

# Tech Used
* Language: Java 17
* ORM: Hibernate Core
* Database: MySQL
