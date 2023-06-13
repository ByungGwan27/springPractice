package com.yedam.app.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.yedam.app.user.mapper.UserMapper;

//@Service("userDetailService")
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserVO userVO = userMapper.getUser(username);
		
		// 해당 사용자 존재유무 확인
		if(userVO == null) {
			throw new UsernameNotFoundException("no user");
		}
		
		// 비밀번호 확인
		
		// 권환 지정.
		//별도 처리 이유 : 
//		List<GrantAuthority> auth = new ArrayList<>();
//		auth.add(new SimpleGrantedAuthority(userVO.getRole()));
		
		return userVO/*new UserVO(username, userVO.getPassword(), auth)*/;
	}

}
