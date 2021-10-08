package com.cg.rebapi.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.model.User;
import com.cg.rebapi.repository.UserRepository;
import com.cg.rebapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
			@Autowired
			UserRepository userRepository;

			@Override
			public User registerUser(User user) {
				return userRepository.save(user);
			}

			@Override
			public boolean isUserExist(String userName) {
				
				return userRepository.existsById(userName);
			}
			
			@Override
			public void deleteUser(String userName) {
				userRepository.deleteById(userName);		
			}

			@Override
			public boolean validateUser(User user) {
				if(userRepository.existsById(user.getUserName())) {
					User us = userRepository.findById(user.getUserName()).get();
					if(user.getPassword().equals(us.getPassword()) && user.getBroker().getId().equals(us.getBroker().getId())) {
						return true;
					}
				}
				return false;
			}
}


