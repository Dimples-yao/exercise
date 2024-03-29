package written.com.newcoder;

public class Third {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int start = 0;
        int total = 0;
        for(int i=0;i<gas.length;i++){
            total += gas[i]-cost[i];
            tank += gas[i]-cost[i];
            if(tank<0){
                start = i+1;
                tank=0;
            }
        }
        return total>=0?start:-1;
     }
}
