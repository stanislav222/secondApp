package com.example.demo.util;

import com.example.demo.model.Client;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientUtilTest {

    @Test
    void filterByBalance() {
        List<Client> clientList = List.of(
                new Client(1L, 100)
        );
        List<Client> flag = ClientUtil.filterByBalance(clientList, 200);

        Assert.assertEquals(clientList, flag);
    }
}