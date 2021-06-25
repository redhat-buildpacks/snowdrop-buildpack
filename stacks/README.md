# Stacks

This project contains different `stacks` such as:

- [openjdk11](./jvm)

## Development

To build the stack use the `./build-stack` script:

```text
./build-stack.sh [-p <prefix> -v <version>] <dir>
  -p    prefix to use for images      (default: sample/stack)
  -v    version to tag images with    (default: latest)
  <dir>  directory of stack to build
```

Example:

```bash
./build-stack.sh redhat/buildpacks-stack-snowdrop <dir>
```

To use this stack see the [sample builders](../builders)

### Additional Resources

* [Stacks documentation](https://buildpacks.io/docs/using-pack/stacks/)