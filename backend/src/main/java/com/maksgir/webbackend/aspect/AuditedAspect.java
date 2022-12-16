package com.maksgir.webbackend.aspect;

import com.maksgir.webbackend.entity.AuditedMethod;
import com.maksgir.webbackend.model.SimpleUser;
import com.maksgir.webbackend.repository.AuditedMethodRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AuditedAspect {

    @Autowired
    private AuditedMethodRepository repository;

    @Before("@annotation(Audited)")
    private void auditedLog(JoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username;
        try {
            SimpleUser user = (SimpleUser) auth.getPrincipal();
            username = user.getUsername();
        } catch (ClassCastException e) {
            username = "anon";
        }

        AuditedMethod auditedMethod = new AuditedMethod(methodName, LocalDateTime.now(), username);

        repository.save(auditedMethod);

    }
}
