package VariablePackage;
/********************************
*   Variable Class			    *
*   File Name: Variable.java    *
*                               *
*   Variable Representation     *
*   with meta data.		        *
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/

// Import Section

/**
 * <p>
 * A representation of variables with added metadata.
 * </p>
 * 
 * @author Terry Roberson
 * @author Christopher E. Howard
 * @since 1.0
 */
public class Variable<V> {
	/* The name meta of this Variable */
	private String _name;
	/* The ID of this Variable */
	private String _id;
	/* The value of this Variable, generic typed */
	private V _value;
	/* The description of this Variable */
	private String _description;
	/* Whether this Variable is independent or dependent */
	private boolean _requiresInput;

	/**
	 * Constructs a Variable object with a known value
	 * 
	 * @param name
	 *            String name of this variable
	 * @param id
	 *            String ID of this variable
	 * @param requiresInput
	 *            Whether this variable is dependant
	 * @param description
	 *            Description of this variable
	 * @param value
	 *            Initial value of this variable
	 *
	 * @since 1.0
	 */

	public Variable(String name, String id, boolean requiresInput, String description, V value) {

		this._build(name, id, requiresInput, description, value);

	}

	/**
	 * Constructs a Variable object with an unknown value
	 * 
	 * @param name
	 *            String name of this variable
	 * @param id
	 *            String ID of this variable
	 * @param requiresInput
	 *            Whether this variable is dependent
	 * @param description
	 *            Description of this variable
	 *
	 * @throws Exception
	 *             Passes back unknown exceptions in case of incompatible null
	 *             typing of Generic
	 *
	 * @since 1.0
	 */
	public Variable(String name, String id, boolean requiresInput, String description) throws Exception {
		try {
			this._build(name, id, requiresInput, description, null);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Builds the Variable object with initial values
	 * 
	 * @param name
	 *            String name of this variable
	 * @param id
	 *            String ID of this variable
	 * @param requiresInput
	 *            Whether this variable is dependent
	 * @param description
	 *            Description of this variable
	 * @param value
	 *            Initial value of this variable
	 *
	 * @since 1.0
	 */
	private void _build(String name, String id, boolean requiresInput, String description, V value) {
		this._name = name;
		this._id = id;
		this._requiresInput = requiresInput;
		this._value = value;
		this._description = description;
	}

	/**
	 *
	 * Gets the name of this variable
	 * 
	 * @return Name
	 *
	 * @since 1.0
	 */
	public String GetName() {
		return this._name;
	}

	/**
	 * Sets the name of this variable
	 *
	 * @param name
	 *            String name of this variable
	 *
	 * @since 1.0
	 */
	public void SetName(String name) {
		this._name = name;
	}

	/**
	 * gets the ID of this variable
	 * 
	 * @return ID
	 * 
	 * @since 1.0
	 */
	public String GetId() {
		return this._id;
	}

	/**
	 * sets the ID of the variable
	 * 
	 * @param id
	 *            String id of this variable
	 * 
	 * @since 1.0
	 */
	public void SetId(String id) {
		this._id = id;
	}

	/**
	 * gets the value of this variable
	 * 
	 * @return Value
	 * 
	 * @since 1.0
	 */
	public V GetValue(V value) {
		return this._value;
	}

	/**
	 * sets the value of this variable
	 * 
	 * @param value
	 *            V value of this variable
	 * 
	 * @since 1.0
	 */
	public void SetValue(V value) {
		this._value = value;
	}

	/**
	 * gets the description of this variable
	 * 
	 * @return Description
	 * 
	 * @since 1.0
	 */
	public String GetDescription() {
		return this._description;
	}

	/**
	 * sets the description of this variable
	 * 
	 * @param description
	 *            String description of this variable
	 * 
	 * @since 1.0
	 */
	public void SetDescription(String description) {
		this._description = description;
	}

	/**
	 * checks whether this variable is dependent
	 * 
	 * @return RequiresInput
	 * 
	 * @since 1.0
	 */
	public boolean isRequiresInput() {
		return this._requiresInput;
	}

	/**
	 * sets the dependency of this variable
	 * 
	 * @param requiresInput
	 *            boolean dependency check of this variable
	 * 
	 * @since 1.0
	 */
	public void SetRequiresInput(boolean requiresInput) {
		this._requiresInput = requiresInput;
	}
	
	


}
