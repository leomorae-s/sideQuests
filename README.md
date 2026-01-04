# sideQuests
App for controll the daily repetitive tasks, helping the user to fight against he's procrastination.

## Resume

The app is a simple web system made using the **MVC** architecture, using **Spring framework** with **Thymeleaf** template engine and **Postgres** to persist data.
The app should give the users a way to controll the execution of they daily tasks and keep the controll of it.

## Stacks

1. Java 21
2. Spring framework 7.0.2
3. Thymeleaf latest
4. Tailwind css
5. Postgres 17
6. Maven

## User's storys

1. The user should be able to create an account
2. The user should be able to log-in his account
3. The user should be able to add tasks that his execute daily
4. The user should be able to mark tasks as concluded
5. The user should be able to delete tasks that he didn't execute anymore

## Non functional requirements
1. The app must restart the status of all tasks at midnight for the daily controll
2. The app must use the correct HTTP status code
3. The app must have friendly error messages and pages
4. The app must have consistent U.I
5. The app must have logs regitring all the user actions

## Next steps
1. Create project code base
2. Modeling the database
3. Configure Spring dependencies
4. Create Github issues and kanban

## Roadmap

### MVC:
1. satisfy all user's story and non functional requirements

### Post-MVC:
1. Consider adding a more robust authentication
2. Consider adding Oauth2  login
3. Consider addin email triggers for password recover and remiders
4. Condiser adding documentation with swagger

## Miscelaneus

### Why Spring framework and not Spring boot?
This a simple project just for my personal use, almost all the apps made today uses spring boot and a lot of abstraction tools.
I want this project to be as challenging as a no framework project,
