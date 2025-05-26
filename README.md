A Java command-line tool that determines the type of a triangle (**equilateral**, **isosceles**, or **scalene**) based on the lengths of its three sides.

## Installation
1. Build the project:
```bash
mvn clean package
```

2. The executable JAR will be generated at:  
target/triangle-classifier-1.0-SNAPSHOT.jar

## Usage:
Run the application from the command line with three side lengths as arguments:
```bash
java -jar target/triangle-classifier-1.0-SNAPSHOT-shaded.jar <sideA> <sideB> <sideC>
```

## Example
```bash
java -jar target/triangle-classifier-1.0-SNAPSHOT.jar 5 5 5
```
Output: The triangle is equilateral.

## Input Rules
Exactly 3 numeric arguments are required.  
All sides must be positive numbers.  
The values must respect the triangle inequality theorem.

## Supported locales
English (messages.properties)  
French (messages_fr.properties)

To run in French:

```bash
java -Duser.language=fr -jar target/triangle-classifier-1.0-SNAPSHOT.jar 3 3 5
```
Output: Le triangle est équilatéral.