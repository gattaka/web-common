package cz.gattserver.web.common.ui;

import com.vaadin.server.ClassResource;
import com.vaadin.server.Resource;

public enum ImageIcon {

	/** */
	ADDRESS_16_ICON("img/icons/address_16.png"),
	/** */
	BLOCK_16_ICON("img/icons/block_16.png"),
	/** */
	BOOKMARK_16_ICON("img/icons/bookmark_16.png"),
	/** */
	BRIEFCASE_16_ICON("img/icons/briefcase_16.png"),
	/** */
	BRIEFCASE_PLUS_16_ICON("img/icons/briefcase_plus_16.png"),
	/** */
	BROKEN_HEART_16_ICON("img/icons/broken_heart_16.png"),
	/** */
	BUBBLE_16_ICON("img/icons/bubble_16.png"),
	/** */
	BUY_16_ICON("img/icons/buy_16.png"),
	/** */
	CALENDAR_16_ICON("img/icons/calendar_16.png"),
	/** */
	CLIPBOARD_16_ICON("img/icons/clipboard_16.png"),
	/** */
	CLOCK_16_ICON("img/icons/clock_16.png"),
	/** */
	DELETE_16_ICON("img/icons/delete_16.png"),
	/** */
	DIAGRAM_16_ICON("img/icons/diagram_16.png"),
	/** */
	DOCUMENT_16_ICON("img/icons/document_16.png"),
	/** */
	DOWN_16_ICON("img/icons/down_16.png"),
	/** */
	FLAG_16_ICON("img/icons/flag_16.png"),
	/** */
	FOLDER_16_ICON("img/icons/folder_16.png"),
	/** */
	GEAR2_16_ICON("img/icons/gear2_16.png"),
	/** */
	GLOBE_16_ICON("img/icons/globe_16.png"),
	/** */
	HEART_16_ICON("img/icons/heart_16.png"),
	/** */
	HELP_16_ICON("img/icons/help_16.png"),
	/** */
	HOME_16_ICON("img/icons/home_16.png"),
	/** */
	IMG_16_ICON("img/icons/img_16.png"),
	/** */
	INFO_16_ICON("img/icons/info_16.png"),
	/** */
	KEY_16_ICON("img/icons/key_16.png"),
	/** */
	LABEL_16_ICON("img/icons/label_16.png"),
	/** */
	LEFT_16_ICON("img/icons/left_16.png"),
	/** */
	LETTER_16_ICON("img/icons/letter_16.png"),
	/** */
	MONITOR_16_ICON("img/icons/monitor_16.png"),
	/** */
	MOVE_16_ICON("img/icons/move_16.png"),
	/** */
	PENCIL_16_ICON("img/icons/pencil_16.png"),
	/** */
	PLUS_16_ICON("img/icons/plus_16.png"),
	/** */
	PRESENT_16_ICON("img/icons/present_16.png"),
	/** */
	PRINT_16_ICON("img/icons/print_16.png"),
	/** */
	QUICKEDIT_16_ICON("img/icons/quickedit_16.png"),
	/** */
	RIGHT_16_ICON("img/icons/right_16.png"),
	/** */
	SAVE_16_ICON("img/icons/save_16.png"),
	/** */
	SEARCH_16_ICON("img/icons/search_16.png"),
	/** */
	SHIELD_16_ICON("img/icons/shield_16.png"),
	/** */
	STATISTICS_16_ICON("img/icons/statistics_16.png"),
	/** */
	STOP_16_ICON("img/icons/stop_16.png"),
	/** */
	TICK_16_ICON("img/icons/tick_16.png"),
	/** */
	TRASH_16_ICON("img/icons/trash_16.png"),
	/** */
	UP_16_ICON("img/icons/up_16.png"),
	/** */
	USER_16_ICON("img/icons/user_16.png"),
	/** */
	WALLET_16_ICON("img/icons/wallet_16.png"),
	/** */
	WARNING_16_ICON("img/icons/warning_16.png");

	private String path;

	private ImageIcon(String path) {
		this.path = path;
	}

	public Resource createResource() {
		return new ClassResource(path);
	}
}
