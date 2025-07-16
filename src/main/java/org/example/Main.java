package org.example;

import org.example.model.entities.Contract;
import org.example.model.entities.Installment;
import org.example.model.services.ContractService;
import org.example.model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato:");
        System.out.print("Numero: ");
        int contractNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate contractDate = LocalDate.parse(sc.nextLine(),fmt);
        System.out.print("Valor do contrato: ");
        double contractTotalAmount = sc.nextDouble();

        System.out.print("Entre com o numero de parcelas: ");
        int installmentsNumber = sc.nextInt();

        Contract contract = new Contract(contractNumber, contractDate, contractTotalAmount);

        ContractService cs = new ContractService(new PaypalService());

        cs.processContract(contract, installmentsNumber);

        System.out.println("Parcelas:");

        for(Installment installment : contract.getInstallments()) {
            System.out.println(installment.getDueDate().format(fmt) + " - " + String.format("%.2f", installment.getAmount()));
        }

        sc.close();
    }
}