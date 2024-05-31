all:
	javac -d ./exe -cp . ./src/PaginationApplication.java
	javac -cp ./lib/junit-4.13.2.jar:./lib/hamcrest-core-1.3.jar -d ./exe ./src/PaginationApplication.java ./src/PaginationApplicationTest.java

comp:
	javac -d ./exe -cp . ./src/PaginationApplication.java

comptest:
	javac -cp ./lib/junit-4.13.2.jar:./lib/hamcrest-core-1.3.jar -d ./exe ./src/PaginationApplication.java ./src/PaginationApplicationTest.java

run: all
	java -cp . ./src/PaginationApplication.java

test: all
	java -cp ./lib/junit-4.13.2.jar::./lib/hamcrest-core-1.3.jar:./exe org.junit.runner.JUnitCore src.PaginationApplicationTest

clean:
	rm -rf ./exe/*
	rm -rf ./output/*