package cz.gattserver.web.common.ui.window;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.server.StreamResource;

public class ImageDetailWindow extends WebDialog {

	private static final long serialVersionUID = 4123506060675738841L;

	private static final int WINDOWPADDING = 45;
	private static final int WINDOWHEADER_HEIGHT = 50;

	public ImageDetailWindow(String description, int width, int height, StreamResource resource) {
		addComponent(new Span(description));
		Image img = new Image(resource, description);
		addComponent(img);
		layout.setHorizontalComponentAlignment(Alignment.CENTER, img);
		setWidth((width + WINDOWPADDING) + "px");
		setHeight((height + WINDOWPADDING + WINDOWHEADER_HEIGHT) + "px");
	}

}
