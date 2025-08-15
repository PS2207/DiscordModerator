Day1 Task Summary-
1)Generate the Project :
    *Go to Spring Initializr.
    *Create a new project named javafx-realtime-chat(or any other name).
    *Select dependencies like Spring Web, JavaFX, lombok, dev tools and any other you need.
    *Generate and download the project.
  
2)Open in IDE :
   *Open Eclipse.
   *Import the generated project as an Existing Maven Project.
  
3)Write the Code:
   *Start coding your chat application:
   *Create your JavaFX GUI for chat.
   *Set up Spring Boot controllers and WebSocket endpoints for real-time messaging.
  
4)Run the Application :
   *Run your Spring Boot application from Eclipse.
   *Ensure the server starts successfully.
  
5)Test in Multiple Browsers :
   *Open two or more browser windows/tabs.
   *Type the application URL (e.g., http://localhost:8081/chat.html) in each browser.
   *Use the chat interface to send messages between browsers, verifying real-time communication works.
   
/*
Right now server is probably accepting whatever the client sends as sender name.
That means someone could fake it (can change name everytime). so needs to modify it.
If you already have authentication, you can extract the username from the session/JWT instead of from the message body.
----------------------
so the username in messages to be secure and not fake-able, the correct flow is:
Register Page – user creates an account in your Spring Boot backend (stored in DB).
Login Page – user login and gets an authenticated session (Spring Security).
WebSocket Handshake – WebSocket connection is established after login, so principal.getName() in your ChatController will return the logged-in username automatically.
Send Messages – since the username comes from principal, no one can fake it in the client.
*/

*************************************************************************************************************************
Day2 Task Summary- 
1)Added two dependencies:
    Spring Data JPA
    MySQL Connector/J  (for database connectivity)
  
2)Added new Backend Java classes, & interfaces for user authentication system:
    UserHandshakeHandler.java (WebSocket handshake customization to pass user data)
    UserController.java (handles user registration/login)
    User.java (entity for storing user info)
    UserRepository.java (DB access layer)
    UserService.java & UserServiceImpl.java (business logic for users)

3)Added static HTML forms for frontend login/registration
    register.html
    login.html 

4)Updated existing files:
    WebSocketConfig to register UserHandshakeHandler for passing user details during WebSocket connection.
    chat.html to work with the login system and show the logged-in user’s name.

Darawback : No Username in Messages After Login    
*************************************************************************************************************************

Day3 Task Summary-

Fix Username Display Issue.

Secure password using BCrypt password when saving or checking: 
  Passwords are hashed using BCrypt when registering.
  Login checks use BCrypt password matching.

Enhance UI
  Show sender’s name, time, and colored bubbles.
  Highlight the logged-in user’s own messages.

Add Message History
   Save messages in a database (e.g., MySQL).
   When a new user connects, load recent messages.

Add Authentication to WebSocket
  Only allow logged-in users to connect.
  Use Spring Security or token-based auth for the WebSocket handshake.
  
Typing Indicators & Read Receipts
  Show “User is typing…” in real-time.
  Mark messages as read when viewed.















