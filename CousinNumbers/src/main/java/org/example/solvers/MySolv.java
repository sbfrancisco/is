package org.example.solvers;
import org.example.interfaces.SolverCousin;
import java.util.ArrayList;

public class MySolv implements SolverCousin {
    public ArrayList<Integer> execute(int number) {
     ArrayList<Integer> result = new ArrayList<>();
      for(int i = number; i > 1; i--) {
        if(isCousin(i))
          result.add(i);
      }
     return result;
    }

    private boolean isCousin(int number){
      int divisible = 0;
        for (int i = 1 ; i <= number ; i++) {
            if(number%i==0){
                divisible++;
            }
            if(divisible > 2)
                return false;
        }
        return true;
    }
}
