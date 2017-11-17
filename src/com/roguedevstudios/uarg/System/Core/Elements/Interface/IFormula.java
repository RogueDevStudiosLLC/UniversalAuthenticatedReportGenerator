package com.roguedevstudios.uarg.System.Core.Elements.Interface;

public interface IFormula {
	/**
	 * Takes in an array of Number based Variables and
	 * processes them through this formula returning an
	 * Integer representation of the resulting answer.
	 * @param args
	 * @return
	 */
	Integer CalculateToInteger(IVariable<?>[] args);
	/**
	 * Takes in an array of Number based Variables and
	 * processes them through this formula returning a
	 * Doble representation of the resulting answer.
	 * @param args
	 * @return
	 */
	Double CalculateToDouble(IVariable<?>[] args);
	/**
	 * Takes in an array of Number based Variables and
	 * processes them through this formula returning a
	 * Float representation of the resulting answer.
	 * @param args
	 * @return
	 */
	Float CalculateToFloat(IVariable<?>[] args);
	/**
	 * Takes in an array of Number based Variables and
	 * processes them through this formula returning a
	 * Long representation of the resulting answer.
	 * @param args
	 * @return
	 */
	Long CalculateToLong(IVariable<?>[] args);
	/**
	 * Gets the string representation of the
	 * derived formula.
	 * @return
	 */
	String GetFormula();
	/**
	 * Gets the original config string that this formula
	 * was derived from.
	 * @return
	 */
	String GetOriginalFormula();
	/**
	 * Gets the array size expected when passing arguments
	 * to be processed by this formula.
	 * @return
	 */
	int GetArgumentsLength();
	/**
	 * Gets the human readable name for this formula.
	 * @return
	 */
	String GetName();
	/**
	 * Gets a description of this formula.
	 * @return
	 */
	String GetDescription();
	/**
	 * Gets the ID of this formula.
	 * @return
	 */
	String GetFormulaID();
	
}
