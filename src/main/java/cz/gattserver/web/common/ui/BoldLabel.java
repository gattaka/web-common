package cz.gattserver.web.common.ui;

import com.vaadin.flow.component.html.Span;

public class BoldLabel extends Span {

	private static final long serialVersionUID = 7526089060607305886L;

	public BoldLabel(String value) {
		super("<strong>" + value + "</strong>");
	}
}
