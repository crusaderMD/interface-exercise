# Contract Payment Processor

This project is a simple Java application that demonstrates how to process a contract with multiple installments, applying interest and payment fees using a payment service (in this case, a simulated PayPal service).

---

## 📜 Overview

The application allows the user to:
- Input contract details (number, date, total value)
- Specify the number of installments
- Automatically calculate the due date and amount for each installment, considering interest and payment fees

The logic is modular, following basic OOP principles with entities (`Contract`, `Installment`) and services (`ContractService`, `PaypalService`).

---

## 📂 Project Structure

```bash
org.example
 ├── Main.java
 └── model
      ├── entities
      │    ├── Contract.java
      │    ├── Installment.java
      └── services
           ├── ContractService.java
           ├── IOnlinePaymentService.java
           └── PaypalService.java
```
---

## 🧩 Classes

### ✅ `Main`

- Entry point of the application.
- Reads user input (contract data and number of installments).
- Calls `ContractService` to process the contract.
- Outputs the generated installments with due dates and amounts.

### ✅ `Contract`

- Represents a contract with:
  - `number` (ID)
  - `date` (contract date)
  - `totalValue` (total contract value)
  - A list of `Installment` objects.

### ✅ `Installment`

- Represents an individual installment:
  - `dueDate` (date when the installment is due)
  - `amount` (amount to be paid)

### ✅ `ContractService`

- Contains the business logic to process a contract.
- Uses an `IOnlinePaymentService` implementation to:
  - Calculate monthly interest
  - Add a payment fee
- Generates the installments and adds them to the contract.

### ✅ `IOnlinePaymentService`

- Interface that defines:
  - `interest()`: calculates interest based on amount and months
  - `paymentFee()`: calculates the payment fee

### ✅ `PaypalService`

- Implements `IOnlinePaymentService`.
- Uses:
  - 1% monthly interest per installment.
  - 2% payment fee on each installment amount.

---

## ⚙️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/crusaderMD/interface-exercise

2. Open the project in your favorite IDE.

3. Compile and run Main.java.

4. Follow the console instructions:

- Enter contract number, date (dd/MM/yyyy), total value.

- Enter the number of installments.

- The application will display the calculated installments.

## ✅ Example Output

```bash
Enter contract data:
Number: 1234
Date (dd/MM/yyyy): 25/07/2025
Contract value: 600.00
Enter number of installments: 3

Installments:
25/08/2025 - 206.04
25/09/2025 - 208.08
25/10/2025 - 210.12

