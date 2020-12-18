# QA Cloud Native - Final Project - SFIA3
## Group 2

## Contents
* [Brief](#brief)
	* [Team](#team)
	* [Requirements](#requirenments)
* [Planning](#planning)
	* [Jira Board](#jira-board)
	* [Risk Assessment](#risk-asessment)
	* [Entity Relationship Diagram](#entity-relationship-diagram)
	* [Team Meetings](#team-meetings)
* [CI Pipeline](#ci-pipeline)
	* [Github](#github)
	* [Jenkins](#jenkins)
* [Testing](#testing)
	* [Unit Tests](#unit-tests)
	* [Integration Tests](#integration-tests)
* [Application Navigation](#application-navigation)
* [Acknowledgements](#acknowledgements)

## Brief
The final project within the QA Academy had required us to be split into groups and develop a Help Queue web application for use within QA. This application would showcase base CRUD functionality, allowing for users to create a help ticket and monitor its journey.
A ticket would have the following fields:
 * title
 * topic
 * description
 * urgency
 * time submitted
 <br>
 A user would create a ticket, this would then be entered into a filterable list, whereby the user would be able to filter and search by topic, keyword, urgency and time order.

 As well as the base functionality, we had also been required to implement two additional functions. For these, our group had chosen the following:
 * Implement a help queue per cohort, such that trainees can navigate to their cohort to see the help queue specific to their class.
 * Tickets should be tagged with a topic. This should allow users to filter tickets based on a topic.
 * Tickets can be marked with different levels of urgency.
 * Implement a search bar feature, so that users can filter tickets based on keywords.

The initial brief required us (within a team) to create a Help Queue web application for use in the Academy, which functions as a CRUD list, allowing users to create issues and for trainers to mark them as complete.

### Team Structure
* Sam Horner - AWS Infrastructure, Nexus Set-Up, Jenkins Pipeline + Build, Kubernetes
* Ramgith Jagajith - Front-end development, front-end functionality
* Sheraz Shahid - AWS Infrastructure (Terraform, Ansible), Docker containerisation, Jenkins Pipeline, Kubernetes
* Lewis Thomson - Front-end development, front-end functionality, front-end testing, back-end unit testing
* Lisandro Villarruel - Back-end development, back-end functionality, back-end integration testing


## Project Management & Planning
The project had been approached with Agile Methodology practises being followed. A scrum master had been assigned (Sheraz Shahid) and we had 3 sprints, each begining with a 'Start of Sprint' meeting and ending with a Sprint Review and Sprint Retrospecive (both outlined below).

### Jira Board
In order to break down the requirements, we had convereted these into user stories and then used them as product backlog items. Each backlog item was assigned story points (unanimously decided) and grouped by epics (functionality based). Product backlog items were then assigned to each sprint, therefore becoming part of the sprint backlog.
This project had entailed 3 sprints in its entirity, which the backlog items for each sprint devided by the group in the weekly 'Start of Sprint' meeting.

![jriabpard][jiraboard]

### Risk Assessment
In order to assess and minimise the chance of the project being impacted greatly by any external or internal threats, we had completed a Risk Assesment prior to starting the project. In doing so, this would allow for us to be prepared for potential threats and risks that we may face and therefore look to minimise and mitigate risks before they may arise.

![riskassessment][riskassessment]

### Entity Relationship Diagram
Below is the attached entity relationship diagram for the project. Originally we attempted a multi relational architecture with 4 tables (trainer, trainee, ticket, ticket_trainee); however, due to time constraints, we had then stripped this down to a single ticket table architecture. The table with all fields are as shown below:

![erd][erd]

### Team Meetings
Due to this project following agile methodology, there was a set procedure/guideline we would follow, alongside any additions we had added on our own accord. At the start of each sprint, we would hold a 'Start of Sprint' meeting in order to discuss the sprint backlog items and associate members to each item. Each sprint was concluded with a Sprint Review and Sprint Retrospective. A link to all the meeting minutes and retrospectives can be found as below:

## CI Pipeline
For this project, we had decided on and aimed towards the following architecture diagram:

![cipipe][cipipe]

As shown in the above diagram, we had decided upon ....

### Github

### Jenkins

![jenkinsci][jenkinsci]

## Testing

### Unit Tests

### Integration Tests

Integration testing was performed to verify that the system we created had the adequate behaviours and functionality. The many methods employed in this application were tested via jUnit5. Integration testing is a fundamental part of automated applications, and we managed to successfully achieve a coverage of ...

![apptests][apptests]

### Jest Testing

![jesttest][jesttest]

### User Design

## Outcome
Overall, we had been able to create, develop and deploy a functional Help Queue Application which incorporated the required functionality. In doing so, we showcased the skills learnt, including: java/spring development, react/html/javascript development, AWS cloud architecture and infrastructure. The functionality can be showcased within the application and the entire application is deployed via Kubernetes through a CI pipeline so that any changes made to the code (with any updates pushed to git) would trigger the build and deployement update.

Once run, the application can be accessed via the node cluster IP for the frontend, which would send data to the backend pod and the database.

## Future Improvements
As a group, we feel we managed the project as best we could however did hit many bumps along the way. If we were to complete this project again, there would be multiple areas of improvement as we are all collectively more knowledgable now than we had been when we started. The following would be our key areas of improvement on this project:

* Arrange for basic functionality and putting this through the pipeline, then adding features in a more organised manner
* Incorporate fully functional and secure login functionality as we had gotten most the way there yet hit bumps.
* Include NAT gateway and Bastion Host in order to access instances within private subnet 
* Improve functionality and user design to increase professional look


## Acknowledgements
We would like to acknowledge the contribution of our colleague Shaquille Rickets-Sesay and our trainers Jordan Harrision, Luke Benson, Savannah Vaithilingam, and Raji Kolluru for their continued support and direction throughout this group project. 

Trello : https://trello.com/b/C5f54Wkv/final-project-group-2 <br>
Jira Board: https://sshahid.atlassian.net/secure/RapidBoard.jspa?projectKey=GRP2&rapidView=5# <br>
Presentation: https://docs.google.com/presentation/d/1fCoc-SBS9Q4AhR2ujqA88gNCe8LzTho-nxHLKSiIheo/edit?usp=sharing <br>
Meeting Minutes: https://docs.google.com/document/d/13ec3HPhvutlPI8vnxUElQxeGXlUSlCxcmUcYQ8zwN2U/edit?usp=sharing <br>
Retrospective Meetings: https://docs.google.com/spreadsheets/d/1sreFU64bie0nRqOoTKejqML0XQxc4-_8SbXFbrQKbvs/edit?usp=sharing <br>

[jiraboard]: https://i.gyazo.com/99ec86602d2b217fb8fc3a91af10df64.png
[riskassessment]: https://i.gyazo.com/acb26d26611dcc8ff12be482e395a9bf.png
[erd]: https://i.gyazo.com/e453a59b8cf3b0afb10cd773a87aaa61.png
[cipipe]: https://i.gyazo.com/b76248ef0be868813a59b439c0613826.png
[jenkinsci]: https://i.gyazo.com/10f8f9cf8a2d293771a681e48f025939.png
[apptests]: https://i.gyazo.com/20ceafc050dcf217e3bf693b95411bcc.png
[jesttest]: https://i.gyazo.com/3deff2cf6e18982660cab74961972653.png
