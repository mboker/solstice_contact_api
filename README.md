# Installation and Setup
## Install postgres
Visit https://www.postgresql.org/download/ to find installation instructions for your operating system.

## Install Java 8

## Install Maven 3

## Create solstice postgres user
On a debian linux OS:  
```
    sudo su postgres
    psql postgres
    \password postgres
```  
Supply a password for postgres admin user  
```
    createuser --interactive --password solstice
    'Shall the new role be a superuser?'  n
    'Shall the new role be allowed to create databases?'  y
    'Shall the new role be allowed to create more new roles?'  n
```  
When prompted for password creation, enter `solstice`  
In /etc/postgresql/9.5/main/pg_hba.conf, find the line containing the comment,   
`# "local" is for Unix domain socket connections only`   
Change the next line to
`local   all             all                                     trust`  
Similarly, change the line under `# IPv4 local connections:` to   
`host    all             all             127.0.0.1/32            trust`  
Now, restart postgres with  
`sudo service postgresql restart`
    
## Build and run application
In terminal, navigate to root of project  
`cd contacts`    
Build project  
`mvn install`  
Run application  
`java -jar target/contacts-0.0.1-SNAPSHOT.jar`
    

# Using the API
## Creating a new contact
Make a POST request to `localhost:8080/contact/` with a JSON body like the following example
```
{
    "streetAddress": "123 ABC",
    "city": "Columbus",
    "state": "ohio",
    "emailAddress": "123@abc.com",
    "phoneNumber": "1231231234",
    "fullName": "Michael Boker"
}
```

## Updating an existing contact
Make a PUT request to `localhost:8080/contact/` with a JSON body like the following, where `id` is set to the id of the record being updated.
```
{
    "id": 1,
    "streetAddress": "123 ABC",
    "city": "Columbus",
    "state": "ohio",
    "emailAddress": "123@abc.com",
    "phoneNumber": "1231231234",
    "fullName": "Michael D Boker"
}
```

## Deleting an existing contact
Make a DELETE request to `localhost:8080/contact/<ID>` replacing `<ID>` with the ID of the record to be deleted

## Retrieving a contact
### By ID
Make a GET request to `localhost:8080/contact/<ID>` replacing `<ID>` with the ID of the record to be retrieved.  This returns a single record, if it exists, otherwise it returns an empty body.
### By Email
Make a GET request to `localhost:8080/contact/email/<EMAIL>` replacing `<EMAIL>` with the email address of the record to be retrieved.  This returns an array of records matching the email address, as there is no uniqueness constraint on the email column.  If none are found, an empty body is returned.
### By Phone
Make a GET request to `localhost:8080/contact/email/<PHONE>` replacing `<PHONE>` with the phone number of the record to be retrieved. This returns an array of records matching the phone number, as there is no uniqueness constraint on the phone column.  If none are found, an empty body is returned.
### By City
Make a GET request to `localhost:8080/contact/city/<CITY>` replacing `<CITY>` with the name of the city to search for.  This returns an array of records matching the city, or an empty body if none are found.
### By State
Make a GET request to `localhost:8080/contact/state/<STATE>` replacing `<STATE>` with the name of the state to search for.  This returns an array of records matching the state, or an empty body if none are found.

