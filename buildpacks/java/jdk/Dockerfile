FROM ghcr.io/graalvm/graalvm-ce:21.3

RUN gu install native-image

# Create a volume to which we can mount to build:
VOLUME /project
WORKDIR /project

# And finally, run native-image
ENTRYPOINT ["/usr/bin/native-image"]
