
public class Student extends Person {
	
	private String campusAddress;
	private double gpa;

	public Student() { //default constructor
		super();
		this.campusAddress = "";
		this.gpa = 0.0;
	}
	
	public Student(String address, double gpa, String name) {
		super(name, address);
		this.campusAddress = address;
		this.gpa = gpa;
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((campusAddress == null) ? 0 : campusAddress.hashCode());
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Student other = (Student) obj;
		if (campusAddress == null) {
			if (other.campusAddress != null)
				return false;
		} else if (!campusAddress.equals(other.campusAddress))
			return false;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
			return false;
		return true;
	}

	public static void main(String[] args) {

	}

}
