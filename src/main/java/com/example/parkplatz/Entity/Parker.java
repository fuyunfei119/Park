package com.example.parkplatz.Entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;


@Data
@Accessors(chain = true)
public class Parker {

  private String id;
  private String licensePlate;
  private Timestamp entryDate;
  private Timestamp exitDate;
  private Boolean seasonParker;
  private Double parkingFee;

}
