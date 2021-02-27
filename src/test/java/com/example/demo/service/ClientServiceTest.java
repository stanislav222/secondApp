package com.example.demo.service;

import com.example.demo.config.MessagingConfig;
import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.config.MessagingConfig.EXCHANGE;
import static com.example.demo.config.MessagingConfig.ROUTING_KEY;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class ClientServiceTest {

    @MockBean
    private ClientRepository clientRepository;
    @MockBean
    RabbitTemplate rabbitTemplate;
    List<Client> clients = new ArrayList<>();

    @Test
    void updateRecordInCouchbaseWithScheduled() {
        Client client = new Client();
        client.setClientId(1L);
        client.setBalance(222);
        clientRepository.save(client);
        Assert.assertNotNull(client);
        Mockito.verify(clientRepository, Mockito.times(1)).save(client);
    }

    @Test
    void getAllRecordWhichScheduled() {
        Mockito.doReturn(new ArrayList<>())
                .when(clientRepository)
                .findAll();
    }

    @Test
    void publicationInRabbit() {
/*
        clients.add(new Client(1L, 100));
        clients.add(new Client(2L, 100));
        clients.add(new Client(3L, 100));
        Mockito.verify(rabbitTemplate).convertAndSend((String) ArgumentMatchers.eq(MessagingConfig.EXCHANGE),
                (String)ArgumentMatchers.eq(MessagingConfig.ROUTING_KEY),
                ArgumentMatchers.eq(clients));
*/
    }
}