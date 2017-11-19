package com.roguedevstudios.uarg.System.Core.Elements.Interface;
/********************************
*   Formula Interface		    *
*   File Name: IFormulaSet.java    *
*                               *
*   Inversion of Control		*
*   for Formula 		 		*
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/
/**
 * Interface representing requirements for the FormulaSet class
 * 
 * @author Gabriel Rosales
 *
 */
public interface IFormulaSet 
{
	/**
	 * Gets name of this FormulaSet
	 * @return SetName
	 * @since 1.0
	 */
	String GetFormulaSetName();
	/**
	 * Gets description of this FormulaSet
	 * @return SetDescription
	 * @since 1.0
	 */
	String GetFormulaSetDescription();
	/**
	 * Sets the name of this formulaset
	 * @param Formulaset Name name
	 * @since 1.0
	 */
	void SetFormulaSetName(String setName);
	/**
	 * Sets the description of this formulaset
	 * @param Formulaset Description description
	 * @since 1.0
	 */
	void SetFormulaSetDescription(String setDescription);
	
	
}
