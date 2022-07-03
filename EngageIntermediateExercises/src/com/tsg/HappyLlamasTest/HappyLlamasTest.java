package com.tsg.HappyLlamasTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.tsg.HappyLlamasTest.HappyLlamas;

public class HappyLlamasTest {


	public HappyLlamasTest() {
		
	}
	
	//areTheLlamasHappy(false, 10) → false
	public void testNormalTrampoline10() {
			//Arranger
			boolean isNasaFabric = false;
	        int numTrampolines = 10;
	        //Act
	        boolean result = HappyLlamas.areTheLlamasHappy(isNasaFabric, numTrampolines);
	        //Assert
	        assertFalse( result , "10 Llamas w/ Normal Trampolines should be Unhappy!" );
	}
		
	//areTheLlamasHappy(false, 24) → true
	@Test
	public void testNormalTrampoline24() {
		//Arranger
		boolean isNasaFabric = true;
        int numTrampolines = 24;
        //Act
        boolean result = HappyLlamas.areTheLlamasHappy(isNasaFabric, numTrampolines);
        //Assert
        assertTrue( result , "24 Llamas w/ Normal Trampolines should be Unhappy!" );
	}
	
	//areTheLlamasHappy(false, 50) → false
    @Test
    public void testNormalTrampoline50() {
        // ARRANGE - for simple methods, this means setting up the parameters
        boolean isNasaFabric = false;
        int numTrampolines = 50;
        
        // ACT - for simple methods, this generally means calling the method under test
        // and then capturing its return to assert on
        boolean result = HappyLlamas.areTheLlamasHappy(isNasaFabric, numTrampolines);
        
        // ASSERT - basically just a conditional that proves the result is what
        // you expect it to be, plus an extra message to display if it doesn't match.
        //
        // There are a wide variety of assert types, here we
        // just want to assert that it returned false. But we could have also used
        // assertEquals and passed in a false value.
        
        assertFalse( result , "50 Llamas w/ Normal Trampolines should be Unhappy!" );
    }

    
}
