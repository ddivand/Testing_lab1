package test.java.HashTable;

import main.java.HashTable.Entry;
import main.java.HashTable.HashTable;
import main.java.HashTable.TestPoints;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TableTest {
    public static HashTable table;

    @Before
    public void prepare() {
        table = new HashTable();
    }

    //insert
    @Test
    public void insertTest()
    {
        table.put(new Entry("123","123"));
        assertEquals(List.of(TestPoints.inserted),table.testLog);
        assertEquals(table.get("123").getValue(),"123");
    }

    @Test
    public void insertSameHash(){
        table.put(new Entry("AaAa","a"));
        table.put(new Entry("BBBB","a"));
        table.put(new Entry("AaBB","a"));
        table.put(new Entry("BBAa","a"));

        assertEquals(List.of(
                TestPoints.inserted,
                TestPoints.hashHit,
                TestPoints.nextBucketCheck,
                TestPoints.inserted,
                TestPoints.hashHit,
                TestPoints.nextBucketCheck,
                TestPoints.nextBucketCheck,
                TestPoints.inserted,
                TestPoints.hashHit,
                TestPoints.nextBucketCheck,
                TestPoints.nextBucketCheck,
                TestPoints.nextBucketCheck,
                TestPoints.inserted
        ), table.testLog);
    }

    @Test
    public void insertWithReplace(){
        table.put(new Entry("BBBB","a"));
        table.put(new Entry("BBBB","a"));

        assertEquals(List.of(
                TestPoints.inserted,
                TestPoints.hashHit,
                TestPoints.nextBucketCheck,
                TestPoints.nodeReplaced
        ), table.testLog);
    }

    @Test
    public void resize(){
        table.setLoadFactor(0.2);
        table.put(new Entry("A1","a1"));
        table.put(new Entry("B2","a"));
        table.put(new Entry("130","a"));

        assertEquals(List.of(
                TestPoints.inserted,
                TestPoints.resize,
                TestPoints.inserted,
                TestPoints.inserted,
                TestPoints.resize,
                TestPoints.inserted,
                TestPoints.inserted,
                TestPoints.inserted
        ), table.testLog);
    }

    @Test
    public void removal(){
        table.put(new Entry("AaAa","a"));
        table.put(new Entry("BBBB","a"));
        table.delete("BBBB");

        assertEquals(List.of(
                TestPoints.inserted,
                TestPoints.hashHit,
                TestPoints.nextBucketCheck,
                TestPoints.inserted,
                TestPoints.nextBucketCheck,
                TestPoints.nodeRemoved
        ), table.testLog);
    }

    @Test
    public void clear(){
        table.put(new Entry("a","a"));
        table.clear();
        table.delete("a");

        assertEquals(List.of(
                TestPoints.inserted,
                TestPoints.clear,
                TestPoints.nextBucketCheck,
                TestPoints.nextBucketCheck,
                TestPoints.nextBucketCheck,
                TestPoints.nextBucketCheck,
                TestPoints.nextBucketCheck,
                TestPoints.nextBucketCheck,
                TestPoints.nodeNotFound
        ), table.testLog);
    }

    @Test
    public void find(){
        table.put(new Entry("AaAa","212"));
        table.put(new Entry("BBBB","313"));
        Entry en = table.get("BBBB");

        assertEquals(List.of(
                TestPoints.inserted,
                TestPoints.hashHit,
                TestPoints.nextBucketCheck,
                TestPoints.inserted,
                TestPoints.nextBucketCheck,
                TestPoints.nodeFound

        ), table.testLog);

        assertEquals("313",en.getValue());
    }

    @Test
    public void findIncorrect(){
        table.get("a");

        assertEquals(List.of(
                TestPoints.nextBucketCheck,
                TestPoints.nextBucketCheck,
                TestPoints.nextBucketCheck,
                TestPoints.nextBucketCheck,
                TestPoints.nextBucketCheck,
                TestPoints.nextBucketCheck,
                TestPoints.nodeNotFound

        ), table.testLog);
    }

}
