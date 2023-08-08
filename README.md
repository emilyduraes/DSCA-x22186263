# Distributed Systems Continuous Assessment Project

**Course**: Higher Diploma in Science in Computing Information - National College of Ireland

**Subject**: Distributed Systems

**Lecturer**: Giovani Estrada

---
### Project domain: Smart Health System
This system aims to give its user an holistic approach to their health, connecting their doctors with all data necessary for a healthy way of living. Below, a diagram to describe how the project architecture is designed.


###Services description:
**Authentication Service (Unary API)**: Takes care of the security of the system, allowing only authenticated users to view data.
- **Request**: the data sent in the request must be the username and password. If it is a new user, must create a new login/password to the system.
- **Response**: given the correct username and password combination, it returns the token for access in the other APIs.
- **Methods**:
  - signup(): creates a new user,
  - login(): authenticates the user,
  - logout(): finishes user section;

**Patient Registration Service (Unary API)**: Allow patients to register with the system by sending their personal information, medical history, and contact details through a unary API call.
- **Request**: the patients medical and personal information.
- **Response**: the patients data.
- **Methods**:
  - register(Patient data): creates a new patient;
  - delete(int id): deletes a patient according to their id number;
  - update(int id, Patient data): updates a patient data according to their id number;
  - getPatient(int id): returns the patients data according to their id number;
  - getPatient(String name): returns the patients data according to their name;

**Real-time Monitoring Service (Server Streaming API)**: Stream vital signs data (such as heart rate, blood pressure, and temperature) from wearable devices to the server, enabling real-time monitoring of patients' health conditions.
- **Request**: no request, the service gets the data from the wearable devices.
- **Response**: the API notify the client about their vital signs data during the day.
- **Methods**:
  - getVitalSigns(): returns the patients vital signs;
  - notify(): gives a notification to the client;

**Health Behavior Logging Service (Client Streaming API)**: Enable patients to log their daily activities, exercise routines, or dietary habits using a client streaming API, which helps healthcare providers assess lifestyle choices.
- **Request**: the client is able to record the exercises done during the their day.
- **Response**: no response needed.
- **Methods**:
  - registerExercise(Exercise[] exercises, Datetime? date): register the clients exercise and date;
  - updateExercise(int id, Exercise exercise): updates an exercise according to its id number;
  - deleteExercise(int id): deletes an exercise according to its id number;
  - view(int? id): view an exercise according to its id number;

**Collaborative Diagnosis Service (Bidirectional Streaming API)**: Support collaborative diagnosis sessions where multiple healthcare providers can simultaneously view patient data, discuss the case, and share insights in real time.
- **Request**: the patients data is sent to the server by different healthcare providers.
- **Response**: the patients data.
- **Methods**:
  - insert(Patient data): inserts the patients new data into the system;
  - view(int? id): view one or all patients data;
  - update(int id, Patient data): updates the patients data according to its id;
  - delete (int id): deletes patient data according to its id;
