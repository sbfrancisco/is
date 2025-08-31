import static org.junit.jupiter.api.Assertions.*;

import org.example.interfaces.SolverCousin;
import org.example.solvers.MySolv;
import org.example.solvers.SieveOfEratosthenes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

class NumberCousinTest {

    static Stream<org.junit.jupiter.params.provider.Arguments> primesProvider() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(2, List.of(2)),
                org.junit.jupiter.params.provider.Arguments.of(3, List.of(2, 3)),
                org.junit.jupiter.params.provider.Arguments.of(4, List.of(2, 3)),
                org.junit.jupiter.params.provider.Arguments.of(5, List.of(2, 3, 5)),
                org.junit.jupiter.params.provider.Arguments.of(10, List.of(2, 3, 5, 7)),
                org.junit.jupiter.params.provider.Arguments.of(13, List.of(2, 3, 5, 7, 11, 13)),
                org.junit.jupiter.params.provider.Arguments.of(1, List.of()),
                org.junit.jupiter.params.provider.Arguments.of(0, List.of()),
                org.junit.jupiter.params.provider.Arguments.of(-5, List.of())
        );
    }

    @ParameterizedTest(name = "Primos hasta {0} deben ser {1}")
    @MethodSource("primesProvider")
    void testPrimesWithMultipleImplementations(int input, List<Integer> expected) {
        SolverCousin s1 = new SieveOfEratosthenes();
        SolverCousin s2 = new MySolv();

        Map<String, Function<Integer, ArrayList<Integer>>> implementations = Map.of(
                "SieveOfEratosthenes", s1::execute,
                "MySolv", s2::execute
        );

        implementations.forEach((name, impl) ->
                assertEquals(expected, impl.apply(input),
                        "Fallo en implementación: " + name + " con input=" + input)
        );
    }
}
