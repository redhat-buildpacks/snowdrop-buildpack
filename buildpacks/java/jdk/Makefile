SHELL             := /bin/bash
CURRENT_DIR       := $(shell pwd)
MAVEN_PROJECT     := jdk
VERSION           := 1.0.0-SNAPSHOT
TARGET_JAR        := $(MAVEN_PROJECT)-$(VERSION)-jar-with-dependencies.jar
APP_NAME          := main
CLASS_NAME        := dev.snowdrop.buildpack.App
TARGET_BUILDPACK  := ../../dummy

all: compile native-build move-main symlink

compile:
	mvn clean package

native-build:
	docker run --rm -it \
	-v $(CURRENT_DIR):/project \
	snowdrop/native-image \
	--no-fallback \
	--static \
	-cp ./target/$(TARGET_JAR) \
	-H:Name=$(APP_NAME) \
	-H:Class=$(CLASS_NAME) \
	-H:+ReportUnsupportedElementsAtRuntime

move-main:
	echo "Move the file created under bin/ folder"
	mv ./main $(TARGET_BUILDPACK)/bin/main

symlink:
	echo "Create the symbolic links for detect and build"
	ln -fs main $(TARGET_BUILDPACK)/bin/build
	ln -fs main $(TARGET_BUILDPACK)/bin/detect

containerize-app:
	docker build -t snowdrop/native-app . -f native.Dockerfile

launch:
	mkdir -p target/platform
	docker run -it \
	-e BP_CMD='echo "detect"' \
	-e CNB_BUILDPACK_DIR="dev.snowdrop.dummy" \
	-v $(CURRENT_DIR)/target:/workspace \
	snowdrop/native-app /workspace/platform/ /workspace/build.toml
