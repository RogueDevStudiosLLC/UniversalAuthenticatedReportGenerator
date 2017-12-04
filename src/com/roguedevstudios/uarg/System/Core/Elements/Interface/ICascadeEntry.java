package com.roguedevstudios.uarg.System.Core.Elements.Interface;

import java.util.List;

public interface ICascadeEntry {

	String GetOutputVariableID();
	List<String> GetInputVariableIDList();
	String GetFormulaID();
	String GetDescription();
	void Shake(IVariables vars, IFormuli formulas);
}
