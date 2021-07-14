SHELL          := /bin/bash
MAVEN_PROJECT  := main-quarkus

all: test native move-runner

generate:
	echo "Generate the Sundrio java classes"
	rm -rf ./$(MAVEN_PROJECT)/target/generated-sources/annotations/dev/snowdrop/buildpack/model/*Builder.java && \
	rm -rf ./$(MAVEN_PROJECT)/target/generated-sources/annotations/dev/snowdrop/buildpack/model/*Impl.java && \
	rm -rf ./$(MAVEN_PROJECT)/target/generated-sources/annotations/dev/snowdrop/buildpack/model/*Fluent.java && \
	rm -rf ./$(MAVEN_PROJECT)/target/generated-sources/annotations/dev/snowdrop/buildpack/model/Editable*.java && \
	mvn clean compile -pl :main && \
	cp -r ./$(MAVEN_PROJECT)/target/generated-sources/annotations/dev/snowdrop/buildpack/model/*.java ./$(MAVEN_PROJECT)/src/main/java/dev/snowdrop/buildpack/model

test:
	mvn clean test -pl :$(MAVEN_PROJECT)

native:
	echo "Generate a native executable of the project"
	mvn clean package -pl :$(MAVEN_PROJECT) -Pnative \
	-Dquarkus.native.container-build=true \
	-Dquarkus.banner.enabled=false \
	-Dquarkus.package.output-name=main

move-runner:
	echo "Move the file created under bin/ folder"
	mv $(MAVEN_PROJECT)/target/main-runner bin/main

	echo "Create the symbolic links for detect and build"
	ln -fs main bin/build
	ln -fs main bin/detect
