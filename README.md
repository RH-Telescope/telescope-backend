# Project Telescope - Backend

This is the backend POC for the Telescope project. Much of this needs to be refactored (or rewritten entirely), as this was hacked together last minute for a demo.


# Build Instructions

To build the backend application:

* rm -rf ./target/
* mvn clean package -Dnative -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true

NOTE: The `rm` step is usually not required, as `mvn clean` should take care of this. Some combination of variables was causing the clean target to not work properly on the targeted build machine, so the `rm` was added as a precaution.

To build the backend image:

* docker build -f src/main/docker/Dockerfile.native -t quay.io/telescope/telescope-backend:latest .
* docker push quay.io/telescope/telescope-backend

NOTE: Ensure that you are logged into Quay and have access to `telescope-backend`
