/**
 * 
 */
package pagecode.templates;

import pagecode.PageCodeBase;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.component.html.HtmlOutcomeTargetButton;

/**
 * @author root
 *
 */
public class MainTemplate extends PageCodeBase {

	protected HtmlCommandLink MainLink1;
	protected HtmlForm MainForm1;
	protected HtmlOutputText mttext1;
	protected HtmlPanelGroup mtgroup1;
	protected HtmlOutputText mttext2;
	protected HtmlPanelGroup mtgroup3;
	protected HtmlOutcomeTargetButton mtbutton1;
	protected HtmlPanelGroup mtgroup2;
	protected HtmlOutcomeTargetButton mtbutton2;
	protected HtmlOutputText getMttext1() {
		if (mttext1 == null) {
			mttext1 = (HtmlOutputText) findComponentInRoot("mttext1");
		}
		return mttext1;
	}
	protected HtmlPanelGroup getMtgroup1() {
		if (mtgroup1 == null) {
			mtgroup1 = (HtmlPanelGroup) findComponentInRoot("mtgroup1");
		}
		return mtgroup1;
	}
	protected HtmlOutputText getMttext2() {
		if (mttext2 == null) {
			mttext2 = (HtmlOutputText) findComponentInRoot("mttext2");
		}
		return mttext2;
	}
	protected HtmlPanelGroup getMtgroup3() {
		if (mtgroup3 == null) {
			mtgroup3 = (HtmlPanelGroup) findComponentInRoot("mtgroup3");
		}
		return mtgroup3;
	}
	protected HtmlOutcomeTargetButton getMtbutton1() {
		if (mtbutton1 == null) {
			mtbutton1 = (HtmlOutcomeTargetButton) findComponentInRoot("mtbutton1");
		}
		return mtbutton1;
	}
	protected HtmlPanelGroup getMtgroup2() {
		if (mtgroup2 == null) {
			mtgroup2 = (HtmlPanelGroup) findComponentInRoot("mtgroup2");
		}
		return mtgroup2;
	}
	protected HtmlOutcomeTargetButton getMtbutton2() {
		if (mtbutton2 == null) {
			mtbutton2 = (HtmlOutcomeTargetButton) findComponentInRoot("mtbutton2");
		}
		return mtbutton2;
	}

}