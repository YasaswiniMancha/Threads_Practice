package com.example.synchrornizedKeywordInThreads.example1;

public class WithdrawThread extends Thread {
	
    int withDrawAmount; 
	private BankAccount account;
    
	public WithdrawThread(BankAccount account, int withDrawAmount) {
        this.account = account;
        this.withDrawAmount = withDrawAmount;
    }

	@Override
	public void run() {
		account.withdraw(withDrawAmount);
		
	}

}
