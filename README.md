# Snowdrop Buildpacks

Table of Contents
=================

  * [Introduction](#introduction)
  * [Documentation](#documentation)
  * [Prerequisite](#prerequisite)
  * [Installation](#installation)
  * [Testing](#testing)
    * [dev.snowdrop.buildpack.Build a Spring Boot project using our builder](#build-a-spring-boot-project-using-our-builder)
    * [Test the image built](#test-the-image-built)
  * [Development of a Buildpacks using Quarkus and native build](#development-of-a-buildpacks-using-quarkus-and-native-build)
    * [Instructions to compile the project as buildpack image](#instructions-to-compile-the-project-as-buildpack-image)
    * [To play with the buildpack locally](#to-play-with-the-buildpack-locally)


## Introduction

These are some WIP build stacks for building Spring Boot applications using Red Hat supported images such as: ubi8 and OpenJDK.
This project allows to generate a [builder](https://buildpacks.io/docs/concepts/components/builder/) image packaging the:
- `Snowdrop` [buildpack](https://buildpacks.io/docs/concepts/components/buildpack/)
- `jvm` [stack](https://buildpacks.io/docs/concepts/components/stack/).

The current project only packages one `buildpack` and one `stack` within the `builder` image. 

It could be extended in a near future to:
- Support several `jdk` using different `run image` part of new stacks or new `build image` supporting more recent versions of `maven`, `gradle`, etc
- Provide additional `buildpack` to instruct the `pack tool` during the build process to by example include some needed libraries, tools or add CA certificate or configure environment variables

## Documentation

- CNCF Official doc: https://buildpacks.io/
- Blog posts explaining stack, builder and buildpacks: https://www.altoros.com/blog/author/m-beaverson/

## Prerequisite

- To use buildpacks you'll need to install the client `pack`. See the instructions here on how to [install it](https://buildpacks.io/docs/tools/pack)
- [Docker desktop](https://docs.docker.com/desktop/) installed and started

## Installation

To create the `builder image` of the Snowdrop buildpacks project, clone this repo and run the following bash script:
```shell script
./create-buildpacks.sh
```

## Testing

### dev.snowdrop.buildpack.Build a Spring Boot project using our builder

To test the `builder` on a Spring Boot application, execute the following command
top of the example [project](./apps) with the help of the `pack` tool.

```bash
pack build snowdrop-jvm-app --path apps/snowdrop-sample-app --builder redhat/buildpacks-builder-maven-jvm:latest
```

### Test the image built

After having built the image with one of the commands above you can simply run them, eg:

```bash
docker run -d -p 8080:8080 --name springboot snowdrop-jvm-app
```

## Development of a Buildpacks using Quarkus and native build

A java quarkus project called `dummy` has been created within this buildpacks [folder](./buildpacks/dummy) 
in order to experiment how java technology could be used as replacement to the existing buidpacks designed
using `go` language or `bash` scripts.

This project will be compiled as a native executable `target/main-runner` and next moved under `bin/main`.
Two symbolic names, one for `detect` and another for `build` will also be created in order to only have to compile one executable `main`

```bash
ls -la buildpacks/dummy/bin 
total 57384
drwxr-xr-x  5 cmoullia  staff       160 Jul  9 15:16 .
drwxr-xr-x  8 cmoullia  staff       256 Jul  9 15:07 ..
lrwxr-xr-x  1 cmoullia  staff         4 Jul  9 15:16 build -> main
lrwxr-xr-x  1 cmoullia  staff         4 Jul  9 15:16 detect -> main
-rwxr-xr-x  1 cmoullia  staff  29380000 Jul  9 15:16 main
```

The java class `dev.snowdrop.buildpack.App` is the core of the application. Quarkus will use the `@QuarkusMain`
annotation to starts it. When the lifecycle creator will call it, then we will determine the parameters
of the command line as defined within the process created.
A `dev.snowdrop.buildpack.Detect` or `dev.snowdrop.buildpack.Build` class is instantiated according to the command, and the process continues.

```java
@ApplicationScoped
@QuarkusMain
public class dev.snowdrop.buildpack.App implements QuarkusApplication {

    public static void main(String[] argv) throws Exception {
        Quarkus.run(dev.snowdrop.buildpack.App.class, argv);
    }

    @Override
    public int run(String... args) throws Exception {
        ...

        LOG.info("## Check the name of the program called by the lifecycle creator");
        switch (ProcessHandler.commandProcessed(BP_CMD)) {
            case "detect":
                LOG.info("## Command called is /bin/detect");
                dev.snowdrop.buildpack.Detect d = new dev.snowdrop.buildpack.Detect();
                return d.call();
            case "build":
                LOG.info("## Command called is /bin/build");
                dev.snowdrop.buildpack.Build b = new dev.snowdrop.buildpack.Build();
                return b.call();
            case "": new Exception("## Unsupported command called !");
        }
```

### Instructions to compile the project as buildpack image

- Launch first docker locally ;-)
- To create the native executable of the `dummy` buildpacks, execute the following command under
```bash
cd buildpacks/dummy
mvn clean package -Pnative \
    -Dquarkus.native.container-build=true \
    -Dquarkus.banner.enabled=false \
    -Dquarkus.package.output-name=main \
    -f main/pom.xml
```
- Rename it and move it under the `bin` folder
```bash
mv main/target/main-runner bin/main
```  
- Create the symbolic links pointing to the main application
```bash
ln -fs main bin/detect 
ln -fs main bin/build 
```
**IMPORTANT**: All these instructions can be executed using the bash script `./scripts/build.sh`

- Package the `dummy` buildpack within the builder image
```bash
pack builder create redhat/buildpacks-builder-maven-jvm:latest --config ./builders/maven-jvm/builder.toml
```
- dev.snowdrop.buildpack.Build now a Spring Boot's application packaged within this project using the builder image and the buildpacks `dummy`
```bash
pack build java-dummy-app --builder redhat/buildpacks-builder-maven-jvm:latest -p ./apps/snowdrop-sample-app -v -b dev.snowdrop.buildpacks.dummy
```

### To play with the buildpack locally

To debug the `buildpacks` locally for the `detect` or `build` phase, add the following `ENV` variables:

```text
BP_WORKSPACE=./apps/snowdrop-sample-app // Location of the application you would like to buildpacks 
CNB_BUILDPACK=./buildpacks/dummy        // Path to the buildpacks
```
Next, launch the Main application `dev.snowdrop.buildpack.dev.snowdrop.buildpack.App` where you pass as parameters the needed arguments 

```text
./tmp/platform ./tmp/build.toml // Arguments for the detect phase: <platform_dir> <build.toml>
./tmp/layers/dummy /tmp/platform /tmp/plan.toml  // arguments for the build phase: <layers_dir> <platform_dir> <build.toml> 
```
and you set the `BP_CMD` ENV variable which emulates the call to either the `detect` or `build` phase

```text
BP_CMD=echo "<phase>" // where <phase> is "detect" or "build"
```

Enjoy :-)