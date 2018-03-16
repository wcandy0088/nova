/**
 * 
 */
package com.onescorpin.metadata.jpa.nflow.security;

/*-
 * #%L
 * nova-operational-metadata-jpa
 * %%
 * Copyright (C) 2017 Onescorpin
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import static org.assertj.core.api.Assertions.assertThat;

import java.security.Principal;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.onescorpin.metadata.api.MetadataAccess;
import com.onescorpin.metadata.api.nflow.Nflow;
import com.onescorpin.metadata.api.nflow.security.NflowOpsAccessControlProvider;
import com.onescorpin.metadata.config.OperationalMetadataConfig;
import com.onescorpin.metadata.core.nflow.BaseNflow;
import com.onescorpin.metadata.jpa.TestJpaConfiguration;
import com.onescorpin.security.UsernamePrincipal;
import com.onescorpin.spring.CommonsSpringConfiguration;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:test-application.properties")
@SpringApplicationConfiguration(classes = {CommonsSpringConfiguration.class, OperationalMetadataConfig.class, NflowOpsAccessControlConfig.class, TestJpaConfiguration.class})
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class JpaNflowOpsAccessControlProviderTest {

    private static final Nflow.ID NFLOW_ID1 = new BaseNflow.NflowId();
    private static final Nflow.ID NFLOW_ID2 = new BaseNflow.NflowId();
    private static final UsernamePrincipal USER1 = new UsernamePrincipal("user1");
    private static final UsernamePrincipal USER2 = new UsernamePrincipal("user2");
    private static final UsernamePrincipal USER3 = new UsernamePrincipal("user3");
    
    @Inject
    private NflowOpsAccessControlProvider opsAccessProvider;
    
    @Inject
    private MetadataAccess metadata;
    
    @Test
    public void testGrantAccess()   {
        metadata.commit(() -> {
            this.opsAccessProvider.grantAccess(NFLOW_ID1, USER1);
            this.opsAccessProvider.grantAccess(NFLOW_ID2, USER1, USER2);
        }, MetadataAccess.SERVICE);
        
        Set<Principal> set1 = metadata.read(() -> {
            return this.opsAccessProvider.getPrincipals(NFLOW_ID1);
        }, MetadataAccess.SERVICE);
        
        assertThat(set1)
            .hasSize(1)
            .containsOnly(USER1);
        
        Set<Principal> set2 = metadata.read(() -> {
            return this.opsAccessProvider.getPrincipals(NFLOW_ID2);
        }, MetadataAccess.SERVICE);
        
        assertThat(set2)
            .hasSize(2)
            .containsOnly(USER1, USER2);
    }
    
    @Test
    public void testMultiGrantAccess()   {
        metadata.commit(() -> {
            this.opsAccessProvider.grantAccess(NFLOW_ID1, USER1, USER2);
            this.opsAccessProvider.grantAccess(NFLOW_ID1, USER1, USER2);
        }, MetadataAccess.SERVICE);
        
        metadata.commit(() -> {
            this.opsAccessProvider.grantAccessOnly(NFLOW_ID1, USER1, USER2, USER3);
        }, MetadataAccess.SERVICE);
        
        Set<Principal> set1 = metadata.read(() -> {
            return this.opsAccessProvider.getPrincipals(NFLOW_ID1);
        }, MetadataAccess.SERVICE);
        
        assertThat(set1)
            .hasSize(3)
            .containsOnly(USER1, USER2, USER3);
    }
    
    @Test
    public void testGrantAccessOnly()   {
        metadata.commit(() -> {
            this.opsAccessProvider.grantAccess(NFLOW_ID1, USER1, USER2);
        }, MetadataAccess.SERVICE);
        
        metadata.commit(() -> {
            this.opsAccessProvider.grantAccessOnly(NFLOW_ID1, USER3);
        }, MetadataAccess.SERVICE);
        
        Set<Principal> set1 = metadata.read(() -> {
            return this.opsAccessProvider.getPrincipals(NFLOW_ID1);
        }, MetadataAccess.SERVICE);
        
        assertThat(set1)
            .hasSize(1)
            .containsOnly(USER3);
    }
    
    @Test
    public void testGrantAccessAdditive()   {
        metadata.commit(() -> {
            this.opsAccessProvider.grantAccess(NFLOW_ID1, USER1, USER2);
        }, MetadataAccess.SERVICE);
        
        metadata.commit(() -> {
            this.opsAccessProvider.grantAccess(NFLOW_ID1, USER3);
        }, MetadataAccess.SERVICE);
        
        Set<Principal> set1 = metadata.read(() -> {
            return this.opsAccessProvider.getPrincipals(NFLOW_ID1);
        }, MetadataAccess.SERVICE);
        
        assertThat(set1)
            .hasSize(3)
            .containsOnly(USER1, USER2, USER3);
    }
    
    @Test
    public void testRevokeAccess()   {
        metadata.commit(() -> {
            this.opsAccessProvider.grantAccess(NFLOW_ID1, USER1, USER2, USER3);
        }, MetadataAccess.SERVICE);
        
        metadata.commit(() -> {
            this.opsAccessProvider.revokeAccess(NFLOW_ID1, USER2);
        }, MetadataAccess.SERVICE);
        
        Set<Principal> set1 = metadata.read(() -> {
            return this.opsAccessProvider.getPrincipals(NFLOW_ID1);
        }, MetadataAccess.SERVICE);
        
        assertThat(set1)
            .hasSize(2)
            .containsOnly(USER1, USER3);
    }
    
    @Test
    public void testRevokeAllNflowAccess()   {
        metadata.commit(() -> {
            this.opsAccessProvider.grantAccess(NFLOW_ID1, USER1, USER2, USER3);
            this.opsAccessProvider.grantAccess(NFLOW_ID2, USER1, USER2, USER3);
        }, MetadataAccess.SERVICE);
        
        metadata.commit(() -> {
            this.opsAccessProvider.revokeAllAccess(NFLOW_ID1);
        }, MetadataAccess.SERVICE);
        
        Set<Principal> set1 = metadata.read(() -> {
            return this.opsAccessProvider.getPrincipals(NFLOW_ID1);
        }, MetadataAccess.SERVICE);
        
        Set<Principal> set2 = metadata.read(() -> {
            return this.opsAccessProvider.getPrincipals(NFLOW_ID2);
        }, MetadataAccess.SERVICE);
        
        assertThat(set1).isEmpty();
        assertThat(set2)
            .hasSize(3)
            .containsOnly(USER1, USER2, USER3);
    }
    
    @Test
    public void testRevokeAllPrincipalAccess()   {
        metadata.commit(() -> {
            this.opsAccessProvider.grantAccess(NFLOW_ID1, USER1, USER2, USER3);
            this.opsAccessProvider.grantAccess(NFLOW_ID2, USER1, USER2, USER3);
        }, MetadataAccess.SERVICE);
        
        metadata.commit(() -> {
            this.opsAccessProvider.revokeAllAccess(USER1, USER3);
        }, MetadataAccess.SERVICE);
        
        Set<Principal> set1 = metadata.read(() -> {
            return this.opsAccessProvider.getPrincipals(NFLOW_ID1);
        }, MetadataAccess.SERVICE);
        
        Set<Principal> set2 = metadata.read(() -> {
            return this.opsAccessProvider.getPrincipals(NFLOW_ID2);
        }, MetadataAccess.SERVICE);
        
        assertThat(set1)
            .hasSize(1)
            .containsOnly(USER2);
        
        assertThat(set2)
            .hasSize(1)
            .containsOnly(USER2);
    }
}