#!/bin/bash

#Crea la imagen de Docker
docker build -f Dockerfile -t stored_app  .

# Corre la imagen de Docker
echo "COMANDO PARA Iniciar Docker"
