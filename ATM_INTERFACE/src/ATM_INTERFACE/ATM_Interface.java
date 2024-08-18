package ATM_INTERFACE;

import java.util.Scanner;

class BankAccount{
	
	int Pin;
	String name;
	String userName;
	String password;
	int accountNo;
	float balance = 100000f;
	int transactions = 0;
	String transactionHistory = "";
	
	
	
	
	public int getPin() {
		return Pin;
	}
	public void setPin(int pin) {
		Pin = pin;
	}
	
	
	
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter your Name: ");
		this.name = sc.nextLine();
		System.out.println("\nEnter your Username: ");
		this.userName = sc.nextLine();
		System.out.println("\nEnter your Password: ");
		this.password = sc.nextLine();
		System.out.println("\nEnter your Account Number: ");
		this.accountNo = sc.nextInt();
		System.out.println("\nRegistration Successful. Please Log in to your Bank Account");
	}
	public boolean login() {
		boolean isLogin = false;
		Scanner sc=new Scanner(System.in);
		while( !isLogin) {
			System.out.println("\nEnter your username: ");
			String Username = sc.nextLine();
			if (Username.equals(userName)) {
				while(!isLogin) {
					System.out.println("\nEnter your password: ");
					String Password = sc.nextLine();
					if(Password.equals(password)) {
						System.out.println("\nLogin Successful");
						isLogin = true;
						generatePin();
					}
					else {
						System.out.println("\nIncorrect Password");
					}
				}
			}else {
				System.out.println("\nUsername not found");
			}
		}
		return isLogin;
	}
	
	public void withdraw() {
		System.out.println("\nEnter Amount to Withdraw: ");
		Scanner sc=new Scanner(System.in); 
		float amount = sc.nextFloat();
		try {
			System.out.println("\nENTER 4 DIGIT PIN");
			int pin = sc.nextInt();
			if(getPin() == pin) {
				if(balance >= amount) {
					transactions++;
					balance -= amount;
					System.out.println("\nWithdral Successful.");
					String str = amount + "Rs Withdrawn\n";
					transactionHistory = transactionHistory.concat(str);
				}else {
					System.out.println("\nInsufficient Balance.");
				}
				
			}else {
				System.out.println("\n\nINCORRECT PIN ");
				withdraw();
			}
			
		}catch(Exception e) {
			
		}
		
	}
	
	public void deposit() {
		System.out.println("\nEnter Amount to Deposit: ");
		Scanner sc=new Scanner(System.in); 
		float amount = sc.nextFloat();
		try {
			System.out.println("\nENTER 4 DIGIT PIN");
			int pin = sc.nextInt();
			if(getPin() == pin) {
				if(amount <= 100000f) {
					transactions++;
					balance += amount;
					System.out.println("\nDeposit Successful.");
					String str = amount + "Rs deposited\n";
					transactionHistory = transactionHistory.concat(str);
				}else {
					System.out.println("\nSorry. The limit is 10000.");
				}
				
			}else {
				System.out.println("\n\nINCORRECT PIN ");
				deposit();
			}
		}catch(Exception e) {
			
		}
		
	}
	
	public void transfer() {
	    Scanner sc=new Scanner(System.in); 
		System.out.println("\nEnter Receipent's Name: ");
		String receipent = sc.nextLine();
		System.out.println("\nEnter Amount to transfer: ");
		float amount = sc.nextFloat();
		try {
			System.out.println("\nENTER 4 DIGIT PIN");
			int pin = sc.nextInt();
			if(getPin() == pin) {
				if(balance>= amount) {
					if(amount <= 50000f) {
						transactions++;
						balance -= amount;
						System.out.println("\nSuccesfully Transferred to "+ receipent);
						String str = amount + "Rs transferred to " + receipent+"\n";
						transactionHistory = transactionHistory.concat(str);
					}else {
						System.out.println("\nSorry. The limit is 50000.");
					}
				}else{
					System.out.println("\nInsufficient Balance.");
				}
				
			}else {
				System.out.println("\n\nINCORRECT PIN ");
				transfer();
			}
			
		}catch(Exception e) {
		}
			
		}
		
	public void checkBalance() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nENTER 4 DIGIT PIN");
		int pin = sc.nextInt();
		if(getPin() == pin) {
			System.out.println("\n"+balance+"Rs");
			
		}else {
			System.out.println("\n\nINCORRECT PIN ");
			checkBalance();
		}
	}
	
	
	
	
	public void transHistory() {
		if(transactions ==0) {
			System.out.println("No TRansactions happened");
		}else {
			System.out.print("\n"+transactionHistory);
		}
	}
	
	public void generatePin() {
		int pin_length;
		do {
			Scanner sc  = new Scanner(System.in);
			System.out.println("   \nGENERATE 4 DIGIT PIN FOR ATM INTERFACE");
			int pin = sc.nextInt();
			pin_length= String.valueOf(pin).length();
			if(pin_length == 4) {
				setPin(pin);
				System.out.println("   \n\nPIN GENERATION SUCCESSFULLY/n/n/n");
			}else {
				System.out.println("   \n\nINCORRECT PIN! Please Enter 4 Digits");
			}
			
		}while(pin_length!=4);
	}
	
	public void changePin() {
		Scanner sc = new Scanner(System.in);
		int pin_length = 0;
		System.out.println("\nENTER OLD PIN\n");
		int oldPin = sc.nextInt();
		
		if(getPin()==oldPin) {
			
			do {
				System.out.println("   \nENTER NEW 4 DIGIT PIN FOR ATM INTERFACE");
				int pin = sc.nextInt();
				pin_length= String.valueOf(pin).length();
				if(pin_length == 4) {
					setPin(pin);
					System.out.println("   \n\nNEW PIN GENERATION SUCCESSFULLY\n\n");
				}else {
					System.out.println("   \n\nINCORRECT PIN! Please Enter 4 Digits");
				}
			}while(pin_length!=4);
			
		}else {
			System.out.println("\nINCORRECT PIN ");
			changePin();
		}
		
	}
	
}

