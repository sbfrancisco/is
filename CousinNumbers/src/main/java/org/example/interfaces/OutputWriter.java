package org.example.interfaces;

import java.io.IOException;
import java.util.ArrayList;

public interface OutputWriter {
    public void write(ArrayList<Integer> numbers) throws IOException;
}
