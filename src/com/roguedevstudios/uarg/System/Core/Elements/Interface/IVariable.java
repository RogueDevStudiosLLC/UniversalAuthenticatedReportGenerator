package com.roguedevstudios.uarg.System.Core.Elements.Interface;

public interface IVariable<V> {
	String GetName();
	String GetDescription();
	String GetId();
	V GetValue();
	Boolean IsRequiredInput();
	void SetDescription(String description);
	void SetId(String id);
	void SetName(String name);
	void SetRequiresInput(Boolean required);
	void SetValue(V value);
}
