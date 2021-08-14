package lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.models.handlerdatas.strategyhandlerdata.postpoints;

import lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.models.handlerdatas.strategyhandlerdata.StrategyHandlerData;
import lowleveldesign.facebook.api.core.entities.Post;

public class PostPointsStrategyHandlerData extends StrategyHandlerData<Post, Double> {

    public PostPointsStrategyHandlerData(final Post post) {
        super(post);
    }

    @Override
    public void attachToResponse(final Double response) {
        if (this.getResponse() == null) this.setResponse(response);
        else this.setResponse(this.getResponse() + response);
        super.attachToResponse(response);
    }

}
