package com.roguedevstudios.uarg.System.Core.Elements.Interface;

import java.util.List;

public interface IFormuli {

	List<String> GetFormulaSet(String ID);
	void SetFormulaSet(String ID);
	IFormula GetFormula(String ID);
	void AddFormulaToSet(String SetID, String FormulaID);
	void AddFormula(String ID, IFormula formula);
	
}
