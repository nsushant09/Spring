** In src/main/resource

* Create a file mysql-root-credentials.yml

apiVersion: v1
kind: Secret
metadata: 
    name: db-root-credentials 
data: 
    password: #your base64 encoded password

* Create a file mysql-credentials.yml

apiVersion: v1 
kind: Secret 
metadata: 
    name: db-credentials 
data: 
    username: #your base64 encoded username
    password: #your base64 encoded password