package cz.gattserver.web.common;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextHelper implements ApplicationContextAware {

	private static volatile ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHelper.applicationContext = applicationContext;
	}

	public static ApplicationContext getContext() {
		return applicationContext;
	}

	public static Object getBean(final String beanRef) {
		return getContext().getBean(beanRef);
	}

	public static <T> T getBean(final Class<T> type) {
		return getContext().getBean(type);
	}

	public static void inject(Object target) {
		getContext().getAutowireCapableBeanFactory().autowireBeanProperties(target,
				AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);
	}

}