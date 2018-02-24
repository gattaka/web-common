package cz.gattserver.web.common.ui;

import java.io.InputStream;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;
import com.wcs.wcslib.vaadin.widget.multifileupload.ui.MultiFileUpload;
import com.wcs.wcslib.vaadin.widget.multifileupload.ui.UploadStateWindow;

public abstract class MultiUpload extends CssLayout {

	private static final long serialVersionUID = 8634797364790772321L;

	private static final String DEFAULT_SINGLE_BUTTON_CAPTION = "Vybrat soubor";
	private static final String DEFAULT_MULTI_BUTTON_CAPTION = "Vybrat soubory";

	private UI ui;
	protected MultiFileUpload multiFileUpload;
	protected UploadStateWindow stateWindow;

	protected abstract void handleFile(InputStream in, String fileName, String mimeType, long length,
			int filesLeftInQueue);

	protected void onStart() {
		ui.setPollInterval(200);
	}

	protected void onFinish() {
		ui.setPollInterval(-1);
	}

	@Override
	public void setCaption(String caption) {
		multiFileUpload.setUploadButtonCaptions(caption, caption);
	}

	public MultiUpload() {
		this(null, true);
	}

	public MultiUpload(String caption) {
		this(caption, true);
	}

	public MultiUpload(String caption, boolean multiple) {
		ui = UI.getCurrent();
		stateWindow = new UploadStateWindow();
		multiFileUpload = new MultiFileUpload(this::onStart, this::handleFile, stateWindow, multiple);
		multiFileUpload.setWidth(null);
		multiFileUpload.setUploadButtonIcon(ImageIcon.UP_16_ICON.createResource());
		multiFileUpload.setUploadButtonCaptions(caption == null ? DEFAULT_SINGLE_BUTTON_CAPTION : caption,
				caption == null ? DEFAULT_MULTI_BUTTON_CAPTION : caption);
		addComponent(multiFileUpload);
	}

}
