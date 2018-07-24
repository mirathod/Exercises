package org.milan.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


public class Sample {
public static void main(String[] args) throws SAXException, IOException, TransformerException {
	Sample s=new Sample();
	s.createRoot(new File("C:\\Downloads\\20160616_232202_cn_payroll.xml"));
}
public void createRoot(File filename){
	DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
	FileInputStream fis=null;
	try {
		
		DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
		
		//Parse the existing xml file
		Document document=documentBuilder.parse(filename);
		
		
		//Create new document which will contain root tag
		Document doc=documentBuilder.newDocument();
		Node root=doc.createElement("root");
		doc.appendChild(root);
		
		//Import all nodes/tags of existing xml file and append it to root element of new document
		Node copy=doc.importNode(document.getDocumentElement(),true);
		root.appendChild(copy);

		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(filename);
		
		//To transform the new document into existing xml file with changes
		transformer.transform(source, result);
		//fis=new FileInputStream(filename);
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		//return null;
	}
	catch (SAXParseException e) {
		// TODO: handle exception
		System.out.println ("** Parsing error" + ", line " + e.getLineNumber () + ", uri " + e.getSystemId ());
		System.out.println(" " + e.getMessage ());
	}
	catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (TransformerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//return fis;
}
}
