package com.roguedevstudios.uarg.System.Core.Elements;

/********************************
*   Variables Class             *
*   File Name: Variables.java   *
*                               *
*   Variables will construct    *
*   the variables needed        *
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/

//Import Section
import java.util.TreeMap;
import com.roguedevstudios.uarg.System.Core.Enum.VariableType;

/**
 * <p>
 * This class constructs variables for the class Variable
 * <p>
 * 
 * @author Grant Richards
 * @author Terry Roberson
 * @since 1.0
 */
public class Variables<V> {

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

	/**Constructs the initial state of the Variables conatainer
	 *
	 * @since 1.0
	 */

	public Variables() throws Exception {
		try {
			this._build();
		} catch (Exception e) {
			throw e;
		}
	}

/**
 * Initializes the TreeMaps for internal variable storage	
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
	 * Gets the id for _integerMap
	 * @param id	 the id associated with the map
	 * @return id
	 * @since 1.0
	 */

	public Variable<Integer> GetInteger(String id) {
		return this._integerMap.get(id);

	}

	/**
	 * SetInteger method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setIntegerMap(String key, Variable<Integer> variable) {
		this._integerMap.put(key, variable);
	}

	/**
	 * Gets the id for _integerArrayMap
	 * @param id	 the id associated with the map
	 * @since 1.0
	 */
	public Variable<Integer[]> GetIntegerArray(String id) {
		return this._integerArrayMap.get(id);
	}

	/**
	 * SetIntegerArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/
	private void _setIntegerArrayMap(String key, Variable<Integer[]> variable) {
		this._integerArrayMap.put(key, variable);
	}

	/**
	 * Gets the id for _stringArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */

	public Variable<String[]> GetString(String id) {
		return this._stringArrayMap.get(id);
	}

	/**
	 * SetStringMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setStringMap(String key, Variable<String> variable) {
		this._stringMap.put(key, variable);
	}

	/**
	 * Gets the id for _stringArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */

	public Variable<String[]> GetStringArray(String id) {
		return this._stringArrayMap.get(id);
	}

	/**
	 * SetStringArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	public void _setStringArrayMap(String key, Variable<String[]> variable) {
		this._stringArrayMap.put(key, variable);
	}

	/**
	 * Gets the id for _floatMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */

	public Variable<Float> GetFloat(String id) {
		return this._floatMap.get(id);
	}

	/**
	 * SetfloatMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	public void _setFloatMap(String key, Variable<Float> variable) {
		this._floatMap.put(key, variable);
	}

	/**
	 * Gets the id for _floatArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */

	public Variable<Float[]> GetFloatArray(String id) {
		return this._floatArrayMap.get(id);
	}

	/**
	 * SetfloatArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	public void _setFloatArrayMap(String key, Variable<Float[]> variable) {
		this._floatArrayMap.put(key, variable);
	}

	/**
	 * Gets the id for _longMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */

	public Variable<Long> GetLong(String id) {
		return this._longMap.get(id);
	}

	/**
	 * SetlongMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	public void _setLongMap(String key, Variable<Long> variable) {
		this._longMap.put(key, variable);
	}

	/**
	 * Gets the id for _longArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */

	public Variable<Long[]> GetLongArray(String id) {
		return this._longArrayMap.get(id);
	}

	/**
	 * SetlongArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	public void _setLongArrayMap(String key, Variable<Long[]> variable) {
		this._longArrayMap.put(key, variable);
	}

	/**
	 * Gets the id for _doubleMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */

	public Variable<Double> GetDouble(String id) {
		return this._doubleMap.get(id);
	}

	/**
	 * SetdoubleMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/
	public void _setDoubleMap(String key, Variable<Double> variable) {
		this._doubleMap.put(key, variable);
	}

	/**
	 * Gets the id for _doubleArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */

	public Variable<Double[]> GetDoubleArray(String id) {
		return this._doubleArrayMap.get(id);
	}

