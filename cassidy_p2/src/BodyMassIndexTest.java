import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.lang.Math;

public class BodyMassIndexTest {

    @Test
    void calculateBmiTest() {
        BodyMassIndex bmi = new BodyMassIndex(0, 0);
        assertEquals(24, Math.ceil(bmi.calculateBmi(62, 130)));
    }

    @Test
    void calculateBmiCategoryTest() {
        BodyMassIndex bmi = new BodyMassIndex(0, 0);
        assertEquals("Normal weight", bmi.calculateBmiCategory(24));
    }

    @Test
    void underweightTest() {
        BodyMassIndex bmi = new BodyMassIndex(75, 110);
        assertEquals("Underweight", bmi.bmiCategory);
    }

    @Test
    void normalWeightTest() {
        BodyMassIndex bmi = new BodyMassIndex(71, 150);
        assertEquals("Normal weight", bmi.bmiCategory);
    }

    @Test
    void overweightTest() {
        BodyMassIndex bmi = new BodyMassIndex(71, 190);
        assertEquals("Overweight", bmi.bmiCategory);
    }

    @Test
    void obesityTest() {
        BodyMassIndex bmi = new BodyMassIndex(78, 310);
        assertEquals("Obesity", bmi.bmiCategory);
    }
}
