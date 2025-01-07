# MITP Backend

This is the backend service for the Medical IT Systems Team Project (MITP). It is built using Spring Boot and provides RESTful APIs for managing patients, medical cases, and doctors.

## Table of Contents

- [Overview](#overview)
- [Core Technologies](#core-technologies)
- [Architecture](#architecture)
- [Authentication and Security](#authentication-and-security)
- [Development Tools](#development-tools)
- [Features](#features)
- [API Endpoints](#api-endpoints)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Overview

This is the backend of the Medical-IT-Systems-Team-Project. It is a RESTful API that provides endpoints for the frontend to interact with data stored in a database. This part of the project is designed to help doctors manage their patients, treatments, and medications efficiently.

## Core Technologies

- Java 17
- Spring Boot
- PostgreSQL
- Maven
- Docker

## Architecture

- MVC (Model-View-Controller)
- RESTful API

## Authentication and Security

- JWT (JSON Web Token)
- OAuth2
- HTTPS

## Development Tools

- IntelliJ IDEA
- Maven
- Docker
- GitHub
- Virtual Machine (NGINX)

## Features

- **CRUD operations for patients**: Add, update, view, and delete patient records.
- **CRUD operations for treatments and medications**: Manage treatment plans and medications for each patient.
- **Restart access ID for patients**: Option to reset patient access IDs for security.
- **Patient summary email**: Automatically send a summary email to patients with their treatment and medication details.

## API Documentation

API documentation is available via Swagger UI. Once the application is running, you can access it at:

- [Swagger UI Documentation](https://caretrack.skni.umcs.pl/swagger-ui/index.html)

## Application Access

You can access the application using the following link:

- [CareTrack Application](https://caretrack.skni.umcs.pl)

Here is a screenshot of the welcome page:

![Welcome Page](img.png)


## Setup
1. Clone the repository: `git clone 
2. Open the project in IntelliJ IDEA.
3. Run the project using the Spring Boot configuration.
4. Access the API endpoints using Postman or any other API testing tool.
5. Make sure to set up the database and environment variables before running the project.
6. Refer to the API documentation for detailed information on each endpoint.



