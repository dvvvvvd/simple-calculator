package com.persistence.factory;

import com.persistence.entity.SimpleCalculationDAO;
import org.springframework.stereotype.Component;

@Component
public class SimpleCalculationDAOFactory {

    public SimpleCalculationDAO create(Integer leftHand, Integer rightHand, String operator, Double result) {
        return new SimpleCalculationDAO(result, leftHand, rightHand, operator);
    }
}
