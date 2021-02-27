package com.example.demo.util;

import com.example.demo.model.Client;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class XMLParserUtil {

    public static List<Client> parseXmlAndAddToObject() throws IOException, ParserConfigurationException, SAXException {
        List<Client> clientList = new ArrayList<>();
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(new InputSource(new StringReader(getXmlOfUrl())));
        NodeList errNodes = doc.getElementsByTagName("item");
        for (int temp = 0; temp < errNodes.getLength(); temp++)
        {
            Node node = errNodes.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                Client client = new Client();
                client.setClientId(Long.valueOf(eElement.getElementsByTagName("clientId").item(0).getTextContent()));
                client.setBalance(Integer.valueOf(eElement.getElementsByTagName("balance").item(0).getTextContent()));
                clientList.add(client);
            }
        }
        return clientList;
}

    public static String getXmlOfUrl() throws IOException {
            URL url = new URL("http://localhost:8080/testApp/users.xml");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        return response.toString();
    }
}
