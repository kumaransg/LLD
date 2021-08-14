package cache;

import com.company.cache.Cache;
import com.company.cache.factory.CacheFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CacheTest {

	Cache<Integer, Integer> cache;

	@BeforeEach
	public void setup() {
		cache = new CacheFactory<Integer, Integer>().defaultCache(5);
	}

	@Test
	void test_itShouldBeAbleToGetItemsFromCache() {
		// When
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);

		// Then
		assertEquals(1, cache.get(1));
		assertEquals(2, cache.get(2));
		assertEquals(3, cache.get(3));

		// When
		cache.put(4, 4);
		cache.put(5, 5);

		// Then
		assertEquals(4, cache.get(4));
		assertEquals(5, cache.get(5));

		// Since, we have used our cache to full capacity,
		// It will remove the last accessed element to insert new.

		// When
		cache.put(6, 6);

		// Then, Key 1 should be removed by now.
		assertNull(cache.get(1));
	}

}
