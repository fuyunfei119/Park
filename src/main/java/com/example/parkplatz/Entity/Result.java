package com.example.parkplatz.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class Result {

    private Integer StatusCode;
    private String Message;
}
