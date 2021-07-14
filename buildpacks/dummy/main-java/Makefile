SHELL       := /bin/bash
CURRENT_DIR := $(shell pwd)
TARGET_JAR  := buildpack-app-1.0-SNAPSHOT-jar-with-dependencies.jar
APP_NAME    := main
CLASS_NAME  := dev.snowdrop.buildpack.App

all: compile native-build package-app launch

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

package-app:
	docker build -t snowdrop/native-app . -f native.Dockerfile

launch:
	docker run snowdrop/native-app
