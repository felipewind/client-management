FROM node:12.15.0

RUN mkdir -p /usr/src/front-end

COPY dist/front-end /usr/src/front-end/dist/front-end

COPY server.js /usr/src/front-end/server.js
COPY deploy-package.json /usr/src/front-end/package.json

WORKDIR /usr/src/front-end

RUN npm install

EXPOSE 80

CMD ["node", "server.js"]