package core;

public interface IDistanceCalculator<E1, E2> {
    Double getDistance(E1 e1, E2 e2);
}
