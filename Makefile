all:
	javac -d ./exe -cp . ./PaginationApplication.java
	javac -cp ./lib/junit-4.13.2.jar:./lib/hamcrest-core-1.3.jar -d ./exe ./PaginationApplication.java ./PaginationApplicationTest.java

run: all
	java -cp . ./PaginationApplication.java

test: all
	java -cp ./lib/junit-4.13.2.jar::./lib/hamcrest-core-1.3.jar:./exe org.junit.runner.JUnitCore PaginationApplicationTest