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

## API Endpoints

### Authentication

- **`/welcome`**: Displays a welcome message and checks if the server is running.
- **`/login`**: Logs in a user (doctor or patient) with provided credentials.
- **`/register`**: Registers a new user (doctor or patient) in the system.
- **`/delete/{login}`**: Deletes the user with the specified login (only accessible by admin).

### User Management

- **`/find/{login}`**: Finds a user (doctor or patient) by their login.
- **`/update/{login}`**: Updates the user's profile information.
- **`/patient/restart`**: Resets the access ID for the patient (useful for security reasons).
- **`/patient/{accessId}`**: Fetches detailed patient information using their access ID.

### Doctor's Management

- **`/doctor/medical-case/all`**: Retrieves all medical cases assigned to the doctor.
- **`/doctor/medication/new`**: Adds a new medication to a patient's treatment plan.
- **`/doctor/medication/{Id}/status`**: Updates the status of a specific medication (e.g., active, completed).
- **`/doctor/patient/all`**: Retrieves all patients assigned to the doctor.
- **`/doctor/patient/all/unassigned`**: Retrieves a list of unassigned patients for the doctor.
- **`/doctor/treatment/new`**: Adds a new treatment plan for a patient.
- **`/doctor/treatment/{Id}/status`**: Updates the status of a specific treatment plan.

### Medical Case Management

- **`/medical-case/new`**: Creates a new medical case for a patient.
- **`/medical-case/{Id}`**: Fetches details of a specific medical case by its ID.
- **`/medical-case/{Id}/medication/all`**: Retrieves a list of all medications linked to a specific medical case.
- **`/medical-case/{Id}/treatment/all`**: Retrieves a list of all treatments linked to a specific medical case.
- **`/medical-case/{accessId}/history`**: Fetches the medical history for a patient using their access ID.
- **`/medical-case/{accessId}/summary`**: Sends a summary email with the patient's treatment and medication details.
- **`/medical-case/allowed-doctor/{accessId}`**: Fetches the list of doctors who are allowed to view the medical case for a specific patient.

## Setup
1. Clone the repository: `git clone 
2. Open the project in IntelliJ IDEA.
3. Run the project using the Spring Boot configuration.
4. Access the API endpoints using Postman or any other API testing tool.
5. Make sure to set up the database and environment variables before running the project.
6. Refer to the API documentation for detailed information on each endpoint.



