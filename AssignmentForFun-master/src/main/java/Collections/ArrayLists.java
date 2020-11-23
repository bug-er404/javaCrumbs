package Collections;

import java.util.ArrayList;

public class ArrayLists {

    public ArrayList<Integer> addShit(ArrayList<Integer> list1, ArrayList<Integer> list2)
    {
        ArrayList<Integer> newList = new ArrayList<Integer>(list1);
        newList.addAll(list2);
        return newList;
    }

    public Integer addShitTogether(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        Integer total = 0;
        for(Integer num:list1)
            total += num;
        for(Integer num:list2)
            total += num;

        return total;
    }

    public ArrayList<Integer> removeAll(ArrayList<Integer> original, Integer toRemove) {
        original.remove(toRemove);
        return original;
    }

    public boolean happyList(ArrayList<String> original)
    {
        // check for single element
        if(original.size() == 1)
            return true;

        // end of string flag
        boolean eos;

        for(int i=0; i<original.size(); i++)
        {
            eos=true;
            // Check next element
            if(i != original.size()-1)
            {
                for(int j=0; j<original.get(i).length();j++)
                {
                    if(original.get(i+1).indexOf(original.get(i).charAt(j)) != -1) {
                        eos = false;
                        break;
                    }
                }
            }
            // Check previous element
            if(i != 0)
            {
                for(int j=0; j<original.get(i).length();j++)
                {
                    if(original.get(i-1).indexOf(original.get(i).charAt(j)) != -1)
                    {
                        eos=false;
                        break;
                    }
                }
            }

            // no match found:
            if(eos)
                return false;
        }
        return true;
    }
}
