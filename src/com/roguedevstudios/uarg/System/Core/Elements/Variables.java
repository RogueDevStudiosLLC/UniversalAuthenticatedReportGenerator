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

import java.util.TreeMap;

import com.roguedevstudios.uarg.System.Core.Enum.VariableType;

// Import Section
/**
 * <p>
 * This class constructs variables for the class Variable
 * </p>
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

	/**
	 * Constructs the initial state of the Variables container
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
	 * Adds a Boolean Array to the container
	 * @param key String ID
	 * @param variable Variable to store
	 * @since 1.0
	 * 
	 **/

	private void _setBooleanArrayMap(String key, Variable<Boolean[]> variable) {
		this._booleanArrayMap.put(key, variable);
	}

	/**
	 * Adds a Boolean to the container
	 * @param key String ID
	 * @param variable Variable to store
	 * @since 1.0
	 * 
	 **/
	private void _setBooleanMap(String key, Variable<Boolean> variable) {
		this._booleanMap.put(key, variable);
	}

	/**
	 * Adds a Double Array to the container
	 * @param key String ID
	 * @param variable Variable to store
	 * @since 1.0
	 * 
	 **/

	private void _setDoubleArrayMap(String key, Variable<Double[]> variable) {
		this._doubleArrayMap.put(key, variable);
	}

	/**
	 * Adds a Double to the container
	 * @param key String ID
	 * @param variable Variable to store
	 * @since 1.0
	 * 
	 **/
	private void _setDoubleMap(String key, Variable<Double> variable) {
		this._doubleMap.put(key, variable);
	}

	/**
	 * Adds a Float Array to the container
	 * @param key String ID
	 * @param variable Variable to store
	 * @since 1.0
	 * 
	 **/

	private void _setFloatArrayMap(String key, Variable<Float[]> variable) {
		this._floatArrayMap.put(key, variable);
	}

	/**
	 * Adds a Float to the container
	 * @param key String ID
	 * @param variable Variable to store
	 * @since 1.0
	 * 
	 **/

	private void _setFloatMap(String key, Variable<Float> variable) {
		this._floatMap.put(key, variable);
	}

	/**
	 * Adds an Integer Array to the container
	 * @param key String ID
	 * @param variable Variable to store
	 * @since 1.0
	 * 
	 **/
	private void _setIntegerArrayMap(String key, Variable<Integer[]> variable) {
		this._integerArrayMap.put(key, variable);
	}

	/**
	 * Adds an Integer to the container
	 * @param key String ID
	 * @param variable Variable to store
	 * @since 1.0
	 * 
	 **/

	private void _setIntegerMap(String key, Variable<Integer> variable) {
		this._integerMap.put(key, variable);
	}

	/**
	 * Adds a Long Array to the container
	 * @param key String ID
	 * @param variable Variable to store
	 * @since 1.0
	 * 
	 **/

	private void _setLongArrayMap(String key, Variable<Long[]> variable) {
		this._longArrayMap.put(key, variable);
	}

	/**
	 * Adds a Long to the container
	 * @param key String ID
	 * @param variable Variable to store
	 * @since 1.0
	 * 
	 **/

	private void _setLongMap(String key, Variable<Long> variable) {
		this._longMap.put(key, variable);
	}

	/**
	 * Adds a String Array to the container
	 * @param key String ID
	 * @param variable Variable to store
	 * @since 1.0
	 * 
	 **/

	private void _setStringArrayMap(String key, Variable<String[]> variable) {
		this._stringArrayMap.put(key, variable);
	}

	/**
	 * Adds a String to the container
	 * @param key String ID
	 * @param variable Variable to store
	 * @since 1.0
	 * 
	 **/

	private void _setStringMap(String key, Variable<String> variable) {
		this._stringMap.put(key, variable);
	}

	/**
	 * Gets a requested Boolean Variable
	 * @param id ID of the requested Variable
	 * @return Variable requested
	 * @since 1.0
	 */

	public Variable<Boolean> GetBoolean(String id) {
		return this._booleanMap.get(id);
	}

	/**
	 * Gets a requested Boolean Array Variable
	 * @param id ID of the requested Variable
	 * @return Variable requested
	 * @since 1.0
	 */

	public Variable<Boolean[]> GetBooleanArray(String id) {
		return this._booleanArrayMap.get(id);
	}

	/**
	 * Gets a requested Double Variable
	 * @param id ID of the requested Variable
	 * @return Variable requested
	 * @since 1.0
	 */

	public Variable<Double> GetDouble(String id) {
		return this._doubleMap.get(id);
	}

	/**
	 * Gets a requested Double Array Variable
	 * @param id ID of the requested Variable
	 * @return Variable requested
	 * @since 1.0
	 */

	public Variable<Double[]> GetDoubleArray(String id) {
		return this._doubleArrayMap.get(id);
	}

	/**
	 * Gets a requested Float Variable
	 * @param id ID of the requested Variable
	 * @return Variable requested
	 * @since 1.0
	 */

	public Variable<Float> GetFloat(String id) {
		return this._floatMap.get(id);
	}

	/**
	 * Gets a requested Float Array Variable
	 * @param id ID of the requested Variable
	 * @return Variable requested
	 * @since 1.0
	 */

	public Variable<Float[]> GetFloatArray(String id) {
		return this._floatArrayMap.get(id);
	}

	/**
	 * Gets a requested Integer Variable
	 * @param id ID of the requested Variable
	 * @return Variable requested
	 * @since 1.0
	 */

	public Variable<Integer> GetInteger(String id) {
		return this._integerMap.get(id);

	}

	/**
	 * Gets a requested Integer Array Variable
	 * @param id ID of the requested Variable
	 * @return Variable requested
	 * @since 1.0
	 */
	public Variable<Integer[]> GetIntegerArray(String id) {
		return this._integerArrayMap.get(id);
	}

	/**
	 * Gets a requested Long Variable
	 * @param id ID of the requested Variable
	 * @return Variable requested
	 * @since 1.0
	 */

	public Variable<Long> GetLong(String id) {
		return this._longMap.get(id);
	}

	/**
	 * Gets a requested Long Array Variable
	 * @param id ID of the requested Variable
	 * @return Variable requested
	 * @since 1.0
	 */

	public Variable<Long[]> GetLongArray(String id) {
		return this._longArrayMap.get(id);
	}

	/**
	 * Gets a requested String Variable
	 * @param id ID of the requested Variable
	 * @return Variable requested
	 * @since 1.0
	 */

	public Variable<String> GetString(String id) {
		return this._stringMap.get(id);
	}

	/**
	 * Gets a requested String Array Variable
	 * @param id ID of the requested Variable
	 * @return Variable requested
	 * @since 1.0
	 */

	public Variable<String[]> GetStringArray(String id) {
		return this._stringArrayMap.get(id);
	}

	/**
	 * Adds a Variable to the container
	 * @param key ID of the variable to add to the container
	 * @param variable The variable object to add to the container
	 * @param Type The variables objects specific supported type
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
	 * Updates a Boolean Variable Value
	 * @param key ID of the variable to update
	 * @param newValue New Value
	 * @since 1.0
	 */
	public void updateValue(String key, Boolean newValue) {
		this._booleanMap.get(key).SetValue(newValue);
	}
	/**
	 * Updates a Boolean Array Variable Value
	 * @param key ID of the variable to update
	 * @param newValue New Value
	 * @since 1.0
	 */
	public void updateValue(String key, Boolean[] newValue) {
		this._booleanArrayMap.get(key).SetValue(newValue);
	}
	/**
	 * Updates a Double Variable Value
	 * @param key ID of the variable to update
	 * @param newValue New Value
	 * @since 1.0
	 */
	public void updateValue(String key, Double newValue) {
		this._doubleMap.get(key).SetValue(newValue);
	}
	/**
	 * Updates a Double Array Variable Value
	 * @param key ID of the variable to update
	 * @param newValue New Value
	 * @since 1.0
	 */
	public void updateValue(String key, Double[] newValue) {
		this._doubleArrayMap.get(key).SetValue(newValue);
	}
	
	/**
	 * Updates a Float Variable Value
	 * @param key ID of the variable to update
	 * @param newValue New Value
	 * @since 1.0
	 */
	public void updateValue(String key, Float newValue) {
		this._floatMap.get(key).SetValue(newValue);
	}
	
	/**
	 * Updates a Float Array Variable Value
	 * @param key ID of the variable to update
	 * @param newValue New Value
	 * @since 1.0
	 */
	public void updateValue(String key, Float[] newValue) {
		this._floatArrayMap.get(key).SetValue(newValue);
	}
	
	/**
	 * Updates a Integer Variable Value
	 * @param key ID of the variable to update
	 * @param newValue New Value
	 * @since 1.0
	 */
	public void updateValue(String key, Integer newValue) {

		this._integerMap.get(key).SetValue(newValue);
	}
	
	/**
	 * Updates a Integer Array Variable Value
	 * @param key ID of the variable to update
	 * @param newValue New Value
	 * @since 1.0
	 */
	public void updateValue(String key, Integer[] newValue) {
		this._integerArrayMap.get(key).SetValue(newValue);

	}
	
	/**
	 * Updates a Long Variable Value
	 * @param key ID of the variable to update
	 * @param newValue New Value
	 * @since 1.0
	 */
	public void updateValue(String key, Long newValue) {
		this._longMap.get(key).SetValue(newValue);
	}
	
	/**
	 * Updates a Long Array Variable Value
	 * @param key ID of the variable to update
	 * @param newValue New Value
	 * @since 1.0
	 */
	public void updateValue(String key, Long[] newValue) {
		this._longArrayMap.get(key).SetValue(newValue);
	}
	
	/**
	 * Updates a String Variable Value
	 * @param key ID of the variable to update
	 * @param newValue New Value
	 * @since 1.0
	 */
	public void updateValue(String key, String newValue) {
		this._stringMap.get(key).SetValue(newValue);
	}
	
	/**
	 * Updates a String Array Variable Value
	 * @param key ID of the variable to update
	 * @param newValue New Value
	 * @since 1.0
	 */
	public void updateValue(String key, String[] newValue) {
		this._stringArrayMap.get(key).SetValue(newValue);
	}
	
}
