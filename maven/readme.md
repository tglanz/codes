maven
=====

prerequisites
- java 8
- maven


run unit tests

    // clean, build and test
    mvn clean -B test

run specific suite

    // test just SomeTest
    mvn -DTest=SomeTest test
