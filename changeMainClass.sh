sed -ie "s/com.OX.app.Automate/com.OX.app.Main/g" pom.xml
rm -r pom.xmle
mvn clean install
cd target
java -jar X0-0.1.jar
