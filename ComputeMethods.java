import java.util.Random;

public class ComputeMethods {
    public static void main(String[] args) {
        double celsiusTemperature = convertFahrenheitToCelsius(128.0);
        double hypotenuseLength = calculateHypotenuse(6, 7);
        int diceSum = rollDice();
        System.out.println("Temperature in Celsius: " + celsiusTemperature);
        System.out.println("Hypotenuse Length: " + hypotenuseLength);
        System.out.println("Sum of Dice Values: " + diceSum);
    }

    public static double convertFahrenheitToCelsius(double fahrenheitDegrees) {
        double celsiusDegrees = (5.0/9.0) * (fahrenheitDegrees - 32.0);
        return celsiusDegrees;
    }

    public static double calculateHypotenuse(int sideA, int sideB) {
        double hypotenuse = Math.sqrt(sideA * sideA + sideB * sideB);
        return hypotenuse;
    }

    public static int rollDice() {
        Random randomDice = new Random();
        int dice1 = randomDice.nextInt(6) + 1;
        int dice2 = randomDice.nextInt(6) + 1;
        int diceSum = dice1 + dice2;
        return diceSum;
    }
}
