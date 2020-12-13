package com.persistence;

import static org.junit.Assert.assertEquals;

import com.persistence.entity.SimpleCalculationDAO;
import com.persistence.factory.SimpleCalculationDAOFactory;
import org.junit.Test;

public class SimpleCalculationDAOFactoryUnitTest {
    private static final Double RESULT = 3.0d;
    private static final String OPERATOR = "ADD";
    private static final Integer LEFTHAND = 1;
    private static final Integer RIGHTHAND = 2;

    private final SimpleCalculationDAOFactory simpleCalculationDAOFactory = new SimpleCalculationDAOFactory();

    @Test
    public void createShouldReturnDaoWithExpectedAttributes() {
        SimpleCalculationDAO dao = simpleCalculationDAOFactory.create(LEFTHAND, RIGHTHAND, OPERATOR, RESULT);

        assertEquals(LEFTHAND, dao.getLeftHand());
        assertEquals(RIGHTHAND, dao.getRightHand());
        assertEquals(OPERATOR, dao.getOperator());
        assertEquals(RESULT, dao.getResult());
    }
}
