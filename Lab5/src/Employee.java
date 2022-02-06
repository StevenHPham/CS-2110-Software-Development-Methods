//Lab 5: Inheritance 

public class Employee extends Person {
	
	private int employeeId;
	private String workAddress;
	
	public Employee(String n, String ha, String wa, int id) {
		super(n, ha);
		this.employeeId = id;
		this.workAddress = wa;
	}
	
	@Override
	public String getMailingAddress() {
		return workAddress;
	}

	public String toString() {
		return "{Empl: n=" + name + ", ha=" + homeAddress + 
		", wa=" + workAddress + ", id=" + employeeId + "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + employeeId;
		result = prime * result + ((workAddress == null) ? 0 : workAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId != other.employeeId)
			return false;
		if (workAddress == null) {
			if (other.workAddress != null)
				return false;
		} else if (!workAddress.equals(other.workAddress))
			return false;
		return true;
	}

	public static void main(String[] args) {
		// For testing code.

	}
}
