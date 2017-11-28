package cz.gattserver.web.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextHelperProvider implements ApplicationContextAware {

	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		SpringContextHelper.setApplicationContext(ctx);
	}
}