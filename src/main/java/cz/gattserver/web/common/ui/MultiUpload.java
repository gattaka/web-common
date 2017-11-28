package cz.gattserver.web.common.ui;

import java.io.InputStream;

import com.vaadin.ui.CssLayout;
import com.wcs.wcslib.vaadin.widget.multifileupload.ui.MultiFileUpload;
import com.wcs.wcslib.vaadin.widget.multifileupload.ui.UploadStateWindow;

public abstract class MultiUpload extends CssLayout {

	private static final long serialVersionUID = 8634797364790772321L;

	protected MultiFileUpload multiFileUpload;
	protected UploadStateWindow stateWindow;

	protected abstract void handleFile(InputStream in, String fileName, String mimeType, long length);

	protected void onStart() {
	}

	@Override
	public void setCaption(String caption) {
		multiFileUpload.setUploadButtonCaptions(caption, caption);
	}

	public MultiUpload() {
		this(true);
	}

	public MultiUpload(boolean multiple) {
		stateWindow = new UploadStateWindow();
		multiFileUpload = new MultiFileUpload(this::onStart,
				(InputStream stream, String fileName, String mimeType, long length,
						int filesLeftInQueue) -> MultiUpload.this.handleFile(stream, fileName, mimeType, length),
				stateWindow, multiple);
		multiFileUpload.setWidth(null);
		multiFileUpload.setUploadButtonCaptions("Vybrat soubor", "Vybrat soubory");
		addComponent(multiFileUpload);
	}

}
