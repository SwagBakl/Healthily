package configuration;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadFromProperty {

    public static String getProperty(String property) {
        Properties properties = new Properties();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream is = classLoader.getResourceAsStream("chatBot.properties");
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }

    public static String getXml(String propertyName, String fileName) {
        DocumentBuilderFactory documentBuilderFactory;
        DocumentBuilder documentBuilder;
        Document document;
        String stringNode = "";
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(inputStream);
            Element element = document.getDocumentElement();
            NodeList nodeList = element.getElementsByTagName(propertyName).item(0).getChildNodes();
            Node node = nodeList.item(0);
            stringNode = node.getNodeValue().trim();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        return stringNode;
    }
}
