package com.vibhor.testing.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	String actual = "{\"id\": 1,\"price\":10,\"name\":\"Ball\"}";
	@Test
	public void jsonAssert() throws JSONException {
		String expected = "";
		JSONAssert.assertEquals(expected, actual, true);
	}

}
