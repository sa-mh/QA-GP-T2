FROM node:latest as reactbuild

COPY package.json package-lock.json ./

RUN npm install

EXPOSE 3000

CMD ["npm", "build"]

RUN npm install -g serve

ENTRYPOINT ["serve",  "-g", "build"]

##########################################
COPY . .

FROM nginx:latest as hostnginx

COPY nginx.conf /etc/nginx/nginx.conf

EXPOSE 80





