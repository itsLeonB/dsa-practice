import javax.swing.JOptionPane;

public class Conversation {
	public static void main(String[] args) {
		String inputQ1 = JOptionPane.showInputDialog("Hi! How are you?");
		String inputQ2 = JOptionPane.showInputDialog("What do I call you?");
		int inputQ3 = Integer.parseInt(JOptionPane.showInputDialog("How old are you?"));
		String inputQ4 = JOptionPane.showInputDialog("Where are you from?");
		String inputQ5 = JOptionPane.showInputDialog("What is your hobby?");
		String inputQ6 = JOptionPane.showInputDialog("I love " + inputQ5 + " too! What are you doing these days?");
		double inputQ7 = Double.parseDouble(JOptionPane.showInputDialog("What is your favorite 1-digit number?"));
		String inputQ8 = JOptionPane.showInputDialog("Why is that your favorite?");
		String inputQ9 = JOptionPane.showInputDialog("I will tell you about myself, ok?");
		String inputQ10 = JOptionPane.showInputDialog("You will listen to me, right?");
		
		int myAge = inputQ3 + 1;
		double myHome = inputQ7 + 108.1;
		
		JOptionPane.showMessageDialog(
			null,
			"Hi " + inputQ2 + ", I'm Leon. I guess my home is " + myHome + " miles from you. I'm " + myAge + ". Maybe sometimes we can " + inputQ5 + " together. Goodluck with " + inputQ6 + ". Bye!",
			"This is me.",
			0);
		}
}