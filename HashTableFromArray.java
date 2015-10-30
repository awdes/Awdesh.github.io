package com.company;

/**
 * Class represents an object that store item as a key value pair.
 * Also points to next available object in case multiple values exists for
 * a unique key.
 * Created by awdesh on 10/26/15.
 */
class LinkedHashEntry
{
    String key;
    int value;
    LinkedHashEntry next;

    LinkedHashEntry(String key, int value)
    {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class HashTableFromArray
{
    private int TABLE_SIZE;
    private int size;
    private LinkedHashEntry[] table;

    /**
     * Constructor to initialize size of the hash table.
     * @param ts - An integer represents table size.
     */
    public HashTableFromArray(int ts)
    {
        size = 0;
        TABLE_SIZE = ts;
        table = new LinkedHashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    /**
     * Creates a hash code. 
     */
    private int myHash(String ip)
    {
        int hashValue = ip.hashCode();
        hashValue %= TABLE_SIZE;
        if(hashValue < 0)
        {
            hashValue += TABLE_SIZE;
        }
        return hashValue;
    }

    public void insert(String key, int value)
    {
        int hash = (myHash(key)) % TABLE_SIZE;
        if (table[hash] == null)
            table[hash] = new LinkedHashEntry(key, value);
        else
        {
            LinkedHashEntry entry = table[hash];
            while (entry.next != null && !entry.key.equals(key))
                entry = entry.next;
            if (entry.key.equals(key))
                entry.value = value;
            else
                entry.next = new LinkedHashEntry(key, value);
        }
        size++;
    }

    public int get(String key)
    {
        int hash = (myHash( key ) % TABLE_SIZE);
        if (table[hash] == null)
            return -1;
        else
        {
            LinkedHashEntry entry = table[hash];
            while (entry != null && !entry.key.equals(key))
                entry = entry.next;
            if (entry == null)
                return -1;
            else
                return entry.value;
        }
    }
}


