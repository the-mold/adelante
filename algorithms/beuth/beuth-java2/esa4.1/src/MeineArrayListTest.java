import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("MeineArrayList")
class MeineArrayListTest {
	@Nested
	@DisplayName("list with default constructor")
	class MeineArrayListTestEmptyList {
		private final MeineArrayList<String> list = new MeineArrayList<>();

		@Test
		public void testAdd() {
			list.add("Max");
			System.out.println(list);
			assertEquals(1, list.size());

			list.add("Sara");
			System.out.println(list);
			assertEquals(2, list.size());
		}

		@Test
		public void testRemove() {
			list.add("Max");
			System.out.println(list);
			assertEquals(1, list.size());

			String itemRemoved = list.remove(0);
			System.out.println(list);
			assertEquals(0, list.size());
			assertEquals("Max", itemRemoved);
		}
	}
	@Nested
	@DisplayName("list with given params")
	class MeineArrayListTestWithParams {
		private final MeineArrayList<String> list = new MeineArrayList<>(1, 5);

		@Test
		public void testAdd() {
			list.add("Max");
			System.out.println(list);
			assertEquals(1, list.size());

			list.add("Sara");
			System.out.println(list);
			assertEquals(2, list.size());

			list.add("Bob");
			System.out.println(list);
			assertEquals(3, list.size());
		}

		@Test
		public void testRemove() {
			list.add("Max");
			System.out.println(list);
			assertEquals(1, list.size());

			String itemRemoved = list.remove(0);
			System.out.println(list);
			assertEquals(0, list.size());
			assertEquals("Max", itemRemoved);
		}

		@Test
		public void testOutOfRange() {
			assertEquals(0, list.size());
			try {
				list.remove(20);
			} catch (Exception e) {
				assertEquals("not in range", e.getMessage());
			}
			assertEquals(0, list.size());
		}

		@Test
		public void testClear() {
			list.add("Max");
			System.out.println(list);
			assertEquals(1, list.size());
			list.clear();
			assertEquals(0, list.size());
			System.out.println(list);
		}
	}
}

