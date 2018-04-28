
package liva_pa3;

/**
 * This is the Power Dissipation interface that will be implemented
 * @author EJ Liva
 */
public interface PowerDissipation {
    
    /**
     * 
     * @param volts value
     * @return PD = voltage value * voltage value / minimum resistance value
     * @throws Exception power rating exceeded
     */
    double powerFromVoltageDrop(double volts) throws Exception;
    /**
     * 
     * @param current value
     * @return PD = voltage value * voltage value / minimum resistance value
     * @throws Exception power rating exceeded
     */
    double powerFromCurrentDraw(double current) throws Exception;
}
