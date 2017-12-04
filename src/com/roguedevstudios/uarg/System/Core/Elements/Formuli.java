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
import java.util.List;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormula;

/**
 * <p>
 * This class implements IFormuli and constructs formulas for the class formula
 * @author Terry Roberson
 * @since 1.0
 */
public class Formuli {
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
	public Formuli(TreeMap<String, IFormula> _formulaMap, TreeMap<String, List<String>> _formulaSetMap) {
		
	}
	
	
	/**
	 * Initializes the formuli maps for internal formula storage
	 * @since 1.0
	 */
	private void _build() {
		this._formulaMap = new TreeMap<String, IFormula>();
		this._formulaSetMap = new TreeMap<String, List<String>>();
	}
	
	
	
}


