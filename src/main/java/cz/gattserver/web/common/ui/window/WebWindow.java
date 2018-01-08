package cz.gattserver.web.common.ui.window;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import cz.gattserver.web.common.spring.SpringContextHelper;

public class WebWindow extends Window {

	private static final long serialVersionUID = -9184044674542039306L;

	protected VerticalLayout layout = new VerticalLayout();

	public WebWindow() {
		init();
	}

	public WebWindow(String name) {
		super(name);
		init();
	}

	private void init() {
		SpringContextHelper.inject(this);

		setContent(layout);
		setModal(true);

		layout.setSpacing(true);
		layout.setMargin(true);

		addAction(new Window.CloseShortcut(this, KeyCode.ESCAPE));
		center();
	}

	public void addComponent(Component component) {
		layout.addComponent(component);
	}

	public void addComponent(Component component, Alignment alignment) {
		layout.addComponent(component);
		setComponentAlignment(component, alignment);
	}

	public void setComponentAlignment(Component component, Alignment alignment) {
		layout.setComponentAlignment(component, alignment);
	}

}
