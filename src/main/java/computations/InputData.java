package computations;

import lombok.Getter;
import lombok.Setter;

import java.util.function.Function;

@Getter
@Setter
public class InputData {

    private Function<Double, Double> function;
    private double upperIntegrationLimit;
    private double lowerIntegrationLimit;
    private double accuracy;

}
