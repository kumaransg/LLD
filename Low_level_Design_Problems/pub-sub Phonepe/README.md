For phonePe SDE-2 interviews, Machine coding round is initial round for screening. Here, one low level design question is asked and that needs to be solved in duration of 2 hours. The solution developed must be correct, satisfying all mentioned requirements, applying object oriented design principles and running code needs to be submitted at end of interview.

I was asked to develop a message queueing system. Functional requirements of this system has been described below in detail.

Create your own queue that will hold messages in form of JSON. Standard library queues were not allowed.
There was one publisher that can generate messages.
There are mutiple suscribers that will listen messages satisfying a particular regex.
Suscribers should not be tighly coupled to system and can be added or removed at runtime.
When a suscriber is added to the system, it registers callback function along with it. And this callback function will be invoked in case some message arrives.
There can be dependency relationship among suscribers i.e if there are two suscribers say A and B and A knows that B has to listen and process first, then only A can listen and process. There was many to many dependency relationship among suscribers.
There must a retry mechanism for handling error cases when some exception occurs in listening/ processing messages, that must be retried.
All Object oriented design principles must be followed and requirements should be fulfilled. Design should be flexible and scalable.
Apart from this, on same day, one more interview of length 20 minutes was conducted to discuss the solution developed and analyse all the test cases for this system.

I am not very sure what went wrong while developing this solution. Already applied observer pattern to solve pub-sub registration/de-registration. Please let me know your solutions in comment section.

My solution github link : https://github.com/shecodes29/Design-interviews/tree/master/PubSubSystem
I am open to any review comments and further enhancements in design. Thanks.