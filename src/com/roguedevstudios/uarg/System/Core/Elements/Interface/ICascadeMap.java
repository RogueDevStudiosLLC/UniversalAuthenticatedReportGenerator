package com.roguedevstudios.uarg.System.Core.Elements.Interface;

import java.util.List;

public interface ICascadeMap {

	List<String> ShakeTree(String UpdatedVariableID, IVariables vars, IFormuli formulas);
	List<ICascadeEntry> GetCascadesForVariable(String VariableID);
	void AddEntry(ICascadeEntry Entry);
	
}
