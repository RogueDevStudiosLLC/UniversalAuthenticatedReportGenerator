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
public class variables {
	/**
	 * Declares the details of the variables and assign them to generic types.
	 *
	 * @param <N> name of id, if given.
	 * @param <I> ID of value.
	 * @param <V> value of variable.
	 * @param <D> description of variable.
	 * @since 1.0
	 */
	public class variableInformation<N, I, V, D>{
		
		private N name;
		private I id;
		private V value;
		private D description;
		
		/**
		 * constructor
		 *   
		 * @param name = N
		 * @param id = I
		 * @param value = V
		 * @param description = D
		 * @since 1.0
		 */
		public void Seperation(N name, I id, V value, D description) {
			this.name = name;
			this.id = id;
			this.value = value;
			this.description = description;
		}
		
		private N getName(String){
			return name;
		}
		private I getId(){
			return id;
		}
		private V getValue(double){
			private bool isVarIndependant;
			
		}
		private D getDescription(String){
			return description;
		}
		
	}
	
	

}
