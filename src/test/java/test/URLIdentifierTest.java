package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cz.gattserver.web.common.URLIdentifierUtils;
import cz.gattserver.web.common.URLIdentifierUtils.URLIdentifier;

public class URLIdentifierTest {

	@Test
	public void testCreateURLIdentifier_basic() {
		String identifier = URLIdentifierUtils.createURLIdentifier(45L, "test");
		assertEquals("45-test", identifier);
	}

	@Test
	public void testCreateURLIdentifier_special() {
		String identifier = URLIdentifierUtils.createURLIdentifier(45L, "test WTF/min");
		assertEquals("45-test+WTF%252Fmin", identifier);
	}

	@Test
	public void testCreateURLIdentifier_unicode() {
		String identifier = URLIdentifierUtils.createURLIdentifier(45L, "test českých znáčků a žluťoučkých žiraf Ň!");
		assertEquals("45-test+českých+znáčků+a+žluťoučkých+žiraf+Ň%21", identifier);
	}

	@Test
	public void testParseURLIdentifier_basic() {
		URLIdentifier identifier = URLIdentifierUtils.parseURLIdentifier("45-test");
		assertEquals(new Long(45L), identifier.getId());
		assertEquals("test", identifier.getName());
	}

	@Test
	public void testParseURLIdentifier_special() {
		URLIdentifier identifier = URLIdentifierUtils.parseURLIdentifier("45-test+WTF%252Fmin");
		assertEquals(new Long(45L), identifier.getId());
		assertEquals("test WTF/min", identifier.getName());
	}

	@Test
	public void testParseURLIdentifier_unicode() {
		URLIdentifier identifier = URLIdentifierUtils
				.parseURLIdentifier("45-test+českých+znáčků+a+žluťoučkých+žiraf+Ň%21");
		assertEquals(new Long(45L), identifier.getId());
		assertEquals("test českých znáčků a žluťoučkých žiraf Ň!", identifier.getName());
	}

}
