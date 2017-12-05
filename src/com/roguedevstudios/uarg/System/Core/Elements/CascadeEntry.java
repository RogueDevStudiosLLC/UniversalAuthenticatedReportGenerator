package com.roguedevstudios.uarg.System.Core.Elements;

import java.util.List;

import com.roguedevstudios.uarg.System.Core.Elements.Interface.ICascadeEntry;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormuli;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariables;

/**
 * Cascade Entry implementation representing a single load
 * for a Cascade Map entry vector.
 * @author Christopher Howard
 *
 */
public class CascadeEntry implements ICascadeEntry {

	/* List of input ID's for this vector */
	private List<String> _inputIDList;
	
	/* The output ID for this vector */
	private String _outputID;
	
	/* The function for this vector */
	private String _formulaID;
	
	/* A description of this vector */
	private String _description;
	
	/**
	 * Constructor for a pre-build Cascade Entry
	 * @param _inputIDList
	 * @param _outputID
	 * @param _formulaID
	 * @param _description
	 */
	public CascadeEntry( List<String> _inputIDList,
						 String _outputID, 
						 String _formulaID, 
						 String _description
					   ) 
	{
		super();
		this._inputIDList = _inputIDList;
		this._outputID = _outputID;
		this._formulaID = _formulaID;
		this._description = _description;
	}

	/**
	 * Gathers the requested variables by the internal ID list from the
	 * given IVariables container
	 * @param vars Variables container given to work against.
	 * @return IVariable<?>[] Gathered variables from the Variables container
	 * @author Christopher Howard
	 */
	private IVariable<?>[] _getVariables( IVariables vars ) 
	{
		// Setup the output variables container
		IVariable<?>[] varsOut = new IVariable<?>[ this._inputIDList.size() ];
		
		// Get each variable from the Variables container using the correct Getter
		for( int i = 0;
			     i <= this._inputIDList.size() - 1;
				 i++
				 ) 
		{
			varsOut[i] = vars.GetVariable(this._inputIDList.get(i));
		}
		
		return varsOut;
	}

	/**
	 * Gets this entries description.
	 * @return String Descrtiption
	 * @author Christopher Howard
	 */
	public String GetDescription() 
	{
		return this._description;
	}

	/**
	 * Gets the formula ID from this entry
	 * @return String Formula ID
	 * @author Christopher Howard
	 */
	public String GetFormulaID() 
	{
		return this._formulaID;
	}

	/**
	 * Gets the list of input ID's for this entry
	 * @return List<String> List of Variable ID's
	 */
	public List<String> GetInputVariableIDList() 
	{
		return this._inputIDList;
	}

	/**
	 * Gets the Output Variable ID
	 * @return String Variable ID
	 */
	public String GetOutputVariableID() 
	{
		return this._outputID;
	}
	
	/**
	 * Detects null value variable wrappers
	 * @param vars IVariables compliant container object
	 * @return Null value detected in input set
	 */
	private boolean _shakeProtect( IVariables vars ) 
	{
		IVariable<?>[] varsList = this._getVariables(vars);
		
		for( IVariable<?> var: varsList ) 
		{
			if( var.GetValue() == null )
				return true;
		}
		return false;
	}
	
	/**
	 * Calls the processing command in the formula with the proper variables
	 * by calling the forumla, input variables, and output variable from the given
	 * containers to work against.
	 * @param vars Variables container to work against
	 * @param formulas Formuli container to work against
	 * @author Christopher Howard
	 */
	public void Shake( IVariables vars, 
					   IFormuli formulas
					   ) 
		   throws IllegalStateException 
	{
		
		// Check the output variables type and call the correct process
		// to calculate.
		// Protect from null children during shake process
		if(!this._shakeProtect(vars))
			return;
		
		switch( vars.GetVariableType( this._outputID ) ) 
		{
		case INTEGER:
			vars.
				GetInteger(
						this._outputID
						).
				SetValue(
						formulas.
							GetFormula(
									this._formulaID
									).
							CalculateToInteger(
									(IVariable<? extends Number>[]) this._getVariables(
														vars
														)
									)
							);
			break;
		case FLOAT:
			vars.
			GetFloat(
					this._outputID
					).
			SetValue(
					formulas.
						GetFormula(
								this._formulaID
								).
						CalculateToFloat(
								(IVariable<? extends Number>[]) this._getVariables(
													vars
													)
								)
						);
		break;
		case DOUBLE:
			vars.
			GetDouble(
					this._outputID
					).
			SetValue(
					formulas.
						GetFormula(
								this._formulaID
								).
						CalculateToDouble(
								(IVariable<? extends Number>[]) this._getVariables(
													vars
													)
								)
						);
		break;
		case LONG:
			vars.
			GetLong(
					this._outputID
					).
			SetValue(
					formulas.
						GetFormula(
								this._formulaID
								).
						CalculateToLong(
								(IVariable<? extends Number>[]) this._getVariables(
													vars
													)
								)
						);
		break;
		case INTEGERARRAY:
			vars.
			GetIntegerArray(
					this._outputID
					).
			SetValue(
					formulas.
						GetFormula(
								this._formulaID
								).
						CalculateToInteger(
								this._getVariables(
													vars
													),
								true
								)
						);
		break;
		case FLOATARRAY:
			vars.
			GetFloatArray(
					this._outputID
					).
			SetValue(
					formulas.
						GetFormula(
								this._formulaID
								).
						CalculateToFloat(
								this._getVariables(
													vars
													),
								true
								)
						);
			break;
		case LONGARRAY:
			vars.
			GetLongArray(
					this._outputID
					).
			SetValue(
					formulas.
						GetFormula(
								this._formulaID
								).
						CalculateToLong(
								this._getVariables(
													vars
													),
								true
								)
						);
			break;
		case DOUBLEARRAY:
			vars.
			GetDoubleArray(
					this._outputID
					).
			SetValue(
					formulas.
						GetFormula(
								this._formulaID
								).
						CalculateToDouble(
								this._getVariables(
													vars
													),
								true
								)
						);
			break;
		default:
			// Illegal output detected, throw IllegalStateException
			throw new IllegalStateException("Output type not supported by Shake mechanism.");
		}
		
	}
	

	

}
