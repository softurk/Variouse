package com.project.e_commerce.services;

import com.project.e_commerce.model.User;

public interface UserService {

	//Email e Göre Kullanıcı Getir
	public User findOneByEmail(String email);
	
	//Kullanıcı Kaydet
	public void save(User user);
	
	//UserId ye Göre Kullanıcı Getir
	User findOne(Integer id);

}
