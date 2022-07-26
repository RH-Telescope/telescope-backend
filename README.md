# Project Telescope - Backend

This is the backend POC for the Telescope project. Much of this needs to be refactored (or rewritten entirely), as this was hacked together last minute for a demo.

# Environment Setup Instructions

Create a target namespace for the telescope-backend project. The name doesn't matter, as long as it does not conflict with an existing project name.

`oc new-project telescope-backend`

# Build Instructions

To build the backend application:

* rm -rf ./target/
* mvn clean package -Dnative -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true

NOTE: The `rm` step is usually not required, as `mvn clean` should take care of this. Some combination of variables was causing the clean target to not work properly on the targeted build machine, so the `rm` was added as a precaution.

To build the backend image:

* docker build -f src/main/docker/Dockerfile.native -t quay.io/telescope/telescope-backend:latest .
* docker push quay.io/telescope/telescope-backend

NOTE: Ensure that you are logged into Quay and have access to `telescope-backend`

# Deploying the application onto OpenShift

* Clone the associated ops repo locally: https://github.com/RH-Telescope/telescope-backend-ops
* From that directory: helm install telescope-backend charts/

## Updating the application: ops repo changes

To allow the application to deploy when the ops repo is updated: 
* In the telescope-backend-ops GitHub repo, got to Settings -> Webhooks -> Add webhook
* For "Payload URL", `https://<gitops-url>/api/webhook` (replacing `<gitops-url>` with the actual URL for the ArgoCD / GitOps URL)
* Update "Content type" to `application/json`
* Click "Add webhook"

Now, any update to the ops repo should trigger a redeploy

## Updating the application: code repo changes

TODO: There were no procedures to do this at the time of the POC; this will need to be tested and documented.
