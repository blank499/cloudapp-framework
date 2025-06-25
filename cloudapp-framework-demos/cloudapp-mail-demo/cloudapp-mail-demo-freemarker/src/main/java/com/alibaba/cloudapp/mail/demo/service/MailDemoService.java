/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.alibaba.cloudapp.mail.demo.service;

import com.alibaba.cloudapp.api.email.TemplateEmailService;
import com.alibaba.cloudapp.exeption.CloudAppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailDemoService {
    
    private static final Logger logger =
            LoggerFactory.getLogger(MailDemoService.class);
    
    private static final String TEMPLATE_NAME = "test.ftl";
    
    @Autowired
    private TemplateEmailService templateEmailService;
    
    // get config from application.yml
    @Value("${com.alibaba.cloudapp.mail.username}")
    private String from;
    
    private JavaMailSender mailSender;
    
    /**
     * send email by template
     *
     * @param to      receiver
     * @param subject subject
     */
    public void sendMail(String to, String subject) {
        try {
            //template params
            Map<String, Object> params = new HashMap<>();
            params.put("name", to);
            params.put("showData", Collections.singletonMap("data", "test " +
                    "data"));
            
            templateEmailService.sendEmail(TEMPLATE_NAME, subject, from,
                                           Collections.singletonList(to), params
            );
        } catch (CloudAppException e) {
            logger.error("send mail fail:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
}
