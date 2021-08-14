import java.util.ArrayList;
import java.util.List;

public class ConsumerImpl implements Consumer {

    PubSubCommonService pubSubCommonService;
    String regex;
    List<Message> messageList;
    List<Consumer> predecessors;
    String name;

    public ConsumerImpl(PubSubCommonService pubSubCommonService, String regex, String name){
        this.pubSubCommonService = pubSubCommonService;
        this.regex = regex;
        this.messageList =  new ArrayList<>();
        predecessors = new ArrayList<>();
        this.name = name;
    }
    @Override
    public void register() {
        pubSubCommonService.addSubscriber(regex, this);
    }

    @Override
    public void deregister() {
        pubSubCommonService.removeSubscriber(regex, this);
    }

    @Override
    public List<Message> getMessages() {
        return messageList;
    }

    @Override
    public String getRegex() {
        return regex;
    }

    @Override
    public void addPredecessor(Consumer consumer) {
        predecessors.add(consumer);
    }

    @Override
    public boolean addMessageToList(Message message) {
        boolean success=true;
        if(messageList.contains(message)){
            return true;
        }else{
            for(Consumer predecessor: predecessors){
                success = success && predecessor.addMessageToList(message);
            }
            if(success && message.getRegex().equals(this.regex)) {
                System.out.println("Message added for consumer="+this.name);
                messageList.add(message);
            }
            return success;
        }
    }

    @Override
    public void printMessages() {
        System.out.println("Printing messages for consumer with name="+name);
        for(Message message : messageList){
            System.out.println(message.payload);
        }
    }

    @Override
    public void getAllMyMessages() {
        pubSubCommonService.downloadMessages(this);
        this.printMessages();
    }

    @Override
    public String getName() {
        return name;
    }
}
