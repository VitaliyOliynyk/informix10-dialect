package eu.vitaliy.hibernate.dialect;

import java.sql.Types;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Hibernate;
import org.hibernate.dialect.InformixDialect;
import org.hibernate.dialect.function.NoArgSQLFunction;
import org.hibernate.type.StandardBasicTypes;

/**
 * Dialect for Informix 10.
 * <ul>
 *   <li>hint for first rows</li>
 *   <li>support for limitOffset</li>
 *   <li>added types for BLOB and CLOB</li>
 *   <li>support for CURRENT_TIME(), CURRENT_DATE()</li>
 * </ul> 
 */
public class Informix10Dialect extends InformixDialect {
    
    /**
     * 
     */

    private final static Pattern excludeLimitPattern;
    static{
        excludeLimitPattern = Pattern.compile("\\s*(?:call|execute)\\s+.*",
                Pattern.CASE_INSENSITIVE |Pattern.MULTILINE |Pattern.DOTALL);
    }



    public Informix10Dialect() {
        super();
        registerColumnType( Types.BLOB, "blob" );
        registerColumnType( Types.CLOB, "clob" );
        registerFunction("current_date", new NoArgSQLFunction("today", StandardTypes.DATE, false));
        registerFunction( "current_time", new NoArgSQLFunction("current", StandardTypes.TIME, false) );
    } 

    public boolean useMaxForLimit() {
        return false;
    }

    public boolean supportsLimitOffset() {
        return true;
    }



    public String getLimitString(String querySelect, int offset, int limit) {

        Matcher matcher = excludeLimitPattern.matcher(querySelect);
        if(matcher.find())
        {
           return querySelect;
        }

        String os = "";
        StringBuffer sb = new StringBuffer(querySelect.length() + 24 + os.length());
        if (offset > 0)
        {
            os = " skip " + offset;        
        }
        sb.append(querySelect);
        if(!matcher.matches())
        {
           sb.insert( querySelect.toLowerCase(Locale.US).indexOf( "select" ) + 6,
                    " {+ FIRST_ROWS }" + os + " first " + limit );
        }

        return sb.toString();
    }



}

