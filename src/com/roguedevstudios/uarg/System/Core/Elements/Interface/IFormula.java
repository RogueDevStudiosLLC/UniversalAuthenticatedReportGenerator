package com.roguedevstudios.uarg.System.Core.Elements.Interface;
/********************************
*   Formula Interface		    *
*   File Name: IFormula.java    *
*                               *
*   Inversion of Control		*
*   for Formula 		 		*
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/
/**
 * Interface representing requirements for the Formula class
 * 
 * @author Gabriel Rosales
 *
 */

public interface IFormula 
{
	/**
	 * Gets name of this Formula
	 * @return FormulaName
	 * @since 1.0
	 */
	String GetFormulaName();
	/**
	 * Gets name of this Formula
	 * @return FormulaDesc
	 * @since 1.0
	 */
	String GetFromulaDesc();
	/**
	 * Gets name of this Formula
	 * @return FormulaID
	 * @since 1.0
	 */
	String GetFormulaId();
	/**
	 * Gets name of this Formula
	 * @return FormulaEquation
	 * @since 1.0
	 */
	String GetFormulaEquation();
	/**
	 * Gets name of this Formula
	 * @return FormulaInputArray
	 * @since 1.0
	 */
	Double GetFormulaInputArray();
	/**
	 * Sets the name of this formula
	 * @param Name Formula Name of this variable
	 * @since 1.0
	 */
	void SetFormulaName(String formulaName);
	/**
	 * Sets the description of this formula
	 * @param Formula Description description
	 * @since 1.0
	 */
	void SetFormulaDescription(String formulaDesc);
	/**
	 * Sets the id of this formula
	 * @param Id of this formula id
	 * @since 1.0
	 */
	void SetFormulaId(String formulaId);
	/**
	 * Sets the equation of this formula
	 * @param equation formula equation
	 * @since 1.0
	 */
	void SetFormulaEquation(String formulaEquation);
	/**
	 * Sets the value of this formula double
	 * @param value Value of this formula
	 * @since 1.0
	 */
	void SetFormulaInputArray(Double value);
}
