# Build all targets
all:
	javac -d ./exe -cp . ./src/PaginationApplication.java
	javac -cp ./lib/junit-4.13.2.jar:./lib/hamcrest-core-1.3.jar -d ./exe ./src/PaginationApplication.java ./src/PaginationApplicationTest.java

# Compile only the main source file
comp:
	javac -d ./exe -cp . ./src/PaginationApplication.java

# Compile only the test source file
comptest:
	javac -cp ./lib/junit-4.13.2.jar:./lib/hamcrest-core-1.3.jar -d ./exe ./src/PaginationApplication.java ./src/PaginationApplicationTest.java

# Run the application
run: all
	java -cp . ./src/PaginationApplication.java $(FILEPATH)

# Run the test cases
test: all
	java -cp ./lib/junit-4.13.2.jar::./lib/hamcrest-core-1.3.jar:./exe org.junit.runner.JUnitCore src.PaginationApplicationTest

# Clean the build and output artifacts
clean:
	rm -rf ./exe/*
	rm -rf ./output/*