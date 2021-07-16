package lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.startegyhandlers;

import lombok.Getter;
import lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.Handler;
import lowleveldesign.facebook.api.core.strategies.IStrategy;

@Getter
public abstract class StrategyHandler<StrategyHandlerData> extends Handler<StrategyHandlerData> {

    protected final IStrategy strategy;

    public StrategyHandler(final IStrategy strategy) {
        this.strategy = strategy;
    }

}
