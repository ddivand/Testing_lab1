package main.java.HashTable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HashTable {
    public List<TestPoints> testLog = new LinkedList<>();
    private Entry[] data;
    private int size = 0;
    private int arr_size = 6; // initial size

    private double loadFactor = 0.7;
    private int multiplier = 2;

    public HashTable(){
        data = new Entry[arr_size];
    }

    private int getEntryIndex(Entry entry){
        return Math.abs(entry.getKey().hashCode() % this.arr_size);
    }


    private void resize() {
        this.arr_size = arr_size * multiplier;
        this.size = 0;
        Entry[] tmp = this.data.clone();
        this.data=Arrays.copyOf(new Entry[1],arr_size);

        for ( int i = 0; i < arr_size/multiplier; i++){
            if( tmp[i] != null)
                this.put(tmp[i]);
        }


    }

    public Entry put(Entry entry){
        Entry retVal = null;

        if((double)(this.size + 1) / (double)this.arr_size >= loadFactor) {
            testLog.add(TestPoints.resize);
            this.resize();
        }
        int index = this.getEntryIndex(entry);

        if(this.data[index] == null) {
            data[index] = entry;
            retVal = null;
            size++;
            testLog.add(TestPoints.inserted);
        }else {
            testLog.add(TestPoints.hashHit);
            while (true) {
                testLog.add(TestPoints.nextBucketCheck);

                if (data[index].getKey().equals(entry.getKey())){
                    retVal = data[index];
                    data[index] = entry;
                    testLog.add(TestPoints.nodeReplaced);
                    break;
                }

                index++;
                if (index >= this.arr_size)
                    index = 0;

                if (data[index] == null) {
                    testLog.add(TestPoints.inserted);
                    data[index] = entry;
                    retVal = null;
                    this.size++;
                    break;
                }

            }
        }

        return retVal;
    }

    public Entry delete(String key){
        int index = this.getEntryIndex(new Entry(key,""));
        int cycle = index;
        Entry retVal = null;

        while (data[index] == null || !data[index].getKey().equals(key)){

            testLog.add(TestPoints.nextBucketCheck);
            index++;
            if(index >= this.arr_size)
                index = 0;

            if(index == cycle) {
                testLog.add(TestPoints.nodeNotFound);
                return null;
            }
        }
        retVal = this.data[index];
        this.data[index] = null;
        size--;
        testLog.add(TestPoints.nodeRemoved);

        return retVal;
    }

    public Entry get(String key){
        int index = this.getEntryIndex(new Entry(key,null));
        int cycle = index;

        if(data[index] != null && data[index].getKey().equals(key)) {
            testLog.add(TestPoints.nodeFound);
            return data[index];
        }
        else {
            while (data[index] == null || !data[index].getKey().equals(key)){
                testLog.add(TestPoints.nextBucketCheck);
                index++;
                if(index >= this.arr_size)
                    index = 0;

                if(index == cycle) {
                    testLog.add(TestPoints.nodeNotFound);
                    return null;
                }
            }
        }
        testLog.add(TestPoints.nodeFound);
        return data[index];
    }



    public void clear(){
        for(int i = 0; i < this.arr_size; i++)
            data[i] = null;
        this.size = 0;
        testLog.add(TestPoints.clear);
    }

    public int getSize() {
        return this.size;
    }

    public void setLoadFactor(double e) {
        this.loadFactor = e;
    }

    public void setMultiplier(int e) {
        this.multiplier = e;
    }

}
