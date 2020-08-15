echo 'docker image build -t spring-boot'

docker image build -t spring-boot .

echo 'docker container run'
docker container run -p 8080:8080 --name spring-boot-cv-container spring-boot
