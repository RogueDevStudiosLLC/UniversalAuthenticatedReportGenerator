package com.roguedevstudios.uarg.System.Core.Elements;



/********************************
*   Formuli Class               *
*   File Name: Formuli.java     *
*                               *
*   The container for each 		*
*   formula created in 			*
*   Formula.java				*
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/

// Import Section
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormula;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormuli;

/**
 * <p>
 * This class implements IFormuli and constructs formulas for the class formula
 * @author Terry Roberson
 * @since 1.0
 */
public class Formuli implements IFormuli {
	private TreeMap<String, IFormula> _formulaMap;
	private TreeMap<String, List<String>> _formulaSetMap;

	/**
	 * Constructs the initial state if the Formuli container
	 * @since 1.0
	 */
	public Formuli() {
		this._build();
	}
	
	/**
	 * Constructs the formuli container with formula variables and formula map
	 * @since 1.0
	 */
	public Formuli(TreeMap<String, IFormula> formulaMap, TreeMap<String, List<String>> formulaSetMap) {
		this._formulaMap = formulaMap;
		this._formulaSetMap = formulaSetMap;
	}
	
	
	/**
	 * Initializes the formuli maps for internal formula storage
	 * @since 1.0
	 */
	private void _build() {
		this._formulaMap = new TreeMap<String, IFormula>();
		this._formulaSetMap = new TreeMap<String, List<String>>();
	}

	@Override
	public List<String> GetFormulaSet(String ID) {
		return this._formulaSetMap.get(ID);
	}

	@Override
	public void SetFormulaSet(String ID) {
		if(this._formulaSetMap.containsKey(ID))
			return;
		this._formulaSetMap.put(ID, new ArrayList<String>());
		
	}

	@Override
	public IFormula GetFormula(String ID) {
		return this._formulaMap.get(ID);
	}

	@Override
	public void AddFormulaToSet(String SetID, String FormulaID) {
		if(!this._formulaSetMap.containsKey(SetID))
			this.SetFormulaSet(SetID);
		if(this._formulaSetMap.get(SetID).contains(FormulaID))
			return;
		this._formulaSetMap.get(SetID).add(FormulaID);
		
	}

	@Override
	public void AddFormula(String ID, IFormula formula) {
		if(this._formulaMap.containsKey(ID))
			return;
		this._formulaMap.put(ID, formula);
		
	}
	
	
	
}


