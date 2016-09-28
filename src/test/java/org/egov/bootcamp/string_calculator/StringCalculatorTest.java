package org.egov.bootcamp.string_calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author subhash
 *
 */
public class StringCalculatorTest {

	@Rule
	public ExpectedException thrownException = ExpectedException.none();

	@Test
	public void shouldThrowExceptionIfEmptyString() throws Exception {
		thrownException.expect(InvalidDataException.class);
		StringCalculator.calculate("");
	}

	@Test
	public void shouldThrowExceptionIfSpecialCharacters() throws Exception {
		thrownException.expect(InvalidDataException.class);
		StringCalculator.calculate("|");
	}

	@Test
	public void shouldThrowExceptionInCaseOfNull() throws Exception {
		thrownException.expect(NullPointerException.class);
		StringCalculator.calculate(null);
	}

	@Test
	public void shouldThrowExceptionIfContinsOnlySpecialCharacters()
			throws Exception {
		thrownException.expect(InvalidDataException.class);
		StringCalculator.calculate("100+");
		StringCalculator.calculate("+100");		
		StringCalculator.calculate("+100+");
		StringCalculator.calculate(" + ");
		StringCalculator.calculate(" + ");
		StringCalculator.calculate(" ++ ");
		StringCalculator.calculate("+");
		StringCalculator.calculate(" 100 ");
		
	}
	
	@Test
	public void shouldReturnValidResult() throws Exception {
		assertEquals(2, StringCalculator.calculate("1+1"));
		assertEquals(101, StringCalculator.calculate("100+1"));
		assertEquals(11, StringCalculator.calculate(" 10 + 1 "));
		assertEquals(11, StringCalculator.calculate(" 11"));
	}
}
