#!/bin/bash
docker run --rm -v "${PWD}:/local" openapitools/openapi-generator-cli \
    generate -g spring -o /local/out/spring "$@" -i /local/meeting_rooms.yaml \
    --additional-properties=groupId=com.example,artifactId=meeting-rooms,basePackage=com.example.meetingrooms