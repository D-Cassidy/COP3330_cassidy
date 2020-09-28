import java.lang.Math;

public class BodyMassIndex {
    double bmi;
    String bmiCategory;

    public double calculateBmi(double h, double w) {
        return (703 * w) / Math.pow(h, 2);
    }

    public String calculateBmiCategory(double bmiScore) {
        if (bmiScore < 18.5)
            return "Underweight";
        else if (bmiScore >= 18.5 && bmiScore < 25)
            return "Normal weight";
        else if (bmiScore >= 25 && bmiScore < 30)
            return "Overweight";
        else
            return "Obesity";
    }

    public BodyMassIndex (double h, double w) {
        bmi = calculateBmi(h, w);
        bmiCategory = calculateBmiCategory(bmi);
    }
}
