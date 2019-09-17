package cz.gattserver.web.common.ui;

import com.vaadin.flow.component.html.Div;

public class HtmlDiv extends Div {

	private static final long serialVersionUID = 7526089060607305886L;

	public HtmlDiv(String value) {
		super();
		setValue(value);
	}

	public HtmlDiv setValue(String value) {
		getElement().setProperty("innerHTML", value);
		return this;
	}

	public String getValue() {
		return getElement().getProperty("innerHTML");
	}
}
