# Snowdrop Buildpacks

These are some WIP build stacks for building Spring Boot applications using Red Hat supported images such as: ubi8 and OpenJDK.
This project allows to generate a [builder](https://buildpacks.io/docs/concepts/components/builder/) image packaging the:
- `Snowdrop` [buildpack](https://buildpacks.io/docs/concepts/components/buildpack/)
- `jvm` [stacks](https://buildpacks.io/docs/concepts/components/stack/).

The current project only packages one `buildpack` and one `stack` within the `builder` image. It could be extended in a near future
to support different jdk using different base images part of the stack and buildpack to instrcut the tool during the build to by example include some needed
libraries, tools: openssl, maven, gradle, etc.

## Prerequisite

- To use buildpacks you'll need to install the client `pack`. See the instructions here on how to [install it](https://buildpacks.io/docs/tools/pack)
- [Docker desktop](https://docs.docker.com/desktop/) installed and started

## Installation

To create the `containerized image` of the Snowdrop buildpacks project, clone this repo and run the `./create-buildpacks.sh` script.

## Snowdrop JVM

To test the buildpack for [Snowdrop](https://snowdrop.dev) using a JVM, execute the following command:

```bash
pack build snowdrop-jvm-test-app --path apps/snowdrop-sample-app --builder redhat/buildpacks-builder-snowdrop-jvm:latest
```

## Running

After having built the image with one of the commands above you can simply run them, eg:

```bash
docker run -d -p 8080:8080 --name springboot snowdrop-jvm-test-app
```

## Development

The information for creating buildpacks comes from:

https://buildpacks.io/docs/buildpack-author-guide/create-buildpack/
