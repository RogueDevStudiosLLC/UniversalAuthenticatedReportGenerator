import static org.junit.Assert.*;
import org.junit.Test;
public class VariableTest<V> {
	private Variable<V> value;

	@Test
	public void variableNameTest() {
		String _name = "hello";
		String expected = "hello";
		String result = _name;
		assertEquals(expected, result);
		
	}
	@Test 
	public void variableIdTest() {
		String _id = "world";
		String expected = "world";
		String result = _id;
		assertEquals(expected, result);
	}
	
	@Test
	public void variableValueTest() {
		Variable<V> _value;
		
		
	}
}
