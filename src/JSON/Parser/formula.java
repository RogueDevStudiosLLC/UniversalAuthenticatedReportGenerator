/************************************************
 * Formula Class File                           *
 * File name: Formula.java                      *
 * The class file for a formula.                *
 ***********************************************/

package JSON.Parser;

/**
 * This class is a formula class.
 * 
 * @author Chel
 * @since 1.0
 */

// TODO:
// Import variable.java, exp4j

public class Formula {
    /* Class Attributes */

    /* The name meta of a formula */
    private String _formulaName;
    /* The description of a formula */
    private String _formulaDesc;
    /* The ID of a formula */
    private String _formulaId;
    /* The base equation this formula uses */
    private String _formulaEquation;
    /* Exp4j compatible rewrite of _formulaEquation*/
    private String _formulaExpression;
    /* Input array of variables converted to doubles*/
    private double[] _formulaInputArray;

    /* Class Methods */
    
    /**
    * Constructor for Formula class
    * Sets values for object fields, establishes
    * an exp4j compatible expression using the base
    * equation given, and sets up
    * a Double array based off of the base equation
    * given for storing input variable object values.
    *
    * @param formulaName	A formula's name, taken from _formulaName
    * @param formulaDesc	A formula's description, taken from _formulaDesc
    * @param formulaId		A formula's id, taken from _formulaId
    * @param formulaEquation	A formula's equation, taken from _formulaEquation
    */
    public Formula (String formulaName, String formulaDesc, String formulaId, String formulaEquation) {
        this._formulaName = formulaName;
        this._formulaDesc = formulaDesc;
        this._formulaId = formulaId;
        this._formulaEquation = formulaEquation;
        this._formulaExpression = this._exp4jExpressionCompatibility(this._formulaEquation); 
        this._formulaInputArray = new double[this._inputCount()];
    }
    
    /**
    * Method that takes the formula equation and processes it into an exp4j compatible expression.
    * The formula expression is directly dependent on this method.
    *
    * @param equation	Should be _formulaEquation to be processed into exp4j compatible _formulaExpression
    * @return An expression (string) that is exp4j-compatible. 
    */
    private String _exp4jExpressionCompatibility (String equation) {
        // Make expression exp4j compatible.
        
        /* Take _formulaEquation
         * Rewrite to exp4j compatible _formulaExpression
         */
        // TODO:
        return null;
    }
    
    /**
    * Method that counts the input variables in an equation and returns that number.
    * Used to initialize the formula input array size.
    * @return An integer representing the amount of input variables in an equation.
    */
    private int _inputCount () {
        /*
         * Counting variables in equation and returning that number
         */
        // TODO:
        return 0;
    }
    
    /**
    * Checks if array size is correct, then converts variable
    * array elements into Double format. Then it outputs the variable
    * array elements as Doubles to be processed by exp4j.
    * Finally, it cleans out the temporary array.
    * 
    * @param vars	The Variable objects with the desired input values.
    * @throws InvalidNumberOfArgumentsException	If the variable object array given does not have the correct amount of elements.
    * @throws InvalidArgumentException	If array values cannot be parsed into a numerical value.
    */
    public Integer processToInteger(Variable<?>[] vars){
        // If the array is the wrong size throw an exception
        if(vars.length != this._formulaInputArray.length){
            throw new InvalidNumberOfArgumentsExceptionPleaseWriteMe(); // TODO: Make exception
        }
        // If the array values can not be parsed to a numerical value, throw an invalid argument exception
        try{
            // Convert the vars to a format we can use
            this._tempArrayDoubleConversion(vars);
            // Process the vars to an output of Double
            Double out = this._process(); // TODO: 23 Oct 2017: process() currently undefined
            // Clean up our temp array
            this._clearTempArray();
            // Convert the output into what was asked for and return it
            return Integer.parseInt(out);
        }
        catch(Exception e){
            throw new InvalidArgumentException(); // TODO: Make exception
        }
        //TODO:
        return null;
    }
    
    /**
    * Populate the temporary input array with doubles of the input values
    * @param vars		The Variable objects with the desired input values.
    * @throws Exception	If one of the argument values given is not capable of being parsed into a Double.
    */
    private void _tempArrayDoubleConversion(Variable<?>[] vars) throws Exception{
        int i = 0;
        try{
        	for(Variable<?> var : vars){
        		this._formulaInputArray[i] = Double.parseDouble(var.GetValue());
        		i++;
        	}
        }
        catch(Exception e){
        	throw e;
        }
    }
        
    // Initialize a loop counter so we can tell which index we are on
    // == Almost always takes on the format "int i = 0"
    // Loop through the variables and convert them to doubles, place them into array
    // == Almost always a for or foreach iterative loop
    // increase the index number to the next array slot
    // == Almost always takes the form "i++" or "++i"
    // if there's a problem we need to throw an exception
    // == Almost always means we wrap our process in a try catch block and spit the exception back to the user
    
    /**
     * Method to clear the temporary variables array.
     * Called by processToInteger().
     */
    private void _clearTempArray(){
        for( int i=0; i <= this._formulaInputArray.length; i++){
            this._formulaInputArray[i] = 0d; // Set element to Double 0
        }
    }
    
    /**
     * Gets the formula name.
     * @return The formula name (String).
     */
    public String GetName(){
        return this._formulaName;
    }
    
    /**
     * Gets the formula description.
     * @return The formula description (String).
     */
    public String GetDesc(){
        return this._formulaDesc;
    }
    
    /**
     * Gets the formula id.
     * @return The formula id (String).
     */
    public String GetId(){
        return this._formulaId;
    }
    
    /**
     * Gets the formula base equation.
     * @return The formula base equation (String).
     */
    public String GetEquation(){
        return this._formulaEquation;
    }
    
    /**
     * Gets the formula exp4j compatible expression.
     * @return The formula expression (String).
     */
    public String GetExpression(){
        return this._formulaExpression;
    }
    
    /**
     * Gets the formula variable input array's size.
     * @return The size of the formula variable input array (int).
     */
    public int GetInputArraySize(){
        return this._formulaInputArray.length;
    }
}