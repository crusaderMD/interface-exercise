package org.example.model.services;

import org.example.model.entities.Contract;
import org.example.model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private final IOnlinePaymentService paymentService;

    public ContractService(IOnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void  processContract(Contract contract, Integer months) {

       Double monthFixAmount = contract.getTotalValue() / months;

       for(int i = 1; i <= months; i++) {

           double result = monthFixAmount + paymentService.interest(monthFixAmount, i);
           double finalResult = result +  paymentService.paymentFee(result);

           LocalDate installmentDate = contract.getDate().plusMonths(i);

           contract.addInstallment(new Installment(installmentDate, finalResult));
       }
    }
}
