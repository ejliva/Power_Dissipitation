
package liva_pa3;

/**
 * 
 * @author EJ Liva
 * This is the Resistor class that implements the Power Dissipation interface
 */
public class Resistor implements PowerDissipation {
    
    double resistanceValue;
    double toleranceValue;
    double powerRating;
    
    /**
     * This is the explicit constructor
     * precondition: Resistance value must be greater than 0. a tolerance value
     * expressed as a number between 0 and 1 (not inclusive), and a power rating
     * expressed as some number of watts greater than 0.
     * @param resistanceValue the resistance value
     * @param toleranceValue the tolerance value
     * @param powerRating the power rating value
     * @throws java.lang.Exception if any of preconditions are violated
     */
    public Resistor(double resistanceValue, double toleranceValue, double powerRating)throws Exception{
        if(resistanceValue <= 0)
            throw new Exception("Resistance value: " + resistanceValue + " must be greater than 0.");
        if(toleranceValue <= 0 || toleranceValue >= 1)
            throw new Exception("Tolerance value: " + toleranceValue + " must be expressed as a number between 0 and 1 (not inclusive).");
        if(powerRating <= 0)
            throw new Exception("Power rating: " + powerRating + " must be greater than 0.");
        
        this.resistanceValue = resistanceValue;
        this.toleranceValue = toleranceValue;
        this.powerRating = powerRating;
    }
    
    /**
     * This is getter method
     * @return resistance value
     */
    public double getResistanceVal(){
        return resistanceValue;
    }
    
    /**
     * This is a getter method
     * @return tolerance value
     */
    public double getToleranceVal(){
        return toleranceValue;
    }
    
    /**
     * This is a getter method
     * @return returns powerRating
     */
    
    public double getPowerRating(){
        return powerRating;
    }
    
    /**
     * 
     * @return a nicely formatted String reporting the values of the three 
     * properties.
     */
    @Override
    public String toString() {
        return String.format("Resistance Value: " + resistanceValue + ", Tolerance Value: "
                + toleranceValue + ", Power rating: " + powerRating);
    }
    
    /**
     * This method return a value that is a function of the resistance property
     * and the tolerance property
     * @return minimum resistance = (resistanceValue - (resistanceValue * toleranceValue))
     */
    public double minResistance(){
        return(resistanceValue - (resistanceValue * toleranceValue));
    }
    
    /**
     * This method return a value that is a function of the resistance property
     * and the tolerance property.
     * @return max resistance = (resistanceValue + (resistanceValue * toleranceValue));
     */
    public double maxResistance(){
        return(resistanceValue + (resistanceValue * toleranceValue));
    }
    
    /**
     * This method is implemented from Power Dissipation interface
     * @param volts value
     * @return PD = (volts * volts / minResistance());
     * @throws Exception when power rating is exceeded.
     */
    @Override
    public double powerFromVoltageDrop(double volts) throws Exception {
        if(powerRating <= 0)
            throw new Exception("Power rating: " + powerRating + " must be greater than 0.");
        return (volts * volts / minResistance());
    }
    
    /**
     * This method is implemented from Power Dissipation interface
     * @param current value
     * @return PD = (current * current * maxResistance());
     * @throws Exception when power rating is exceeded
     */
    @Override
    public double powerFromCurrentDraw(double current) throws Exception {
        if(powerRating <= 0)
            throw new Exception("Power rating: " + powerRating + " must be greater than 0.");
        return (current * current * maxResistance());
    }
  
}
