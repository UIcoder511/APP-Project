# APP-Project

### Dependencies
- Node.js v16.13.2 https://nodejs.org/en/
- 


> Follow below steps to run and test the system

---
### Backend:

1. To run backend APIs, go to the ```PARENT_DIRECTORY\APP-Project\backend``` and please up the tomcat server using the command in command line : 
```
mvn tomcat7:run
```

2. To check server is successfully started, make a request in browser: http://localhost:8080/photo-api/get-photographers-with-photos. User will be able to see some JSON response ( no need to bother about response). Please find the below screenshot for reference:
![image](https://user-images.githubusercontent.com/52369694/201550615-fab31c92-b3d9-4a44-9080-9899a1bedcb9.png)

---
### Frontend:
1. Run frontend on server using the command in command line :
```
npm install
npm start
```
2. Open any browser and open ```http://localhost:3000/```. You will be able to see below screen.
![image](https://user-images.githubusercontent.com/116931930/201552113-47e78f49-4164-4e2c-9ee2-aa78a78eb994.png)

---
### Testing:
1. Open command line in backend folder and run commands: 
```
mvn clean
```
--> this must should print BUILD SUCCESS message. Then run 
```
mvn install
```
--> this will run all the tests.

2. Tests are written using `Rest Assured` and `TestNG` tools in Java
3. To run test in IDE, you can use eclipse and install TestNG from eclipse marketplace. Once successfully installed, select the tests folder(src/test/java) on right click you should be able to see option to run tests as "TestNG tests".

In command line:
![image](https://user-images.githubusercontent.com/52369694/201550845-ff327544-dd37-479f-8e98-8c4e826e50a0.png)

In eclipse:
![image](https://user-images.githubusercontent.com/52369694/201550933-3a77cbed-ab85-4ad7-a7a4-31b8364d6e42.png)
