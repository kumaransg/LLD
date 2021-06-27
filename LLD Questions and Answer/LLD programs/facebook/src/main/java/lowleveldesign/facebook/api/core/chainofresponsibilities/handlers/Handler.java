package lowleveldesign.facebook.api.core.chainofresponsibilities.handlers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Handler<HandlerData> {

    private Handler<HandlerData> next;

    protected abstract boolean isSpam(HandlerData data);
    protected abstract void handle(HandlerData data);

    public final void handleRequest(final HandlerData data) {
        if (!isSpam(data)) this.handle(data);
        if (this.getNext() != null) this.getNext().handleRequest(data);
    }

    public Handler<HandlerData> setNext(final Handler<HandlerData> next) {
        this.next = next;
        return this;
    }

}
