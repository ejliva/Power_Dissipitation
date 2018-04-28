package liva_pa3;

/**
 *
 * @author EJ Liva This is Test driver class
 */
public class LIVA_PA3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //test class for Resistor Class
        try {
            System.out.println("Resistor Class test case where all inputs to the"
                    + "various methods are valid ");
            Resistor resist = new Resistor(10000.0, 0.10, 2.0);

            //testing the the getters for the three properties in resistor class
            System.out.println("Get resistance value: " + resist.getResistanceVal());
            System.out.println("Get tolerance value: " + resist.getToleranceVal());
            System.out.println("Get Power Rating: " + resist.getPowerRating());

            //testing the toString method in resistor class
            System.out.println(resist.toString());

            //testing double minResistance method
            System.out.println("Minimum Resistance = " + resist.minResistance());

            //testing double maxResistance method
            System.out.println("Maximum Resistance = " + resist.maxResistance());

            //testing the two methods from PowerDissipation interface.
            //powerFromCurrentDraw method
            System.out.println("pd = " + resist.powerFromCurrentDraw(10));

            //powerFromVoltageDrop method
            System.out.println("pd = " + resist.powerFromVoltageDrop(10));

        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            //test cases for Variable Resistor class
            System.out.println("Test cases for VariableResistor class where all"
                    + "the inputs to the various methods are valid");
            VariableResistor var = new VariableResistor(10000.0, 0.10, 2.0, 0.25);

            //testing the setter method for control setting property
            var.setControlSettings(0.50);

            //testing the getter method for control setting property.
            System.out.println("New control setting = " + var.getControlSettings());

            //testing base class methods for getResistance, minResistance, maxResistance
            //Resistance Value
            System.out.println("Resistance Value = " + var.getResistanceVal());

            //Minimum Resistance
            System.out.println("Minimum Resistance = " + var.minResistance());

            //Maximum Resistance
            System.out.println("Maximum Resistance = " + var.maxResistance());

            //testing the toString method in VariableResistor class
            System.out.println(var.toString());

            //testing 2 base class methods for the PD interface
            //powerFromCurrentDraw method
            System.out.println("PD = " + var.powerFromCurrentDraw(10));

            //powerFromVoltageDrop
            System.out.println("PD = " + var.powerFromVoltageDrop(10));

        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            // test cases for the resistor class that cause all possible exceptions
            //tesing the resistance class
            Resistor r = new Resistor(-1.0, 0.5, 2);
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            // test cases for the resistor class that cause all possible exceptions
            //testing the tolerance value
            Resistor r1 = new Resistor(1.0, 2.5, 2);
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            // test cases for the resistor class that cause all possible exceptions
            // testing the power rating
            Resistor r2 = new Resistor(1.0, 0.10, 0);
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            // test cases for the Resistor class that cause all possible exceptions
            Resistor r3 = new Resistor(1.0, 0.10, 0);
            //testing powerFromVoltageDrop exception
            System.out.println(r3.powerFromVoltageDrop(10));
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            // test cases for the Resistor class that cause all possible exceptions
            Resistor r4 = new Resistor(1.0, 0.10, 0);
            //testing powerFromVoltageDrop exception
            System.out.println(r4.powerFromVoltageDrop(10));
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            // test cases for the variable resistor class that cause all possible exceptions
            // testing the control setting
            VariableResistor vr = new VariableResistor(1.0, 0.10, 2, 1.5);
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            // test cases for the variable resistor class that cause all possible exceptions
            //testing the resistance value
            VariableResistor vr1 = new VariableResistor(-1.0, 0.10, 2, 0.5);
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            // test cases for the variable resistor class that cause all possible exceptions
            //tesing the tolerance value
            VariableResistor vr2 = new VariableResistor(1.0, 2, 2, 0.5);
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            // test cases for the variable resistor class that cause all possible exceptions
            // test case for power rating
            VariableResistor vr3 = new VariableResistor(1.0, 0.10, 0, 0.5);
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            // test cases for the variable class that cause all possible exceptions
            VariableResistor vr4 = new VariableResistor(1.0, 0.10, 2, 0.5);
            //testing setter method exception
            vr4.setControlSettings(2);
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            // test cases for the variable class that cause all possible exceptions
            VariableResistor vr4 = new VariableResistor(1.0, 0.10, 0, 0.5);
            //testing powerFromCurrentDraw exception
            System.out.println(vr4.powerFromCurrentDraw(10));
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            // test cases for the variable class that cause all possible exceptions
            VariableResistor vr4 = new VariableResistor(1.0, 0.10, 0, 0.5);
            //testing powerFromVoltageDrop exception
            System.out.println(vr4.powerFromVoltageDrop(10));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
