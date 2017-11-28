package cz.gattserver.web.common.ui.window;

import java.io.Serializable;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

public class ConfirmWindow extends WebWindow {

	private static final long serialVersionUID = 4123506060675738841L;

	private ConfirmAction confirmAction;

	public interface ConfirmAction extends Serializable {
		public void onConfirm(ClickEvent event);
	}

	/**
	 * Nejobecnější dotaz na potvrzení operace
	 */
	public ConfirmWindow(ConfirmAction confirmAction) {
		this("Opravdu si přejete provést tuto operaci ?", confirmAction);
	}

	/**
	 * Okno bude vytvořeno s popiskem, ve kterém bude předaný text
	 * 
	 * @param labelCaption
	 *            text popisku okna
	 */
	public ConfirmWindow(String labelCaption, ConfirmAction confirmAction) {
		this(new Label(labelCaption), confirmAction);
	}

	/**
	 * Okno bude vytvořeno přímo s připraveným popiskem
	 * 
	 * @param label
	 *            popisek okna
	 */
	public ConfirmWindow(Label label, ConfirmAction confirmAction) {
		super("Potvrzení operace");
		this.confirmAction = confirmAction;

		label.setWidth("350px");

		GridLayout subWindowlayout = new GridLayout(2, 2);
		setContent(subWindowlayout);
		subWindowlayout.setMargin(true);
		subWindowlayout.setSpacing(true);

		subWindowlayout.addComponent(label, 0, 0, 1, 0);

		Button confirm = new Button("Ano", new Button.ClickListener() {

			private static final long serialVersionUID = 8490964871266821307L;

			public void buttonClick(ClickEvent event) {
				ConfirmWindow.this.confirmAction.onConfirm(event);
				close();
			}
		});

		subWindowlayout.addComponent(confirm, 0, 1);
		subWindowlayout.setComponentAlignment(confirm, Alignment.MIDDLE_CENTER);

		Button close = new Button("Ne", new Button.ClickListener() {

			private static final long serialVersionUID = 8490964871266821307L;

			public void buttonClick(ClickEvent event) {
				close();
			}
		});

		subWindowlayout.addComponent(close, 1, 1);
		subWindowlayout.setComponentAlignment(close, Alignment.MIDDLE_CENTER);

	}

	public ConfirmAction getConfirmAction() {
		return confirmAction;
	}

	public void setConfirmAction(ConfirmAction confirmAction) {
		this.confirmAction = confirmAction;
	}

}
