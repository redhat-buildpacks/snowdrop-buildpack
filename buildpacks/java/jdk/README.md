## How to create a native executable

TODO: To be reviewed and document how to use instead the Makefile 

- Build first the docker image containing:
  - graalvm-ce:21.3,
  - the `native-image` gu tool 
  - a `/project` volume

```bash
pushd buildpacks/java/jdk
docker build -t snowdrop/native-image .
```

- Next, compile the java project 
```bash
mvn clean package
```
- Create the `native` executable application packaging the jar+dependencies built previously
```bash
docker run --rm -it \
        -v $(pwd):/project \
        snowdrop/native-image \
        --no-fallback \
        --static \
        -cp ./target/jdk-1.0.0-SNAPSHOT-jar-with-dependencies.jar \
        -H:Name=main \
        -H:Class=dev.snowdrop.buildpack.App \
        -H:+ReportUnsupportedElementsAtRuntime
```
- Create an image packaging the native executable using the `alpine` OS
```bash
docker build -t snowdrop/native-app . -f native.Dockerfile
popd
```
- Run the application to test it locally
```bash
docker run -it snowdrop/native-app
```