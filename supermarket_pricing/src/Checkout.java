

class Checkout
{
    private int total = 0;
    private CheckoutRule ruleOfA = new RuleOfA();
    private CheckoutRule ruleOfB = new RuleOfB();
    private CheckoutRule ruleOfC = new RuleOfC();
    private CheckoutRule ruleOfD = new RuleOfD();

    public void scan(String products)
    {
        total = 0;

        for (String product : products.split(""))
        {
            if ("A".equals(product))
            {
                total += ruleOfA.getPrice();
            }
            if ("B".equals(product))
            {
                total += ruleOfB.getPrice();
            }
            if ("C".equals(product))
            {
                total += ruleOfC.getPrice();
            }
            if ("D".equals(product))
            {
                total += ruleOfD.getPrice();
            }
        }
        ruleOfA.reset();
    }

    public int getTotalPrice()
    {
        return total;
    }
}