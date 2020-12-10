FROM node:latest as reactbuild

WORKDIR ./
COPY package.json package-lock.json ./
RUN npm install
COPY . ./  
EXPOSE 3000
CMD ["npm", "build"]


FROM nginx:latest as hostnginx

COPY --from=reactbuild ./ 





