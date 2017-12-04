package com.roguedevstudios.uarg.System.Core.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.roguedevstudios.uarg.System.Core.Elements.CascadeEntry;
import com.roguedevstudios.uarg.System.Core.Elements.CascadeMap;
import com.roguedevstudios.uarg.System.Core.Elements.Formula;
import com.roguedevstudios.uarg.System.Core.Elements.Formuli;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;
import com.roguedevstudios.uarg.System.Core.Elements.Variables;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.ICascadeEntry;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormuli;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariables;
import com.roguedevstudios.uarg.System.Core.Enum.VariableType;

public class CascadeMapTest {

	private CascadeMap CM;
	private IFormuli formuli;
	private IVariables vars;
	
	@Before
	public void Setup() {
		this.vars = new Variables();
		this.formuli = new Formuli();
		this.CM = new CascadeMap();
		
		this.formuli.AddFormula("Square", new Formula("Square", "Square of Item", "Square", "_VAR_^2"));
		this.formuli.AddFormula("Volume", new Formula("Volume","Volume of Item","Volume","_BASE_*_HEIGHT_"));
		this.formuli.AddFormula("BaseArea", new Formula("BaseArea","Area of an items Base","BaseArea","_WIDTH_*_DEPTH_"));
		
		this.vars.SetVariable( "Building Base Width", 
								new Variable<Integer>( "Building Base Width", 
													   "Building Base Width", 
													    true, 
													    "The width of a building base", 
													    5), 
								VariableType.INTEGER
							 );
		this.vars.SetVariable( "Building Base Height", 
				new Variable<Integer>( "Building Base Height", 
									   "Building Base Height", 
									    true, 
									    "The height of a building", 
									    10), 
				VariableType.INTEGER
			 );
		this.vars.SetVariable( "Building Base Depth", 
				new Variable<Integer>( "Building Base Depth", 
									   "Building Base Depth", 
									    true, 
									    "The Depth of a building base", 
									    20), 
				VariableType.INTEGER
			 );
		this.vars.SetVariable( "Building Grid Volume", 
				new Variable<Integer>( "Building Grid Volume", 
									   "Building Grid Volume", 
									    true, 
									    "The Grid Volume of a buildings"
									    ), 
				VariableType.INTEGER
			 );
		this.vars.SetVariable( "Building Base Area", 
				new Variable<Integer>( "Building Base Area", 
									   "Building Base Area", 
									    true, 
									    "The Base Area of a building"
									    ), 
				VariableType.INTEGER
			 );
		this.vars.SetVariable( "Building Volume", 
				new Variable<Integer>( "Building Volume", 
									   "Building Volume", 
									    true, 
									    "The Volume of a building"
									    ), 
				VariableType.INTEGER
			 );
		
		//System.out.println(this.vars.GetIntegerCount());
		List<ICascadeEntry> Vectors = new ArrayList<ICascadeEntry>();
		List<String> V1 = new ArrayList<>();
		V1.add("Building Base Depth");
		V1.add("Building Base Width");
		Vectors.add(new CascadeEntry(
									V1, 
									"Building Base Area", 
									"BaseArea", 
									"Base Area Calculation"));
		List<String> V2 = new ArrayList<>();
		V2.add("Building Base Area");
		V2.add("Building Base Height");
		Vectors.add(new CascadeEntry(
									V2, 
									"Building Volume", 
									"Volume", 
									"Volume Calculation"));
		List<String> V3 = new ArrayList<>();
		V3.add("Building Volume");
		Vectors.add(new CascadeEntry(
									V3, 
									"Building Grid Volume", 
									"Square", 
									"Square Calculation"));
		CM.AddAllEntries(Vectors);
		
	}
	
	@Test
	public void TestCascadeMapConstruction() {
		try {
			CM.ShakeTree("Building Base Width", this.vars, this.formuli);
			/*
			for(String ID: this.vars.GetMasterIDList()) {
				IVariable<?> var = this.vars.GetVariable(ID);
				System.out.println(var.toString());
			}
			*/
		}catch(Exception e) {
			System.err.println(e.getMessage());
			assertTrue(false);
		}
		assertTrue(true);
	}

}
