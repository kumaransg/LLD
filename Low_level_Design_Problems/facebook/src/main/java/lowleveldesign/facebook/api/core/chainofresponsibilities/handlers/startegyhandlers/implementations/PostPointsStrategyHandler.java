package lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.startegyhandlers.implementations;

import lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.models.handlerdatas.strategyhandlerdata.postpoints.PostPointsStrategyHandlerData;
import lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.startegyhandlers.StrategyHandler;
import lowleveldesign.facebook.api.core.strategies.postpointsstrategies.IPostPointsStrategy;

public class PostPointsStrategyHandler extends StrategyHandler<PostPointsStrategyHandlerData> {

    public PostPointsStrategyHandler(final IPostPointsStrategy strategy) {
        super(strategy);
    }

    @Override
    protected boolean isSpam(final PostPointsStrategyHandlerData data) {
        return data.getRequest() == null;
    }

    @Override
    protected void handle(final PostPointsStrategyHandlerData data) {
        Double response = (Double) this.strategy.apply(data);
        data.attachToResponse(response);
    }

}
