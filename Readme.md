# One to one chat with Sprint boot and redis. 

This works in cluster environment as well where client can be connected to arbitrary server. 

It can be also used to other purposes such as notifications

## Running Redis Locally

To get started with this project, you'll need to launch a Redis server locally. You can do this by running the following command:

```
docker run -d --name redis-stack -p 6379:6379 -p 8001:8001 redis/redis-stack:latest
```

Ensure that Redis is running on the default localhost address and port 6379. If you need to modify the Redis connection settings, you can do so in the `Publisher.java` and `Subscriber.java` files.

## Launching the Application

1. Once Redis is up and running, you can proceed to launch the application on your local machine.

2. **Build the Application**: To run the Spring Boot application, you'll need to follow these steps:

   Before launching the Spring Boot application, make sure you have Maven installed on your system. Open a terminal or command prompt and navigate to the project's root directory (where the `pom.xml` file is located). Then, execute the following Maven command to build the application:

   ```
   mvn clean install
   ```

   This command will download dependencies, compile the code, and package the application.

3. **Run the Application**:

   After a successful build, you can run the Spring Boot application using the following command:

   ```
   mvn spring-boot:run
   ```

   This will start the application, and it will be accessible at the default port (usually 8080).

   4. **Open the Browser Console and Start Chat**:

      * Once the Spring Boot application is running, follow the steps mentioned earlier to open the browser console and start a chat session by executing the provided JavaScript code. 
      * Open your preferred web browser and navigate to the application. 
      * Access the browser console, typically by right-clicking on the webpage and selecting "Inspect" or "Open Developer Tools," then navigating to the "Console" tab. 
      * Start a chat session by executing the following JavaScript code in the console:
           ```javascript
           let ws = new WebSocket('ws://localhost:8080/user/channelId');
           ws.onmessage = message => {
             console.log(message.data);
           }
           ws.send("receiverId->Hi");
           ```

This will establish a WebSocket connection to the specified URL and allow you to send and receive messages within the application. Enjoy your chat experience!
