package computations.functions;

import java.util.ArrayList;
import java.util.List;

public class FunctionsHandlerImpl implements FunctionsHandler {

    private List<FunctionContainer> functions;

    public FunctionsHandlerImpl() {
        functions = new ArrayList<>();
        functions.add(new PolynomialFunction());
        functions.add(new NaturalLogarithmFunction());
        functions.add(new XRootFunction());
        functions.add(new SinusFunction());
        functions.add(new XDivisionFunction());
    }

    public List<FunctionContainer> getFunctions() {
        return functions;
    }

}
