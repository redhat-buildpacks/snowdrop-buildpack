# Snowdrop Buildpacks

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

## Test the builder using a Spring Boot project

To test the `builder` on a Spring Boot application, execute the following command
top of the example [project](./apps) with the help of the `pack` tool.

```bash
pack build snowdrop-jvm-test-app --path apps/snowdrop-sample-app --builder redhat/buildpacks-builder-snowdrop-jvm:latest
```

## Test the image build

After having built the image with one of the commands above you can simply run them, eg:

```bash
docker run -d -p 8080:8080 --name springboot snowdrop-jvm-test-app
```

## Development

More information about the CNCF Buildpacks project is available here: https://buildpacks.io/docs/