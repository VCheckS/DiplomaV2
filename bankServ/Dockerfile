FROM node:14

WORKDIR /bankServ

COPY package.json .
COPY package-lock.json .
COPY data.json .

RUN npm install

COPY . .

CMD ["npm", "start"]