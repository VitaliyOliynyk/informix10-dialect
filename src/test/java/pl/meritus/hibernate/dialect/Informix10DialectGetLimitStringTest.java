package pl.meritus.hibernate.dialect;

import eu.vitaliy.hibernate.dialect.Informix10Dialect;
import org.hibernate.dialect.Dialect;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: Witalij
 * Date: 2010-12-14
 * Time: 00:49:18
 */
public class Informix10DialectGetLimitStringTest {

    private Dialect informixDialect;
    private String  testSQL = "SELECT * FROM A";

    @Before
    public void before(){
         informixDialect = new Informix10Dialect();

    }

    private String getSQL(int offset, int limit){
         return informixDialect.getLimitString(testSQL, offset, limit);
    }

    @Test
    public void getLimitString_0_5_Test(){
        //given

        //when
        String sql = getSQL(0, 5);

        //then
        assertEquals("SELECT {+ FIRST_ROWS } first 5 * FROM A",  sql);  
    }


    @Test
    public void getLimitString_2_5_Test(){
        //given

        //when
        String sql = getSQL(2, 5);

        //then
        assertEquals("SELECT {+ FIRST_ROWS } skip 2 first 5 * FROM A",  sql);
    }

}
