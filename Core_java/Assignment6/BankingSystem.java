package Assignment6;

class BankAccount {
	private int accountNumber;
	private double balance;

	public BankAccount(int accountNumber, double initialBalance) {
		this.accountNumber = accountNumber;
		this.balance = initialBalance;
	}

	public synchronized boolean deposit(double amount) {
		balance += amount;
		System.out.println("Deposit of " + amount + " successful for account " + accountNumber + ". New balance: " + balance);
		return true;
	}

	public synchronized boolean withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println("Withdrawal of " + amount + " successful for account " + accountNumber + ". New balance: " + balance);
			return true;
		} else {
			System.out.println("Insufficient funds in account " + accountNumber);
			return false;
		}
	}

	public int getAccountNumber() {
		return accountNumber;
	}
}

class Bank {
	private BankAccount[] accounts;
	private int size;

	public Bank(int capacity) {
		accounts = new BankAccount[capacity];
		size = 0;
	}

	public void addAccount(BankAccount account) {
		if (size < accounts.length) {
			accounts[size++] = account;
		}
	}

	public BankAccount getAccount(int accountNumber) {
		for (int i = 0; i < size; i++) {
			if (accounts[i].getAccountNumber() == accountNumber) {
				return accounts[i];
			}
		}
		return null;
	}
}

class DepositWindow implements Runnable {
	private Bank bank;

	public DepositWindow(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		while (true) {
			int accountNumber = (int) (Math.random() * 3) + 1; // Random account 1, 2, or 3
			double amount = Math.random() * 1000; // Random amount up to 1000
			BankAccount account = bank.getAccount(accountNumber);
			if (account != null) {
				account.deposit(amount);
				System.out.println("Deposit window: Deposited " + amount + " to account " + accountNumber);
			}
			try {
				Thread.sleep(1000); // Wait for 1 second before next operation
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class WithdrawalWindow implements Runnable {
	private Bank bank;

	public WithdrawalWindow(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		while (true) {
			int accountNumber = (int) (Math.random() * 3) + 1; // Random account 1, 2, or 3
			double amount = Math.random() * 500; // Random amount up to 500
			BankAccount account = bank.getAccount(accountNumber);
			if (account != null) {
				if (account.withdraw(amount)) {
					System.out.println("Withdrawal window: Withdrew " + amount + " from account " + accountNumber);
				}
			}
			try {
				Thread.sleep(1500); // Wait for 1.5 seconds before next operation
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class BankingSystem {
	public static void main(String[] args) {
		Bank bank = new Bank(3);
		bank.addAccount(new BankAccount(1, 1000));
		bank.addAccount(new BankAccount(2, 2000));
		bank.addAccount(new BankAccount(3, 3000));

		Thread depositThread = new Thread(new DepositWindow(bank));
		Thread withdrawalThread = new Thread(new WithdrawalWindow(bank));

		depositThread.start();
		withdrawalThread.start();
	}
}
