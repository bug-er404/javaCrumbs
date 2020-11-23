package Collections;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MapPractice {

    public Object findValueOf(Map map, Object key) {
        return map.get(key);
    }

    public Object[] findKeysOf(Map map, Object value)
    {
        ArrayList<Object> temp = new ArrayList<Object>();
        for(Object key:map.keySet())
        {
            if(map.get(key)==value)
            {
                temp.add(key);
            }
        }
        return temp.toArray();
    }

    public Map<Integer, Integer> fibonacciTree(int size)
    {
        Map<Integer, Integer> sequence = new TreeMap<Integer, Integer>();

        for(int i=1;i<=size;i++)
        {
            // first two terms of the sequence
            if(i==1 || i==2)
                sequence.put(i,1);
            // rest of the terms
            else
                sequence.put(i, sequence.get(i - 1) + sequence.get(i - 2));
        }

        return sequence;
    }

    public Map<Integer, Integer> crazySpiral(Integer first, Integer second, Integer size) {
        Map<Integer, Integer> sequence = new TreeMap<Integer, Integer>();

        for(int i=1;i<=size;i++)
        {
            // first two terms of the sequence
            if(i==1 || i==2)
                sequence.put(i,(i==1)?first:second);
            // rest of the terms
            else
                sequence.put(i, sequence.get(i - 1) + sequence.get(i - 2));
        }

        return sequence;
    }
}
