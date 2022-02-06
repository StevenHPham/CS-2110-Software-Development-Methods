//Demonstrates the CreditCard class
//NEEDS MODIFICATION

public class CreditCardDriver
{
	public static void main(String[] args)
	{
		final Money LIMIT = new Money(1000);
		final Money FIRST_AMOUNT = new Money(200);
		final Money SECOND_AMOUNT = new Money(10.02);
		final Money THIRD_AMOUNT = new Money(25);
		final Money FOURTH_AMOUNT = new Money(990);
		Person owner = new Person("Bruce", "Wayne", 
				new Address("123 Wayne Manor", "Gotham","NY", "54321"));
		CreditCard visa = new CreditCard(owner, LIMIT);

		
		System.out.println(visa.getPersonals());
		System.out.println("Balance: " + visa.getBalance());
		System.out.println("Credit Limit: " + visa.getCreditLimit());
		visa.charge(FIRST_AMOUNT);
		
		System.out.println("Attempting to Charge: " + FIRST_AMOUNT.toString());
		System.out.println("Balance: " + visa.getBalance());
		visa.charge(SECOND_AMOUNT);
		
		System.out.println("Attempting to Charge: " + SECOND_AMOUNT.toString());
		System.out.println("Balance: " + visa.getBalance());
		System.out.println("Attempting to Pay: " + THIRD_AMOUNT.toString());
		visa.payment(THIRD_AMOUNT);
		
		System.out.println("Balance: " + visa.getBalance());
		System.out.println("Attempting to Charge: " + FOURTH_AMOUNT.toString());
		visa.charge(FOURTH_AMOUNT);
		System.out.println("Balance: " + visa.getBalance());
		
		
		
	}
}