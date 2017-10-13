/********************************
*   Variables Class			    *
*   File Name: variable.class   *
*                               *
*   the class file for          *
*   the variables.		        *
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
public class variables<N, I, V, D> {
	/**
	 * Declares the details of the variables and assign them to generic types.
	 *
	 * @since 1.0
	 */	
	private N name;
	private I id;
	private V value;
	private D description;
	
	/**
	 * constructor
	 *   
	 * @param name  the names of the variables called
	 * 
	 * @param id  the ID of the called variable
	 * 
	 * @param value  the value of the called variable
	 * 
	 * @param description  the description of the called variable 
	 * 
	 * @return	<code> identifies value <code>
	 * 			class returns specified value
	 * @since 1.0
	 */
		public void Seperation(N name, I id, V value, D description) {
			this.name = name;
			this.id = id;
			this.value = value;
			this.description = description;
		}
		/**
		 * getName method
		 * 
		 * @param N	the generic type associated with varName
		 * 
		 * @return name
		 * 
		 * @since 1.0
		 */
		private N getName(String){
			return name;
		}
		
		/**
		 * getId method 
		 * 
		 * @param I	the generic type associated with varID
		 * 
		 * @return id
		 * 
		 * @since 1.0
		 */
		private I getId(int){
			return id;
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
		private V getValue(double){
			private bool isVarIndependant;
			
		}
		
		/**
		 * getDescription
		 * 
		 * @param D	the generic type associated with varDescription
		 * 
		 * @return description 
		 * 
		 * @since 1.0
		 */
		private D getDescription(String){
			return description;
		}
		
	
	
	


