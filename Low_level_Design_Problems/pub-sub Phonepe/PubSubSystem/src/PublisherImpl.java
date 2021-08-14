public class PublisherImpl implements Publisher{
    PubSubCommonService pubSubCommonService;

    public PublisherImpl(PubSubCommonService pubSubCommonService){
        this.pubSubCommonService = pubSubCommonService;
    }

    @Override
    public boolean addToMessageQueue(Message message){
        int retries = 3, count=0;
        boolean isSuccess=false;
        while(count<retries && !isSuccess){
            isSuccess = pubSubCommonService.addToMessageQueue(message);
            count++;
        }
        return isSuccess;
    }
}
