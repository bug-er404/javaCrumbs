package DansDilemma;

import java.util.HashSet;

public class DansDilemma {
    HashSet<Double> entries = new HashSet<Double>();

    public Integer dilemmaOfTwo(Double input1, Double input2) {
        //unique cases(+*):
        entries.add(input1+input2);
        entries.add(input1*input2);
        //non-unique cases(/-):
        entries.add(input1-input2);
        entries.add(input2-input1);
        if(input1 > 0 && input2 > 0)
        {
            entries.add(input1/input2);
            entries.add(input2/input1);
        }
        return entries.size();
    }

    public Integer dilemmaOfThree(Double input1, Double input2, Double input3) {
        Double[] args = {input1, input2, input3};

        for(int i=0; i<args.length; i++)
        {
            if(i==args.length-1)
                break;

            for(int j=i+1; j<args.length; j++)
            {
                //unique cases(+*):
                entries.add(args[i]+args[j]);
                entries.add(args[i]*args[j]);
                //non-unique cases(/-):
                entries.add(args[i]-args[j]);
                entries.add(args[j]-args[i]);
                if(args[i] > 0 && args[j] > 0)
                {
                    entries.add(args[i]/args[j]);
                    entries.add(args[j]/args[i]);
                }
            }
        }
        return entries.size();
    }

    public Integer dilemmaOfN(Double... args){

        for(int i=0; i<args.length; i++)
        {
            if(i==args.length-1)
                break;

            for(int j=i+1; j<args.length; j++)
            {
                //unique cases(+*):
                entries.add(args[i]+args[j]);
                entries.add(args[i]*args[j]);
                //non-unique cases(/-):
                entries.add(args[i]-args[j]);
                entries.add(args[j]-args[i]);
                if(args[i] > 0 && args[j] > 0)
                {
                    entries.add(args[i]/args[j]);
                    entries.add(args[j]/args[i]);
                }
            }
        }
        return entries.size();
    }
}
