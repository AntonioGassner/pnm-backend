# pnm-backend
Prodotti Nobili Marchigiani BackEnd

# Installation

1) Download and install PostgreSQL. Install Pgadmin4 as well (Should come as default in Postgre installation)
https://www.postgresql.org/download/
When it asks you to setup a password that is for the "postgres" user. It is important later on

2) Run Pgadmin4, setup a password for it when asked. This password is asked only when running Pgadmin, it is not the same as the one for the postgres user

3)Create a local server
  once you are in Pgadmin, double click "servers" in the top right. Below it you shoudl now see "PostgreSQL 15" or whatever     postgres version you are using. Double click that.
  You shoudl now see Databases, Login/Grou Roles and Tablespaces.
  Right click Databases -> Create -> Database...
  Name the Database as "pnm-produttori", leave the rest as is and save.
  
  Now if you double-click Databases(2) you should see "pnm-produttori" and "postgres" 
Leave this window open, we will need it later to check if database has been correctly autoconfigured.

4) Open codebase with your IDE. I recommend IntellijIdea. You can get the premium version using your university credentials.
  Do that, it gives premium support for Springboot and that is very useful.
  Once you open the codebase check the pom.xml file.
  Maven might automatically install dependencies. 
  If unsure open a console (In intellij it is at the bottom-left) and use the following command:
  "mvn clean install -DskipTests" 
  Pray that you get no errors
  If this worked successfully you installed dependencies and generated mappers.
  To check if you generated mappers look at project structure in the top left. You should now see an orange "target"    folder.
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
Now, pnm-produttori is the name of the database you created. Username is default for postgres. Password is whatever you setup locally, so change it for that. NOTE: put password for Postgres there, not Pgadmin.
Once you all complete this configuration step we will put these files on .gitignore so everyone can have his password and it is not saved on github. 
  
6) Go back to IDE and look in top right on the toolbar. There should be something like "PnmApplication" between the build   and run buttons. This is a intellij premium feature from what i know and allows you to more easily run the project.
Now click the "run" icon and pray. If all went well the application is now running and listening on port 8092

7) Go back to Pgadmin, under "pnm-produttori" double click "schemas" -> public -> tables
you should see 5 tables, azienda, comune, produttore, provincia, tipo_prodotto
