package cz.gattserver.web.common.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;

public class InlineDiv extends Div {

	private static final long serialVersionUID = 7526089060607305886L;

	public InlineDiv(Component... components) {
		super(components);
		addClassName("inline-div");
	}
	
}
