# Galaxy

This application is a case test.

The app predicts the weather on a fictional solar system. This system is composed of three planets with a circular orbit around the sun (in a 2D dimension).

Depending on the position of the planets, the weather will change in the entire solar system.

To calculate the position of the planets, we used the “java.awt” library and the shoelace formula.


###### STACK
- Java11
- Maven 3.6.1
- SpringBoot 2.4.4
- Swagger (Documentation)


###### Run App

To run the app, you need to build the project with maven and use command java, or you can use your IDE to do it.

- Maven Example
  > go to your app directory and type:
  > mvn clean package
  > 
  > got to target directory and type:
  > java -jar galaxy-0.0.1-SNAPSHOT.jar


###### Swagger Documentation 

https://localhost:8080/swagger-ui.html


###### Heroku

The application can be seen on heroku on link:

https://caseml-galaxy2-weather.herokuapp.com/swagger-ui.html

> OBS: The link will have a delay to run, because Heroku stops the application when it is inactive


###### References

https://en.wikipedia.org/wiki/Shoelace_formula

https://docs.oracle.com/javase/7/docs/api/java/awt/Polygon.html
