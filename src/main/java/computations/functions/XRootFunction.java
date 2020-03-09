package computations.functions;

import java.math.BigDecimal;
import java.util.function.Function;

public class XRootFunction extends FunctionContainer {

    public XRootFunction() {
        super("3*x^0.5");
    }

    @Override
    public Function<BigDecimal, BigDecimal> getFunction() {
        return x -> {
            if (x.compareTo(BigDecimal.ZERO) < 0) {
                throw new NotAllowableRangeException();
            }
            return BigDecimal.valueOf(3*Math.pow(x.doubleValue(), 0.5));
        };
    }

}
