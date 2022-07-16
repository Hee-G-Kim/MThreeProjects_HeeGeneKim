package com.sg.vendingmachine.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.LinkedHashMap;
import java.util.Map;

import com.sg.vendingmachine.dto.Item;

public class ChangeDistributor {

	public enum Unit {
        HUNDRED(BigDecimal.valueOf(100)),
        FIFTY(BigDecimal.valueOf(50)),
        TWENTY(BigDecimal.valueOf(20)),
        TEN(BigDecimal.valueOf(10)),
        FIVE(BigDecimal.valueOf(5)),
        TWO(BigDecimal.valueOf(2)),
        ONE(BigDecimal.valueOf(1)),
        FiftyC(BigDecimal.valueOf(0.50)),
        Twentyc(BigDecimal.valueOf(0.20)),
        TenC(BigDecimal.valueOf(0.10)),
        FiveC(BigDecimal.valueOf(0.5));

        private BigDecimal value;

        Unit(BigDecimal value) {
            this.value = value;
        }
    }
	
	
	public ChangeDistributor() {
		
	}


	public static Map<Unit, Integer> getUnit(BigDecimal amountPayed, BigDecimal price) {
        BigDecimal change = amountPayed.subtract(price);
        System.out.println("Return change:  "+ change);
        Map<Unit, Integer> changeReturn = new LinkedHashMap<Unit, Integer>();
        for(Unit unit : Unit.values()) {

            BigDecimal[] values = change.divideAndRemainder(unit.value, MathContext.DECIMAL32);
            if(!values[0].equals(BigDecimal.valueOf(0.0)) && !values[1].equals(BigDecimal.valueOf(0.0))) {
                changeReturn.put(unit, values[0].intValue());
                change = values [1];
            }

        }
        return changeReturn;
    }

    
	
	
	
	
	
}
