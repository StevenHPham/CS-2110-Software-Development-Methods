
public class Vet {

	// TODO The following method is incomplete; you need to fix it to:
	// a) take an animal argument and b) have the animal make its noise
	public static void giveShot() {
		// do horrible things to the animal
		System.out.print(" after the shot cried ");

	}
	
	public static void main(String[] args) {
		Animal a = new Dog("Jack");
		String aType = String.valueOf(a.getClass()).substring(6);
		// TODO Complete the rest of the code to print the following output:
		// > Dog Jack after the shot cried Woof!
		// > Cat Garfield after the shot cried Miaw!
		// > Animal Marlow after the shot cried ...

	}

}
