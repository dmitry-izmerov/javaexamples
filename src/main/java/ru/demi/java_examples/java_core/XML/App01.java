package ru.demi.java_examples.java_core.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by demi
 * on 26.06.15.
 */
public class App01 {
	public static void main(String[] args) throws IOException {
//        InputStream is = Files.newInputStream(Paths.get("/media/demi/b4ca797e-825f-4cbc-879b-3344daf23a78/idd90/Java/JavaExamples/src/ru/demi/java_examples/XML/data1.xml"));
//        InputStream is = Files.newInputStream(Paths.get("/media/demi/b4ca797e-825f-4cbc-879b-3344daf23a78/idd90/Java/JavaExamples/src/ru/demi/java_examples/XML/data2.xml"));
		InputStream is = Files.newInputStream(Paths.get("/media/demi/b4ca797e-825f-4cbc-879b-3344daf23a78/idd90/Java/JavaExamples/src/ru/demi/java_examples/XML/data3.xml"));

		Document document = buildDocument(is);
		Element element = document.getDocumentElement();
		insertComment(document, element);

		// output
		String res = getDocumentString(document);
		System.out.println(res);
	}

	public static Document buildDocument(InputStream inputStream) {
		Document document = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(inputStream);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}

	public static void insertComment(Document document, Node element) {
		NodeList nodeList = element.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (hasChildElements(node)) {
				insertComment(document, node);
			} else {
				if (node.getNodeName().equals("first")) {
					element.insertBefore(document.createComment("test comment"), node);
					Node textNode = node.getPreviousSibling().getPreviousSibling();
					if (textNode.getNodeType() == Node.TEXT_NODE) {
						element.insertBefore(textNode.cloneNode(false), node);
					}
					++i;
					++i;
				}
			}
		}
	}

	public static boolean hasChildElements(Node node) {
		boolean r = false;
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
				r = true;
				break;
			}
		}
		return r;
	}

	public static String getDocumentString(Document document) {
		Writer out = new StringWriter();
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult(out));
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return out.toString();
	}
}
