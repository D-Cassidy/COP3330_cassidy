import java.util.ArrayList;
import java.util.Scanner;

public class App {

    // Takes Y or N input and returns corresponding Boolean
    public static boolean moreInput() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to input more data? Y or N");
        char input = scan.next().charAt(0);

        return !(input == 'N' || input == 'n');
    }

    // Takes input for the user's height
    public static double getUserHeight() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a valid height");
        double h = scan.nextDouble();
        scan.nextLine();

        return (h > 0) ? h : getUserHeight();
    }

    // Takes input for the user's weight
    public static double getUserWeight() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a valid weight");
        double w = scan.nextDouble();
        scan.nextLine();

        return (w > 0) ? w : getUserWeight();
    }

    // Displays BMI and BMI Category from BodyMassIndex class
    public static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.println("BMI: " + bmi.bmi);
        System.out.println("BMI Category: " + bmi.bmiCategory);
    }

    // Displays average BMI of all BMIs entered
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        double average = 0;

        int len = bmiData.size();
        for (int i = 0; i < len; i++)
            average += bmiData.get(i).bmi;

        average = average / len;
        System.out.println("Average BMI: " + average);
    }

    // NO TOUCHING
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
}
