package computations.functions;

import java.util.function.Function;

public class NaturalLogarithmFunction extends FunctionContainer {

    public NaturalLogarithmFunction() {
        super("ln(x)");
    }

    @Override
    public Function<Double, Double> getFunction() {
        return x -> Math.log(x);
    }

}
