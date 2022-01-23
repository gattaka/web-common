package cz.gattserver.web.common.spring;

//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

//@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfiguration.class)
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

	@Test
	public void testInject() {
		TestConsumer consumer = new TestConsumer();
		assertNull(consumer.getComponent());

		SpringContextHelper.inject(consumer);
		assertNotNull(consumer.getComponent());
		assertTrue(consumer.getComponent() instanceof TestComponentImpl);
	}

}
