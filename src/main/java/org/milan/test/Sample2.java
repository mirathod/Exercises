package org.milan.test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class Sample2 {
public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
	String filename="C:\\Downloads\\20160616_232202_cn_payroll.xml";
	BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Downloads\\20160616_232202_cn_payroll.xml")));
	String line;
	StringBuilder sb = new StringBuilder();
	sb.append("<root>");
	while((line=br.readLine())!= null){	
			 sb.append(line.trim());	  
	}
	
	sb.append("</root>");
	System.out.println(sb.toString());
	
	 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
     DocumentBuilder builder = factory.newDocumentBuilder();
     Document document=builder.parse(new InputSource(new StringReader(sb.toString())));
     TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		DOMSource source = new DOMSource(document);
		
		StreamResult result = new StreamResult(filename);
		transformer.transform(source, result);
		
}
}
