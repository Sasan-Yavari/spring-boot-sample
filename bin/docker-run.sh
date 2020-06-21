cd ..
mvn clean package
docker build -t weather:latest .
docker run -p 8080:8080 weather:latest