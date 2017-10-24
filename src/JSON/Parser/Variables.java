/********************************
*   Variables Class             *
*   File Name: Variables.java   *
*                               *
*   Variables will construct    *
*   the variables needed        *
*                               *
*  ©2049 Rogue Dev Studios, LLC *
********************************/
package JSON.Parser;

import java.util.TreeMap;

// Import Section
/**
 * <p>
 * the construction of variables
 *
 * </p>
 * 
 * @author Grant Richards
 * @author Terry Roberson
 * @since 1.0
 */
public class Variables<V> {

    /**
     * constructor
     * 
     * @param _integerMap
     *            a treeMap of the variable type integer
     * 
     * @param _integerArrayMap
     *            a treeMap of the variable type integerArray
     * 
     * @param _StringMap
     *            a treeMap of the variable type String
     * 
     * @param _StringArrayMap
     *            a treeMap of the variable type StringArray
     * 
     * 
     * @param _floatMap
     *            a treeMap of the variable type float
     * 
     * @param _floatArrayMap
     *            a treeMap of the variable type floatArray
     * 
     * @param _longMap
     *            a treeMap of the variable type long
     * 
     * @param _longArrayMap
     *            a treeMap of the variable type longArray
     * 
     * @param _doubleMap
     *            a treeMap of the variable type double
     * 
     * @param _doubleArrayMap
     *            a treeMap of the variable type doubleArray
     * 
     * @param _booleanMap
     *            a treeMap of the variable type boolean
     * 
     * @param _booleanArrayMap
     *            a treeMap of the variable type booleanArray
     * 
     * @return <code> identifies value <code> class returns specified value
     * @since 1.0
     */

    private TreeMap<String, Variable<Integer>> _integerMap;

    private TreeMap<String, Variable<Integer[]>> _integerArrayMap;

    private TreeMap<String, Variable<String>> _stringMap;

    private TreeMap<String, Variable<String[]>> _stringArrayMap;

    private TreeMap<String, Variable<Float>> _floatMap;

    private TreeMap<String, Variable<Float[]>> _floatArrayMap;

    private TreeMap<String, Variable<Long>> _longMap;

    private TreeMap<String, Variable<Long[]>> _longArrayMap;

    private TreeMap<String, Variable<Double>> _doubleMap;

    private TreeMap<String, Variable<Double[]>> _doubleArrayMap;

    private TreeMap<String, Variable<Boolean>> _booleanMap;

    private TreeMap<String, Variable<Boolean[]>> _booleanArrayMap;

