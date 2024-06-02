package com.javatechie;

import com.javatechie.dto.AlertDTO;
import com.javatechie.service.SnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/sns")
public class AwsSnsApplication {

	@Autowired
	private SnsService snsService;

	@GetMapping("/subscribe")
	public String subscribeToTopic(@RequestParam String endpoint) {
		return snsService.subscribeToTopic(endpoint);
	}

	@PostMapping("/publish")
	public String publishMessage(@RequestBody AlertDTO alertDTO) {
		return snsService.publishMessage(alertDTO.getAlertMessage());
	}


	public static void main(String[] args) {
		SpringApplication.run(AwsSnsApplication.class, args);
	}

}
