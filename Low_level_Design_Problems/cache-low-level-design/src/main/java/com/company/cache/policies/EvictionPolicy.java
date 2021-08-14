package com.company.cache.policies;


/**
 * Interface to define eviction policy.
 *
 * @param <K> Type of Key.
 */
public interface EvictionPolicy<K> {

	/**
	 * Add the key in the eviction policy.
	 *
	 * @param key
	 */
	void keyAccessed(K key);


	/**
	 * Remove the key from the eviction policy and return it.
	 *
	 * @return <Key> Type of Key.
	 */
	K removeKey();

}
