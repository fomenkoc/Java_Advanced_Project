package com.gmail.fomenkoc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gmail.fomenkoc.dao.PeriodicalRepository;
import com.gmail.fomenkoc.dao.UserRepository;
import com.gmail.fomenkoc.domain.Bucket;
import com.gmail.fomenkoc.domain.Periodical;
import com.gmail.fomenkoc.domain.User;
import com.gmail.fomenkoc.domain.UserRole;
import com.gmail.fomenkoc.service.BucketService;
import com.gmail.fomenkoc.service.PeriodicalsService;
import com.gmail.fomenkoc.service.UserService;

@SpringBootTest
class PeriodicalsApplicationTests {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PeriodicalsService periodicalsService;
	
	@Autowired
	PeriodicalRepository periodicalRepository;
	
	@Autowired
	BucketService bucketService;
	
	@Test
	void createReadDeleteUser() {
		List<User> users = userRepository.findAll();
		Integer userCount = users.size();
		User testUser = getTestUser();
		userService.save(testUser);
		assertThat(userCount + 1).isEqualTo(userRepository.findAll().size());
		
		User userFromDB = userService.findByEmail(testUser.getEmail());
		assertThat(testUser.getEmail()).isEqualTo(userFromDB.getEmail());
		assertThat(testUser.getFirstName()).isEqualTo(userFromDB.getFirstName());
		assertThat(testUser.getLastName()).isEqualTo(userFromDB.getLastName());
		assertThat(testUser.getRole()).isEqualTo(userFromDB.getRole());
		
		userService.deleteUserByEmail(testUser.getEmail());
		assertThat(userCount).isEqualTo(userRepository.findAll().size());
	}
	
	@Test
	void createReadDeletePeriodical() {
		List<Periodical> periodicals = periodicalRepository.findAll();
		Integer periodicalCount = periodicals.size();
		Periodical periodical = getTestPeriodical();
		periodicalsService.save(periodical);
		periodicals = periodicalRepository.findAll();
		assertThat(periodicalCount + 1).isEqualTo(periodicals.size());
		periodical.setId(periodicals.get(periodicalCount).getId());
		Periodical periodicalFromDB = periodicalsService.findByName(periodical.getName());
		assertThat(periodical.getName()).isEqualTo(periodicalFromDB.getName());
		assertThat(periodical.getDescription()).isEqualTo(periodicalFromDB.getDescription());
		assertThat(periodical.getPrice()).isEqualTo(periodicalFromDB.getPrice());
		periodicalsService.deleteById(periodical.getId());
		periodicals = periodicalRepository.findAll();
		assertThat(periodicalCount).isEqualTo(periodicals.size());
	}
	
	@Test
	void createReadDeleteBucket() {
		User testUser = getTestUser();
		Periodical periodical = getTestPeriodical();
		userService.save(testUser);
		periodicalsService.save(periodical);
		testUser = userService.findByEmail(testUser.getEmail());
		periodical = periodicalsService.findByName(periodical.getName());
		List<Bucket> buckets = bucketService.getAll();
		Integer bucketCount = buckets.size();
		Bucket bucket  = getTestBucket();
		bucket.setPeriodical(periodical);
		bucket.setUser(testUser);
		bucketService.add(bucket);
		buckets = bucketService.getAll();
		assertThat(bucketCount + 1).isEqualTo(buckets.size());
		bucket.setId(buckets.get(bucketCount).getId());
		Bucket bucketFromDB = buckets.get(bucketCount);
		assertThat(bucket.getUser()).isEqualTo(bucketFromDB.getUser());
		assertThat(bucket.getPeriodical()).isEqualTo(bucketFromDB.getPeriodical());
		assertThat(bucket.getPurchaseDate()).isEqualTo(bucketFromDB.getPurchaseDate());
		bucketService.delete(bucketFromDB);
		buckets = bucketService.getAll();
		assertThat(bucketCount).isEqualTo(buckets.size());
		periodicalsService.deleteById(periodical.getId());
		userService.deleteUserByEmail(testUser.getEmail());
	}
	
	User getTestUser() {
		User user = new User();
		user.setEmail("test@email.com");
		user.setFirstName("FirstName");
		user.setLastName("LastName");
		user.setPassword("123");
		user.setRole(UserRole.ROLE_USER);
		return user;
	}
	
	Periodical getTestPeriodical() {
		Periodical periodical = new Periodical();
		periodical.setName("PeriodicalName");
		periodical.setDescription("PeriodicalDescription");
		periodical.setPrice(123.45);
		return periodical;
	}

	Bucket getTestBucket() {
		Bucket bucket = new Bucket();
		bucket.setPurchaseDate(new Date());
		return bucket;
	}
}
