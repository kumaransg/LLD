package lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.startegyhandlers.implementations;

import lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.startegyhandlers.StrategyHandler;
import lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.models.handlerdatas.strategyhandlerdata.socialpoints.SocialPointsStrategyHandlerData;
import lowleveldesign.facebook.api.core.strategies.socialpointsstrategy.ISocialPointsStrategy;

public class SocialPointsStrategyHandler extends StrategyHandler<SocialPointsStrategyHandlerData> {

    public SocialPointsStrategyHandler(final ISocialPointsStrategy strategy) {
        super(strategy);
    }

    @Override
    public boolean isSpam(final SocialPointsStrategyHandlerData strategyHandlerData) {
        return strategyHandlerData.getRequest() == null;
    }

    @Override
    public void handle(final SocialPointsStrategyHandlerData strategyHandlerData) {
        Double response = (Double) this.strategy.apply(strategyHandlerData.getRequest());
        strategyHandlerData.attachToResponse(response);
    }

}
