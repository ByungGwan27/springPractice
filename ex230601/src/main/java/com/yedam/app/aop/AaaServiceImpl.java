package com.yedam.app.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("aService")// 특정이 안되어서 지칭함
public class AaaServiceImpl implements AaaService {

	@Autowired
	AaaMapper aaaMapper;
	
	//같이 동작 할 수 있도록 해줌.root-context에서 tx 추가.
	//전부 정상이어야 commit 하나라도 정상적이지 않으면 rollback
	@Transactional
	@Override
	public void insert() {
		aaaMapper.insert("101");
		aaaMapper.insert("a101");
	}

}
