package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cz.gattserver.web.common.URLIdentifierUtils;

public class URLIdentifierTest {

	@Test
	public void test() {

		String identifier = URLIdentifierUtils.createURLIdentifier(45L, "test");
		assertEquals("45-test", identifier);

		identifier = URLIdentifierUtils.createURLIdentifier(45L, "test WTF/min");
		assertEquals("45-test+WTF%252Fmin", identifier);

	}

}
