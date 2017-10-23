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
	* 
	* 
	* @return	
	*
	* @since 1.0
	*/
	public  GetInteger(String ,Variable <Integer>) {
		return this._integerMap.get(Variable<Integer>);
	}
	
	/**
	* 
	*
	* @param 
	*
	* @since 1.0
	* 
	* 	*/
	public void SetInteger(String ) {
		this._integerMap = _integerMap;
	}


/**
*
* 
* 
* @return	
*
* @since 1.0
*/
public  GetIntegerArray(String ) {
	return this._integerArrayMap.get();
}

/**
* 
*
* @param 
*
* @since 1.0
* 
* 	*/
public void SetIntegerArray(String ) {
	this._integerArrayMap = _integerArrayMap;
}
	

/**
*
* 
* 
* @return	
*
* @since 1.0
*/
public  GetString(String ) {
	return this._integerMap.get();
}

/**
* 
*
* @param 
*
* @since 1.0
* 
* 	*/
public void SetString(String ) {
	this._integerMap = _integerMap;
}	

/**
*
* 
* 
* @return	
*
* @since 1.0
*/
public  GetFloat(String ) {
	return this._integerMap.get();
}

/**
* 
*
* @param 
*
* @since 1.0
* 
* 	*/
public void SetFloat(String ) {
	this._integerMap = _integerMap;
}


/**
*
* 
* 
* @return	
*
* @since 1.0
*/
public  GetFloatArray(String ) {
	return this._integerMap.get();
}

/**
* 
*
* @param 
*
* @since 1.0
* 
* 	*/
public void SetFloatArray(String ) {
	this._integerMap = _integerMap;
}

/**
*
* 
* 
* @return	
*
* @since 1.0
*/
public  GetLong(String ) {
	return this._integerMap.get();
}

/**
* 
*
* @param 
*
* @since 1.0
* 
* 	*/
public void SetLong(String ) {
	this._integerMap = _integerMap;
}


/**
*
* 
* 
* @return	
*
* @since 1.0
*/
public  GetLongArray(String ) {
	return this._integerMap.get();
}

/**
* 
*
* @param 
*
* @since 1.0
* 
* 	*/
public void SetLongArray(String ) {
	this._integerMap = _integerMap;
}


/**
*
* 
* 
* @return	
*
* @since 1.0
*/
public  GetDouble(String ) {
	return this._integerMap.get();
}

/**
* 
*
* @param 
*
* @since 1.0
* 
* 	*/
public void SetDouble(String ) {
	this._integerMap = _integerMap;
}


/**
*
* 
* 
* @return	
*
* @since 1.0
*/
public  GetDoubleArray(String ) {
	return this._integerMap.get();
}

/**
* 
*
* @param 
*
* @since 1.0
* 
* 	*/
public void SetDoubleArray(String ) {
	this._integerMap = _integerMap;
}

/**
*
* 
* 
* @return	
*
* @since 1.0
*/
public  GetBoolean(String ) {
	return this._integerMap.get();
}

/**
* 
*
* @param 
*
* @since 1.0
* 
* 	*/
public void SetBoolean(String ) {
	this._integerMap = _integerMap;
}

