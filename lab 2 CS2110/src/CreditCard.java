//Defines a credit card
//NEEDS MODIFICATION

public class CreditCard
{
	private Money balance;		//the current balance
	private Money creditLimit;	//the approved credit limit
	private Person owner;		//the owner of the credit card

	//Constructor creates a credit card for the Person parameter
	//with an approved credit limit of the Money parameter
	//and sets the balance to a Money amount of zero 
	public CreditCard(Person newCardholder, Money limit) 
	{
		//MUST COMPLETE THIS
		this.balance = new Money(0);
		this.owner = newCardholder;
		this.creditLimit = limit;
	}

	//Accessor method returns the balance
	public Money getBalance()
	{
		return balance;
	}

	//Accessor method returns the credit limit
	public Money getCreditLimit()
	{
		return creditLimit;
	}

	//Accessor method returns information about the owner
	public String getPersonals()
	{
		return owner.toString();
	}
	
	//Method to make a charge to the credit card (but only if
	//the credit limit will not be exceeded)
	public void charge(Money amount){
		if (balance.add(amount).compareTo(creditLimit) == -1) {
			balance = balance.add(amount);
		} else {
			System.out.println("Credit Limit Exceeded. Please pay your bill.");
		}
	}

	//Method to make a payment to the credit card
	public void payment(Money amount)
	{
		balance = balance.subtract(amount);
	}		
}