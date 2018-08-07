package cz.gattserver.web.common.ui;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import com.vaadin.server.StreamVariable.StreamingEndEvent;
import com.vaadin.server.StreamVariable.StreamingErrorEvent;
import com.vaadin.server.StreamVariable.StreamingStartEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;
import com.wcs.wcslib.vaadin.widget.multifileupload.component.FileDetail;
import com.wcs.wcslib.vaadin.widget.multifileupload.ui.MultiFileUpload;
import com.wcs.wcslib.vaadin.widget.multifileupload.ui.UploadStatePanel;
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
		multiFileUpload = new MultiFileUpload(this::fileUploadStarted, this::fileUploadFinished, stateWindow,
				multiple) {
			private static final long serialVersionUID = -6677106795206435746L;

			protected UploadStatePanel createStatePanel(UploadStateWindow uploadStateWindow) {
				return new UploadStatePanel(uploadStateWindow) {
					private static final long serialVersionUID = -1374553853516331934L;

					@Override
					public void filesQueued(Collection<FileDetail> pendingFileNames) {
						ui.accessSynchronously(() -> ui.setPollInterval(200));
						super.filesQueued(pendingFileNames);
					}

					public void streamingStarted(StreamingStartEvent event) {
						ui.accessSynchronously(() -> ui.setPollInterval(200));
						super.streamingStarted(event);
					};

					public void streamingFinished(StreamingEndEvent event) {
						ui.accessSynchronously(() -> ui.setPollInterval(-1));
						super.streamingFinished(event);
					};

					public void streamingFailed(StreamingErrorEvent event) {
						ui.accessSynchronously(() -> ui.setPollInterval(-1));
						super.streamingFailed(event);
					};
				};
			};
		};
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
		queueStarted = true;
	}

	@Override
	public void attach() {
		super.attach();
	}

	@Override
	public void detach() {
		super.detach();
		// pro jistotu, aby se to aspoň někdy vypnulo
		ui.setPollInterval(-1);
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
