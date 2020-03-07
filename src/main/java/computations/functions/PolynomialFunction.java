package computations.functions;

import java.util.function.Function;

public class PolynomialFunction extends FunctionContainer {

    public PolynomialFunction() {
        super("2*x^2 + 3x + 5");
    }

    @Override
    public Function<Double, Double> getFunction() {
        return x -> 2*Math.pow(x, 2) + 3*x + 5;
    }

}
