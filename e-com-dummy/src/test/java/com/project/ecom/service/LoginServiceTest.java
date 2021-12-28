package com.project.ecom.service;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.ecom.pojo.User;
import com.project.ecom.repository.LoginMongoRepository;

@ExtendWith(MockitoExtension.class)
class LoginServiceTest {

	@Mock
	LoginMongoRepository mockLoginRepository;

	@InjectMocks
	LoginService mockService;

	@Test
	void testInsertUser() {
		//assertNotNull(mockLoginRepository);

		Optional<User> user = Optional
				.ofNullable(new User("Raghav121", "Raghav121", "9999999999", "raghav121@gmail.com"));

		when(mockLoginRepository.findById(user.get().getEmail())).thenReturn(Optional.ofNullable(null));
		when(mockLoginRepository.save(user.get())).thenReturn(user.get());

		boolean returnedValue = mockService.insertUser(user.get());
		assertThat(returnedValue).isEqualTo(true);
	}

	@Test
	void testUpdateUser() {
		//assertNotNull(mockLoginRepository);

		Optional<User> user = Optional
				.ofNullable(new User("Raghav121", "Raghav121", "9999999999", "raghav121@gmail.com"));

		when(mockLoginRepository.findById(user.get().getEmail())).thenReturn(user);
		when(mockLoginRepository.save(user.get())).thenReturn(user.get());

		boolean returnedValue = mockService.updateUser(user.get());
		assertThat(returnedValue).isEqualTo(true);
	}

	@Test
	void testFindByUserId() {
		//assertNotNull(mockLoginRepository);

		Optional<User> user = Optional
				.ofNullable(new User("Raghav121", "Raghav121", "9999999999", "raghav121@gmail.com"));

		when(mockLoginRepository.findById(user.get().getEmail())).thenReturn(user);

		User userReturned = mockService.findByUserId(user.get().getEmail());
		assertThat(user.get()).isEqualTo(userReturned);
	}

	@Test
	void testRemoveUser() {
		//assertNotNull(mockLoginRepository);

		Optional<User> user = Optional
				.ofNullable(new User("Raghav121", "Raghav121", "9999999999", "raghav121@gmail.com"));

		when(mockLoginRepository.findById(user.get().getEmail())).thenReturn(Optional.ofNullable(null));

		boolean returnedValue = mockService.removeUser(user.get().getEmail());
		assertThat(returnedValue).isEqualTo(true);
	}

}
