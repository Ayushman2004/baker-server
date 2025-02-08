# Baker: C/C++ Package Manager

Baker is a lightweight and efficient package manager for C/C++ libraries. It simplifies the process of downloading, managing, and linking libraries in C/C++ projects. The system consists of two primary components:

1. **Baker Client:** A C++ application designed to efficiently handle package management on the client side.
2. **Baker Server:** A Java-based backend built using Spring Boot, providing scalable and stable package hosting and management.

---

## Baker Server

### Overview
The Baker Server is a scalable backend service built using Java and Spring Boot. It manages package data and serves client requests for downloading and storing libraries.

### Key Features
- **Scalability and Stability:** Built with Java and Spring Boot to leverage a robust web development framework.
- **MongoDB Integration:** Utilizes MongoDB for data storage.
- **GridFS Support:** Efficiently stores library files in MongoDB.

### Installation
#### Prerequisites
- Java 17 or higher
- Maven
- MongoDB

#### Build and Run Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/Ayushman2004/baker-server.git
   cd baker-server
   ```

2. Build the server:
   ```bash
   mvn clean package
   ```

3. Run the server:
   ```bash
   java -jar target/baker-server.jar
   ```

### API Endpoints
- **Download Package_info:**
  ```http
  GET /get-pkg_info/{name}
  ```
- **Download File:**
  ```http
  GET /down-pkg/{name}
  ```

### Database Configuration
- MongoDB is required for the Baker Server.
- GridFS is used to store package files efficiently.

---

## License
This project is licensed under the Apache-2.0 License.

