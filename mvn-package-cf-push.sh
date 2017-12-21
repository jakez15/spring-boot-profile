#!/usr/bin/env bash

mvn clean package

cf v2-push spring-boot-profile -p target/spring-boot-sample-profile-1.5.8.RELEASE.jar -b java_buildpack_offline
