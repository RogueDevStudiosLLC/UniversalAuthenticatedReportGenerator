package com.roguedevstudios.uarg.System.Core.Elements.Interface;
/********************************
*   IVariable Interface		    *
*   File Name: IVariable.java   *
*                               *
*   Inversion of Control		*
*   for Variable		 		*
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/

/**
 * 
 * Interface representing Variable requirements
 * 
 * @author Christopher E. Howard
 * @author Terry Roberson
 * @since 1.0
 */
public interface IVariable<V>
{
	
	/**
	 * 
	 * Gets the name of this variable
	 * 
	 * @return Name
	 * @since 1.0
	 */
	String GetName();
	
	/**
	 * 
	 * Gets the description of this variable
	 * 
	 * @return Description
	 * @since 1.0
	 */
	String GetDescription();
	
	/**
	 * 
	 * Gets the ID of this variable
	 * 
	 * @return ID
	 * @since 1.0
	 */
	String GetId();
	
	/**
	 * 
	 * Gets the value of this variable
	 * 
	 * @return Value
	 * @since 1.0
	 */
	V GetValue();
	
	/**
	 * 
	 * Checks if variable is independent
	 * 
	 * @return RequiresInput
	 * @since 1.0
	 */
	Boolean IsRequiredInput();
	
	/**
	 * 
	 * Sets the description of this variable
	 * 
	 * @param description Description of this variable
	 * @since 1.0
	 */
	void SetDescription( String description );
	
	/**
	 * 
	 * Sets the ID of the variable
	 * 
	 * @param id String id of this variable
	 * @since 1.0
	 */
	void SetId( String id );
	
	/**
	 * 
	 * Sets the name of this variable
	 * 
	 * @param name String name of this variable
	 * @since 1.0
	 */
	void SetName( String name );
	
	/**
	 * 
	 * Sets whether the variable is independent
	 * 
	 * @param requiresInput boolean dependency check of this variable
	 * @since 1.0
	 */
	void SetRequiresInput( Boolean required );
	
	/**
	 * 
	 * Sets the value of this variable
	 * 
	 * @param value Value of this variable
	 * @since 1.0
	 */
	void SetValue( V value );
}
