#### Instructions how to run project

if locally - there are some pre-requisities needed:

+ Browser - Chrome/Firefox/Edge
+ JDK 15

Import as Maven project with IntelliJ or Eclipse. Download dependencies with Maven.

Tests can be executed:
+ using IDE - run any chosen test. Add parameters below to VM options
+ using Maven - use command ***mvn test***.

To run UI tests some parameters are needed:
+ -DBROWSER (chrome/firefox/edge)
+ -DBASE_URL = https://www.xm.com
+ -DTIMEOUT (for example 5)
+ -DSCREEN_RESOLUTION (Maximum/1024x768/800x600)

Examples:

Run all tests with maven:
mvn test -ea -DBROWSER=firefox -DBASE_URL=https://www.xm.com -DSCREEN_RESOLUTION=Maximum -DTIMEOUT=5

vm options:
-ea -ea -DBROWSER=firefox -DBASE_URL=https://www.xm.com -DSCREEN_RESOLUTION=1024x768 -DTIMEOUT=5

Details of tests - in TestDocumentation file.