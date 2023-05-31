package com.example.parkplatz.Service;

import com.example.parkplatz.Entity.Parker;
import com.example.parkplatz.Repositry.ParkerRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkerService {

    @Autowired
    private ParkerRepositry parkerRepositry;

    public List<Parker> FindSet() {
        return parkerRepositry.FindSet();
    }
}
