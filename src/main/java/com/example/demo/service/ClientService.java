package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.util.ClientUtil;
import com.example.demo.util.XMLParserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static com.example.demo.config.MessagingConfig.EXCHANGE;
import static com.example.demo.config.MessagingConfig.ROUTING_KEY;

@Service
@Slf4j
public class ClientService {

    final ClientRepository clientRepository;
    final RabbitTemplate rabbitTemplate;
    static final Integer BALANCE = 200;

    private List<Client> clientList;

    @Scheduled(initialDelay = 6000, fixedDelay = 5000)
    public void updateRecordInCouchbaseWithScheduled(){
        try {
            List<Client> list = XMLParserUtil.parseXmlAndAddToObject();
            list.forEach(client -> {
                clientRepository.save(client);
                log.info("Add to couchbase" + client.getClientId());
            });
        } catch (IOException | ParserConfigurationException | SAXException e) {
            log.error("Parsing error " + e);
        }
    }

    @Scheduled(initialDelay = 10000, fixedDelay = 20000)
    public void getAllRecordWhichScheduled(){
        clientList = clientRepository.findAll();
        System.out.println("Get all record from Couchbase " + clientList);
    }

    @Scheduled(initialDelay = 10000, fixedDelay = 30000)
    public void publicationInRabbit(){
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, ClientUtil.filterByBalance(clientList, 200));
        System.out.println("Unload entire list to RabbitMq " + clientList);
    }

    @Autowired
    public ClientService(ClientRepository clientRepository, RabbitTemplate rabbitTemplate) {
        this.clientRepository = clientRepository;
        this.rabbitTemplate = rabbitTemplate;
    }
}
