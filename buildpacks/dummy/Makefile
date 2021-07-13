SHELL := /bin/bash

all: test native move-runner

generate:
	echo "Generate the Sundrio java classes"
	rm -rf ./main/target/generated-sources/annotations/dev/snowdrop/buildpack/model/*Builder.java && \
	rm -rf ./main/target/generated-sources/annotations/dev/snowdrop/buildpack/model/*Impl.java && \
	rm -rf ./main/target/generated-sources/annotations/dev/snowdrop/buildpack/model/*Fluent.java && \
	rm -rf ./main/target/generated-sources/annotations/dev/snowdrop/buildpack/model/Editable*.java && \
	mvn clean compile -pl :main && \
	cp -r ./main/target/generated-sources/annotations/dev/snowdrop/buildpack/model/*.java ./main/src/main/java/dev/snowdrop/buildpack/model

test:
	mvn clean test -pl :main

native:
	echo "Generate a native executable of the project"
	mvn clean package -pl :main -Pnative \
	-Dquarkus.native.container-build=true \
	-Dquarkus.banner.enabled=false \
	-Dquarkus.package.output-name=main \
	-f main/pom.xml

move-runner:
	echo "Move the file created under bin/ folder"
	mv main/target/main-runner bin/main

	echo "Create the symbolic links for detect and build"
	ln -fs main bin/build
	ln -fs main bin/detect
