package computations.functions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@AllArgsConstructor
public abstract class FunctionContainer {

    @Getter
    private String description;

    public abstract Function<Double, Double> getFunction();

}
