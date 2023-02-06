import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("StacksTest")
class StacksTest {
	@Nested
	@DisplayName("[LibStack] - string")
	class LibStackStringTest {
		Stack<String> as = new Stack<>();

		@Test
		public void doesNotImplementInterface() {
			assertFalse(as instanceof Stacker);
		}

		@Test
		public void testPush() {
			assertTrue(as.empty());
			as.push("Sam");
			assertFalse(as.empty());
			as.push("Wendy");
			as.push("Jeff");
			assertEquals("[Sam, Wendy, Jeff]", as.toString());
		}

		@Test
		public void testPop() {
			as.push("Sam");
			as.push("Wendy");
			as.push("Jeff");

			String v = as.pop();
			assertEquals("Jeff", v);
			assertEquals("[Sam, Wendy]", as.toString());
		}
	}

	@Nested
	@DisplayName("[LibStack] - int")
	class LibStackIntTest {
		Stack<Integer> as = new Stack<>();

		@Test
		public void doesNotImplementInterface() {
			assertFalse(as instanceof Stacker);
		}

		@Test
		public void testPush() {
			assertTrue(as.empty());
			as.push(1);
			assertFalse(as.empty());
			as.push(2);
			as.push(3);
			assertEquals("[1, 2, 3]", as.toString());
		}

		@Test
		public void testPop() {
			as.push(1);
			as.push(2);
			as.push(3);

			int v = as.pop();
			assertEquals(3, v);
			assertEquals("[1, 2]", as.toString());
		}
	}

	@Nested
	@DisplayName("[ListStack] - string")
	class ListStackStringTest {
		ListStack<String> as = new ListStack<>();

		@Test
		public void testImplementsInterface() {
			assertTrue(as instanceof Stacker);
		}

		@Test
		public void testPush() {
			assertTrue(as.empty());
			as.push("Sam");
			assertFalse(as.empty());
			as.push("Wendy");
			as.push("Jeff");
			assertEquals("[Jeff, Wendy, Sam]", as.toString());
		}

		@Test
		public void testPop() throws EmptyStackException, FullStackException {
			boolean isThrown = false;
			try {
				String v = as.pop();
			} catch (EmptyStackException expectedException) {
				isThrown = true;
			}
			assertTrue(isThrown);

			as.push("Sam");
			as.push("Wendy");
			as.push("Jeff");

			String v = as.pop();
			assertEquals("Jeff", v);
			assertEquals("[Wendy, Sam]", as.toString());
		}
	}
	@Nested
	@DisplayName("[ListStack] - int")
	class ListStackIntTest {
		Stacker<Integer> as = new ListStack<>();

		@Test
		public void testPush() throws FullStackException {
			assertTrue(as.empty());
			as.push(1);
			assertFalse(as.empty());
			as.push(2);
			as.push(3);
			assertEquals("[3, 2, 1]", as.toString());
		}

		@Test
		public void testPop() throws EmptyStackException, FullStackException {
			boolean isThrown = false;
			try {
				int v = as.pop();
			} catch (EmptyStackException expectedException) {
				isThrown = true;
			}
			assertTrue(isThrown);

			as.push(1);
			as.push(2);
			as.push(3);

			int v = as.pop();
			assertEquals(3, v);
			assertEquals("[2, 1]", as.toString());
		}
	}

	@Nested
	@DisplayName("[ArrayStack] - int")
	class ArrayStackIntTest {
		ArrayStack<Integer> as = new ArrayStack<>(2);

		@Test
		public void testImplementsInterface() {
			assertTrue(as instanceof Stacker);
		}

		@Test
		public void testPush() throws FullStackException {
			as.push(1);
			assertFalse(as.empty());

			as.push(2);
			assertTrue(as.full());

			boolean isThrown = false;
			try {
				as.push(3);
			} catch (FullStackException expectedException) {
				isThrown = true;
			}
			assertTrue(isThrown);

			assertEquals("[2, 1]", as.toString());
		}


		@Test
		public void testPop() throws EmptyStackException, FullStackException {
			boolean isThrown = false;
			try {
				int v = as.pop();
			} catch (EmptyStackException expectedException) {
				isThrown = true;
			}
			assertTrue(isThrown);

			as.push(1);
			as.push(2);

			int v = as.pop();
			assertEquals(2, v);
			assertEquals("[1]", as.toString());
		}
	}

	@Nested
	@DisplayName("[ArrayStack] - string")
	class ArrayStackStringTest {
		Stacker<String> as = new ArrayStack<>(2);

		@Test
		public void testPush() throws FullStackException {
			as.push("Sam");
			assertFalse(as.empty());

			as.push("Wendy");
			assertTrue(as.full());

			boolean isThrown = false;
			try {
				as.push("Jeff");
			} catch (FullStackException expectedException) {
				isThrown = true;
			}
			assertTrue(isThrown);
			assertEquals("[Wendy, Sam]", as.toString());
		}


		@Test
		public void testPop() throws EmptyStackException, FullStackException {
			boolean isThrown = false;
			try {
				String v = as.pop();
			} catch (EmptyStackException expectedException) {
				isThrown = true;
			}
			assertTrue(isThrown);

			as.push("Sam");
			as.push("Wendy");

			String v = as.pop();
			assertEquals("Wendy", v);
			assertEquals("[Sam]", as.toString());
		}
	}


}

