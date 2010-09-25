/**
 * 
 */
package pagecode;

import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.component.html.HtmlOutcomeTargetLink;

/**
 * @author root
 *
 */
public class Librarian1 extends PageCodeBase {

	protected HtmlForm form1;
	protected HtmlPanelGroup group1;
	protected HtmlPanelGroup group2;
	protected HtmlOutcomeTargetLink link1;
	protected HtmlOutputText text2;
	protected HtmlPanelGroup group3;
	protected HtmlCommandButton button2;
	protected HtmlOutputText text1;
	protected HtmlOutputText text3;
	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlPanelGroup getGroup1() {
		if (group1 == null) {
			group1 = (HtmlPanelGroup) findComponentInRoot("group1");
		}
		return group1;
	}

	protected HtmlPanelGroup getGroup2() {
		if (group2 == null) {
			group2 = (HtmlPanelGroup) findComponentInRoot("group2");
		}
		return group2;
	}

	protected HtmlOutcomeTargetLink getLink1() {
		if (link1 == null) {
			link1 = (HtmlOutcomeTargetLink) findComponentInRoot("link1");
		}
		return link1;
	}

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlPanelGroup getGroup3() {
		if (group3 == null) {
			group3 = (HtmlPanelGroup) findComponentInRoot("group3");
		}
		return group3;
	}

	protected HtmlCommandButton getButton2() {
		if (button2 == null) {
			button2 = (HtmlCommandButton) findComponentInRoot("button2");
		}
		return button2;
	}

	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		return text1;
	}

	protected HtmlOutputText getText3() {
		if (text3 == null) {
			text3 = (HtmlOutputText) findComponentInRoot("text3");
		}
		return text3;
	}

}