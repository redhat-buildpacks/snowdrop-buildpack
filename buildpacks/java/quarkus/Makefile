SHELL             := /bin/bash
TARGET_BUILDPACK  := ../../dummy

all: test native move-runner symlink

generate:
	echo "Generate the Sundrio java classes"
	rm -rf ./target/generated-sources/annotations/dev/snowdrop/buildpack/model/*Builder.java && \
	rm -rf ./target/generated-sources/annotations/dev/snowdrop/buildpack/model/*Impl.java && \
	rm -rf ./target/generated-sources/annotations/dev/snowdrop/buildpack/model/*Fluent.java && \
	rm -rf ./target/generated-sources/annotations/dev/snowdrop/buildpack/model/Editable*.java && \
	mvn clean compile && \
	cp -r ./target/generated-sources/annotations/dev/snowdrop/buildpack/model/*.java ./src/main/java/dev/snowdrop/buildpack/model

test:
	mvn clean test

native:
	echo "Generate a native executable of the project"
	mvn clean package -Pnative \
	-Dquarkus.native.container-build=true \
	-Dquarkus.banner.enabled=false \
	-Dquarkus.package.output-name=main

move-runner:
	echo "Move the file created under bin/ folder"
	mv ./target/main-runner $(TARGET_BUILDPACK)/bin/main

symlink:
	echo "Create the symbolic links for detect and build"
	ln -fs main $(TARGET_BUILDPACK)/bin/build
	ln -fs main $(TARGET_BUILDPACK)/bin/detect
