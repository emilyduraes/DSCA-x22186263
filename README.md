# Distributed Systems Continuous Assessment Project

**Course**: Higher Diploma in Science in Computing Information - National College of Ireland

**Subject**: Distributed Systems

**Lecturer**: Giovani Estrada

---
### Project domain: Smart Health System
This system aims to give its user an holistic approach to their health, connecting their doctors with all data necessary for a healthy way of living. 

###Services description:
**Patient Registration Service (Unary API)**: Allow patients to register with the system by sending their personal information, medical history, and contact details through a unary API call.
- **Request**: the patients personal information.
- **Response**: the patients data.
- **Methods**:
  - register(Patient data): creates a new patient;

**Real-time Monitoring Service (Server Streaming API)**: Stream vital signs data (such as heart rate, blood pressure and temperature) from wearable devices to the server, enabling real-time monitoring of patients' health conditions.
- **Request**: no request, the service gets the data from the wearable devices.
- **Response**: the API notify the client about their vital signs data during the day.
- **Methods**:
  - getVitalSigns(): returns the patients vital signs;

**Health Behavior Logging Service (Client Streaming API)**: Enable patients to log their daily activities, exercise routines, or dietary habits using a client streaming API, which helps healthcare providers assess lifestyle choices.
- **Request**: the client is able to record the exercises done during the their day.
- **Response**: no response needed.
- **Methods**:
  - registerExercise(Exercise exercise): register the clients exercise data (such as type, time exercising and date);

**Collaborative Diagnosis Service (Bidirectional Streaming API)**: Support collaborative diagnosis sessions where multiple healthcare providers can simultaneously view patient data, discuss the case, and share insights in real time.
- **Request**: the patients data is sent to the server by different healthcare providers.
- **Response**: the patients data.
- **Methods**:
  - getDiagnosis(Diagnosis diagnosis): inserts the patients new diagnosis into the system, giving information like diagnosis and health provider.;