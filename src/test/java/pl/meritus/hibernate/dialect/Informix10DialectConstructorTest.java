package pl.meritus.hibernate.dialect;

import eu.vitaliy.hibernate.dialect.Informix10Dialect;
import org.hibernate.dialect.Dialect;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * User: Witalij
 * Date: 2010-12-14
 * Time: 01:06:45
 */
public class Informix10DialectConstructorTest {

    @Test
    public void constructorTest(){
        Dialect dialect = new Informix10Dialect();
        assertNotNull(dialect);
    }
}
