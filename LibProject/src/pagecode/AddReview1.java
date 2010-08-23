/**
 * 
 */
package pagecode;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlOutcomeTargetLink;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputText;

/**
 * @author root
 *
 */
public class AddReview1 extends PageCodeBase {

	protected HtmlCommandButton button1;
	protected HtmlOutcomeTargetLink link1;
	protected HtmlInputTextarea textarea1;
	protected HtmlOutputText text1;
	protected HtmlCommandButton getButton1() {
		if (button1 == null) {
			button1 = (HtmlCommandButton) findComponentInRoot("button1");
		}
		return button1;
	}
	protected HtmlOutcomeTargetLink getLink1() {
		if (link1 == null) {
			link1 = (HtmlOutcomeTargetLink) findComponentInRoot("link1");
		}
		return link1;
	}
	protected HtmlInputTextarea getTextarea1() {
		if (textarea1 == null) {
			textarea1 = (HtmlInputTextarea) findComponentInRoot("textarea1");
		}
		return textarea1;
	}
	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		return text1;
	}

}