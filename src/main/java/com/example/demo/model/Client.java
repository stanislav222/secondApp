package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Client {
    @Id
    public Long clientId;
    @Field
    public Integer balance;
}
