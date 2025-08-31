package org.example.solvers;

import org.example.interfaces.SolverCousin;

import java.util.ArrayList;

public class SieveOfEratosthenes implements SolverCousin {

    public ArrayList<Integer> execute(int number) {
        ArrayList<Integer> primes = new ArrayList<>();
        if (number < 2) return primes;

        boolean[] isComposite = new boolean[number + 1]; // false = prime, true = composite

        for (int i = 2; i * i <= number; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= number; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        for (int i = 2; i <= number; i++) {
            if (!isComposite[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
