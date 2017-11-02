package com.roguedevstudios.uarg.System.Core.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.*;

import java.util.*;

/**
 * <P>
 * this will test the Variable.java file
 * <P>
 * 
 * @author Terry Roberson
 * @since 1.0
 */
public class VariableTest{
	
	/**
	 * <P>
	 * obtains the class Variable.java name
	 * <P>
	 * 
	 * @author Terry Roberson
	 * @since 1.0
	 */
	public class VariableName{
		/*obtain Variable.java Name.*/
		Class<?> variableClass = Variable.class;
		/*obtain Variable.java fully qualified class name*/
		String variableName = variableClass.getName();
		/*obtain Variable.java name without package*/
		String simpleVariableName = variableClass.getSimpleName();
	}
	
	/**
	 * <P>
	 * obtains the class Variable.java modifiers
	 * <P>
	 * 
	 * @author Terry Roberson
	 * @since 1.0
	 */
	public class VariableModifiers{
		
		/*obtain class Variable.java modifiers*/
		Class<?> variableClass = Modifier.class;
		/*get method for obtaining modifiers*/
		int modifiers = variableClass.getModifiers();
		
	}
	
	/**
	 * <P>
	 * obtains the class Variable.java package information
	 * <P>
	 * 
	 * @author Terry Roberson
	 * @since 1.0
	 */
	public class VariablePackage{
		
		/*obtain information about Variable.java package*/
		Class<?> variableClass = Package.class;
		/*get method to obtain information about Variable.java package*/
		Package variablePackage = variableClass.getPackage();
	}
	
	/*accesses superclass of Variable.java*/
	Class<?> superClass = (Variable.class).getSuperclass();
	
	/**
	 * <P>
	 * obtains the class Variable.java constructor objects
	 * <P>
	 * 
	 * @author Terry Roberson
	 * @since 1.0
	 */
	public class VariableConstructors{
		
		/*obtain information about Variable.java  constructor objects*/
		Class<?> variableClass = Constructor.class;
		/*get method to obtain information about Variable.java constructors*/
		Constructor<?>[] constructors = variableClass.getConstructors();
		/*read what parameters a given constructor takes*/
		Class<?>[] parameterTypes = constructors[2].getParameterTypes();
		/**/
		protected List<String> stringList = ...;
		Constructor<?> variable = Variable.class.getConstructor(String.class, String.class, boolean.class, V.class String.class);
	}
	
	

}

