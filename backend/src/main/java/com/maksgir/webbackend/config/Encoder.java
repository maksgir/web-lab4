package com.maksgir.webbackend.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Encoder extends BCryptPasswordEncoder {
}
