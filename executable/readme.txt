- Execute With:  java -jar sample-rest-webapp-1.0.0-SNAPSHOT.jar

- JDK 1.8

- Service Urls:

1. http://localhost:8080/api/collect -> POST

{
	"url":"https://www.google.com",
    "callbackUrl":"https://inpwrd.com/results"
}

2. http://localhost:8080/api/query?url=https://www.google.com -> GET