## ----Perform this operation in src/main/resource----

## Add your password and username by encoding it  in base64

### Create a file mysql-root-credentials.yml and copy paste it.

    apiVersion: v1
    kind: Secret
    metadata: 
        name: db-root-credentials 
    data: 
    password: #your base64 encoded password
    


### Create a file mysql-credentials.yml and copy paste it.

    apiVersion: v1 
    kind: Secret 
    metadata: 
        name: db-credentials 
    data: 
        username: #your base64 encoded username
        password: #your base64 encoded password
