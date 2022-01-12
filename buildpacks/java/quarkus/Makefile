SHELL             := /bin/bash
TARGET_BUILDPACK  := ../../dummy

all: test native move-runner symlink

test:
	mvn clean test

native:
	echo "Generate a native executable of the project"
	mvn clean package -Pnative \
	-Dquarkus.native.container-build=true \
	-Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-native-image:21.3-java17 \
	-Dquarkus.banner.enabled=false \
	-Dquarkus.package.output-name=main

move-runner:
	echo "Move the file created under bin/ folder"
	mkdir -p $(TARGET_BUILDPACK)/bin
	mv ./target/main-runner $(TARGET_BUILDPACK)/bin/main

symlink:
	echo "Create the symbolic links for detect and build"
	ln -fs main $(TARGET_BUILDPACK)/bin/build
	ln -fs main $(TARGET_BUILDPACK)/bin/detect
