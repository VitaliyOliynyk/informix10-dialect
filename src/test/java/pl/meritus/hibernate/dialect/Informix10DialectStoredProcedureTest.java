package pl.meritus.hibernate.dialect;

import eu.vitaliy.hibernate.dialect.Informix10Dialect;
import org.hibernate.dialect.Dialect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.fest.assertions.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class Informix10DialectStoredProcedureTest {

    private Dialect informixDialect;
    String query, expectedResult;

    public Informix10DialectStoredProcedureTest(String query) {
        this.query =
        this.expectedResult = query;
        informixDialect = new Informix10Dialect();
    }

     @Parameterized.Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = new Object[][] {
               { "EXECUTE PROCEDURE procedureName(2)"},
               { "   EXECUTE   PROCEDURE procedureName(2) "},
               { "   execute\n   PROCEDURE\nprocedureName(2) "},
               {"{? = call f_rabat_ar_ceh(?, ?)}"},
               {"{ ?  =  call \nf_rabat_ar_ceh(?, ?)}"}
       };
	   return Arrays.asList(data);
	 }

    @Test
    public void testStoredProcedure()
    {
        //given
        String result;

        //when
        result = informixDialect.getLimitString(query, 0, 1);
        assertThat(result).isEqualTo(expectedResult);
    }

}
