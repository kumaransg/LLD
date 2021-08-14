package com.company.cache.storage;

import com.company.cache.exception.NotFoundException;
import com.company.cache.exception.StorageFullException;

/**
 * Interface used to manage storage of our application.
 *
 * @param <K> Type of Key.
 * @param <V> Type of Value.
 */
public interface Storage<K, V> {

	/**
	 * Method used to add new cache in storage.
	 *
	 * @param key
	 * @param value
	 * @throws StorageFullException
	 */
	void put(K key, V value);

	/**
	 * Method used to remove an entry from the storage.
	 *
	 * @param key
	 * @throws NotFoundException
	 */
	void remove(K key);

	/**
	 * Method used to get Value based on Key from storage.
	 *
	 * @param key
	 * @return
	 * @throws NotFoundException
	 */
	V get(K key);

}
