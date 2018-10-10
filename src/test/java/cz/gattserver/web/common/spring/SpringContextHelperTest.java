package cz.gattserver.web.common.spring;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:spring/app-context.xml" })
public class SpringContextHelperTest {

	@Test
	public void testGetBean1() {
		TestComponent tc = SpringContextHelper.getBean(TestComponent.class);
		assertNotNull(tc);
	}

	@Test
	public void testGetBean2() {
		Object tc = SpringContextHelper.getBean("testComponentImplementation");
		assertNotNull(tc);
		assertTrue(tc instanceof TestComponentImpl);
	}
	
	@Test
	public void testGetContext() {
		ApplicationContext context = SpringContextHelper.getContext();
		assertNotNull(context);
		
		TestComponent tc = context.getBean(TestComponent.class);
		assertNotNull(tc);
	}

}
