package lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.models.handlerdatas;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class HandlerData<Request, Response> {

    @Getter
    private final Request request;

    @Getter
    @Setter
    private Response response;

    public HandlerData(final Request request) {
        this.request = request;
    }

    public void attachToResponse(Response response) {}

}
