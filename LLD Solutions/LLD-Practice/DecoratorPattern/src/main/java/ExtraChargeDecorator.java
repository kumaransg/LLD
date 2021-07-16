public abstract class ExtraChargeDecorator implements IBaseRoom{
    protected IBaseRoom room;

    public ExtraChargeDecorator(IBaseRoom room) {
        this.room = room;
    }
}
