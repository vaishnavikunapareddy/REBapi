package com.cg.rebapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.model.User;
import com.cg.rebapi.repository.UserRepository;
import com.cg.rebapi.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	@Override
	public boolean validate(User user) {
		   if(userRepository.existsById(user.getId())){
			  User u = userRepository.findById(user.getId()).get();
			   if(user.getPassword().equals(u.getPassword())) {
				   return true;
			   }
		   }
		   return false;
	   }
	   
		@Override
	   public List<User> getAllUsers() {
		  return userRepository.findAll();
	   }
		
//	
//		/* Put address Id to session variable Sprint -2 */  
//		@Override
//		public LoginBean signIn(LoginBean login) throws UserException{
//			List<LoginBean> logList = loginDao.getUserByUname(login.getUsername());
//			if(logList.size()>0) {
//				log = logList.get(0);
//			}else {
//				throw new UserException("User "+login.getUsername()+" not found..Check credentials");
//			}
//			if(log!=null && (login.getPassword().equals(log.getPassword()))){
//				sn.setAttribute("uid", log.getUserid());
//				sn.setAttribute("uname", log.getUsername());
//				if(customerDao.existsById(log.getUserid())) {
//					sn.setAttribute("utype", "customer");
//					return log;
//				}
//				else {
//					sn.setAttribute("utype", "restaurant");
//					return log;
//				}	
//			}
//
//			throw new UserException("User "+login.getUsername()+" not found..Check credentials");
//		}
//
//		@Override
//		public LoginBean signOut() throws UserException {
//			String uid = (String)sn.getAttribute("uid");
//			if(uid !=null) {
//				log = isUser(uid);
//				log = loginDao.findById(log.getUserid()).get();
//				sn.invalidate();
//				return log;
//			}
//			throw new UserException("User not logged in");
//		}
//		
//		public LoginBean isUser(String userId) {
//			if(loginDao.existsById(userId)) {
//				log = loginDao.findById(userId).get();
//				if(log!=null) {
//					return log;
//				}
//			}
//			return null;
//		}
//	}

}
