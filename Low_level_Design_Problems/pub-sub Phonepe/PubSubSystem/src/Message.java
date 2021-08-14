public class Message {
    String regex;
    String payload;
    Message(String regex, String payload){
        this.regex = regex;
        this.payload = payload;
    }
    public String getRegex(){
        return regex;
    }
    public String getPayload(){
        return payload;
    }
}
