package com.roguedevstudios.uarg.System.Core.Elements.Interface;

import java.util.List;

public interface IConfig {
	List<String> VariableUpdated(String ID);
	List<String> GetVariableList();
	List<String> GetFormulaList();
	List<String> GetFormulaSetList();
	
}
