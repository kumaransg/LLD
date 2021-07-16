package lowleveldesign.facebook.api.core.strategies;

public interface IStrategy<Request, Response> {

    Response apply(Request request);

}
