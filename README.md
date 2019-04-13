# Fordham-Airlines
Airline App Inspired by my university, final application will include functional Client and Server Apps with GUIs


From 4/13/2019

App asks users for basic input and information on their upcoming flight. Hitting the reserve button allows the 
user to see their ticket information printed on the screen.

Some of the Java FX GUI controls utilized are Text Fields, a Text Area, Radio Buttons, Labels, DatePickers,
ComboBoxes and Buttons. 


![Completed Form](https://user-images.githubusercontent.com/38671335/56084245-4dcf0500-5dfe-11e9-9013-77215b9d863b.PNG)


Users form will go through validation and an AlertBox class allows a separate dialogue box to prompt the user of any errors.


![AlertBox example](https://user-images.githubusercontent.com/38671335/56084246-4dcf0500-5dfe-11e9-9907-3e62ee0f3cdd.PNG)


***Note from last merge:***
Users will go through some validations to verify their airline ticket. If data does not meet the requirements, a dialogue box will prompt the user to reenter their information. To name a few:

- Full Name must be longer than 3 characters
- The date you are leaving cannot be before today's date (Still haven't been able to fix conflict between return date being before depart date)
- You cannot leave and go to the same port

I cleaned up the GUI so images and controls don't overlap.

Important Note
Basic Simple Socket Server Support included as well. (GUI may crash if you dont currently have one of your own. 
Feel free to wait for mine :))

The main class includes some early socket server support, while our server app is still in the making, the client app here may crash without it, I suggest you comment it out before running.
(src\ClientApp.java : Lines 299-312)
