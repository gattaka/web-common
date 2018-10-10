package cz.gattserver.web.common.spring;

import org.springframework.stereotype.Component;

@Component("testComponentImplementation")
public class TestComponentImpl implements TestComponent {

	@Override
	public String testMethod() {
		return "ok";
	}

}
