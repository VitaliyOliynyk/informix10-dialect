package eu.vitaliy.hibernate.dialect;

import org.hibernate.Hibernate;
import org.hibernate.type.Type;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 09.02.12
 * Time: 11:00
 * To change this template use File | Settings | File Templates.
 */
public class StandardTypes {
    public final static Type DATE = Hibernate.DATE;
    public final static Type TIME = Hibernate.TIME;
}
