

abstract class CheckoutRule
{
    private int productsCount = 0;

    abstract int getPrice();

    public void reset()
    {
        productsCount = 0;
    }
}
    