package pl.meritus.hibernate.dialect;

import eu.vitaliy.hibernate.dialect.Informix10Dialect;
import org.hibernate.dialect.Dialect;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * User: Witalij
 * Date: 2010-12-14
 * Time: 01:36:53
 */
public class Informix10DialectOtherTest {

     private Dialect informixDialect;

    @Before
    public void before(){
         informixDialect = new Informix10Dialect();
    }


    @Test
    public void useMaxForLimitTest()
    {
         assertFalse(informixDialect.useMaxForLimit());
    }

    @Test
    public void supportsLimitOffsetTest() {
        assertTrue (informixDialect.supportsLimitOffset());
    }
}
