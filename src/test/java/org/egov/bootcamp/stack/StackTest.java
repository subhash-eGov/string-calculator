package org.egov.bootcamp.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * 
 * @author subhash
 *
 */
public class StackTest {

	private Stack<Object> elements;

	@Rule
	public ExpectedException thrownException = ExpectedException.none();

	@Before
	public void setUp() {
		elements = new Stack<Object>();
	}

	@Test
	public void push() {
		assertEquals(1, elements.push(1));
		assertEquals("2", elements.push("2"));
	}

	@Test
	public void shouldThrowExceptionOnNullInsertion() {
		thrownException.expect(NullPointerException.class);
		elements.push(null);
	}

	@Test
	public void shouldReturnNullOnEmptyStack() {
		assertEquals(null, elements.pop());
	}

	@Test
	public void size() {
		assertEquals(0, elements.size());
		elements.push(1);
		elements.push(2);
		assertEquals(2, elements.size());

	}

	@Test
	public void isEmpty() {
		assertTrue(elements.isEmpty());
		elements.push(1);
		elements.push(2);
		assertFalse(elements.isEmpty());
	}

	@Test
	public void shouldReturnTopElement() {
		elements.push(1);
		elements.push(2);
		elements.push(3);
		elements.push(4);
		assertEquals(4, elements.pop());
		assertEquals(3, elements.size());
		assertEquals(3, elements.pop());
		assertEquals(2, elements.size());
	}

	@Test
	public void toArray() {
		assertTrue(elements.toArray().isEmpty());
		elements.push(1);
		elements.push(2);
		elements.push(3);
		elements.push(4);
		assertEquals(4, elements.toArray().size());
	}

	@Test
	public void contains() {
		elements.push(1);
		elements.push(2);
		elements.push(3);
		elements.push(4);
		assertTrue(elements.contains(1));
		assertFalse(elements.contains(5));
		thrownException.expect(NullPointerException.class);
		elements.contains(null);
	}

}
