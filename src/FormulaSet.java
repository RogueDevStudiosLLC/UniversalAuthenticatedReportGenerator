/************************************************
 * Formula Set Class File                       *
 * File name: FormulaSet.java                   *
 * The class file for a formula set.            *
 ***********************************************/

package com.roguedevstudios.uarg.System.Core.Elements;

/**
 * This class is the formula set class.
 * @author Chel
 * @since 1.0
 */
public class FormulaSet {
	/*Class Attributes*/
	
	/*Name of the formula set*/
	private String _formulaSetName
	/*Description of the formula set*/
	private String _formulaSetDescription
	
	/*Class Methods */
	
	/**
	 * Constructor for FormulaSet class. Sets values for the set name and set description.
	 * @param setName	The name of the formula set.
	 * @param setDescription	The formula set description.
	 */
	public FormulaSet(String setName, String setDescription) {
		this._formulaSetName = setName;
		this._formulaSetDescription = setDescription;
		
	}
	
	/**
	 * Gets the formula set name.
	 * @return The formula set name String.
	 */
	public String GetFormulaSetName() {
		return this._formulaSetName;
	}
	
	/**
	 * Gets the formula set description.
	 * @return The formula set description String.
	 */
	public String GetFormulaSetDesc() {
		return this._formulaSetDescription;
	}
}
