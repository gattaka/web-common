package cz.gattserver.web.common.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class TestConsumer {

	@Autowired
	private TestComponent component;

	public TestComponent getComponent() {
		return component;
	}

	public void setComponent(TestComponent component) {
		this.component = component;
	}

}
