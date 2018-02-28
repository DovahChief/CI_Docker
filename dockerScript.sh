#!/bin/bash

#Crea la imagen de Docker
docker build -f Dockerfile -t test  .

#docker save -o ./image.tar project-dockerImage
# docker load -i 
echo "COMANDO PARA PASAR IMAGEN DE DOCKER"
