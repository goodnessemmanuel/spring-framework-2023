package com.ocheejeh.learnspringframework02.dependencyinjection.example_a1;

import com.ocheejeh.learnspringframework02.dependencyinjection.example_a1.db.DataService;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {
    private final DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
