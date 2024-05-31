# PaginationApplication

A Java project done to complete the assesment for [TOPS SW Technical exercise.pdf](https://github.com/mostazomarc/PaginationApplication/blob/paginationApplication/TOPS%20SW%20Technical%20exercise.pdf).

## Project Instructions
> Use the Makefile to run the project.
>
> You'll need to have `make` installed on your machine
>
> ALL COMMANDS MUST BE EXECUTED IN THE ROOT DIRECTORY!

To build all the source code targets:
```sh
make all
```

To build only the main source file:
```sh
make comp
```

To build only the test source file:
```sh
make comptest
```

To build & run the main source file with example input file:
```sh
make run FILEPATH=./input/document.txt
```
> FILEPATH MUST be equal to the path of the input file intendet to be paginated.
> 
> Input files MUST be 1 line and .txt

To build & run the tests for the main source file with the test source file:
```sh
make test
```

To clean the build and output artifacts:
```sh
make clean
```

## Project Structure
```
.
├── LICENSE                         #LICENSE of the repo
├── Makefile                        #Makefile for the project
├── README.md                       #README of the repo
├── TOPS SW Technical exercise.pdf  #Instruccions for the assesment
├── exe                             #Build artifacts directory
│   └── src
│       ├── PaginationApplication.class
│       └── PaginationApplicationTest.class
├── input                           #Input example files directory
│   └── document.txt
├── lib                             #Libraries for JUnit testing
│   ├── hamcrest-core-1.3.jar
│   └── junit-4.13.2.jar
├── output                          #Output files generated from running the program
│   └── output.txt
└── src                             #Source code of the project
    ├── PaginationApplication.java      #Source code for PaginationApplication class
    └── PaginationApplicationTest.java  # Source code for PaginationApplication test
```

## Author
- Mostazo Gonzàlez, Marc
