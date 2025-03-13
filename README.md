# 🚀 Spring Boot + Redis Demo  

A simple **Spring Boot** application demonstrating how to use **Redis** for:  
✅ **Caching** – Improve performance with in-memory storage  
✅ **Session Management** – Maintain user sessions across distributed systems  
✅ **Real-time Messaging (Pub/Sub)** – Publish and subscribe to Redis channels  

---

## 📌 Features  
- **Redis Hashes** – Store structured data efficiently  
- **Redis Pub/Sub** – Implement real-time communication  
- **Redis-backed Sessions** – Secure authentication with auto-expiry  

---

## 🛠️ Prerequisites  
Before running this project, make sure you have:  
- **Java 17+** installed  
- **Spring Boot 3+**  
- **Redis installed & running** (`redis-server`)  

---

## 📥 Installation & Setup  

### **1️⃣ Clone the Repository**  
```sh
git clone https://github.com/YOUR_USERNAME/redis-demo.git
cd redis-demo
2️⃣ Start Redis Server
If Redis is installed locally, start it using:

redis-server
If you're using Docker, run:
docker run --name redis -p 6379:6379 -d redis
3️⃣ Run the Spring Boot Application
sh
Copy
Edit
mvn spring-boot:run
🔥 API Endpoints
🔹 Store Data in Redis Hashes
POST /user – Save a new user


{
  "id": "1",
  "name": "John Doe",
  "email": "john@example.com"
}
GET /user/{id} – Retrieve user details

🔹 Redis Pub/Sub – Real-time Messaging
Subscribe to a Channel:

redis-cli SUBSCRIBE chat
Publish a Message to the Channel:


redis-cli PUBLISH chat "Hello, Redis!"
🔹 Redis-backed Sessions
POST /session/create – Create a session


{
  "username": "john_doe"
}
GET /session/get – Retrieve session details

{
  "username": "john_doe",
  "sessionId": "xyz123"
}
DELETE /session/logout – Destroy session

⏳ If a user doesn’t log out, their session automatically expires after 30 minutes.

📚 Technologies Used
Spring Boot 3+
Spring Data Redis
Redis
Docker (Optional)
💡 Use Cases
Redis is widely used for:
🔹 Caching – Improve response times & reduce DB load
🔹 Session Management – Track user sessions efficiently
🔹 Real-time Messaging – Build chat applications, notifications, live updates
🔹 Rate Limiting – Prevent API abuse in distributed systems

🤝 Contributing
Feel free to fork this repository and submit a pull request! 🚀
