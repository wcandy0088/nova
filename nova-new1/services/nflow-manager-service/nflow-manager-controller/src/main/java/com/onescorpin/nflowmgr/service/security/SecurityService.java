package com.onescorpin.nflowmgr.service.security;

/*-
 * #%L
 * nova-nflow-manager-controller
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

import com.onescorpin.security.rest.model.ActionGroup;
import com.onescorpin.security.rest.model.PermissionsChange;
import com.onescorpin.security.rest.model.PermissionsChange.ChangeType;
import com.onescorpin.security.rest.model.RoleMembership;
import com.onescorpin.security.rest.model.RoleMembershipChange;
import com.onescorpin.security.rest.model.RoleMemberships;

import java.security.Principal;
import java.util.Optional;
import java.util.Set;

/**
 *
 */
public interface SecurityService {

    Optional<ActionGroup> getAvailableNflowActions(String id);

    Optional<ActionGroup> getAllowedNflowActions(String id, Set<Principal> principals);

    Optional<ActionGroup> changeNflowPermissions(String id, PermissionsChange change);

    Optional<RoleMemberships> getNflowRoleMemberships(String id);

    Optional<RoleMembership> changeNflowRoleMemberships(String id, RoleMembershipChange change);

    Optional<ActionGroup> getAvailableCategoryActions(String id);

    Optional<ActionGroup> getAllowedCategoryActions(String id, Set<Principal> principals);

    Optional<ActionGroup> changeCategoryPermissions(String id, PermissionsChange change);

    Optional<RoleMemberships> getCategoryRoleMemberships(String id);

    Optional<RoleMembership> changeCategoryRoleMemberships(String id, RoleMembershipChange change);
    
    Optional<RoleMemberships> getCategoryNflowRoleMemberships(String id);
    
    Optional<RoleMembership> changeCategoryNflowRoleMemberships(String id, RoleMembershipChange change);

    Optional<ActionGroup> getAvailableTemplateActions(String id);

    Optional<ActionGroup> getAllowedTemplateActions(String id, Set<Principal> principals);

    Optional<ActionGroup> changeTemplatePermissions(String id, PermissionsChange change);

    Optional<RoleMemberships> getTemplateRoleMemberships(String id);

    Optional<RoleMembership> changeTemplateRoleMemberships(String id, RoleMembershipChange change);

    Optional<ActionGroup> getAvailableDatasourceActions(String id);

    Optional<ActionGroup> getAllowedDatasourceActions(String id, Set<Principal> principals);

    Optional<ActionGroup> changeDatasourcePermissions(String id, PermissionsChange change);

    Optional<RoleMemberships> getDatasourceRoleMemberships(String id);

    Optional<RoleMembership> changeDatasourceRoleMemberships(String id, RoleMembershipChange change);

    Optional<PermissionsChange> createNflowPermissionChange(String id, ChangeType changeType, Set<Principal> members);

    Optional<PermissionsChange> createCategoryPermissionChange(String id, ChangeType changeType, Set<Principal> members);

    Optional<PermissionsChange> createTemplatePermissionChange(String id, ChangeType changeType, Set<Principal> members);

    Optional<PermissionsChange> createDatasourcePermissionChange(String id, ChangeType changeType, Set<Principal> members);
}
