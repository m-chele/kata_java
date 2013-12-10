import junit.framework.TestCase;

public class SupermarketTest extends TestCase
{

    private Checkout checkout;

    public void setUp() throws Exception
    {
        super.setUp();
        checkout = new Checkout();
    }

    public void test_no_prod_total_is_0() throws Exception
    {
        checkout.scan("");
        assertCheckoutTotalIs(0);
    }

    public void test_each_prod_costs_X() throws Exception
    {
        checkout.scan("A");
        assertCheckoutTotalIs(50);

        checkout.scan("B");
        assertCheckoutTotalIs(30);

        checkout.scan("C");
        assertCheckoutTotalIs(20);
    }

    public void test_different_prods_sum_costs() throws Exception
    {
        checkout.scan("AB");
        assertCheckoutTotalIs(80);

        checkout = new Checkout();
        checkout.scan("CDBA");
        assertCheckoutTotalIs(115);

        checkout = new Checkout();
        checkout.scan("AA");
        assertCheckoutTotalIs(100);
    }

    public void test_3_A_is_130() throws Exception
    {
        checkout.scan("AAA");
        assertCheckoutTotalIs(130);
    }

    public void test_4_A_is_180() throws Exception
    {
        checkout.scan("AAAA");
        assertCheckoutTotalIs(180);
    }

    public void test_6_A_is_260() throws Exception
    {
        checkout.scan("AAAAAA");
        assertCheckoutTotalIs(260);
    }

    private void assertCheckoutTotalIs(int expectedTotal)
    {
        assertEquals(expectedTotal, checkout.getTotalPrice());
    }
}
