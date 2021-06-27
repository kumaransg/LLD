package lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.models.handlerdatas.strategyhandlerdata.socialpoints;

import lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.models.handlerdatas.strategyhandlerdata.StrategyHandlerData;
import lowleveldesign.facebook.api.core.entities.Person;

public class SocialPointsStrategyHandlerData extends StrategyHandlerData<Person, Double> {

    public SocialPointsStrategyHandlerData(final Person person) {
        super(person);
    }

    @Override
    public void attachToResponse(final Double response) {
        if (this.getResponse() == null) this.setResponse(response);
        else this.setResponse(this.getResponse() + response);
        super.attachToResponse(response);
    }

}
