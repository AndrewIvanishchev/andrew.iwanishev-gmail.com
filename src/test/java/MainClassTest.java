import org.junit.*;

public class MainClassTest {


    @Before
    public void setUp() {

    }

    @Test
    public void method2() {
        Assert.assertEquals(20, 5 + 5);
        //Assert.assertNotEquals(10, 1 + 1);
    }

    @Test
    public void method3() {
        Assert.assertTrue(1 + 1 ==2);
        //Assert.assertFalse( 1 + 1 == 10);
    }

    @After
    public void tearDown() {

    }

}
