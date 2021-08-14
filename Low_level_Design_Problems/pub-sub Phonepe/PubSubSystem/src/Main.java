import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to message queuing system");
        PubSubCommonService pubSubCommonService = new PubSubCommonServiceImpl(2);
        Publisher publisher = new PublisherImpl(pubSubCommonService);
        Consumer consumer1 = new ConsumerImpl(pubSubCommonService, "a", "consumer1");
        Consumer consumer2 = new ConsumerImpl(pubSubCommonService, "a", "consumer2");
        Consumer consumer3 = new ConsumerImpl(pubSubCommonService, "b", "consumer3");

        consumer1.register();
        consumer2.register();
        //consumer3.register();

        consumer1.addPredecessor(consumer2);


        System.out.println("Sending message");
        Message message1 = new Message("a", "abcd");
        System.out.println(publisher.addToMessageQueue(message1));
       // System.out.println(publisher.addToMessageQueue(message1));
      //  System.out.println(publisher.addToMessageQueue(message1));

        consumer1.getAllMyMessages();

        System.out.println("Sending message");
        Message message2 = new Message("a", "efgh");
        publisher.addToMessageQueue(message2);
        consumer2.getAllMyMessages();

        System.out.println("Sending message");
        Message message3 = new Message("c", "xyz");
        publisher.addToMessageQueue(message3);
        consumer3.getAllMyMessages();
        String path = "/a/./../../c/";
        String[] stubs = path.split("/+");
        for (String s : stubs) {
            System.out.println(s);
        }
    }
}
