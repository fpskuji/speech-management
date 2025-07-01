# Speech Management Backend Application

This is a backend application designed to manage speeches. 

It allows retrieval, creation, modification, and deletion of speech data, as well as sending speeches via email to recipients. 

It is built with Java 17, Spring Boot 3.5.3, and utilizes various dependencies like H2, MapStruct, and Lombok.

## Base URL
localhost:9696/speech


## Endpoints

### 1. Retrieve All Speeches

**Endpoint:** `/retrieveAll`  
**HTTP Method:** GET  
**Description:** Retrieves all speeches in the database.  
**Response:** Returns a list of all speeches.

---

### 2. Retrieve Speech By Author

**Endpoint:** `/retrieveByAuthor?author=`  
**HTTP Method:** GET  
**Description:** Retrieves all speeches written by the specified author.  
**Request Parameter:**
- `author`: (required) The name of the author.
  **Response:** Returns a list of speeches matching the given author.

---

### 3. Retrieve Speech By Subject

**Endpoint:** `/retrieveBySubject?subject=`  
**HTTP Method:** GET  
**Description:** Retrieves all speeches related to the specified subject.  
**Request Parameter:**
- `subject`: (required) The subject of the speech.
  **Response:** Returns a list of speeches matching the given subject.

---

### 4. Retrieve Speech By Date Range

**Endpoint:** `/retrieveByDate?startDate=&endDate=`  
**HTTP Method:** GET  
**Description:** Retrieves all speeches within the specified date range.  
**Request Parameters:**
- `startDate`: (required) The start date of the date range.
- `endDate`: (required) The end date of the date range.
  **Response:** Returns a list of speeches matching the date range.

---

### 5. Create Speech

**Endpoint:** `/createSpeech`  
**HTTP Method:** POST  
**Description:** Creates a new speech in the system.  
**Request Body:** A `SpeechDTO` object with the speech details.  
**Response:** Returns the created speech.

**Sample `SpeechDTO` Request Body:**

```json
{
  "author": "Test",
  "subject": "Test",
  "content": "Test",
  "speechDate": "2025-04-07"
}
```
---

### 6. Update Speech

**Endpoint:** `/updateSpeech/{speechId}`  
**HTTP Method:** PUT  
**Description:** Updates the details of an existing speech.  
**Path Variable:**
- `speechId`: The ID of the speech to be updated.  
  **Request Body:** A `SpeechDTO` object with the updated speech details.  
  **Response:** Returns the updated speech.

---

### 7. Delete Speech

**Endpoint:** `/deleteSpeech/{speechId}`  
**HTTP Method:** DELETE  
**Description:** Deletes a speech from the system.  
**Path Variable:**
- `speechId`: The ID of the speech to be deleted.  
  **Response:** Returns a message indicating if the deletion was successful or not.

---

### 8. Send Speech via Email

**Endpoint:** `/sendSpeech/{speechId}?recipient=`  
**HTTP Method:** POST  
**Description:** Sends the speech as an email to the specified recipient.  
**Path Variable:**
- `speechId`: The ID of the speech to be sent.  
  **Request Parameters:**
- `recipient`: (required) The email address of the recipient.
 
  **Response:** Returns a message indicating whether the email was sent successfully or not.

---

## Technologies Used

- **Java 17**: The backend code is developed using Java 17.
- **Spring Boot 3.5.3**: Framework used to build the backend.
- **Gradle**: Build tool for managing dependencies and project structure.
- **H2 Database**: In-memory database for storing speech data.
- **MapStruct**: For mapping between entities and DTOs.
- **Lombok**: For generating constructors, getters, setters.
- **Spring Boot Starter Mail**: For sending emails with the speech content.
- **JUnit**: For unit testing the backend functionality.

## Running the Application

To run the application, make sure you have Java 17 and Gradle installed. You can start the backend by running:

### Option 1: Using Gradle

```bash
./gradlew bootRun
```
### Option 2: Run the jar file

```bash
java -jar .\build\libs\speechmanagementsystem-0.0.1-SNAPSHOT.jar

```