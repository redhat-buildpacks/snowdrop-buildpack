FROM alpine:3.14

RUN apk add bash

VOLUME /workspace
WORKDIR /workspace

COPY main /main
ENTRYPOINT ["/main"]
