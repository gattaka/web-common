package cz.gattserver.web.common.ui;

import java.io.InputStream;
import java.util.List;

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

	private boolean queueStarted = false;

	public MultiUpload() {
		this(null, true);
	}

	public MultiUpload(String caption) {
		this(caption, true);
	}

	public MultiUpload(String caption, boolean multiple) {
		ui = UI.getCurrent();
		stateWindow = new UploadStateWindow();
		multiFileUpload = new MultiFileUpload(this::fileUploadStarted, this::fileUploadFinished, stateWindow, multiple);
		multiFileUpload.setWidth(null);
		multiFileUpload.setUploadButtonIcon(ImageIcon.UP_16_ICON.createResource());
		multiFileUpload.setUploadButtonCaptions(caption == null ? DEFAULT_SINGLE_BUTTON_CAPTION : caption,
				caption == null ? DEFAULT_MULTI_BUTTON_CAPTION : caption);
		addComponent(multiFileUpload);
	}

	/**
	 * Dokončení nahrávání souboru z fronty
	 * 
	 * @param in
	 *            datový tok souboru
	 * @param fileName
	 *            název souboru
	 * @param mimeType
	 *            mime typ souboru
	 * @param length
	 *            délka souboru
	 * @param filesLeftInQueue
	 *            počet zbývajících souborů ve frontě
	 */
	protected void fileUploadFinished(InputStream in, String fileName, String mimeType, long length,
			int filesLeftInQueue) {
		if (filesLeftInQueue == 0)
			queueFinished();
	}

	protected void queueFinished() {
		// ui.setPollInterval(-1);
		queueStarted = false;
	}

	/**
	 * Zahájení nahrávání souboru z fronty
	 */
	protected void fileUploadStarted() {
		if (!queueStarted)
			queueStarted();
	}

	/**
	 * Zahájení nahrávání fronty
	 */
	protected void queueStarted() {
		// ui.setPollInterval(200);
		queueStarted = true;
	}

	@Override
	public void attach() {
		ui.setPollInterval(200);
		super.attach();
	}

	@Override
	public void detach() {
		ui.setPollInterval(-1);
		super.detach();
	}

	@Override
	public void setCaption(String caption) {
		multiFileUpload.setUploadButtonCaptions(caption, caption);
	}

	public void setMaxFileSize(long size) {
		multiFileUpload.setMaxFileSize(size);
	}

	@Override
	public void setEnabled(boolean enabled) {
		multiFileUpload.setEnabled(enabled);
	}

	public void setAcceptedMimeTypes(List<String> mimeTypes) {
		multiFileUpload.setAcceptedMimeTypes(mimeTypes);
	}

}
