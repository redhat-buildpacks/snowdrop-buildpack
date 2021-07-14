## Howto - native executable

- dev.snowdrop.buildpack.Build first the docker image containing the `native-image` tool and a `/project` volume

```bash
docker build -t snowdrop/native-image .
```

- Compile the project `mvn clean package`
- Create the `native` executable application
```bash
docker run --rm -it \
  -v /Users/cmoullia/code/snowdrop/buildpacks-projects/buildpacks/tmp/graalvm/:/project \
  snowdrop/native-image \
  --no-fallback \
   --static \
  -cp ./target/hello-world-1.0-SNAPSHOT-jar-with-dependencies.jar \
  -H:Name=helloworld \
  -H:Class=HelloWorld \
  -H:+ReportUnsupportedElementsAtRuntime
```
- Create an image packaging it using `scratch` OS
```bash
docker build -t snowdrop/native-app . -f native.Dockerfile
```
- Run the application
```bash
docker run -it snowdrop/native-app
```