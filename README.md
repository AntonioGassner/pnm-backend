# pnm-backend

Prodotti Nobili Marchigiani BackEnd

URL for API generation
http://localhost:8080/v3/api-docs

# Installation

1) Download and install PostgreSQL. Install Pgadmin4 as well (Should come as default in Postgre installation)
   https://www.postgresql.org/download/
   When it asks you to setup a password that is for the "postgres" user. It is important later on

2) Run Pgadmin4, setup a password for it when asked. This password is asked only when running Pgadmin, it is not the
   same as the one for the postgres user

3) Create a local server
   once you are in Pgadmin, double click "servers" in the top right. Below it you shoudl now see "PostgreSQL 15" or
   whatever postgres version you are using. Double click that.
   You shoudl now see Databases, Login/Grou Roles and Tablespaces.
   Right click Databases -> Create -> Database...
   Name the Database as "pnm-produttori", leave the rest as is and save.

Now if you double-click Databases(2) you should see "pnm-produttori" and "postgres"
Leave this window open, we will need it later to check if database has been correctly autoconfigured.

4) Open codebase with your IDE. I recommend IntellijIdea. You can get the premium version using your university
   credentials.
   Do that, it gives premium support for Springboot and that is very useful.
   Once you open the codebase check the pom.xml file.
   Maven might automatically install dependencies.
   If unsure open a console (In intellij it is at the bottom-left) and use the following command:
   "mvn clean install -DskipTests"
   Pray that you get no errors
   If this worked successfully you installed dependencies and generated mappers.
   To check if you generated mappers look at project structure in the top left. You should now see an orange "target"
   folder.
   Open it -> generated-sources -> annotations -> it.unicam.pnm.core.mapper -> inbound
   You should see 5 classes of the type "Something DTOMapperImpl" in both this directory and the outbound one.

At this point you have both dependencies and generated classes. Nice!

5) Check application.yml  
   Go to src -> main -> resources and open application.yml file  
   At the end you will see
   datasource:
   url: jdbc:postgresql://localhost:5432/pnm-produttori
   username: postgres
   password: pass
   driverClassName: org.postgresql.Driver
   Now, pnm-produttori is the name of the database you created. Username is default for postgres. Password is whatever
   you setup locally, so change it for that. NOTE: put password for Postgres there, not Pgadmin.
   Once you all complete this configuration step we will put these files on .gitignore so everyone can have his password
   and it is not saved on github.

6) hibernate: ddl-auto: update
   This needs to be set to "create" the first time you run the project, then set back to update.
   It generates your database structure automatically

7) Go back to IDE and look in top right on the toolbar. There should be something like "PnmApplication" between the
   build and run buttons. This is a intellij premium feature from what i know and allows you to more easily run the
   project.
   Now click the "run" icon and pray. If all went well the application is now running and listening on port 8092

8) Go back to Pgadmin, under "pnm-produttori" double click "schemas" -> public -> tables
   you should see 5 tables, azienda, comune, produttore, provincia, tipo_prodotto

A word on jdk and Environment Variables.
This project requires JDK 19, so download that from Java website, install it and set up the evironment variable pointing
to it.
If you have no clue what this means let me guide you trough it step by step:

1) Download jdk 19 here https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html
2) Install it, and pay attention to where it is installed. Mine is at C:\Program Files\Java\jdk-19 for example
3) Search "Environment Variables". On windows it is called "Edit the system environment variables"
   On the tab you just opened at the bottom right is "environment variables...". Open that.

4) On the top section look for "Path". Open it and click New at the top right to create a new Environment variable
   Paste C:\Program Files\Java\jdk-19\bin or whatever is your jdk19 path.
   The \bin part is important, dont skip it. Click OK and clsoe this tab for now.
5) Now if you Have IntelliJ there should be a variable called "Intellij IDEA"
   Check if there is also a MAVEN_HOME and JAVA_HOME.
6) If there isn't well, tough luck. Find where Intellij is installed on your computer, and navigate to: C:\Program
   Files\JetBrains\IntelliJ IDEA 2022.2.3\plugins\maven\lib\maven3
   If you found your maven installation there then just create a new environment variable with Name "MAVEN_HOME"
   and Value "C:\Program Files\JetBrains\IntelliJ IDEA 2022.2.3\plugins\maven\lib\maven3" or whatever your path is
7) If you don't find Maven at that path then download Maven from https://maven.apache.org/download.cgi
   Extract it to a folder of your choice, then create an environment variable as explained above with the path where you
   extracted Maven to.
8) Open "Path" and create a variable "%MAVEN_HOME%\bin"

9) Now go back to Intellij and on the navigation bar on top left go to File -> Project Structure
10) Under SDK if you have none selected or if the selected one is not jdk19 click on it -> Add SDK -> Download JDK and
    find jdk 19
11) Once downloaded navigate to C:\Users\Antonio Gassner\.jdks where Intellij usually downloads JDKs to. If you don't
    see this then it is because it's a hidden folder. Now you either show hidden folders or paste the path directly in
    the navigation bar of your folder explorer
12) In here you have your "openjdk-19.0.1". Open the folder, then copy the path. This should look like C:\Users\Antonio
    Gassner\.jdks\openjdk-19.0.1
13) Back to environment variables. Create a new variable "JAVA_HOME" with value "C:\Users\Antonio
    Gassner\.jdks\openjdk-19.0.1" or whatever your path is
14) Open "Path" and create a variable "%JAVA_HOME%\bin"
15) Open cmd, and try running "java -version". You should see
    java version "19.0.1" 2022-10-18
    Java(TM) SE Runtime Environment (build 19.0.1+10-21)
    Java HotSpot(TM) 64-Bit Server VM (build 19.0.1+10-21, mixed mode, sharing)
16) run "javac -version", you should see
    javac 19.0.1
17) run "mvn -version", you should see something like
    Apache Maven 3.8.6 (84538c9988a25aec085021c365c560670ad80f63)
    Maven home: C:\Program Files\JetBrains\IntelliJ IDEA 2022.2.3\plugins\maven\lib\maven3
    Java version: 19.0.1, vendor: Oracle Corporation, runtime: C:\Users\Antonio Gassner\.jdks\openjdk-19.0.1
    Default locale: en_GB, platform encoding: UTF-8
    OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

If all the -version commands worked then you're good to go.

