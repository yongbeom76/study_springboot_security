package com.study.study_springboot_security.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.study.study_springboot_security.configurations.PrincipalUser;
import com.study.study_springboot_security.daos.SharedDao;

@Service
public class PrincipalUserService implements UserDetailsService {

  @Autowired
  SharedDao sharedDao;

  @Override
  // url /login 일때 spring securty가 호출
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // query select
    String sqlMapId = "Memberwithauthority.selectByUID";
    Object usernameObj = username;
    Map<String, String> resultMap = (Map<String, String>) sharedDao.getOne(sqlMapId, usernameObj);

    // session 등록
    PrincipalUser principalUser = new PrincipalUser(resultMap);
    return principalUser;
  }
}
