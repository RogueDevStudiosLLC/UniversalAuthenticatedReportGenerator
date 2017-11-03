package com.roguedevstudios.uarg.System.Core.Elements;

/********************************
*   Variables Class             *
*   File Name: Variables.java   *
*                               *
*   The container for each 		*
*   Variable created in 		*
*   Variable.java				*
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/

//Import Section
import java.util.TreeMap;

import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariables;
import com.roguedevstudios.uarg.System.Core.Enum.VariableType;

/**
 * <p>
 * This class implements IVariables and constructs variables for the class Variable
 * <p>
 * 
 * @author Grant Richards
 * @author Terry Roberson
 * @since 1.0
 */
public class Variables implements IVariables {

	private TreeMap<String, IVariable<Integer>> _integerMap;

	private TreeMap<String, IVariable<Integer[]>> _integerArrayMap;

	private TreeMap<String, IVariable<String>> _stringMap;

	private TreeMap<String, IVariable<String[]>> _stringArrayMap;

	private TreeMap<String, IVariable<Float>> _floatMap;

	private TreeMap<String, IVariable<Float[]>> _floatArrayMap;

	private TreeMap<String, IVariable<Long>> _longMap;

	private TreeMap<String, IVariable<Long[]>> _longArrayMap;

	private TreeMap<String, IVariable<Double>> _doubleMap;

	private TreeMap<String, IVariable<Double[]>> _doubleArrayMap;

	private TreeMap<String, IVariable<Boolean>> _booleanMap;

