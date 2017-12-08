package com.roguedevstudios.uarg.System.Core.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import com.roguedevstudios.uarg.System.Core.Elements.Variable;
import com.roguedevstudios.uarg.System.Core.Elements.Variables;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;
import com.roguedevstudios.uarg.System.Core.Enum.VariableType;


public class VariableTypeTest {
	private ArrayList<Integer[]> _initialVariableCondIntArrVals;
	private ArrayList<Float[]> _initialVariableCondFloatArrVals;
	private ArrayList<Double[]> _initialVariableCondDoubleArrVals;
	private ArrayList<String[]> _initialVariableCondStringArrVals;
	private ArrayList<Long[]> _initialVariableCondLongArrVals;
	private ArrayList<Boolean[]> _initialVariableCondBoolArrVals;
	@Before 
	public void VariablesStart() {
		//Populate initial int[] values
		this._initialVariableCondIntArrVals = new ArrayList<Integer[]>();
		// 0 slot = [99,12,3]
		this._initialVariableCondIntArrVals.add(new Integer[] {99,12,3});
		// 1 slot = [10,11,12]
		this._initialVariableCondIntArrVals.add(new Integer[] {10,11,12});
		// 2 slot = [15,20,25]
		this._initialVariableCondIntArrVals.add(new Integer[] {15,20,25});
		//Populate initial String[] values
		this._initialVariableCondStringArrVals = new ArrayList<String[]>();
		// 0 slot = [A,B,C]
		this._initialVariableCondStringArrVals.add(new String[] {"A","B","C"});
		// 1 slot = [B,C,D]
		this._initialVariableCondStringArrVals.add(new String[] {"B","C","D"});
		// 2 slot = [C,D,E]
		this._initialVariableCondStringArrVals.add(new String[] {"C","D","E"});
		//Populate initial Float[] values
		this._initialVariableCondDoubleArrVals = new ArrayList<Double[]>();
		// 0 slot = [990.2,30.5,.04]
		this._initialVariableCondDoubleArrVals.add(new Double[] {990.2,30.5,.04});
		// 1 slot = [10.1,35.5,401.5]
		this._initialVariableCondDoubleArrVals.add(new Double[] {10.1,35.5,401.5});
		// 2 slot = [15.36,5.2,4.8]
		this._initialVariableCondDoubleArrVals.add(new Double[] {15.36,5.2,4.8});
		//Populate initial Long[] values
		this._initialVariableCondLongArrVals = new ArrayList<Long[]>();
		// 0 slot = [99,50,8]
		this._initialVariableCondLongArrVals.add(new Long[] {99L,50L,8L});
		// 1 slot = [10,5,8000]
		this._initialVariableCondLongArrVals.add(new Long[] {10L,5L,8000L});
		// 2 slot = [15,8,56]
		this._initialVariableCondLongArrVals.add(new Long[] {15L,8L,56L});
		//Populate initial Float[] values
		this._initialVariableCondFloatArrVals = new ArrayList<Float[]>();
		// 0 slot = [99, 12,5.2]
		this._initialVariableCondFloatArrVals.add(new Float[] {99F, 12F,5.2F});
		// 1 slot = [10, 58.2,500.1]
		this._initialVariableCondFloatArrVals.add(new Float[] {10F, 58.2F,500.1F});
		// 2 slot = [15, 64.2,69.1]
		this._initialVariableCondFloatArrVals.add(new Float[] {15F, 64.2F,69.1F});
		//Populate initial Boolean[] values
		this._initialVariableCondBoolArrVals = new ArrayList<Boolean[]>();
		// 0 slot = [true, false, true]
		this._initialVariableCondBoolArrVals.add(new Boolean[] {true, false, true});
		// 1 slot = [false, true, false]
		this._initialVariableCondBoolArrVals.add(new Boolean[] {false, true, false});
		// 2 slot = [false, true, true]
		this._initialVariableCondBoolArrVals.add(new Boolean[] {false, true, true});
	}
	@Test
	public void TestGetVariableType() {
		Variable<Integer> vi1 = new Variable<Integer>("T", "T", false, "T", 10);
		Variable<String> vs1 = new Variable<String>("T", "T", false, "T", "TestString");
		Variable<Float> vf1 = new Variable<Float>("T", "T", false, "T", 5.4F);
		Variable<Double> vd1 = new Variable<Double>("T", "T", false, "T", 10.5);
		Variable<Long> vl1 = new Variable<Long>("T", "T", false, "T", 5L);
		Variable<Boolean> vb1 = new Variable<Boolean>("T", "T", false, "T", false);
		Variable<Integer[]> via1 = new Variable<Integer[]>("T", "T", false, "T", _initialVariableCondIntArrVals.get(0));
		Variable<String[]> vsa1 = new Variable<String[]>("T", "T", false, "T", _initialVariableCondStringArrVals.get(0));
		Variable<Float[]> vfa1 = new Variable<Float[]>("T", "T", false, "T", _initialVariableCondFloatArrVals.get(0));
		Variable<Double[]> vda1 = new Variable<Double[]>("T", "T", false, "T", _initialVariableCondDoubleArrVals.get(0));
		Variable<Long[]> vla1 = new Variable<Long[]>("T", "T", false, "T", _initialVariableCondLongArrVals.get(0));
		Variable<Boolean[]> vba1 = new Variable<Boolean[]>("T", "T", false, "T", _initialVariableCondBoolArrVals.get(0));
		TreeMap<String, IVariable<Integer>> integerMap =  new TreeMap<String, IVariable<Integer>>();
		TreeMap<String, IVariable<Integer[]>> integerArrayMap = new TreeMap<String, IVariable<Integer[]>>();
		TreeMap<String, IVariable<String>> stringMap =  new TreeMap<String, IVariable<String>>();;
		TreeMap<String, IVariable<String[]>> stringArrayMap =  new TreeMap<String, IVariable<String[]>>();;
		TreeMap<String, IVariable<Float>> floatMap =  new TreeMap<String, IVariable<Float>>();;
		TreeMap<String, IVariable<Float[]>> floatArrayMap =  new TreeMap<String, IVariable<Float[]>>();;
		TreeMap<String, IVariable<Long>> longMap =  new TreeMap<String, IVariable<Long>>();;
		TreeMap<String, IVariable<Long[]>> longArrayMap =  new TreeMap<String, IVariable<Long[]>>();;
		TreeMap<String, IVariable<Double>> doubleMap =  new TreeMap<String, IVariable<Double>>();;
		TreeMap<String, IVariable<Double[]>> doubleArrayMap =  new TreeMap<String, IVariable<Double[]>>();;
		TreeMap<String, IVariable<Boolean>> booleanMap =  new TreeMap<String, IVariable<Boolean>>();;
		TreeMap<String, IVariable<Boolean[]>> booleanArrayMap =  new TreeMap<String, IVariable<Boolean[]>>();;
		TreeMap<String, VariableType> variableTypeMap = new TreeMap<String, VariableType>();
		
		VariableType out = variableTypeMap//hmm
	
		
	}
}