	/**
	 * SetdoubleArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	public void _setDoubleArrayMap(String key, Variable<Double[]> variable) {
		this._doubleArrayMap.put(key, variable);
	}

	/**
	 * Gets the id for _booleanMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */

	public Variable<Boolean> GetBoolean(String id) {
		return this._booleanMap.get(id);
	}

	/**
	 * SetbooleanMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/
	public void _setBooleanMap(String key, Variable<Boolean> variable) {
		this._booleanMap.put(key, variable);
	}

	/**
	 * 
	 * Gets the id for _booleanArrayMap
	 * @param id	the id associated with the map       
	 * @return id
	 * @since 1.0
	 */

	public Variable<Boolean[]> GetBooleanArray(String id) {
		return this._booleanArrayMap.get(id);
	}

	/**
	 * SetbooleanArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	public void _setBooleanArrayMap(String key, Variable<Boolean[]> variable) {
		this._booleanArrayMap.put(key, variable);
	}

	/**
	 * @param id
	 * @param variable
	 * @param Type
	 */
	public void SetVariable(String key, Variable<?> variable, VariableType Type) {
		switch (Type) {
		case INTEGER:
			this._setIntegerMap(key, (Variable<Integer>) variable);
			break;
		case INTEGERARRAY:
			this._setIntegerArrayMap(key, (Variable<Integer[]>) variable);
			break;
		case STRING:
			this._setStringMap(key, (Variable<String>) variable);
			break;
		case STRINGARRAY:
			this._setStringArrayMap(key, (Variable<String[]>) variable);
			break;
		case FLOAT:
			this._setFloatMap(key, (Variable<Float>) variable);
			break;
		case FLOATARRAY:
			this._setFloatArrayMap(key, (Variable<Float[]>) variable);
			break;
		case LONG:
			this._setLongMap(key, (Variable<Long>) variable);
			break;
		case LONGARRAY:
			this._setLongArrayMap(key, (Variable<Long[]>) variable);
			break;
		case DOUBLE:
			this._setDoubleMap(key, (Variable<Double>) variable);
			break;
		case DOUBLEARRAY:
			this._setDoubleArrayMap(key, (Variable<Double[]>) variable);
			break;
		case BOOLEAN:
			this._setBooleanMap(key, (Variable<Boolean>) variable);
			break;
		case BOOLEANARRAY:
			this._setBooleanArrayMap(key, (Variable<Boolean[]>) variable);
			break;
		default:
			return;
		}

	}
	/**
	 * updates the value of an integer variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void updateValue(String key, Integer newValue) {

		this._integerMap.get(key).SetValue(newValue);
	}
	/**
	 * updates the value of an integer variable array
	 * @param key
	 * @param newValue
	 * @param i
	 * @since 1.0
	 */
	public void updateValue(String key, Integer[] newValue) {
		this._integerArrayMap.get(key).SetValue(newValue);

	}
	/**
	 * updates the value of a String variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void updateValue(String key, String newValue) {
		this._stringMap.get(key).SetValue(newValue);
	}
	/**
	 * updates the value of a String array variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void updateValue(String key, String[] newValue) {
		this._stringArrayMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a Float variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void updateValue(String key, Float newValue) {
		this._floatMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a float variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void updateValue(String key, Float[] newValue) {
		this._floatArrayMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a long variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void updateValue(String key, Long newValue) {
		this._longMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a long variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void updateValue(String key, Long[] newValue) {
		this._longArrayMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a double variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void updateValue(String key, Double newValue) {
		this._doubleMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a double variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void updateValue(String key, Double[] newValue) {
		this._doubleArrayMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a boolean variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void updateValue(String key, Boolean newValue) {
		this._booleanMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a boolean variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void updateValue(String key, Boolean[] newValue) {
		this._booleanArrayMap.get(key).SetValue(newValue);
	}
	
}
