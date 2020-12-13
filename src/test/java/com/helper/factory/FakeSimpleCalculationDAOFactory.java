package com.helper.factory;

import com.persistence.entity.SimpleCalculationDAO;

public class FakeSimpleCalculationDAOFactory {

    private static final Double RESULT = 3.0d;
    private static final String OPERATOR = "ADD";
    private static final Integer LEFTHAND = 1;
    private static final Integer RIGHTHAND = 2;

    public static SimpleCalculationDAO create() {
        return new SimpleCalculationDAO(RESULT, LEFTHAND, RIGHTHAND, OPERATOR);
    }
}
