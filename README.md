# Referrers Tracking

## Instructions
1. Build with `mvn install`
* Start a Postgresql database named `referrers` at `localhost:5432`. Username/password should be `postgres/postgres`. DB connection settings can be customized in `referrers.yml`.
* Run `java -jar ./target/referrers-1.0.0-SNAPSHOT.jar db migrate referrers.yml` to setup the database.
* Run `java -jar ./target/referrers-1.0.0-SNAPSHOT.jar server referrers.yml` to start the server.
* Visit `localhost:8080/application` to see the UI.

## API

### POST /application/api/referrers
Add a new referrer entry.

* Request
  * Content-Type: `application/json`

      ```
      {
        "url" : "http://www.example.com/blahblah" // a full url including protocol
      }
      ```
* Response: `200 OK`
  * Content-Type: `application/json`
  
      ```
      {
        "domain" : "www.example.com", // the domain of the submitted url
        "sightings" : 10 // the number of times this domain has been submitted
      }
      ```
* Response: `400 Bad Request`

  If the given url is malformed.

### GET /referrers/top-three
Get the top three referring domains by the number of sightings.

* Response: `200 OK`
  * Content-Type: `application/json`

      ```
      {
        "referrers" : [
          {
            "domain" : "www.example.com",
            "sightings" : 10
          },
          ...
          ]
      }
      ```
