FROM node:latest as reactbuild

COPY package.json ./

RUN npm install

EXPOSE 3000

CMD ["npm", "run", "build"]

RUN npm install -g serve

ENTRYPOINT ["serve",  "-s", "build"]

##########################################

FROM nginx:latest as hostnginx

#Copy static files from the build folder from the first stage
COPY --from=reactbuild ./build .

# Overwriting the /etc/nginx/nginx.conf with the existing nginx.conf
COPY ./nginx.conf /etc/nginx/nginx.conf

EXPOSE 80
