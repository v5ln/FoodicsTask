package apiTests;

import org.testng.TestNG;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testSuite = new TestNG();

        Class[] classes = new Class[]{
                LoginTest.class,
                WhoAmITest.class
        };

        testSuite.setTestClasses(classes);

        testSuite.addListener(new MyTestListener());

        testSuite.run();
    }
}
