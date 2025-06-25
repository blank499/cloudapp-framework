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

package com.alibaba.cloudapp.sequence.demo;

import com.alibaba.cloudapp.api.sequence.SequenceGenerator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudappSequenceSnowflakeDemoApplication implements InitializingBean {

    @Autowired
    private SequenceGenerator sequenceGenerator;

    public static void main(String[] args) {
        SpringApplication.run(CloudappSequenceSnowflakeDemoApplication.class, args);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("Generated sequence id: " + sequenceGenerator.nextId());

        long start = System.currentTimeMillis();
        for (int i = 0 ; i < 1000; i++) {
            System.out.println("Loop generating sequence id: " + sequenceGenerator.nextId());
        }

        System.out.println("Time spent in milliseconds: " + (
                System.currentTimeMillis() - start
        ));

    }
}
