package com.example.parkplatz.Entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Parkingspot {

  private Integer id;
  private Boolean reserved;
  private String parkerId;
}
