# murraywhiteins_spring
Murray White Insurance website using Spring Boot

## Prerequisites
* Git (latest version)
* Java 8 SDK or higher
* Gradle
* MySQL

## Optional Pre
* Spring Tool Suite (STS)
* Heroku CLI
* postgresql (for testing production settings)

## General information
There are two profiles available; local and production. The application runs with the local profile by default, so the -Plocal profile does not need to be specifed when running a build. To run with the production profile, -Pproduction must be specified in the gradle build command.

The local profile uses a MySQL database and developer tools
The local profile runs on port 8000. This can be configured in src\main\resources\application-local.properties
The production profile uses a postgresql database (this is already configured in heroku, where the application is hosted)

## Developing
This section provides directions for developing on the Murray White Insurance website with or without an IDE

### Obtaining the code
* Clone the repository
```
git clone https://github.com/JonPecoraro/murraywhiteins_spring.git
cd murraywhiteins_spring
```

### General workflow
* Checkout the devlop branch
```
git checkout develop
```
* make code changes
* stage the changes
```
git add .
```
* Commit the changes
```
git commit -m "commmit message"
```
* Push changes to remote develop branch
```
git push origin develop
```
* Create a pull request on the github website
* Merge the code into master
  * Upon a successful merge, the code will be automatically built and deployed to heroku

### Building from the command line
* To just build, use:
```
gradlew build
```
* To just build and run, use the following command then navigate to http://localhost:8000 in a web browser:
```
gradlew bootRun
```
* To test the production setting, use the following command then navigate to http://localhost:8000 in a web browser:
```
gradlew -Pproduction bootRun
```
  * You need to have postresql setup and an environment variable with the database URL named JDBC_DATABASE_URL

### Using Spring Tool Suite (STS)
* Open STS
* Select **File -> Import**
* Select **Gradle (STS) Project**
* Browse to the repository and select the murraywhiteins_spring folder
* Click **Build Model**
* Click **Finish**

#### Building in STS
* Right-click murraywhiteins_spring in the Package Explorer and select **Run As -> Spring Boot App**
* Navigate to http://localhost:8000 in a web browser

## Notes and Tips
* Creating a profile specific runtime configuration in STS
  * Right-click the murraywhiteins_spring project in the Package Explorer and select "Run As -> Gradle (STS) Build ..."
  * In the Gradle Tasks tab, enter bootRun
  * In the Arguments tab, enter -Plocal in the Program Args section (you must select the "use" radiobutton)
  * Click Apply, then Run
* Run a postgresql script from the heroku CLI:
```
heroku pg:psql < file.sql
```
* Run a single postgresql command from the heroku CLI:
```
echo select * from table; | heroku pg:psql
```
* All configuration settins are located in the application.properties files:
  * src\main\resources\application.properties
  * src\main\resources\application-local.properties
  * src\main\resources\application-production.properties

  Note that the active profiles setting in application.properties determines if local or production properties are used. The local properties are used by default if no profile is specified

  * Views are located in src\main\resources\templates
    * Views are organized by discipline, for example, companies, quotes, team, etc...
  * CSS, JS, images, and other static files are located in src\main\resources\static
  * Models and controllers are both located in src\main\java\site
* Anytime there is a push to the master branch, heroku automatically builds and deploys the application