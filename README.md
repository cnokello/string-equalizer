## Background
This application calculates the least possible cost of transforming two strings, s1 and s2, so that both strings are the same. Three possible transformation actions are:

*	Insertion
*	Deletion
*	Replacement


Insertion and Deletion has a cost of 1 unit. Replacement has a cost of 2 units.


## How to run
The project is maven based. Therefore, to compile, run the following from the base directory of the project:
	
	> mvn clean package
	
This will create a jar archive in the *target* directory named 'string-trans4mer-0.0.1-SNAPSHOT.jar'.

To run, from the base directory of the project, run:

	> java -jar target/string-trans4mer-0.0.1-SNAPSHOT.jar
	

Running the above command will present you with a command line interface for interacting with the application.
