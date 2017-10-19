/********************************
*   Variable Class			    *
*   File Name: variable.java   *
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
}
		public variable(String name, String id, V value, String description) {
			/**
			 * accessor methods for variable name
			 * 
			 * @param name	the name of the variable
			 * 
			 * @return	the accessor methods should provide the variable name
			 */
			private String getName() {
				
				return name;
			}
			private void setName(String name) {
				this.name = name;
			}
			/**
			 * accessor methods for variable ID
			 * 
			 * @param id	the ID of the variable
			 * 
			 * @return	the accessor methods should provide the variable ID
			 */
			private String getId(String id) {
				return id;
			}
			private void setId(String id) {
				this.id = id;
			}
			/**
			 * accessor methods for variable value
			 * 
			 * @param value	the value of the variable
			 * 
			 * @return	the accessor methods should provide the variable value
			 */
			private V getValue() {
				return value;
			}
			private void setValue(V value) {
				this.value = value;
			}
			/**
			 * accessor methods for variable description
			 * 
			 * @param description	the description of the variable
			 * 
			 * @return	the accessor methods should provide the variable description
			 */
			private String getDescription() {
				return description;
			}
			private void setDescription(String description) {
				this.description = description;
			}
			/**
			 * accessor methods for variable dependency
			 * 
			 * @param requiresInput	tells user if variable is independent/dependent
			 * 
			 * @return	the accessor methods should state if the variables is independent or dependent
			 */	
	
}
	