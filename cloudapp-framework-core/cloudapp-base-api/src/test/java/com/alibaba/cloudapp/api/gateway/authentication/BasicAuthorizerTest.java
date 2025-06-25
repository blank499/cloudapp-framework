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

package com.alibaba.cloudapp.api.gateway.authentication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BasicAuthorizerTest {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Mock
    private HttpRequest request;
    @Mock
    private HttpHeaders headers;

    private BasicAuthorizer basicAuthorizer;

    @Before
    public void setUp() {
        basicAuthorizer = new BasicAuthorizer(USERNAME, PASSWORD);
        when(request.getHeaders()).thenReturn(headers);
    }

    @Test
    public void applyAuthorization_ShouldSetBasicAuthCredentials() {
        basicAuthorizer.applyAuthorization(request);

        verify(request).getHeaders();
        verify(request.getHeaders()).setBasicAuth(USERNAME, PASSWORD);
    }
}
