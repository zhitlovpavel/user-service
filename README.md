
mvn liquibase:update -Dprefix=dbo

mvn clean package liquibase:diff -Dprefix=dbo -DskipTests=true



