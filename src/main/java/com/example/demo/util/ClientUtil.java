package com.example.demo.util;

import com.example.demo.model.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientUtil {

    private ClientUtil() { }

    public static List<Client> filterByBalance(List<Client> clientList, Integer balance) {
        return clientList.stream().filter(client -> client.getBalance() < balance)
                .collect(Collectors.toList());
    }

}
