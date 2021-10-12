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
			
			public List<User> getUsers(){
				return userRepository.findAll();
			}
			@Override
			public User registerUser(User user) {
				return userRepository.save(user);
			}

			@Override
			public boolean isUserExist(Long id) {
				
				return userRepository.existsById(id);
			}
			public User getUser(long id) {
				return userRepository.findById(id).get();
			}
			@Override
			public void deleteUser(Long id) {
				userRepository.deleteById(id);		
			}
			@Override
			public boolean validateUser(User user) {
				List<User> users=userRepository.findAll();
				for(User u: users) {
					if(u.getUserName().equals(user.getUserName())&& u.getPassword().equals(user.getPassword())) {
						return true;
					}
				}
				return false;
			}


}


