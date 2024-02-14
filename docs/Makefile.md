# Makefile
## Overview
The Makefile provides a set of commands for building, running, and deploying the software project. It includes commands for building the application using Gradle, running the application locally using AWS SAM, and deploying the application to development and production environments using AWS SAM.

## Table of Contents
1. [Prerequisites](#prerequisites)
2. [Usage](#usage)
3. [Methods](#methods)
4. [Useful details](#properties)

## Prerequisites
- Gradle
- AWS SAM CLI
- Access to development and production AWS environments

## Usage
To build the application:
```bash
make build-app
```
To run the application locally:
```bash
make local-run
```
To deploy to development environment:
```bash
make deploy-dev
```
To deploy to production environment:
```bash
make deploy-prod
```

## Methods
### build-app
Builds the application using Gradle.
### local-run
Runs the application locally using AWS SAM.
### deploy-dev
Deploys the application to the development environment using AWS SAM with the specified configuration.
### deploy-prod
Deploys the application to the production environment using AWS SAM with the specified configuration.

## Useful details
- The build-app command uses Gradle to build the application and create a shadow JAR.
- The local-run command uses the SAM CLI to start the API locally for testing.
- The deploy-dev and deploy-prod commands use the SAM CLI to deploy the application to the specified environment with the specified configuration.