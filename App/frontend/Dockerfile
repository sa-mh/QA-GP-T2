FROM node:latest as reactbuild

COPY package.json package-lock.json ./

RUN npm install

EXPOSE 3000

CMD ["npm", "build"]

RUN npm install -g serve

ENTRYPOINT ["serve",  "-s", "build"]

##########################################


FROM nginx:latest as hostnginx

COPY --from=reactbuild . .

COPY ./nginx.conf /etc/nginx/nginx.conf

EXPOSE 80





