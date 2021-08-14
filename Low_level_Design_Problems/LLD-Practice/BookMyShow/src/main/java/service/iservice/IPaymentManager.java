package service.iservice;

import model.User;

public interface IPaymentManager {
    Boolean doPayment(User user);
}
