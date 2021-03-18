# Snowdrop Buildpacks

This are some WIP build stacks for building Snowdrop applications using supported images like Red Hat OpenJDK and Red Hat Snowdrop builder (Mandrel).

To use buildpacks you'll need `pack`, see the instructions here on how to install it:

https://buildpacks.io/docs/tools/pack/


## Installation

To install the build packs run clone this repo and run the `create-buildpacks.sh` script.


## Snowdrop JVM

To test the buildpack for [Snowdrop](https://snowdrop.dev) using the JVM run this:

```
pack build snowdrop-jvm-test-app --path apps/snowdrop-sample-app --builder redhat/buildpacks-builder-snowdrop-jvm:latest
```

## Snowdrop Native

To test the buildpack for [Snowdrop](https://snowdrop.dev) compiling to native code run this:

```
pack build snowdrop-native-test-app --path apps/snowdrop-sample-app --builder redhat/buildpacks-builder-snowdrop-native:latest
```

## Running

After having built the image with one of the commands above you can simply run them, eg:

```
docker run -it --rm snowdrop-jvm-test-app
```

or

```
docker run -it --rm snowdrop-native-test-app
```

## Development

The information for creating buildpacks comes from:

https://buildpacks.io/docs/buildpack-author-guide/create-buildpack/
