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

package com.alibaba.cloudapp.filestore.aliyun.util;

import com.aliyun.oss.OSS;
import com.alibaba.cloudapp.exeption.CloudAppException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OSSUtilTest {
    
    @Mock
    private OSS oss;
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testCheckBucketExists() {
        // Setup
        when(oss.doesBucketExist(anyString())).thenReturn(true);
        
        // Run the test
        OSSUtil.checkBucketExists(oss, "bucketName");
        
        // Verify the results
    }
    
    @Test
    public void testCheckBucketExists_ThrowsCloudAppException() {
        // Setup
        // Run the test
        assertThatThrownBy(() -> OSSUtil.checkBucketExists(
                oss, "bucketName"
        ))
                .isInstanceOf(CloudAppException.class);
    }
    
}
