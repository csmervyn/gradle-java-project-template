#!/bin/bash
echo "Start to build and push arm64 images to docker hub"
docker buildx build  -t csmervyn718/gradle-java-project-template:latest --platform=linux/arm64 . --push
echo "ARM64 Images push to docker hub success U+2705"
echo "Start to build and push amd64 images to docker hub"
docker buildx build  -t csmervyn718/gradle-java-project-template:latest --platform=linux/amd64 . --push
echo "AMD64 Images push to docker hub success U+2705"
