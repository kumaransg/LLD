package service;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.iservice.IPaymentManager;

public class PaymentManager implements IPaymentManager {
    private Logger logger= LoggerFactory.getLogger(PaymentManager.class);

    @Override
    public Boolean doPayment(User user) {
        logger.info("Starting payment for user: ",user);

        int num= (int)Math.floor(Math.random()*100 +1);

        //replicate slow payment
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Fail payment 10% of the time
        if(num<90) {
            logger.info("Payment successful for user: ",user);
            return true;
        }

        logger.error("Payment unsuccessful for user",user);
        return false;
    }
}
