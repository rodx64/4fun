package domain.my_implementation;

import domain.my_implementation._HashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _HashTableTest {

    @Test
    void validateMyHashTable() {
        _HashTable hashTable = new _HashTable();
        hashTable.printTable();
    }

    @Test
    void givenHashMap_whenSetValues_thenPrint() {
        _HashTable hashTable = new _HashTable();
        hashTable.set("nails", 100);
        hashTable.set("tile", 40);
        hashTable.set("lumber", 500);
        hashTable.set("bolts", 300);
        hashTable.set("screws", 300);

        hashTable.printTable();
    }

    @Test
    void givenHashMap_whenGetTheValue_thenValidateValueIsTrue() {
        _HashTable hashTable = new _HashTable();
        hashTable.set("nails", 100);
        hashTable.set("tile", 40);
        hashTable.set("lumber", 500);
        hashTable.set("bolts", 300);
        hashTable.set("screws", 300);
        hashTable.printTable();

        int value = hashTable.get("lumber");
        assertEquals(500, value);
    }

    @Test
    void givenHashMap_whenGetTheKey_thenValidateKeyIsTrue() {
        _HashTable hashTable = new _HashTable();
        hashTable.set("nails", 100);
        hashTable.set("tile", 40);
        hashTable.set("lumber", 500);
        hashTable.set("bolts", 300);
        hashTable.set("screws", 300);
        hashTable.printTable();

        String firstKey = (String) hashTable.keys().get(0);
        assertEquals("screws", firstKey);
    }
}