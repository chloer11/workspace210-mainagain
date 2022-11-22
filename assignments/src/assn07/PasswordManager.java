package assn07;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
// why make this so hard on us with the directions and not adding things, like ArrayList makes things easier???

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "bestpasswordever";
    private Account[] _passwords;
    private int _size;
    private HashSet<K> _hashyset;
    // or _hash or _set or _hashset
    // names that matter or funny names?

    public PasswordManager() {
        _passwords = new Account[50];
        this._size = 0;
        this._hashyset = new HashSet<>();
    }
    // more accounts than slots -> collisions
    // indexed linked lists
    // TODO: put
    @Override
    public void put(K key, V value) {
        // void = no return statement
        // .equals() instead of == bc strings!
        int index = Math.abs(key.hashCode()) % this._passwords.length;
        Account<K, V> acct = new Account<K, V>(key, value);
        // hash code facilitates hashing; integer associated with value
        if (this._passwords[index] != null) {
            Account<K, V> earlierAcct = this._passwords[index];
            acct.setNext(earlierAcct);

            while (earlierAcct != null) {
                if (earlierAcct.getWebsite().equals(key)) {
                    earlierAcct.setPassword(value);
                    return;
                }
                earlierAcct = earlierAcct.getNext();
            }
        }
        this._hashyset.add(key);
        this._passwords[index] = acct;
        this._size++;
    }

    // TODO: get
    //@Override
    public V get(K key) {
        //return null;
        // modulus - returns remainder
        int index = Math.abs(key.hashCode()) % this._passwords.length;
        Account<K, V> earlierAcct = this._passwords[index];

        while (earlierAcct != null) {
            if (earlierAcct.getWebsite().equals(key)) {
                return earlierAcct.getPassword();
            }
            earlierAcct = earlierAcct.getNext();
        }
        return null;
    }

    // TODO: size
    //@Override
    public int size() {
        //return 0;
        return this._size;
        // similar to past assignments
    }

    // TODO: keySet
    //@Override
    public Set<K> keySet() {
        //return null;
        return this._hashyset;
        // also similar (like said above)
    }

    // TODO: remove
    //@Override
    public V remove(K key) {
        //return null;
        // possible null error in while loop
        int index = Math.abs(key.hashCode()) % this._passwords.length;

        Account<K, V> earlierAcct = null;
        Account<K, V> acct = this._passwords[index];

        while (acct != null) {
            if (acct.getWebsite().equals(key)) {
                V password = acct.getPassword();

                if (earlierAcct != null) {
                    earlierAcct.setNext(acct.getNext());
                } else {
                    this._passwords[index] = null;
                }
                this._hashyset.remove(key);
                this._size--;
                return password;
            }
            earlierAcct = acct;
            acct = acct.getNext();
        }
        return null;
    }

    // TODO: checkDuplicate
    //@Override
    public List<K> checkDuplicate(V value) {
        //return null;
        List<K> copyOfList = new ArrayList<>();
        // think of different cases
        // traverse is for each node of ArrayList in order to perform operations
        // iterate through a List
        // chaining

        for (int i = 0; i < this._passwords.length; i++) {
            Account<K, V> acct = this._passwords[i];

            while (acct != null) {
                if (acct.getPassword().equals(value)) {
                    copyOfList.add(acct.getWebsite());
                }
                acct = acct.getNext();
            }
        }
        return copyOfList;
    }

    // TODO: checkMasterPassword
    //@Override
    public boolean checkMasterPassword(String enteredPassword) {
        //return false;
        return enteredPassword.equals(MASTER_PASSWORD);
    }

    /*
    Generates random password of input length
     */
    //@Override
    public String generateRandomPassword(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /*
    Used for testing, do not change
     */
    public Account[] getPasswords() {
        return _passwords;
    }
}