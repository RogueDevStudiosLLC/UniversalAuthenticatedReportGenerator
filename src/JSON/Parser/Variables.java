/********************************
*   Variables Class			    *
*   File Name: Variables.java   *
*                               *
*   Variables will construct    *
*   the variables needed		*
*                               *
*  ©3000 Rogue Dev Studios, LLC *
********************************/
package JSON.Parser;

import java.util.TreeMap;

// Import Section
/**
* <p>
* the construction of variables 
*
* </p>
* 
* @author Grant Richards
* @since 1.0
*/
public class Variables<V> {

	
	


	private TreeMap <String, Variable <Integer>> _integerMap;
	
	private TreeMap <String, Variable <Integer[]>> _integerArrayMap;
	
	private TreeMap <String, Variable <String>> _StringMap;
	
	private TreeMap <String, Variable <String[]>> _StringArrayMap;
	
	private TreeMap <String, Variable <Float>> _floatMap;
	
	private TreeMap <String, Variable <Float[]>> _floatArrayMap;
	
	private TreeMap <String, Variable <Long>> _longMap;
	
	private TreeMap <String, Variable <Long[]>> _longArrayMap;
	
	private TreeMap <String, Variable <Double>> _doubleMap;
	
	private TreeMap <String, Variable <Double[]>> _doubleArrayMap;
	
	private TreeMap <String, Variable <Boolean>> _booleanMap;
	
	private TreeMap <String, Variable <Boolean[]>> _booleanArrayMap;
	
	
	

	
	
