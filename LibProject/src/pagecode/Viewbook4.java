/**
 * 
 */
package pagecode;

import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlOutcomeTargetLink;
import javax.faces.component.UIParameter;

/**
 * @author root
 *
 */
public class Viewbook4 extends PageCodeBase {

	protected HtmlOutputText text1;
	protected HtmlOutcomeTargetLink link1;
	protected UIParameter param1;
	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		return text1;
	}
	protected HtmlOutcomeTargetLink getLink1() {
		if (link1 == null) {
			link1 = (HtmlOutcomeTargetLink) findComponentInRoot("link1");
		}
		return link1;
	}
	protected UIParameter getParam1() {
		if (param1 == null) {
			param1 = (UIParameter) findComponentInRoot("param1");
		}
		return param1;
	}

}