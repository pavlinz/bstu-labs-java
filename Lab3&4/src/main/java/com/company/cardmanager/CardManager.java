package com.company.cardmanager;


import com.company.account.Account;
import com.company.cardset.CardSet;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CardManager {

    public CardSet createCardSet(CardSet someCardSet) throws ParserConfigurationException, IOException, SAXException {
        File file = new File("D:\\OneDrive\\Study\\Course_2\\2\\Java\\Solutions\\Lab3&4\\files\\info.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("account");
        for (int i = 0; i < nodeList.getLength(); i++) {
            someCardSet.add(getAccount(nodeList.item(i)));
        }
        return someCardSet;
    }

    private static Account getAccount(Node node) {
        Account acc = new Account();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            acc.setBalanceAmount(Double.valueOf(getTagValue("balanceAmount", element)));
            acc.setStatus(Boolean.valueOf(getTagValue("status", element)));
        }
        return acc;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    public CardSet generateCardSet (CardSet someCardSet) {
        System.out.println("Enter the number of accounts");
        Scanner in = new Scanner(System.in);
        byte answer = 0;
        System.out.print("Input:");
        answer = in.nextByte();
        for(int i = 0; i < answer; i++) {
            someCardSet.add(new Account(Math.random() * 3000,true));
        }
        return  someCardSet;
    }
}
