package com.yedam.app.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserVO implements UserDetails {
	
	private String id;
	private String pwd;
	private String role;

	//private MemberVO member; //밑에 해결방법 사용 한 것
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//userDetails로 userVO정보를 받게 되면 json오류가 날 수 있음(getAuthorities 때문에 : json이 return타입인 collection을 커버하지 못함)
		//해결방법 : VO를 따로 만들고 필드로 집어 넣기
		List<GrantedAuthority> auth = new ArrayList<>();
		auth.add(new SimpleGrantedAuthority(this.role));
		return auth;
	}

	@Override
	public String getPassword() {
		return pwd;
	}

	@Override
	public String getUsername() {
		return id;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
