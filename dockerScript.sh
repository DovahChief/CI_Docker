#!/bin/bash

#Crea la imagen de Docker
docker build -f Dockerfile -t stored_app  .

#docker save -o ./image.tar project-dockerImage
# docker load -i 
echo "COMANDO PARA Iniciar Docker"
