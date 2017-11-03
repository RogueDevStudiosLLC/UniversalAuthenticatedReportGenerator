package com.roguedevstudios.uarg.System.Core.Elements.Interface;

import com.roguedevstudios.uarg.System.Core.Enum.VariableType;

public interface IVariables {
	IVariable<Boolean> GetBoolean(String key);
	IVariable<Boolean[]> GetBooleanArray(String key);
	IVariable<Double> GetDouble(String key);
	IVariable<Double[]> GetDoubleArray(String key);
	IVariable<Float> GetFloat(String key);
	IVariable<Float[]> GetFloatArray(String key);
	IVariable<Integer> GetInteger(String key);
	IVariable<Integer[]> GetIntegerArray(String key);
	IVariable<Long> GetLong(String key);
	IVariable<Long[]> GetLongArray(String key);
	IVariable<String> GetString(String key);
	IVariable<String[]> GetStringArray(String key);
	void SetVariable(String key, IVariable<?> variable, VariableType Type);
	void UpdateValue(String key, Boolean value);
	void UpdateValue(String key, Boolean[] value);
	void UpdateValue(String key, Double value);
	void UpdateValue(String key, Double[] value);
	void UpdateValue(String key, Float value);
	void UpdateValue(String key, Float[] value);
	void UpdateValue(String key, Integer value);
	void UpdateValue(String key, Integer[] value);
	void UpdateValue(String key, Long value);
	void UpdateValue(String key, Long[] value);
	void UpdateValue(String key, String value);
	void UpdateValue(String key, String[] value);
	
}
