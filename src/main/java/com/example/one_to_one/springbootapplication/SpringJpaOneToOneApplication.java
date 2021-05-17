package com.example.one_to_one.springbootapplication;

import com.example.one_to_one.entity.Husband;
import com.example.one_to_one.entity.Wife;
import com.example.one_to_one.repository.HusbandRepository;
import com.example.one_to_one.repository.WifeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringJpaOneToOneApplication implements CommandLineRunner {

    @Autowired
    WifeRepository wifeRepository;

    @Autowired
    HusbandRepository husbandRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaOneToOneApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        deleteData();
        saveData();
        showData();
    }

    @Transactional
    private void deleteData() {
        wifeRepository.deleteAll();
        husbandRepository.deleteAll();
    }

    @Transactional
    private void saveData() {
        Wife lisa = new Wife("Lisa", new Husband("David"));
        Wife mary = new Wife("Mary", new Husband("Raul"));
        wifeRepository.save(Arrays.asList(lisa, mary));

    }

    @Transactional
    private void showData() {
        List wifes = wifeRepository.findAll();
        List husbands = husbandRepository.findAll();
        System.out.println("==================Wifes==================");
        wifes.forEach(System.out::println);

        System.out.println("==============Husbands====================");
        husbands.forEach(System.out::println);
    }

}
