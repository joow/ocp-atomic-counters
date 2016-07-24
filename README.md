# Atomic Counters

Simple Web API to get atomic counters.  
The only offered feature yet is to increment the current value of a counter and get the current value.  
If the counter doesn't exist yet it is created, incremented and the current value is returned (1).

## Run

You can deploy the application on Heroku, but be aware that when your app is restarted all counters will be lost.  
By default the port 4567 is used to run the app, you can customize this by defining the `PORT` variable.

## Use

    http POST <host>/<counter>
    curl -XPOST <host>/<counter>

to create the counter `counter` if needed, increment it and get the current value.