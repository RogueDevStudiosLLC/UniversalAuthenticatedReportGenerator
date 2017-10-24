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
    *
    * @param ...
    *
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
    * Value of _formulaExpression (constructor) directly dependent on this method
    *
    * @param equation Should be _formulaEquation to be processed into exp4j compatible _formulaExpression 
    */
    private String _exp4jExpressionCompatibility (String equation) {
        // Make expression exp4j compatible.
        
        /* Take _formulaEquation
         * Rewrite to exp4j compatible _formulaExpression
         * 
         *
         *
         */
        // TODO:
        return null;
    }
    
    /**
    * Method that counts the variables in an equation and returns that number
    * Used to initialize _formulaInputArray size in Formula constructor
    *
    */
    private int _inputCount () {
        /*
         * Counting variables in equation and returning that number
         */
        // TODO:
        return 0;
    }
    
    /**
    *
    *
    */
    public Integer processToInteger(Variable<?>[] vars){
        // If the array is the wrong size throw an exception
        if(vars.length != this._formulaInputArray.length){
            throw new InvalidNumberOfArgumentsExceptionPleaseWriteMe(); // Make exception
        }
        // If the array values can not be parsed to a numerical value, throw an invalid argument exception
        try{
            // Convert the vars to a format we can use
            this._tempArrayDoubleConversion(vars);
            // Process the vars to an output of Double
            Double out = this._process();
            // Clean up our temp array
            this._clearTempArray();
            // Convert the output into what was asked for and return it
            return Integer.parseInt(out);
        }Catch(Exception e){
            throw new InvalidArgumentException(); // Make exception
        }
        //TODO:
        return null;
    }
    
    /**
    *
    * Populate the temporary input array with doubles of the input values
    * @param vars The Variable objects with the desired input values.
    *
    */
    private void _tempArrayDoubleConversion(Variable<?>[] vars) throws Exception{
        int i = 0;
        try{
        foreach(Variable<?> var in vars){
            this._formulaInputArray[i] = Double.parseDouble(var.GetValue());
        }
        catch(Exception e){
            throw e;
        }
    }
    
    private void _clearTempArray(){
        for( int i=0; i <= this._formulaInputArray.length; i++){
            this._formulaInputArray[i] = 0d;
        }
    }
    
    public String GetName(){
        return this._formulaName;
    }
    
    public String GetDesc(){
        return this._formulaDesc;
    }
    
    public String GetId(){
        return this._formulaId;
    }
    
    public String GetEquation(){
        return this._formulaEquation;
    }
    
    public String GetExpression(){
        return this._formulaExpression;
    }
    
    public int GetInputArraySize(){
        return this._formulaInputArray.length;
    }
}