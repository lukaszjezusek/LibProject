package pagecode;

import java.io.File;
import java.io.IOException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//import com.ibm.misc.BASE64Encoder;

import databasecode.User;
import databasecode.UserManagerBean;

@ManagedBean
public class Register {
	@EJB
	UserManagerBean um;
	
	String login = "";
	String password = "";
	
	String filepath="/home/hez/r/IBM/WebSphere/AppServer/profiles/AppSrv04/config/cells/localhostNode04Cell/fileRegistry.xml";
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String register() throws ParserConfigurationException, SAXException, IOException {
		
		if(um.getUser(login) != null) {
			return "registererror";
		}
		
		User newUser = new User();
		newUser.setName(login);
		
		um.saveUser(newUser);
		
		String userId = newUser.getId().toString();
		String userLogin = login;
		String hashPassword = "U0hBLTE6NHpkMGlwdWx2NmN2OkdqRGZFVkpQWDBQMHV4K0RldnlUUUVRN3BJWT0K";
		// zaszyfrowane haslo: u
	/*	try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(password.getBytes("UTF-8"));
			byte raw[] = md.digest();
		    hashPassword = (new BASE64Encoder()).encode(raw);
		    //TODO: nie dziala - problemy z zamiana z tablicy bajtow na stringa
		} catch (NoSuchAlgorithmException e3) {
			e3.printStackTrace();
		}*/
		
		String id = "aaaaaaaa-aaaa-aaaa-aaaa-";
		String lastId = "";
		for(int i = 0; i < 12-userId.length(); i++) {
			lastId+="a";
		}
		lastId+=userId;
		id+=lastId;
		
		String name = "o=defaultWIMFileBasedRealm";
		String fullName = "uid="+userLogin+","+name;
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		File file = new File(filepath);
		Document document = documentBuilder.parse(file);
		
		Node mainNode = document.getElementsByTagName("wim:Root").item(0);
		Node userGroupNode = null;
		
		NodeList nl = document.getElementsByTagName("wim:entities");
		
		for(int i = 0; i < nl.getLength(); i++) {
			Node n = nl.item(i);
			if(n.getAttributes().item(0).getNodeValue().equals("wim:Group")) {
				NodeList nnl = n.getChildNodes();
				boolean rightGroup = false;
				for(int j = 0; j < nnl.getLength(); j++) {
					Node nn = nnl.item(j);
					if(nn.getNodeName().equals("wim:cn")) {
						if(nn.getTextContent().equals("USER")) {
							rightGroup = true;
						}
						break;
					}
				}
				
				if(rightGroup == true) {
					userGroupNode = n;
					break;
				}
			}
		}
		
		Element e = document.createElement("wim:entities");
		NamedNodeMap EAttrMap = e.getAttributes();
		Attr eAttr = document.createAttribute("xsi:type");
		eAttr.setValue("wim:PersonAccount");
		EAttrMap.setNamedItem(eAttr);
		
		Element identifier = document.createElement("wim:identifier");
		NamedNodeMap identifierAttrMap = identifier.getAttributes();
		Attr externalId = document.createAttribute("externalId");
		Attr uniqueId = document.createAttribute("uniqueId");
		Attr externalName = document.createAttribute("externalName");
		Attr uniqueName = document.createAttribute("uniqueName");
		
		// ...
		
		externalId.setValue(id);
		uniqueId.setValue(id);
		externalName.setValue(fullName);
		uniqueName.setValue(fullName);
		
		identifierAttrMap.setNamedItem(externalId);
		identifierAttrMap.setNamedItem(externalName);
		identifierAttrMap.setNamedItem(uniqueId);
		identifierAttrMap.setNamedItem(uniqueName);
		
		// ...
		
		Element parent = document.createElement("wim:parent");
		Element parentIdentifier = document.createElement("wim:identifier");
		NamedNodeMap parentIdentifierAttrMap = parentIdentifier.getAttributes();
		Attr piUniqueName = document.createAttribute("uniqueName");
		piUniqueName.setValue(name);
		parentIdentifierAttrMap.setNamedItem(piUniqueName);
		parent.appendChild(parentIdentifier);
		
		// ...
		
		Element createTimestamp = document.createElement("wim:createTimestamp");
		createTimestamp.setTextContent("2010-08-18T13:19:53.913Z");
		
		// ...
		
		Element password = document.createElement("wim:password");
		password.setTextContent(hashPassword);
		
		// ...
		
		Element uid = document.createElement("wim:uid");
		uid.setTextContent(userLogin);
		Element cn = document.createElement("wim:cn");
		cn.setTextContent(userLogin);
		Element sn = document.createElement("wim:sn");
		sn.setTextContent(userLogin);
		Element mail = document.createElement("wim:mail");
		mail.setTextContent("not@important.com");
		
		e.appendChild(identifier);
		e.appendChild(parent);
		e.appendChild(createTimestamp);
		e.appendChild(password);
		e.appendChild(uid);
		e.appendChild(cn);
		e.appendChild(sn);
		e.appendChild(mail);
		
		mainNode.appendChild(e);
		
		// ...
		
		Element members = document.createElement("wim:members");
		Element membersIdentifier = document.createElement("wim:identifier");
		NamedNodeMap membersIdentifierMap = membersIdentifier.getAttributes();
		
		Attr mexternalId = document.createAttribute("externalId");
		Attr muniqueId = document.createAttribute("uniqueId");
		Attr mexternalName = document.createAttribute("externalName");
		Attr muniqueName = document.createAttribute("uniqueName");
		mexternalId.setValue(id);
		muniqueId.setValue(id);
		mexternalName.setValue(fullName);
		muniqueName.setValue(fullName);
		
		membersIdentifierMap.setNamedItem(mexternalId);
		membersIdentifierMap.setNamedItemNS(mexternalName);
		membersIdentifierMap.setNamedItem(muniqueId);
		membersIdentifierMap.setNamedItem(muniqueName);
		
		members.appendChild(membersIdentifier);
		userGroupNode.appendChild(members);
		
		// zapisywanie zmian do pliku
		
		Source source = new DOMSource(document);
		
		Result result = new StreamResult(file);
		
		try {
			Transformer xformer = TransformerFactory.newInstance().newTransformer();
			xformer.transform(source, result); 
		} catch (TransformerConfigurationException e1) {
			e1.printStackTrace();
		} catch (TransformerFactoryConfigurationError e1) {
			e1.printStackTrace();
		} catch (TransformerException e2) {
			e2.printStackTrace();
		} 
		
		return "registered";
	}

}
