package cz.gattserver.web.common.ui.window;

import com.vaadin.server.StreamResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Image;

public class ImageDetailWindow extends WebWindow {

	private static final long serialVersionUID = 4123506060675738841L;

	private static final int WINDOWPADDING = 45;
	private static final int WINDOWHEADER_HEIGHT = 50;

	public ImageDetailWindow(String description, int width, int height, StreamResource resource) {
		super(description);
		Image img = new Image(null, resource);
		addComponent(img);
		layout.setComponentAlignment(img, Alignment.MIDDLE_CENTER);
		setWidth((width + WINDOWPADDING) + "px");
		setHeight((height + WINDOWPADDING + WINDOWHEADER_HEIGHT) + "px");
	}

}
