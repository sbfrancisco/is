package org.example;

import org.example.input.ConsoleReading;
import org.example.input.FileReading;
import org.example.interfaces.InputReader;
import org.example.interfaces.OutputWriter;
import org.example.interfaces.SolverCousin;
import org.example.output.ConsoleWriter;
import org.example.output.FileOutput;
import org.example.solvers.MySolv;
import org.example.solvers.SieveOfEratosthenes;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class numberCousin {
    InputReader input;
    OutputWriter output;
    SolverCousin solver;

    public numberCousin() throws IOException {
        input = new ConsoleReading();
        output = new FileOutput();
        solver = new SieveOfEratosthenes();
    }
    public void run() throws IOException {
     output.write(solver.execute(input.read()));
    }
}