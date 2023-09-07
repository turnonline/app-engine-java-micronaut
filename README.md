# Micronaut web application template built on the Micronaut framework

The template is built on the Micronaut framework, configured to run on the Google App Engine Java 17 standard
environment, with the option to build a **GraalVM** native image that can be deployed using Cloud Build.

For web content rendering, the [Micronaut Views](https://micronaut-projects.github.io/micronaut-views/latest/guide/)
is used with Apache Freemarker employed as the template engine.

It enables developers to create scalable and efficient web applications that run on App Engine.

## Micronaut Latest Documentation

- [User Guide](https://docs.micronaut.io/latest/guide/index.html)
- [API Reference](https://docs.micronaut.io/latest/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/latest/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/latest/index.html)
- [Using the App Engine Maven Plugin](https://cloud.google.com/appengine/docs/standard/java-gen2/using-maven)

---

## Template local prerequisites

* Java 17 (temurin-17)
* Maven installed, check with `mvn -v`
* gcloud CLI app-engine-java component: `gcloud components install app-engine-java`
* Check the target GCP project: `gcloud config list`
    * Optionally set the target GCP project: `gcloud config set project [PROJECT_ID]`

# GraalVM support

There is a dedicated Cloud Build configuration for GraalVM native image build. To use
it, [build-graalvm.yaml](build-graalvm.yaml)
file must be utilized.

### Performance boost seen directly on GCP

```stacktrace
INFO [protoPayload.latency: 1.809 s] [protoPayload.userAgent: Safari 16.5.2] /
DEFAULT Startup completed in 317ms. Server Running: http://localhost:8080
```

compared to the Default JAR packaging

```stacktrace
INFO [protoPayload.latency: 5.4 s] [protoPayload.userAgent: Safari 16.5.2] /
DEFAULT Startup completed in 3399ms. Server Running: http://localhost:8080
```

## Check Native Image Support for Google Cloud Libraries

[Supported APIs](https://github.com/googleapis/google-cloud-java#supported-apis)

## Build

### JAR locally, and deploying by Maven plugin

```bash
mvn clean package appengine:deploy
```

### GraalVM native image

```bash
mvn clean package -Dpackaging=native-image
```

### Cloud Build testing

```bash
gcloud builds submit --config build-graalvm.yaml .
```

### GraalVM build time boost (Cloud Build)

To speed up the build time, you can configure a more powerful machine type (attach it to the end of the Cloud Build
YAML).
The first 120 build-minutes per day are free (applicable only to the default one).

```yaml
options:
  machineType: 'E2_HIGHCPU_8'
```