    public Variables() throws Exception {
        try {
            this._build();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 
     * Gets the id for _integerMap
     * 
     * 
     * @return id
     *
     * @since 1.0
     */
    private void _build() {
        this._integerMap = new TreeMap<String, Variable<Integer>>();
        this._integerArrayMap = new TreeMap<String, Variable<Integer[]>>();
        this._stringMap = new TreeMap<String, Variable<String>>();
        this._stringArrayMap = new TreeMap<String, Variable<String[]>>();
        this._floatMap = new TreeMap<String, Variable<Float>>();
        this._floatArrayMap = new TreeMap<String, Variable<Float[]>>();
        this._longMap = new TreeMap<String, Variable<Long>>();
        this._longArrayMap = new TreeMap<String, Variable<Long[]>>();
        this._doubleMap = new TreeMap<String, Variable<Double>>();
        this._doubleArrayMap = new TreeMap<String, Variable<Double[]>>();
        this._booleanMap = new TreeMap<String, Variable<Boolean>>();
        this._booleanArrayMap = new TreeMap<String, Variable<Boolean[]>>();

    }
   
  
    /**
     * SetInteger method
     *
     * sets _integermap
     * 
     * 
     *
     * @since 1.0
     * 
     **/
    public Variable<Integer> GetInteger(String id) {
        return this._integerMap.get(id);

    }

    private void _setIntegerMap(String key, Variable<Integer> variable) {
        this._integerMap.put(key,variable);
    }

    /**
     * 
     * Gets the id for _integerArrayMap
     * 
     * 
     * @return id
     *
     * @since 1.0
     */
    public Variable<Integer[]> GetIntegerArray(String id) {
        return this._integerArrayMap.get(id);
    }

    /**
     * sets _integerArrayMap
     * 
     * @since 1.0
     * 
     */
    public void _setIntegerArrayMap(String key, Variable<Integer[]> variable) {
        this._integerArrayMap.put(key, variable);
    }
    

    public Variable<String[]> GetString(String id) {
        return this._stringArrayMap.get(id);
    }

    /**
     * 
     * Gets the id for StringMap
     * 
     * 
     * @return id
     *
     * @since 1.0
     */
    public void _setStringMap(String key, Variable<String> variable) {
        this._stringMap.put(key, variable);
    }

    /**
     * SetString method
     * 
     * sets _StringMap
     *
     * @since 1.0
     */
    public Variable<String[]> GetStringArray(String id) {
        return this._stringArrayMap.get(id);
    }

    /**
     * 
     * Gets the id for _StringArrayMap
     * 
     * 
     * @return id
     *
     * @since 1.0
     */

    public void _setStringArrayMap(String key, Variable<String[]> variable) {
        this._stringArrayMap.put(key, variable);
    }

    /**
     * 
     * sets _StringArrayMap
     *
     * @since 1.0
     */

    public Variable<Float> GetFloat(String id) {
        return this._floatMap.get(id);
    }

    /**
     * Gets the id for _floatMap
     *
     * @return id
     *
     * @since 1.0
     * 
     */
    public void _setFloatMap(String key, Variable<Float> variable) {
        this._floatMap.put(key, variable);
    }

    /**
     * sets _floatmap
     * 
     *
     * @since 1.0
     */
    public Variable<Float[]> GetFloatArray(String id) {
        return this._floatArrayMap.get(id);
    }

    /**
     * Gets id for _floatArrayMap
     *
     *
     * @return id
     *
     * @since 1.0
     * 
     */
    public void _setFloatArrayMap(String key, Variable<Float[]> variable) {
        this._floatArrayMap.put(key, variable);
    }

    /**
     * set floatArrayMap
     * 
     * 
     *
     * @since 1.0
     */
    public Variable<Long> GetLong(String id) {
        return this._longMap.get(id);
    }

    /**
     * Gets id for _longMap
     *
     * @return id
     *
     * @since 1.0
     * 
     */
    public void _setLongMap(String key, Variable<Long> variable) {
        this._longMap.put(key, variable);
    }

    /**
     *
     * sets _longmap
     *
     * @since 1.0
     */
    public Variable<Long[]> GetLongArray(String id) {
        return this._longArrayMap.get(id);
    }

    /**
     * gets id for longArrayMap
     *
     * @return id
     *
     * @since 1.0
     * 
     */
    public void _setLongArrayMap(String key, Variable<Long[]> variable) {
        this._longArrayMap.put(key, variable);
    }

    /**
     * SetLongArray method
     * 
     * sets _longArrayMap
     * 
     * @since 1.0
     */
    public Variable<Double> GetDouble(String id) {
        return this._doubleMap.get(id);
    }

    /**
     * gets id for _doublemap
     *
     * 
     *
     * @return id
     * 
     * @since 1.0
     * 
     */
    public void _setDoubleMap(String key, Variable<Double> variable) {
        this._doubleMap.put(key, variable);
    }

    /**
     * 
     * sets _doubleMap
     *
     * @since 1.0
     */
    public Variable<Double[]> GetDoubleArray(String id) {
        return this._doubleArrayMap.get(id);
    }

    /**
     * gets id for _doubleArrayMap
     *
     * @return id
     *
     * @since 1.0
     * 
     */
    public void _setDoubleArrayMap(String key, Variable<Double[]> variable) {
        this._doubleArrayMap.put(key, variable);
    }

    /**
     *
     * sets _doubleArrayMap
     *
     * @since 1.0
     */
    public Variable<Boolean> GetBoolean(String id) {
        return this._booleanMap.get(id);
    }

    /**
     * gets id for _booleanMap
     *
     * 
     *
     * @return id
     * 
     * @since 1.0
     * 
     */
    public void _setBooleanMap(String key, Variable<Boolean> variable) {
        this._booleanMap.put(key, variable);
    }

    /**
     *
     * sets _booleanMap
     * 
     * @since 1.0
     * 
     */

    public Variable<Boolean[]> GetBooleanArray(String id) {
        return this._booleanArrayMap.get(id);
    }

    /**
     * gets id for _booleanArrayMap
     *
     * 
     *
     * @return id
     * 
     * @since 1.0
     * 
     */
    public void _setBooleanArrayMap(String key, Variable<Boolean[]>variable) {
        this._booleanArrayMap.put(key, variable);
    }
    
    /**
     * @param id
     * @param variable
     * @param Type
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
        LONGARRAY("Long Array");
        
        private final String _value;
        
        private VariableType(String v){
            this._value = VariableType;
          
        }
    }
        public SetVariable(String id, Variable<?> variable, VariableType Type) {
        	switch(Type) {
        	case VariableType.INTEGER:
        		this._setIntegerMap(key, variable);
        		break;
        	case VariableType.INTEGERARRAY:
        		this._setIntegerArrayMap(key, variable);
        		break;
        	case VariableType.STRING:
        		this._setStringMap(key, variable);
        		break;
        	case VariableType.STRINGARRAY:
        		this._setStringArrayMap(key,variable);
        		break;
        	case VariableType.FLOAT:
        		this._setFloatMap(key, variable);
        		break;
        	case VariableType.FLOATARRAY:
        		this._setFloatArrayMap(key, variable);
        		break;
        	case VariableType.LONG:
        		this._setLongMap(key, variable);
        		break;
        	case VariableType.LONGARRAY:
        		this._setLongArrayMap(key, variable);
        		break;
        	case VariableType.DOUBLE:
        		this._setDoubleMap(key, variable);
        		break;
        	case VariableType.DOUBLEARRAY:
        		this._setDoubleArrayMap(key,variable);
        		break;
        	case VariableType.BOOLEAN:
        		this._setBooleanMap(key, variable);
        		break;
        	case VariableType.BOOLEANARRAY:
        		this._setBooleanArrayMap(key, variable);
        		break;
        	}
        	
        }

    }
}
/**
 * setBoolean method
 *
 * sets _booleanArrayMap
 * 
 * @since 1.0
 * 
 **/