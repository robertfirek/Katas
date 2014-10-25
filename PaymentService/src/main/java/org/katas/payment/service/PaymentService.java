package org.katas.payment.service;

import org.katas.payment.gateway.PaymentDetails;
import org.katas.payment.gateway.PaymentGateway;
import org.katas.payment.repository.users.User;
import org.katas.payment.repository.users.UserRepository;
import org.katas.payment.repository.users.exceptions.UserDoesNotExistException;

public class PaymentService {

    private final PaymentGateway paymentGateway;
    private final UserRepository userRepository;

    public PaymentService(PaymentGateway paymentGateway,UserRepository userRepository) {
        this.paymentGateway = paymentGateway;
        this.userRepository = userRepository;
    }
    public void processPayment(User user, PaymentDetails paymentDetails) throws UserDoesNotExistException {
        if (!userRepository.doesUserExist(user)) {
            throw new UserDoesNotExistException();
        }
        paymentGateway.process(paymentDetails);
    }
}
