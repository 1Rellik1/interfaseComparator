package Homework.third;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Mapsyncronized extends Thread {
    Map<Integer, String> syncHashMap;
    public Mapsyncronized(String name) {
        super(name);

        syncHashMap= Collections.synchronizedMap(new HashMap<>());
        if (name.equals("first")){
            syncHashMap.put(1, "A");
            syncHashMap.put(2, "B");
        }
        else{
            syncHashMap.put(1, "C");
            syncHashMap.put(2, "D");
        }
    }
    @Override
    public void run() {
        Mapsyncron();
    }
    public void Mapsyncron(){
        Iterator<Integer> itr = syncHashMap.keySet().iterator();

        synchronized (syncHashMap)
        {
            while(itr.hasNext()) {
                syncHashMap.put(1, "A");
                syncHashMap.put(2, "B");
                System.out.println(Thread.currentThread().getName() + syncHashMap.get(itr.next()));
            }
        }
    }
}
