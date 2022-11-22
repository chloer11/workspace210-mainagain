package assn07;

import java.util.List;
import java.util.Set;

public interface Map <K, V> {

    /**
     * Creates an Account object using the key value pair,
     * and inserts the object at the appropriate index
     * based on the hash of they key. If the key already
     * exists in map, update its value.
     * @param key: the website name
     * @param value: the password
     */
    void put(K key, V value);

    /**
     * Returns the value associated with the given key.
     * This operation should have O(1) runtime.
     * If the key is not in the array, return null.
     * @param key
     * @return the value (password) associated with that key
     */
    V get(K key);

    /**
     * Returns the number of key-value mappings in the map.
     * @return the number of accounts in the map.
     */
    int size();

    /**
     * Returns a Set of all the keys (websites) contained in this map.
     *
     * @return A set of the keys contained in the map
     */
    Set<K> keySet();

    /**
     * Removes the Key and value pair from the map
     * and returns the removed value.
     * If the key is not in the array, return null.
     * @param key to be removed
     * @return the value (password) that was removed
     */
    V remove(K key);

    /**
     * Returns a list the website names
     * that have a password matching the parameter
     *
     * @return A List containing the keys of accounts whose password
     * match the parameter
     */
    List<K> checkDuplicate(V value);

    /**
     * Checks to see if the entered Master Password matches
     * the password stored in MASTER_PASSWORD
     * @param enteredPassword - the password the user typed in
     * @return true if passwords match, false otherwise
     */
    boolean checkMasterPassword(String enteredPassword);

    String generateRandomPassword(int length);

}
