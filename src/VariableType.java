/********************************
*   VariableType Class          *
*   File Name: VariableType.java*
*                               *
*   VariableType will enumerate *
*   the variables needed        *
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/

//

/**
 * <p>
 * this enumerates the variables in the variables.java class file
 * <p>
 * 
 * @author Terry Roberson
 *
 *@since 1.0
 */

public enum VariableType{
        INTEGER("Integer"),
        INTEGERARRAY("Integer Array"),
        FLOAT("Float"),
        FLOATARRAY("Float Array"),
        DOUBLE("Double"),
        DOUBLEARRAY("Double Array"),
        STRING("String"),
        STRINGARRAY("String Array"),
        BOOLEAN("Boolean"),
        BOOLEANARRAY("Boolean Array"),
        LONG("Long"),
        LONGARRAY("Long Array"),
        NULL("Invalid");
		
        
        private final String _value;
        
        private VariableType(String v){
            this._value = v;
          
       }

}
