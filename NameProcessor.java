import java.util.Scanner;

public class NameProcessor {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Type your name: ");
		String name = input.nextLine();
		int spaceIdx = name.indexOf(" ");
		String lastName = name.substring(spaceIdx + 1, name.length());
		String initial = name.substring(0, 1);
		String newName = lastName + ", " + initial + ".";
		System.out.println("Your name is: " + newName);
	}
}