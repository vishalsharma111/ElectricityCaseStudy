package com.vishal.electricity;

import com.vishal.electricity.constants.ConsumerType;
import com.vishal.electricity.entity.Category;
import com.vishal.electricity.entity.Consumer;
import com.vishal.electricity.entity.ConsumerConsumption;
import com.vishal.electricity.repository.CategoryRepository;
import com.vishal.electricity.repository.ConsumerConsumptionRepository;
import com.vishal.electricity.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ElectricityApplication implements CommandLineRunner {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ConsumerService consumerService;

	@Autowired
	ConsumerConsumptionRepository consumerConsumptionRepository;

	public static void main(String[] args) {
		SpringApplication.run(ElectricityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Category> categories = List.of(new Category(1, ConsumerType.INDUSTRY, 10, 0), new Category(2, ConsumerType.RETAIL, 8, 0), new Category(3, ConsumerType.HOME, 6, 0), new Category(4, ConsumerType.HOME_LOW, 5, 100));
		categoryRepository.saveAll(categories);

		Consumer homeConsumer = consumerService.saveConsumer(new Consumer(1, "name", "email", categories.get(3)));
		Consumer industryConsumer = consumerService.saveConsumer(new Consumer(2, "name2", "email2", categories.get(0)));

		List<ConsumerConsumption> consumerConsumptions = List.of(new ConsumerConsumption(1, System.currentTimeMillis(), 50, homeConsumer), new ConsumerConsumption(2, System.currentTimeMillis(), 50, homeConsumer), new ConsumerConsumption(3, System.currentTimeMillis(), 200, homeConsumer), new ConsumerConsumption(4, System.currentTimeMillis(), 100, homeConsumer));
		consumerConsumptionRepository.saveAll(consumerConsumptions);

		consumerConsumptionRepository.save(new ConsumerConsumption(5, (System.currentTimeMillis()), 100, industryConsumer));
	}
}