public class ATM_Interface {

	
	public static int takenIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while(!flag) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if(flag && input>limit || input<1) {
					System.out.println("Choose the number between 1 to "+limit);
					flag=false;
				}
			}catch(Exception e) {
				System.out.println("Enter only integer value.");
				flag=false;
			}
		}
		return input;
	}
	
	public static void main(String[] args) {
		System.out.println("\n********************WELCOME TO ATM INTERFACE*******************");
		System.out.println("\n1.Register \n2.Exit");
		System.out.println("Choose one option: ");
		int choose = takenIntegerInput(2);
		
		if(choose == 1) {
			BankAccount b= new BankAccount();
			b.register();
			while(true) {
				System.out.println("\n1.Login \n2.Exit");
				System.out.println("Enter your choice: ");
				int ch = takenIntegerInput(2);
				if(ch==1) {
					if(b.login()) {
						
						System.out.println("\n********************"+b.name.toUpperCase() +" WELCOME"+" TO ATM INTERFACE"+"*******************");
						boolean isFinished = false;
						while(!isFinished) {
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History\n6.Change PIN \n7.Exit");
							System.out.println("Enter your choice: ");
							int c = takenIntegerInput(7);
							switch(c) {
							  case 1:
								 b.withdraw();
								 break;
							  case 2:
								 b.deposit();
								 break;
							  case 3:
								b.transfer();
								break;
							  case 4:
								b.checkBalance();
								break;
							  case 5:
								b.transHistory();
								break;
							  case 6:
									b.changePin();
									break;
							  case 7:
								isFinished = true;
								break;
							}
						}
					}
				}else {
					System.exit(0);
				}
				
			}
		}else {
			System.exit(0);
		}
	}

	
	
}
