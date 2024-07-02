# FlipFit Gym Management System

[![GitHub last commit](https://img.shields.io/github/last-commit/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT?style=for-the-badge&logo=git)](https://github.com/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT) 
[![GitHub stars](https://img.shields.io/github/stars/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT?style=for-the-badge)](https://github.com/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT/stargazers) 
[![GitHub forks](https://img.shields.io/github/forks/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT?style=for-the-badge&logo=git)](https://github.com/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT/network)
[![GitHub issues](https://img.shields.io/github/issues/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT?style=for-the-badge)](https://github.com/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT/issues)
[![GitHub stars](https://img.shields.io/github/stars/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT?style=for-the-badge)](https://github.com/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT?color=%230000ff&style=for-the-badge)](https://github.com/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT/network)
[![GitHub license](https://img.shields.io/github/license/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT?style=for-the-badge)](https://github.com/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT)

## Vision
To design and implement FlipFit Application (Gym Management System) where users can view gym centers and available slots, book and cancel slots. Gym owners can register their gyms, add slots, view bookings, etc. Admins can approve registration requests for gym owners, gym centers, and users.

## Purpose
FlipFit is designed to address the common challenges faced by gym facilities, including managing schedules, handling memberships, and maintaining efficient communication between users and staff. The system offers a user-friendly interface and robust features that facilitate the smooth operation of gym centers.

## Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Dropwizard](https://img.shields.io/badge/Dropwizard-4A90E2?style=for-the-badge&logo=dropwizard&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Spring Tool Suite](https://img.shields.io/badge/Spring_Tool_Suite-6DB33F?style=for-the-badge&logo=spring&logoColor=white)


## Development Approach
FlipFit is built using modern development practices to ensure scalability, maintainability, and ease of use. The project follows a modular approach, with clearly defined roles and responsibilities for each component.

## Features
### User
- View gym centers and available slots
- Book and cancel slots
### Gym Owner
- Register a gym
- Add slots for a gym
- View bookings
  
### Admin
- Approve registration requests for gym owners, gym centers. 

## Getting Started
- Prerequisites
- Java 17
- MySQL 
- Maven
- IDE (IntelliJ IDEA or STS)
- Postman

### How to commit in CLI

```sh
$ git clone https://github.com/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT.git
$ git checkout -b Branch_Name
$ git add .
$ git commit -m 'message'
$ git push -u origin Branch_Name

```

### How to sync your forked repository

```sh
$ git fetch --all --prune
$ git checkout master
$ git reset --hard upstream/master
$ git push origin master

```

## API Endpoints
### User Endpoints
- View Gym Centers: GET /user/gym-centers
- View Available Slots: GET /user/slots
- Book Slot: POST /user/book-slot
- Cancel Slot: DELETE /user/cancel-slot
### Gym Owner Endpoints
- Register Gym: POST /owner/register-gym
- Add Slots: POST /owner/add-slots
- View Bookings: GET /owner/view-bookings
### Admin Endpoints
- Approve Gym Owner: PUT /admin/approve-owner
- Approve Gym Center: PUT /admin/approve-gym-center
- Approve User: PUT /admin/approve-user
## Development Guidelines
- Code Style: Follow standard Java coding conventions.
- Documentation: Comment your code adequately and use JavaDocs for public methods.
- Version Control: Commit changes to a new branch and create pull requests for code reviews.
- Testing: Write unit tests for your code using JUnit and mock dependencies as necessary.
## Contribution Guidelines
- Fork the repository.
- Create a new feature branch.
- Make your changes.
- Commit and push your changes.
- Create a pull request.

## License
JEDI-FLIPKART-GROUP-C-FLIPFIT is released under the [MIT License](https://github.com/SampratiVishnoi/JEDI-FLIPKART-GROUP-C-FLIPFIT/blob/main/LICENSE)
