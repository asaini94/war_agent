# bean-validation: Bean Validation Tested Using Arquillian

Author: Karel Piwko  
Level: Beginner  
Technologies: CDI, JPA, BV  
Summary: The `bean-validation` quickstart provides Arquillian tests to demonstrate how to use CDI, JPA, and Bean Validation.  
Target Product: WildFly  
Source: <https://github.com/wildfly/quickstart/>  

## What is it?

The `bean-validation` quickstart demonstrates how to use CDI, JPA, and Bean Validation in WildFly Application Server. It includes a persistence unit and some sample persistence code to introduce you to database access in enterprise Java.

This quickstart does not contain a user interface layer. The purpose of this project is to show you how to test bean validation with Arquillian. If you want to see an example of how to test bean validation with a user interface, look at the [kitchensink](../kitchensink/README.md) example.

This quickstart is a basic example of bean validation and is not localized. Because it is not localized, English messages are hard-coded in the constraint annotations in the `Member` class to ensure the test violation messages are matched when running the WildFly server using another language. For examples of localized quickstarts, see the `kitchensink-ml`, `kitchensink-ml-ear`, and `logging-tools` quickstarts.

_Note: This quickstart uses the H2 database included with WildFly Application Server 11. It is a lightweight, relational example datasource that is used for examples only. It is not robust or scalable, is not supported, and should NOT be used in a production environment!_

_Note: This quickstart uses a `*-ds.xml` datasource configuration file for convenience and ease of database configuration. These files are deprecated in WildFly and should not be used in a production environment. Instead, you should configure the datasource using the Management CLI or Management Console. Datasource configuration is documented in the [Configuration Guide](https://access.redhat.com/documentation/en/red-hat-jboss-enterprise-application-platform/) for WildFly Application Server._

## System Requirements

The application this project produces is designed to be run on WildFly Application Server 11 or later.

All you need to build this project is Java 8.0 (Java SDK 1.8) or later and Maven 3.3.1 or later. See [Configure Maven for WildFly 11](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/CONFIGURE_MAVEN_JBOSS_EAP7.md#configure-maven-to-build-and-deploy-the-quickstarts) to make sure you are configured correctly for testing the quickstarts.


## Use of WILDFLY_HOME

In the following instructions, replace `WILDFLY_HOME` with the actual path to your WildFly installation. The installation path is described in detail here: [Use of WILDFLY_HOME and JBOSS_HOME Variables](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/USE_OF_WILDFLY_HOME.md#use-of-eap_home-and-jboss_home-variables).


## Start the Server

1. Open a command prompt and navigate to the root of the WildFly directory.
2. The following shows the command line to start the server:

        For Linux:   WILDFLY_HOME/bin/standalone.sh
        For Windows: WILDFLY_HOME\bin\standalone.bat


## Run the Arquillian Tests

This quickstart provides Arquillian tests. By default, these tests are configured to be skipped as Arquillian tests require the use of a container.

1. Make sure you have started the WildFly server as described above.
2. Open a command prompt and navigate to the root directory of this quickstart.
3. Type the following command to run the test goal with the following profile activated:

        mvn clean verify -Parq-remote

You can also let Arquillian manage the WildFly server by using the `arq-managed` profile. For more information about how to run the Arquillian tests, see [Run the Arquillian Tests](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/RUN_ARQUILLIAN_TESTS.md#run-the-arquillian-tests).


## Investigate the Console Output

When you run the tests, JUnit will present you test report summary:

    Tests run: 5, Failures: 0, Errors: 0, Skipped: 0

If you are interested in more details, look in the `target/surefire-reports` directory.

You can also check the server console output to verify that the Arquillian tests deployed to and ran in the application server. Search for lines similar to the following ones in the server output log:

    INFO [org.jboss.as.server.deployment] (MSC service thread 1-5) WFLYSRV0027: Starting deployment of "test.war" (runtime-name: "test.war")
    ...
    INFO [org.jboss.as.server] (management-handler-thread - 2) WFLYSRV0010: Deployed "test.war" (runtime-name : "test.war")
    ...
    INFO [org.jboss.as.server.deployment] (MSC service thread 1-3) WFLYSRV0028: Stopped deployment test.war (runtime-name: test.war) in 32ms
    ...
    INFO [[org.jboss.as.server] (management-handler-thread - 2) WFLYSRV0009: Undeployed "test.war" (runtime-name: "test.war")


## Server Log: Expected Warnings and Errors

_Note:_ You will see the following warnings in the server log. You can ignore these warnings.

    WFLYJCA0091: -ds.xml file deployments are deprecated. Support may be removed in a future version.

    HHH000431: Unable to determine H2 database version, certain features may not work


## Run the Quickstart in Red Hat JBoss Developer Studio or Eclipse

You can also start the server and deploy the quickstarts or run the Arquillian tests from Eclipse using JBoss tools. For general information about how to import a quickstart, add a WildFly server, and build and deploy a quickstart, see [Use JBoss Developer Studio or Eclipse to Run the Quickstarts](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/USE_JBDS.md#use-jboss-developer-studio-or-eclipse-to-run-the-quickstarts).


## Debug the Application

If you want to debug the source code of any library in the project, run the following command to pull the source into your local repository. The IDE should then detect it.

        mvn dependency:sources
