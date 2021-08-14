# Low Level System Design - PubSub Messaging Queue

### Video Explanation
https://youtu.be/4BEzgPlLKTo

### Problem statement
[Check here](problem-statment.md)

### Project requirements
* JDK 1.8
* Maven

## APIs supported in queue
* createTopic(topicName) -> topicId
* subscribe(topicId, subscriber) -> boolean
* publish(topicId, message) -> boolean
* readOffset(topidId, subscriber, offset) -> boolean
