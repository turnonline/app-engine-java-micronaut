# ConnecSys Micronaut App Template

ConnecSys app template based on the Micronaut framework. Configured for Google App Engine Java 17 standard environment.

## Micronaut 3.9.4 Documentation

- [User Guide](https://docs.micronaut.io/3.9.4/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.9.4/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.9.4/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/latest/index.html)
- [Using the App Engine Maven Plugin](https://cloud.google.com/appengine/docs/standard/java-gen2/using-maven)

---

## App Template prerequisites

* Java 17 (temurin-17)
* Maven installed, check with `mvn -v`
* gcloud CLI app-engine-java component: `gcloud components install app-engine-java`
* Check the target GCP project: `gcloud config list`
    * Optionally set the target GCP project: `gcloud config set project [PROJECT_ID]`

## Building and Deploying locally by Maven plugin

```
mvn package appengine:deploy
```
