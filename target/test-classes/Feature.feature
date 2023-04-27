Feature: To validate the login funtionality 
Scenario: To validate login with wrong username and password
Given  To launch the chrome browser
When To launch the facebook page
And To pass the data to the username and password
And To click the login button
Then To close the browser

Scenario Outline:To validate the login Funtionality of the eamil
Given to launch the browser
When to launch the email 
And to pass the data "<username>"
Then close the browser

Examples:
            |username|
            |pravinrk33@gmail.com|
            |abcd1234@gmail.com|
            |iamprobot|
            |Chennai|