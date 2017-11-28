package cz.gattserver.web.common.ui.window;

import com.vaadin.server.Resource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;

public class MessageWindow extends WebWindow {

	private static final long serialVersionUID = 4123506060675738841L;

	protected TextArea detailsArea;

	/**
	 * @param caption
	 *            popisek okna
	 * @param labelCaption
	 *            obsah zprávy v okně
	 * @param imageResource
	 *            resource ikony okna
	 */
	public MessageWindow(String caption, String labelCaption, Resource imageResource) {
		this(caption, labelCaption, null, imageResource);
	}

	/**
	 * @param caption
	 *            popisek okna
	 * @param labelCaption
	 *            obsah zprávy v okně
	 * @param imageResource
	 *            resource ikony okna
	 */
	public MessageWindow(String caption, String labelCaption, String details, Resource imageResource) {
		super(caption);

		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setSpacing(true);
		addComponent(horizontalLayout);

		Embedded embedded = new Embedded(null, imageResource);
		horizontalLayout.addComponent(embedded);
		horizontalLayout.setComponentAlignment(embedded, Alignment.MIDDLE_CENTER);

		Label msgLabel = new Label(labelCaption);
		msgLabel.setSizeUndefined();
		horizontalLayout.addComponent(msgLabel);

		createDetails(details);

		Button proceedButton = new Button("OK", event -> close());

		addComponent(proceedButton);
		setComponentAlignment(proceedButton, Alignment.BOTTOM_RIGHT);
	}

	protected void createDetails(String details) {
		if (details != null) {
			detailsArea = new TextArea();
			detailsArea.setValue(details);
			detailsArea.setEnabled(false);
			detailsArea.setWidth("100%");
			detailsArea.setHeight("200px");
			addComponent(detailsArea);
		}
	}

}