	private TreeMap<String, IVariable<Boolean[]>> _booleanArrayMap;

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
		this._integerMap = new TreeMap<String, IVariable<Integer>>();
		this._integerArrayMap = new TreeMap<String, IVariable<Integer[]>>();
		this._stringMap = new TreeMap<String, IVariable<String>>();
		this._stringArrayMap = new TreeMap<String, IVariable<String[]>>();
		this._floatMap = new TreeMap<String, IVariable<Float>>();
		this._floatArrayMap = new TreeMap<String, IVariable<Float[]>>();
		this._longMap = new TreeMap<String, IVariable<Long>>();
		this._longArrayMap = new TreeMap<String, IVariable<Long[]>>();
		this._doubleMap = new TreeMap<String, IVariable<Double>>();
		this._doubleArrayMap = new TreeMap<String, IVariable<Double[]>>();
		this._booleanMap = new TreeMap<String, IVariable<Boolean>>();
		this._booleanArrayMap = new TreeMap<String, IVariable<Boolean[]>>();

	}

	/**
	 * SetbooleanArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setBooleanArrayMap(String key, IVariable<Boolean[]> variable) {
		this._booleanArrayMap.put(key, variable);
	}

	/**
	 * SetbooleanMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/
	private void _setBooleanMap(String key, IVariable<Boolean> variable) {
		this._booleanMap.put(key, variable);
	}

	/**
	 * SetdoubleArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setDoubleArrayMap(String key, IVariable<Double[]> variable) {
		this._doubleArrayMap.put(key, variable);
	}

	/**
	 * SetdoubleMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/
	private void _setDoubleMap(String key, IVariable<Double> variable) {
		this._doubleMap.put(key, variable);
	}

	/**
	 * SetfloatArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setFloatArrayMap(String key, IVariable<Float[]> variable) {
		this._floatArrayMap.put(key, variable);
	}

	/**
	 * SetfloatMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setFloatMap(String key, IVariable<Float> variable) {
		this._floatMap.put(key, variable);
	}

	/**
	 * SetIntegerArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/
	private void _setIntegerArrayMap(String key, IVariable<Integer[]> variable) {
		this._integerArrayMap.put(key, variable);
	}

	/**
	 * SetInteger method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setIntegerMap(String key, IVariable<Integer> variable) {
		this._integerMap.put(key, variable);
	}

	/**
	 * SetlongArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setLongArrayMap(String key, IVariable<Long[]> variable) {
		this._longArrayMap.put(key, variable);
	}

	/**
	 * SetlongMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setLongMap(String key, IVariable<Long> variable) {
		this._longMap.put(key, variable);
	}

	/**
	 * SetStringArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setStringArrayMap(String key, IVariable<String[]> variable) {
		this._stringArrayMap.put(key, variable);
	}

	/**
	 * SetStringMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setStringMap(String key, IVariable<String> variable) {
		this._stringMap.put(key, variable);
	}

	/**
	 * Gets the id for _booleanMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IVariable<Boolean> GetBoolean(String id) {
		return this._booleanMap.get(id);
	}

	/**
	 * 
	 * Gets the id for _booleanArrayMap
	 * @param id	the id associated with the map       
	 * @return id
	 * @since 1.0
	 */
	public IVariable<Boolean[]> GetBooleanArray(String id) {
		return this._booleanArrayMap.get(id);
	}

	/**
	 * Gets the id for _doubleMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IVariable<Double> GetDouble(String id) {
		return this._doubleMap.get(id);
	}

	/**
	 * Gets the id for _doubleArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IVariable<Double[]> GetDoubleArray(String id) {
		return this._doubleArrayMap.get(id);
	}

	/**
	 * Gets the id for _floatMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IVariable<Float> GetFloat(String id) {
		return this._floatMap.get(id);
	}

	/**
	 * Gets the id for _floatArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IVariable<Float[]> GetFloatArray(String id) {
		return this._floatArrayMap.get(id);
	}

	/**
	 * Gets the id for _integerMap
	 * @param id	 the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IVariable<Integer> GetInteger(String id) {
		return this._integerMap.get(id);

	}

	/**
	 * Gets the id for _integerArrayMap
	 * @param id	 the id associated with the map
	 * @since 1.0
	 */
	public IVariable<Integer[]> GetIntegerArray(String id) {
		return this._integerArrayMap.get(id);
	}

	/**
	 * Gets the id for _longMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IVariable<Long> GetLong(String id) {
		return this._longMap.get(id);
	}

	/**
	 * Gets the id for _longArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IVariable<Long[]> GetLongArray(String id) {
		return this._longArrayMap.get(id);
	}

	/**
	 * Gets the id for _stringMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IVariable<String> GetString(String id) {
		return this._stringMap.get(id);
	}

	/**
	 * Gets the id for _stringArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IVariable<String[]> GetStringArray(String id) {
		return this._stringArrayMap.get(id);
	}

	/**
	 * Determines the value type for a Variable
	 * 
	 * @param id
	 * @param variable
	 * @param Type
	 */
	public void SetVariable(String key, IVariable<?> variable, VariableType Type) {
		switch (Type) {
		case INTEGER:
			this._setIntegerMap(key, (IVariable<Integer>) variable);
			break;
		case INTEGERARRAY:
			this._setIntegerArrayMap(key, (IVariable<Integer[]>) variable);
			break;
		case STRING:
			this._setStringMap(key, (IVariable<String>) variable);
			break;
		case STRINGARRAY:
			this._setStringArrayMap(key, (IVariable<String[]>) variable);
			break;
		case FLOAT:
			this._setFloatMap(key, (IVariable<Float>) variable);
			break;
		case FLOATARRAY:
			this._setFloatArrayMap(key, (IVariable<Float[]>) variable);
			break;
		case LONG:
			this._setLongMap(key, (IVariable<Long>) variable);
			break;
		case LONGARRAY:
			this._setLongArrayMap(key, (IVariable<Long[]>) variable);
			break;
		case DOUBLE:
			this._setDoubleMap(key, (IVariable<Double>) variable);
			break;
		case DOUBLEARRAY:
			this._setDoubleArrayMap(key, (IVariable<Double[]>) variable);
			break;
		case BOOLEAN:
			this._setBooleanMap(key, (IVariable<Boolean>) variable);
			break;
		case BOOLEANARRAY:
			this._setBooleanArrayMap(key, (IVariable<Boolean[]>) variable);
			break;
		default:
			return;
		}

	}
	
	/**
	 * updates the value of a boolean variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Boolean newValue) {
		this._booleanMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a boolean variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Boolean[] newValue) {
		this._booleanArrayMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a double variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Double newValue) {
		this._doubleMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a double variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Double[] newValue) {
		this._doubleArrayMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a Float variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Float newValue) {
		this._floatMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a float variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Float[] newValue) {
		this._floatArrayMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of an integer variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Integer newValue) {

		this._integerMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of an integer variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Integer[] newValue) {
		this._integerArrayMap.get(key).SetValue(newValue);

	}
	
	/**
	 * updates the value of a long variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Long newValue) {
		this._longMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a long variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Long[] newValue) {
		this._longArrayMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a String variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, String newValue) {
		this._stringMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a String array variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, String[] newValue) {
		this._stringArrayMap.get(key).SetValue(newValue);
	}
	
}
