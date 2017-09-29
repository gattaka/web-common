package cz.gattserver.web.common.window;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import cz.gattserver.web.common.SpringContextHelper;

public class WebWindow extends Window {

	private static final long serialVersionUID = -9184044674542039306L;

	protected VerticalLayout layout = new VerticalLayout();

	public WebWindow(String name) {
		super(name);
		SpringContextHelper.inject(this);

		setContent(layout);

		layout.setSpacing(true);
		layout.setMargin(true);

		addAction(new Window.CloseShortcut(this, KeyCode.ESCAPE));

		center();
	}

	protected void addComponent(Component component) {
		layout.addComponent(component);
	}

	protected void setComponentAlignment(Component component, Alignment alignment) {
		layout.setComponentAlignment(component, alignment);
	}

}
