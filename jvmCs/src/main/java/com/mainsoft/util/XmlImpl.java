package com.mainsoft.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * xml文件的解析及添加
 * @author wgs
 *
 */
public class XmlImpl implements XmlInterface {
	private Document document;

	public XmlImpl() {
		try {
			// 实例化 Document
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			this.document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 创建文件
	 * 
	 * @param fileName
	 * @param List
	 *            <String[]>
	 */

	public void createXml(String fileName, List<String[]> L) {
		Element root = this.document.createElement("root");
		this.document.appendChild(root);
          //遍历添加字符集
		for (int i = 0; i < L.size(); i++) {
			String p[] = L.get(i);
			Element employee = this.document.createElement("tatol");
			Element name = this.document.createElement("name");
			name.appendChild(this.document.createTextNode(p[0]));
			employee.appendChild(name);
			Element money = this.document.createElement("money");
			money.appendChild(this.document.createTextNode(p[1]));
			employee.appendChild(money);
			Element tradeState = this.document.createElement("tradeState");
			tradeState.appendChild(this.document.createTextNode(p[2]));
			employee.appendChild(tradeState);
			root.appendChild(employee);
		}
		TransformerFactory tf = TransformerFactory.newInstance();
		try {
           //生成xml文件
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result);
			System.out.println("生成XML文件成功!");
		} catch (TransformerConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (TransformerException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 解析文件
	 * 
	 * @param fileName  当前路径的文件名
	 * @param state
	 *            0全部 1成功 2失败
	 */
	public List<String[]> parserXml(String fileName, String state) {
		List<String[]> L = new ArrayList<String[]>();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(fileName);

			NodeList employees = document.getChildNodes();
			for (int i = 0; i < employees.getLength(); i++) {
				Node employee = employees.item(i);
				NodeList employeeInfo = employee.getChildNodes();
				for (int j = 0; j < employeeInfo.getLength(); j++) {
					Node node = employeeInfo.item(j);
					NodeList employeeMeta = node.getChildNodes();
					String[] s = new String[3];
					int p = 0;
					for (int k = 0; k < employeeMeta.getLength(); k++) {
						// System.out.println(employeeMeta.item(k).getNodeName()
						// + ":" + employeeMeta.item(k).getTextContent());
						// // s[k]=employeeMeta.item(k).getNodeName();
						// String a= employeeMeta.item(k).getTextContent();
						if (employeeMeta.item(k).getTextContent() != null
								&& !(employeeMeta.item(k).getTextContent()
										.trim().equals(""))) {
							s[p] = employeeMeta.item(k).getTextContent();
							//System.out.println(s[p]);
							p++;
							//
							// System.out.println(employeeMeta.item(k).getTextContent()+"============");
						}
					}
					//System.out.println(s[0]+"s[0])"+s[1]+"||"+s[2]);
					
					if (state.equals(s[2])) {
						L.add(s);
					}
					if (state.equals("0")) {
						L.add(s);

					}
				}
			}
			System.out.println("解析成功");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return L;
	}

}