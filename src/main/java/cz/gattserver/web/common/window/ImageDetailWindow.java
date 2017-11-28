package cz.gattserver.web.common.window;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.vaadin.server.FileResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Image;

import cz.gattserver.web.common.window.WebWindow;

public class ImageDetailWindow extends WebWindow {

	private static final long serialVersionUID = 4123506060675738841L;

	private static final int WINDOWPADDING = 45;
	private static final int WINDOWHEADER_HEIGHT = 50;

	public ImageDetailWindow(String description, File file) {
		super(description);
		BufferedImage bimg = null;
		try {
			bimg = ImageIO.read(file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		if (bimg != null) {
			int width = bimg.getWidth();
			int height = bimg.getHeight();

			Image img = new Image(null, new FileResource(file));
			addComponent(img);
			layout.setComponentAlignment(img, Alignment.MIDDLE_CENTER);
			setWidth((width + WINDOWPADDING) + "px");
			setHeight((height + WINDOWPADDING + WINDOWHEADER_HEIGHT) + "px");
		}
	}

}
