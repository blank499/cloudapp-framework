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
package com.alibaba.cloudapp.api.oauth2.handler;

import com.alibaba.cloudapp.api.gateway.model.OAuthToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface LoginHandler {
    
    /**
     * handle when login success
     * @param request request
     * @param response response
     * @param token token info
     * @throws IOException write exception
     * @throws ServletException servlet exception
     */
    void loginSuccess(HttpServletRequest request,
                      HttpServletResponse response,
                      OAuthToken token) throws IOException, ServletException;
    
    /**
     * handle when login failure
     * @param request request
     * @param response response
     * @param e exception
     * @throws IOException write exception
     * @throws ServletException servlet exception
     */
    void loginFailure(HttpServletRequest request,
                      HttpServletResponse response,
                      Exception e) throws IOException, ServletException;
    
}
