/********************************
*   Variable Class			    *
*   File Name: variable.class   *
*                               *
*   the class file for          *
*   a variable.			        *
*                               *
*   ©3000 SomeCompany, Inc.     *
********************************/


/**
* <p>
* the variables class, declare values, 
* apply accessor methods
* </p>
* 
* @author Terry Roberson
* @since 1.0
*/
package JSON.Parser;
public class variable<V> {
	/**
	 * Declares the details of the variables and assigns generic type.
	 *
	 * @since 1.0
	 */	
	private String name;
	private String id;
	private V value;
	private String description;
	private boolean requiresInput;
	/**
	 * constructor
	 *   
	 * @param name  the names of the variables called
	 * 
	 * @param id  the ID of the called variable
	 * 
	 * @param requiresInput	declares is the variable is independant or dependant
	 * 
	 * @param value  the value of the called variable
	 * 
	 * @param description  the description of the called variable 
	 * 
	 * @return	<code> identifies value <code>
	 * 			class returns specified value
	 * @since 1.0
	 */
		public void Seperation(String name, String id, boolean requiresInput, V value, String description) {
			this.name = name;
			this.id = id;
			this.requiresInput = requiresInput;
			this.value = value;
			this.description = description;
		}
		/**
		 * getName method
		 * 
		 * @param String	String associated with varName
		 * 
		 * @return name
		 * 
		 * @since 1.0
		 */
		@SuppressWarnings("unused")
		private String getName(){
			return name;
		}
		
		/**
		 * getId method 
		 * 
		 * @param String	String associated with varID
		 * 
		 * @return id
		 * 
		 * @since 1.0
		 */
		@SuppressWarnings("unused")
		private String getId(){
			return id;
		}
		
		/**
		 * requiresInput method
		 * 
		 * @param boolean
		 * 
		 * @return	requiresInput
		 * 
		 * @since 1.0
		 */
		@SuppressWarnings("unused")
		private boolean requiresInput() {
			return requiresInput;
		}
		
		/**
		 * getValue method
		 * 
		 *@param V	the generic type associated with varValue
		 *
		 *@return	value
		 *
		 * @since 1.0
		 */
		@SuppressWarnings("unused")
		private V getValue() {
			
			return value;
		}
		
		/**
		 * getDescription
		 * 
		 * @param String	String associated with varDescription
		 * 
		 * @return description 
		 * 
		 * @since 1.0
		 */
		@SuppressWarnings("unused")
		private String getDescription(){
			return description;
		}
		
	
	
	
}

