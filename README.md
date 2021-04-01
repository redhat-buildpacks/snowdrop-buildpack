# Snowdrop Buildpacks

These are some WIP build stacks for building Spring Boot applications using Red Hat supported images like UBI, OpenJDK.

## Prerequisite

- To use buildpacks you'll need to install the client `pack`. See the instructions here on how to [install it](https://buildpacks.io/docs/tools/pack)
- [Docker desktop](https://docs.docker.com/desktop/) and started

## Installation

To create the `containerized image` of the Snowdrop buildpacks project, clone this repo and run the `./create-buildpacks.sh` script.

## Snowdrop JVM

To test the buildpack for [Snowdrop](https://snowdrop.dev) using the JVM run this:

```
pack build snowdrop-jvm-test-app --path apps/snowdrop-sample-app --builder redhat/buildpacks-builder-snowdrop-jvm:latest
```

## Running

After having built the image with one of the commands above you can simply run them, eg:

```
docker run -d -p 8080:8080 --name springboot snowdrop-jvm-test-app
```

## Development

The information for creating buildpacks comes from:

https://buildpacks.io/docs/buildpack-author-guide/create-buildpack/
