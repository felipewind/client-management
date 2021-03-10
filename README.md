# client-management

One software to manage your clients. You can add, delete, edit and remove clients.

This is a study project, the objective is learning!

This project is divided in two main folders:
- [back-end](./back-end/README.md);
- [front-end](./front-end/README.md);

The back-end uses a PostgreSQL to persist the data.

# Running the project

## Running this project with the Docker Hub images

Install:
- [Docker](https://docs.docker.com/engine/install/);
- [Docker Compose](https://docs.docker.com/compose/install/);

Execute the script on the root folder:
```
./run-from-docker-hub.sh
```

## Building the project locally and then running it

Install:
- [Docker](https://docs.docker.com/engine/install/);
- [Docker Compose](https://docs.docker.com/compose/install/);
- Java;
- NPM - Node Package Manager;
- Angular;

Execute the script on the root folder:
```
./run-with-build.sh
```

After the first build, if you want to run it again without building it, just execute the script:
```
run-after-first-build.sh
```

## Running it locally in development mode

Install:
- Java;
- NPM - Node Package Manager;
- Angular;


Follow the instructions of the projects:
- [back-end](./back-end/README.md);
- [front-end](./front-end/README.md);

You need to start first the back-end.

