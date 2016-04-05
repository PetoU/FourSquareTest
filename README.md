# whitBread

This App shows Venues near your location as you type into search.

Technically, it's a standard architecture, with the UI layer, there is DataManager, which serves as a controller layer.
It could be divided more into Presentation and Network layer, but App of this kind of complexity with more structuring
would be overhead. There is usage of RxJava in order to wrap around GPS location request,
routing to http request and passing down response to subscribers on UI layer.

Developed and tested on Nexus 4.

Possible improvements:
- proper error handling from requests
- activity is portrait only, state management through native onSaveInstanceState, or through presentation layer
- empty in listView
- progressBar when waiting for longer requests