	public Variables() throws Exception {
		try{
			this._build();
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * constructor
	 *   
	 * @param _integerMap  a treemap of the variable type integer
	 * 
	 * @param _integerArrayMap  a treemap of the variable type integerArray
	 * 
	 * @param _StringMap  a treemap of the variable type String
	 * 
	 * @param _StringArrayMap  a treemap of the variable type StringArray
	 * 
	 * 
	 * @param _floatMap  a treemap of the variable type float
	 * 
	 * @param _floatArrayMap  a treemap of the variable type floatArray
	 * 
	 * @param _longMap  a treemap of the variable type long
	 * 
	 * @param _longArrayMap  a treemap of the variable type longArray
	 * 
	 * @param _doubleMap  a treemap of the variable type double
	 * 
	 * @param _doubleArrayMap  a treemap of the variable type doubleArray
	 * 
	 * @param _booleanMap  a treemap of the variable type boolean
	 * 
	 * @param _booleanArrayMap  a treemap of the variable type booleanArray
	 * 
	 * @return	<code> identifies value <code>
	 * 			class returns specified value
	 * @since 1.0
	 */
	
	private void _build(){
		this._integerMap = new TreeMap <String, Variables <Integer>>();
		this._integerArrayMap = new TreeMap <String, Variables <Integer[]>>();
		this._StringMap = new TreeMap <String, Variables <String>>();
		this._StringArrayMap = new TreeMap <String, Variables <String[]>>();
		this._floatMap = new TreeMap <String, Variables <Float>>();
		this._floatArrayMap = new TreeMap <String, Variables <Float[]>>();
		this._longMap = new TreeMap <String, Variables <Long>>();
		this._longArrayMap = new TreeMap <String, Variables <Long[]>>();
		this._doubleMap = new TreeMap <String, Variables <Double>>();
		this._doubleArrayMap = new TreeMap <String, Variables <Double[]>>();
		this._booleanMap = new TreeMap <String, Variables <Boolean>>();
		this._booleanArrayMap = new TreeMap <String, Variables <Boolean[]>>();
		
		
	}
	/**
	* 
	* Gets the id for _integerMap
	* 
	* 
	* @return	id
	*
	* @since 1.0
	*/
	public Variable<Integer []> GetInteger (String id)
	return this._integerMap.get ( id );


	}
	
	/**
	* SetInteger method
	*
	* sets _integermap
	* 
	* 
	*
	* @since 1.0
	* 
	* 	*/
	public void SetInteger(String id) {
		this._integerMap = _integerMap;
	}


	/**
	* 
	* Gets the id for _integerArrayMap
	* 
	* 
	* @return	id
	*
	* @since 1.0
	*/
	public Variable<Integer []> GetIntegerArray (String id)
	return this._integerArrayMap.get ( id );

/**
*sets _integerArrayMap
* 
* @since 1.0
* 
* 	*/
public void SetIntegerArray(String id) {
	this._integerArrayMap = _integerArrayMap;
}
	


public Variable<Integer []> GetString (String id){
return this._StringArrayMap.get ( id );
}

/**
* 
* Gets the id for StringMap
* 
* 
* @return	id
*
* @since 1.0
*/
public void SetString(String id) {
	this._StringMap = _StringMap;
}	

/**
*SetString method
* 
*sets _StringMap
*
* @since 1.0
*/
public Variable<Integer []> GetStringArray (String id){
return this._StringArrayMap.get ( id );
}

/**
* 
* Gets the id for _StringArrayMap
* 
* 
* @return	id
*
* @since 1.0
*/

public void SetStringArray(String id) {
	this._StringArrayMap = _StringArrayMap;
}	

/**
* 
* sets _StringArrayMap
*
* @since 1.0
*/

public Variable<Integer []> GetFloat (String id)
return this._floatMap.get ( id );

/**
* Gets the id for _floatMap
*
* @return id
*
* @since 1.0
* 
* 	*/
public void SetFloat(String id) {
	this._floatMap = _floatMap;
}


/**
*sets _floatmap
* 
*
* @since 1.0
*/
public Variable<Integer []> GetFloatArray (String id)
return this._floatArrayMap.get ( id );

/**
* Gets id for _floatArrayMap
*
*
* @return id
*
* @since 1.0
* 
* 	*/
public void SetFloatArray(String id) {
	this._floatArrayMap = _floatArrayMap;
}

/**
* set floatArrayMap
* 
* 
*
* @since 1.0
*/
public Variable<Integer []> GetLong (String id)
return this._longMap.get ( id );

/**
* Gets id for _longMap
*
* @return id 
*
* @since 1.0
* 
* 	*/
public void SetLong(String id) {
	this._longMap = _longMap;
}


/**
*
*sets _longmap	
*
* @since 1.0
*/
public Variable<Integer []> GetLongArray (String id)
return this._longArrayMap.get ( id );

/**
* gets id for longArrayMap
*
* @return id
*
* @since 1.0
* 
* 	*/
public void SetLongArray(String id) {
	this._longArrayMap = _longArrayMap;
}


/**
* SetLongArray method
* 
* sets _longArrayMap
* @since 1.0
*/
public Variable<Integer []> GetDouble (String id)
return this._doubleMap.get ( id );
}

/**
* gets id for _doublemap
*
* 
*
* @return id
* 
* @since 1.0
* 
* 	*/
public void SetDouble(String id) {
	this._doubleMap = _doubleMap;
}


/**
* 
* sets _doubleMap
*
* @since 1.0
*/
public Variable<Integer []> GetDoubleArray (String id)
return this._doubleArrayMap.get ( id );

/**
* gets id for _doubleArrayMap
*
* @return id 
*
* @since 1.0
* 
* 	*/
public void SetDoubleArray(String id) {
	this._doubleArrayMap = _doubleArrayMap;
}

/**
*
*sets _doubleArrayMap	
*
* @since 1.0
*/
public Variable<Integer []> GetBoolean (String id)
return this._booleanMap.get ( id );

/**
* gets id for _booleanMap
*
* 
*
* @return id
* 
* @since 1.0
* 
* 	*/
public void SetBoolean(String id) {
	this._booleanMap = _booleanMap;
}

/**
*
* sets _booleanMap
* 
* @since 1.0
* 
* 	*/

public Variable<Integer []> GetBooleanArray (String id)
return this._booleanArrayMap.get ( id );

/**
* gets id for _booleanArrayMap
*
* 
*
* @return id
* 
* @since 1.0
* 
* 	*/
public void SetBooleanArray(String id) {
	this._booleanArrayMap = _booleanArrayMap;
}

/**
* setBoolean method
*
*sets _booleanArrayMap
* 
* @since 1.0
* 
* 	*/