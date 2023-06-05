# Automated Test with Java, Selenium, and Page Object Model

This project is an automated test using Java, Selenium, and the Page Object Model (POM) design pattern. The objective of the test is to validate the functionality of the December Labs website, as well as the navigation to the Austin office page and interaction with a calendar popup.

## Project Structure

The project has the following structure:

- `src/main/java`: Contains the page representation classes.
- `src/test/java`: Contains the test classes.
- `chromedriver.exe`: The Chrome browser driver file.

## Improvements

- Page Object Model design pattern was used to organize and maintain the code in a structured and maintainable way.
- Page Factory was used to efficiently initialize page elements.
- `@FindBy` annotations were used to declaratively map page elements.
- Tests were implemented using JUnit, and `@Test` annotations were used to identify the test methods.

## Steps to Run the Tests

1. Make sure you have the Chrome browser driver (`chromedriver.exe`) in the correct location. If you don't have it, download it and include it in the project root.
2. Open the project in IntelliJ IDEA or your preferred development environment.
3. Configure the necessary dependencies in the `pom.xml` file.
4. Run the `DecemberLabsTest` class as a JUnit test.