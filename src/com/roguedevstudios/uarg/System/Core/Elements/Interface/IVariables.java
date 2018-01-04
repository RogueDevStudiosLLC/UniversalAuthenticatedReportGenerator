//TODO: Cleanup #2
package com.roguedevstudios.uarg.System.Core.Elements.Interface;
/********************************
*   IVariables Interface        *
*   File Name: IVariables.java  *
*                               *
*   Inversion of Control for 	*
*   Variables.java				*
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/

import com.roguedevstudios.uarg.System.Core.Enum.VariableType;
//import section 

/**
 * Interface representing Variable container requirements
 * @author Christopher E. Howard
 * @author Terry Roberson
 * @since 1.0
 */
public interface IVariables {
	
	/**
	 * Gets the id for _booleanMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	IVariable<Boolean> GetBoolean(String key);
	
	/**
	 * 
	 * Gets the id for _booleanArrayMap
	 * @param id	the id associated with the map       
	 * @return id
	 * @since 1.0
	 */
	IVariable<Boolean[]> GetBooleanArray(String key);
	
	/**
	 * Gets the id for _doubleMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	IVariable<Double> GetDouble(String key);
	
	/**
	 * Gets the id for _doubleArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	IVariable<Double[]> GetDoubleArray(String key);
	
	/**
	 * Gets the id for _floatMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	IVariable<Float> GetFloat(String key);
	
	/**
	 * Gets the id for _floatArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	IVariable<Float[]> GetFloatArray(String key);
	
	/**
	 * Gets the id for _integerMap
	 * @param id	 the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	IVariable<Integer> GetInteger(String key);
	
	/**
	 * Gets the id for _integerArrayMap
	 * @param id	 the id associated with the map
	 * @since 1.0
	 */
	IVariable<Integer[]> GetIntegerArray(String key);
	
	/**
	 * Gets the id for _longMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	IVariable<Long> GetLong(String key);
	
	/**
	 * Gets the id for _longArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	IVariable<Long[]> GetLongArray(String key);
	
	/**
	 * Gets the id for _stringMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	IVariable<String> GetString(String key);
	
	/**
	 * Gets the id for _stringArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	IVariable<String[]> GetStringArray(String key);
	
	/**
	 * Determines the value type for a Variable
	 * @param id
	 * @param variable
	 * @param Type
	 */
	void SetVariable(String key, IVariable<?> variable, VariableType Type);
	
	/**
	 * updates the value of a boolean variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Boolean value);
	
	/**
	 * updates the value of a boolean variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Boolean[] value);
	
	/**
	 * updates the value of a double variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Double value);
	
	/**
	 * updates the value of a double variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Double[] value);
	
	/**
	 * updates the value of a Float variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Float value);
	
	/**
	 * updates the value of a float variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Float[] value);
	
	/**
	 * updates the value of an integer variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Integer value);
	
	/**
	 * updates the value of an integer variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Integer[] value);
	
	/**
	 * updates the value of a long variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Long value);
	
	/**
	 * updates the value of a long variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Long[] value);
	
	/**
	 * updates the value of a String variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, String value);
	
	/**
	 * updates the value of a String array variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, String[] value);
	
}
