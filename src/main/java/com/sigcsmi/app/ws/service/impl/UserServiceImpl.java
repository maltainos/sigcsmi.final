package com.sigcsmi.app.ws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigcsmi.app.ws.io.controllers.UserRepository;
import com.sigcsmi.app.ws.io.models.AddressEntity;
import com.sigcsmi.app.ws.io.models.ContactEntity;
import com.sigcsmi.app.ws.io.models.UserEntity;
import com.sigcsmi.app.ws.service.UserService;
import com.sigcsmi.app.ws.shared.utils.Utils;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	public UserEntity createUser(UserEntity userDetails) {
		
		Utils utils = new Utils();
		
		userDetails.setUserId(utils.generationAddressId(35));
		
		for(int index = 0; index < userDetails.getAddresses().size(); index++) {
			AddressEntity address = userDetails.getAddresses().get(index);
			address.setAddressId(utils.generationAddressId(30));
			address.setUserDetails(userDetails);
			userDetails.getAddresses().set(index, address);
		}
		
		for(int index = 0; index < userDetails.getContacts().size(); index++) {
			ContactEntity contact = userDetails.getContacts().get(index);
			contact.setContactId(utils.generationContactsId(30));
			contact.setUserDetails(userDetails);
			userDetails.getContacts().set(index, contact);
		}
		
		return userRepository.save(userDetails);
	}

}
