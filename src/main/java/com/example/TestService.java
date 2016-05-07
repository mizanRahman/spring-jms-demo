package com.example;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mac on 5/7/16.
 */
@Service
public class TestService {

    @Transactional
    public void printReport(Card card) {
        System.out.println("===============");
        System.out.println("Report ");
        System.out.println("===============");
        System.out.println(card);
        System.out.println("======End=========");

    }
}
