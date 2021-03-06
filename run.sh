#!/bin/bash

printf "===== Executing Docker Compose with Build to start the application =====\n"
printf "\n"

printf "========== Building local Back-End Project with local Maven ============\n"
printf "\n"
cd back-end/
./mvnw package
cd ..
printf "\n"
printf "============ Back-end Project builded successfully by  Maven ===========\n"
printf "\n"

function ctrl_c() {
printf "\n"
printf '==========================================================================\n'
printf '============= EXECUTIN DOCKER COMPOSE DOWN AFTER CTRL+C ==================\n'
printf '==========================================================================\n'
printf "\n"
docker-compose -f ./docker-compose.yml down
exit
}
trap ctrl_c INT

docker-compose -f ./docker-compose.yml up --build

ctrl_c