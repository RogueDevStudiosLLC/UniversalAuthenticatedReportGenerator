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
		
		this.formuli.AddFormula("Monthly Period Rate", new Formula("Monthly Period Rate", "Monthly Period Rate", "Monthly Period Rate", "_WEEKS_ * _DAYS_ / _MONTHS_"));
		this.formuli.AddFormula("Unit Period Multiplier", new Formula("Unit Period Multiplier","Unit Period Multiplier","Unit Period Multiplier","_MONTHLY_ * _UNIT_"));
		this.formuli.AddFormula("BaseArea", new Formula("BaseArea","Area of an items Base","BaseArea","_WIDTH_*_DEPTH_"));
		
		this.vars.SetVariable( "Building Base Width", 
								new Variable<Integer>( "Building Base Width", 
													   "Building Base Width", 
													    true, 
													    "The width of a building base", 
													    5), 
								VariableType.INTEGER
							 );
		this.vars.SetVariable( "Week Day Multiplier", 
				new Variable<Double[]>( "Week Day Multiplier", 
									   "Week Day Multiplier", 
									    true, 
									    "Week Day Multiplier", 
									    new Double[] {5d,4d,3d,2d,1d,0.5d,(52d/12d),(52d/12d),1d,0.5d,(52d/12d),(52d/12d),(52d/12d),(52d/12d)}), 
				VariableType.DOUBLEARRAY
			 );
		this.vars.SetVariable( "Weeks in Year", 
				new Variable<Integer>( "Weeks in Year", 
									   "Weeks in Year", 
									    true, 
									    "Weeks in Year", 
									    52), 
				VariableType.INTEGER
			 );
		this.vars.SetVariable( "Months in Year", 
				new Variable<Integer>( "Months in Year", 
									   "Months in Year", 
									    true, 
									    "Months in Year", 
									    12), 
				VariableType.INTEGER
			 );
		this.vars.SetVariable( "Pickup Unit 1", 
				new Variable<Integer>( "Pickup Unit 1", 
									   "Pickup Unit 1", 
									    true, 
									    "Pickup Unit 1", 
									    1), 
				VariableType.INTEGER
			 );
		this.vars.SetVariable( "Pickup Unit 2", 
				new Variable<Integer>( "Pickup Unit 2", 
									   "Pickup Unit 2", 
									    true, 
									    "Pickup Unit 2",
									    2
									    ), 
				VariableType.INTEGER
			 );
		this.vars.SetVariable( "Pickup Unit 3", 
				new Variable<Integer>( "Pickup Unit 3", 
									   "Pickup Unit 3", 
									    true, 
									    "Pickup Unit 3",
									    3
									    ), 
				VariableType.INTEGER
			 );
		this.vars.SetVariable( "Pickup Unit 4", 
				new Variable<Integer>( "Pickup Unit 4", 
									   "Pickup Unit 4", 
									    true, 
									    "Pickup Unit 4",
									    4
									    ), 
				VariableType.INTEGER
			 );
		this.vars.SetVariable( "Pickup Unit 5", 
				new Variable<Integer>( "Pickup Unit 5", 
									   "Pickup Unit 5", 
									    true, 
									    "Pickup Unit 5",
									    5
									    ), 
				VariableType.INTEGER
			 );
		this.vars.SetVariable( "Pickup Unit 6", 
				new Variable<Integer>( "Pickup Unit 6", 
									   "Pickup Unit 6", 
									    true, 
									    "Pickup Unit 6",
									    6
									    ), 
				VariableType.INTEGER
			 );
		this.vars.SetVariable( "Pickup Unit 7", 
				new Variable<Integer>( "Pickup Unit 7", 
									   "Pickup Unit 7", 
									    true, 
									    "Pickup Unit 7",
									    4
									    ), 
				VariableType.INTEGER
			 );
		this.vars.SetVariable( "PickupFactor 1", 
				new Variable<Double[]>( "PickupFactor 1", 
									   "PickupFactor 1", 
									    true, 
									    "PickupFactor 1",
									    new Double[14]
									    ), 
				VariableType.DOUBLEARRAY
			 );
		this.vars.SetVariable( "PickupFactor 2", 
				new Variable<Double[]>( "PickupFactor 2", 
									   "PickupFactor 2", 
									    true, 
									    "PickupFactor 2",
									    new Double[14]
					    ), 
				VariableType.DOUBLEARRAY
			 );
		this.vars.SetVariable( "PickupFactor 3", 
				new Variable<Double[]>( "PickupFactor 3", 
									   "PickupFactor 3", 
									    true, 
									    "PickupFactor 3",
									    new Double[14]
					    ), 
				VariableType.DOUBLEARRAY
			 );
		this.vars.SetVariable( "PickupFactor 4", 
				new Variable<Integer[]>( "PickupFactor 4", 
									   "PickupFactor 4", 
									    true, 
									    "PickupFactor 4",
									    new Integer[14]
									    ), 
				VariableType.INTEGERARRAY
			 );
		this.vars.SetVariable( "PickupFactor 5", 
				new Variable<Integer[]>( "PickupFactor 5", 
									   "PickupFactor 5", 
									    true, 
									    "PickupFactor 5",
									    new Integer[14]
									    ), 
				VariableType.INTEGERARRAY
			 );
		this.vars.SetVariable( "PickupFactor 6", 
				new Variable<Integer[]>( "PickupFactor 6", 
									   "PickupFactor 6", 
									    true, 
									    "PickupFactor 6",
									    new Integer[14]
									    ), 
				VariableType.INTEGERARRAY
			 );
		this.vars.SetVariable( "PickupFactor 7", 
				new Variable<Integer[]>( "PickupFactor 7", 
									   "PickupFactor 7", 
									    true, 
									    "PickupFactor 7",
									    new Integer[14]
									    ), 
				VariableType.INTEGERARRAY
			 );
		
		//System.out.println(this.vars.GetIntegerCount());
		List<ICascadeEntry> Vectors = new ArrayList<ICascadeEntry>();
		List<String> V1 = new ArrayList<>();
		V1.add("Weeks in Year");
		V1.add("Week Day Multiplier");
		V1.add("Months in Year");
		Vectors.add(new CascadeEntry(
									V1, 
									"PickupFactor 1", 
									"Monthly Period Rate", 
									"Desc"));
		List<String> V2 = new ArrayList<>();
		V2.add("PickupFactor 1");
		V2.add("Pickup Unit 2");
		Vectors.add(new CascadeEntry(
									V2, 
									"PickupFactor 2", 
									"Unit Period Multiplier", 
									"Unit level 2"));
		List<String> V3 = new ArrayList<>();
		V3.add("PickupFactor 1");
		V3.add("Pickup Unit 2");
		Vectors.add(new CascadeEntry(
									V3, 
									"PickupFactor 3", 
									"Unit Period Multiplier", 
									"Unit level 3"));
		CM.AddAllEntries(Vectors);
		
	}
	
	@Test
	public void TestCascadeMapConstruction() {
		try {
			CM.ShakeTree("Week Day Multiplier", this.vars, this.formuli);
			
			for(String ID: this.vars.GetMasterIDList()) {
				IVariable<?> var = this.vars.GetVariable(ID);
				System.out.println(var.toString());
			}
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
			assertTrue(false);
		}
		assertTrue(true);
	}

}
