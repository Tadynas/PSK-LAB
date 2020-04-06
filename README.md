# PSK lab project 2020
Project is based on *Maven*, thus import project to IntelliJ IDEA by:
* File -> Open... -> pick `pom.xml` file.

## Application Server configuration

### WildFly

1. Download ZIP of WildFly 18 "Java EE Full & Web Distribution" from: [http://wildfly.org/downloads/]
2. Unzip
3. In IntelliJ IDEA: register "JBoss Server" -> local:
    * Press "Fix", choose "exploded war"
4. Run the server, project should start successfully.

## Database

* Database will be created after first successful launch. Source URL: "jdbc:h2:~/h2database/SteamDB;AUTO_SERVER=TRUE". User: "sa" Password: "sa".
* Additionaly, database with filled data and SQL insert files can be found at: "src\main\resources\Database".
