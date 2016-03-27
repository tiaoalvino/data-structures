package net.datastructures.creditcard;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

	// Variáveis de instância:
	private String number;
	private String name;
	private String bank;
	private double balance;
	private int limit;

	// Construtor:
	public CreditCard(String number, String name, String bank, double balance, int limit) {
		this.number = number;
		this.name = name;
		this.bank = bank;
		this.balance = balance;
		this.limit = limit;
	}

	// Métodos de acesso:
	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getBank() {
		return bank;
	}

	public double getBalance() {
		return balance;
	}

	public int getLimit() {
		return limit;
	}

	// Métodos de ação:
	public boolean chargeIt(double price) {
		boolean hasLimit = false;
		// Debita
		if ((price + balance) < limit) {
			balance = balance + price;
			hasLimit = true;
		}
		return hasLimit;
	}

	public void makePayment(double payment) {
		// Faz um pagamento
		balance = balance - payment;
	}

	public static void printCard(CreditCard creditCard) {
		// Imprime informações sobre o cartão
		System.out.println("Number = " + creditCard.getNumber());
		System.out.println("Name = " + creditCard.getName());
		System.out.println("Bank = " + creditCard.getBank());
		// Conversão implícita
		System.out.println("Balance = " + creditCard.getBalance());
		System.out.println("Limit = " + creditCard.getLimit());
	}

	public static void main(String[] args) {
		List<CreditCard> wallet = new ArrayList<>();
		wallet.add(new CreditCard("5391 0375 9387 5309", "John Bowman", "California Savings", 0.0, 2500));
		wallet.add(new CreditCard("3485 0399 3395 1954", "John Bowman", "California Federal", 0.0, 3500));
		wallet.add(new CreditCard("6011 4902 3294 2994", "John Bowman", "California Finance", 0.0, 5000));
		for (int i = 1; i <= 16; i++) {
			wallet.get(0).chargeIt(i);
			wallet.get(1).chargeIt(2.0 * i); // Conversão implícita
			wallet.get(2).chargeIt((double) 3 * i); // Conversão explícita
		}
		for (CreditCard creditCard : wallet) {
			CreditCard.printCard(creditCard);
			while (creditCard.getBalance() > 100.0) {
				creditCard.makePayment(100.0);
				System.out.println("New balance = " + creditCard.getBalance());
			}
		}
	}
}
