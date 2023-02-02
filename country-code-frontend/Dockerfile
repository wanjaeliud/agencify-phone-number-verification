# Build stage
FROM node:latest as builder
COPY ./ /usr/src/
WORKDIR /usr/src
RUN npm install
RUN npm run ng build --prod

# Compiled app based on nginx
FROM nginx:alpine
COPY --from=build-stage /usr/src/dist/country-code-frontend/ /usr/share/nginx/html
COPY /nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 1827
