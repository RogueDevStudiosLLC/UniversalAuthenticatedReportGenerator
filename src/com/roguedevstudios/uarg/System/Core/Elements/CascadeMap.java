package com.roguedevstudios.uarg.System.Core.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.roguedevstudios.uarg.System.Core.Elements.Interface.ICascadeEntry;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.ICascadeMap;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormuli;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariables;

/**
 * Cascade Map Implementation class to represent the
 * cascade effect between variables and formuli.
 * @author Christopher Howard
 *
 */
public class CascadeMap 
	   implements ICascadeMap 
{

	/* Child Node Entry Tree */
	private TreeMap< String, List< ICascadeEntry > > _childOfNodes;
	
	/* Parent Node Reverse Entry Tree */
	private TreeMap< String, List< ICascadeEntry > > _parentOfNodes;
	
	public CascadeMap() 
	{
		this._childOfNodes = new TreeMap<>();
		this._parentOfNodes = new TreeMap<>();
	}
	
	/**
	 * Shakes the Cascade Tree with a Variable Update
	 * @param UpdatedVariableID The ID of the variable that got updated causing the shake.
	 * @param vars the Variables container to function against.
	 * @param formulas the Formuli container to function against
	 * @return List<String> A list of all the variables that cascade updated.
	 * @author Christopher Howard
	 */
	public List<String> ShakeTree(
							String UpdatedVariableID, 
							IVariables vars, 
							IFormuli formulas
							) 
	{
		
		// Start the affect ID list
		List<String> affect = new ArrayList<String>();
		
		// Add this variable to the affect ID list
		affect.add(UpdatedVariableID);
		
		// If this variable does not effect another we are at a root, return the affect list
		// this is the base case for the recursion.
		if(!this._childOfNodes.containsKey(UpdatedVariableID))
			return affect;
		
		// If this variable has a parent we need to dive deeper, get its effects list.
		List<ICascadeEntry> effects = this.GetCascadesForVariable(UpdatedVariableID);
		
		// Cascade all the effects of this child
		for(ICascadeEntry effect: effects) 
		{
			// Cause the effect.
			effect.Shake(vars, formulas);
			
			// Vibrate the tree down to the roots recursively and add to the affect list.
			affect.addAll(
					this.ShakeTree(
							effect.GetOutputVariableID(), 
							vars, 
							formulas
							)
					);
		}
		
		// Return the affect list on unwind.
		return affect;
		
	}

	/**
	 * Gets the list of Cascade Entries for a VariableID
	 * @param VariableID
	 * @return List<ICascadeEntry> List of Cascades
	 * @author Christopher Howard
	 */
	public List< ICascadeEntry > GetCascadesForVariable( String VariableID ) 
	{
		return this.
					_childOfNodes.
					get(
						  VariableID
						);
	}
	
	/**
	 * Gets the list of Reverse Cascade Entries for a VariableID
	 * In theory this should always have a size of 1, but rare use cases
	 * may break such, so we assume a list object.
	 * @param VariableID
	 * @return List<ICascadeEntry> List of reverse cascades
	 * @author Christopher Howard
	 */
	public List< ICascadeEntry > GetReverseCascadesForVariable(	String VariableID )
	{
		return this.
				_parentOfNodes.
				get(
					  VariableID
					);
	}

	/**
	 * Adds a Cascade Entry to the mapping
	 * @param Entry The entry to be added.
	 * @author Christopher Howard
	 */
	public void AddEntry( ICascadeEntry Entry ) 
	{
		// For each child register it in the child mapping
		for( String input:
					Entry.GetInputVariableIDList()
			) 
		{
			// If this is a new child add it's key to the index
			if( !this._childOfNodes.containsKey(input) ) 
			{
				this._childOfNodes.put( input, new ArrayList<ICascadeEntry>() );
			}
			
			// Check that this is not a duplication before adding the entry
			if( !this.GetCascadesForVariable( input ).contains( Entry ) ) 
			{
				this.GetCascadesForVariable( input ).add( Entry );
			}	
			
		}
		
		// If the parent is not registered in the parent reverse tree, do so now
		if( !this._parentOfNodes.containsKey( Entry.GetOutputVariableID() ) ) 
		{
			this._parentOfNodes.put( Entry.GetOutputVariableID(), 
									 new ArrayList< ICascadeEntry >()
									 );
		}
		// Add the entry to the parent reverse tree
		if( !this._parentOfNodes.get( Entry.GetOutputVariableID() ).contains( Entry ) ) 
		{
			this._parentOfNodes.get( Entry.GetOutputVariableID() ).add( Entry );
		}
		
	}
	
	public void AddAllEntries( List< ICascadeEntry > Entries ) 
	{
		for(ICascadeEntry Entry: 
						  Entries
			) 
		{
			this.AddEntry( Entry );
		}
	}

}
