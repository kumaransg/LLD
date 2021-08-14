package ProducerConsumerPatternUsingBlockingQueue;

public class Message {

    int id;
    String content;

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
