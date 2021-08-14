package cache.policies;

import com.company.cache.policies.LRUEvictionPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LRUEvictionPolicyTest {

	LRUEvictionPolicy<Integer> evictionPolicy;

	@BeforeEach
	public void setup() {
		evictionPolicy = new LRUEvictionPolicy<>();
	}

	@Test
	void test_noKeysEvictionInitially() {
		// Then
		assertNull(evictionPolicy.removeKey());
	}

	@Test
	void test_keyEvictionInSameOrderTheyAreAccessed() {

		// When
		evictionPolicy.keyAccessed(1);
		evictionPolicy.keyAccessed(2);
		evictionPolicy.keyAccessed(3);
		evictionPolicy.keyAccessed(4);
		evictionPolicy.keyAccessed(5);

		// Then
		assertEquals(1, evictionPolicy.removeKey());
		assertEquals(2, evictionPolicy.removeKey());
		assertEquals(3, evictionPolicy.removeKey());
		assertEquals(4, evictionPolicy.removeKey());
		assertEquals(5, evictionPolicy.removeKey());
	}

	@Test
	void test_keyEvictionOrderIfReAccessed() {

		// When
		evictionPolicy.keyAccessed(1);
		evictionPolicy.keyAccessed(2);
		evictionPolicy.keyAccessed(3);
		evictionPolicy.keyAccessed(2);
		evictionPolicy.keyAccessed(1);
		evictionPolicy.keyAccessed(4);
		evictionPolicy.keyAccessed(5);
		evictionPolicy.keyAccessed(1);

		// Then
		assertEquals(3, evictionPolicy.removeKey());
		assertEquals(2, evictionPolicy.removeKey());
		assertEquals(4, evictionPolicy.removeKey());
		assertEquals(5, evictionPolicy.removeKey());
		assertEquals(1, evictionPolicy.removeKey());
	}

}
