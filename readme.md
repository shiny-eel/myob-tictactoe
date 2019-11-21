## MYOB TicTacToe
### FMA Application Coding Problem
##### Lu Shien LEE | @shiny-eel

### Running the code
To run the application:
- Build the code, pointing to the main method in `tic.TicTacToe`
    - Java 11 was used in development
    - `javac -d [desired output dir] tic/TicTacToe.java`
- Give a file-path pointing to a text file as the first and only argument
    - within the output dir: `java tic.TicTacToe [test file path]` 

To run the unit tests
- JUnit 5, `org.junit.jupiter`, is needed to run the unit tests

### Design
An object oriented design was implemented, with a focus on two things:

- Creating 'GOOD' objects and architecture
- Creating production-quality code that is
    - Maintainable
    - Extensible
    - Functional

### Assumptions

- Some assumptions were made of the problem at hand
    - How the query lines are structured
    - How error messages should be presented to the user


---
_Thank you for reading!_ :)
