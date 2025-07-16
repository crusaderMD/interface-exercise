package org.example.model.services;

public interface IOnlinePaymentService {

    Double paymentFee(Double amount);

    Double interest(Double amount, Integer months);
}
