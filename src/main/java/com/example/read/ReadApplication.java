package com.example.read;

import com.example.read.model.prevision;
import com.example.read.repository.PrevisionRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class ReadApplication{
    

	public static void main(String[] args) {
		SpringApplication.run(ReadApplication.class, args);
                
	}

  /*  @Override
    public void run(String... strings) throws Exception {
      
        prevision.save(new prevision("stb","lac1","cheque",new Date(01/02/2017),77,"rfet789","yhdetcb",new Date(01-02-2017),new Date(01/02/2017)));
    }*/
}
