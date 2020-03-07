package computations.functions;

import java.util.function.Function;

public class XRootFunction extends FunctionContainer {

    public XRootFunction() {
        super("1/x^0.5");
    }

    @Override
    public Function<Double, Double> getFunction() {
        return x -> 1/Math.pow(x, 0.5);
    }

}
