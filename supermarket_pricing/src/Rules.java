

class RuleOfA extends CheckoutRule
{
    private int productsCount = 0;

    @Override
    public int getPrice()
    {
        productsCount++;
        return 0 == (productsCount % 3) ? 30 : 50;
    }
}

class RuleOfB extends CheckoutRule
{

    @Override
    public int getPrice()
    {
        return 30;
    }
}

class RuleOfC extends CheckoutRule
{

    @Override
    public int getPrice()
    {
        return 20;
    }
}

class RuleOfD extends CheckoutRule
{

    @Override
    public int getPrice()
    {
        return 15;
    }
}