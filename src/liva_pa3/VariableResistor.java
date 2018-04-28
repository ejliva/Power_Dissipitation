package liva_pa3;

/**
 *
 * @author EJ Liva
 * This is the VariableResistor class that extends Resistor class
 */
public class VariableResistor extends Resistor{
    
    private double controlSetting;
    
    /**
     * This is the sole constructor for this class that takes 4 parameters
     * @param resistanceValue the resistance value
     * @param toleranceValue the tolerance value
     * @param powerRating the power rating value
     * @param controlSetting the control setting value
     * @throws Exception when any preconditions are violated
     */
    public VariableResistor(double resistanceValue, double toleranceValue, 
            double powerRating, double controlSetting) throws Exception {
        super(resistanceValue, toleranceValue, powerRating);
        if(resistanceValue <= 0)
            throw new Exception("Resistance Value: " + resistanceValue + " must be greater than 0.");
        if(toleranceValue <= 0 || toleranceValue >= 1)
            throw new Exception("Tolerance Value: " + toleranceValue + " must be expressed as a number between 0 and 1 (not inclusive).");
        if(powerRating <= 0)
            throw new Exception("Power rating: " + powerRating + " must be greater than 0.");
        if(controlSetting < 0 || controlSetting > 1)
            throw new Exception("Control Setting: " + controlSetting + " value must be from 0 to 1 inclusive");
        
        this.resistanceValue = resistanceValue;
        this.toleranceValue = toleranceValue;
        this.resistanceValue = resistanceValue;
        this.controlSetting = controlSetting;
    }
    
    /**
     * This is a setter method for control setting property
     * @param controlSetting value that is passed in for new control setting
     * @throws IllegalArgumentException when any preconditions are violated 
     */
    public void setControlSettings(double controlSetting)throws 
            IllegalArgumentException{
        if(controlSetting < 0 || controlSetting >1)
            throw new IllegalArgumentException("Control setting: " + controlSetting + " is out of range");
        this.controlSetting = controlSetting;
    }
    
    /**
     * getter method for control setting property
     * @return control setting
     */
    public double getControlSettings(){
        return controlSetting;
    }
    
     /**
     * This is getter method
     * @return resistance value * controlSetting
     */
    @Override
    public double getResistanceVal(){
        return resistanceValue * controlSetting;
    }
    
    /**
     * This method return a value that is a function of the resistance property
     * and the tolerance property.
     * @return the minimum resistance (resistanceValue - (resistanceValue * toleranceValue)) * controlSetting
     */
    @Override
    public double minResistance(){
        return(resistanceValue - (resistanceValue * toleranceValue)) * controlSetting;
    }
    
    /**
     * This method return a value that is a function of the resistance property
     * and the tolerance property.
     * @return max resistance = (resistanceValue + (resistanceValue * toleranceValue)) * controlSetting
     */
    @Override
    public double maxResistance(){
        return(resistanceValue + (resistanceValue * toleranceValue)) * controlSetting;
    }
    
    /**
     * This is toString method
     * @return a nicely formatted String reporting the values of the four
     * properties.
     */
    @Override
    public String toString() {
        return String.format("Resistance Value: " + resistanceValue + ", Tolerance Value: "
                + toleranceValue + ", Power rating: " + powerRating + ", Control setting: " + controlSetting);
    }
    
    /**
     * This method is implemented from Power Dissipation interface
     * @param volts value
     * @return PD = (volts * volts / minResistance());
     * @throws Exception power rating is exceeded
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
     * @throws Exception power rating is exceeded
     */
    @Override
    public double powerFromCurrentDraw(double current) throws Exception {
        if(powerRating <= 0)
            throw new Exception("Power rating: " + powerRating + " must be greater than 0.");
        return (current * current * maxResistance());
    }
    

}
