/**
 *
 */
package com.onescorpin.metadata.rest.model.nflow.transform;

/*-
 * #%L
 * onescorpin-metadata-rest-model
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

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class FieldsPolicy {

    List<FieldPolicy> fieldPolicies = new ArrayList<>();

    public List<FieldPolicy> getFieldPolicies() {
        return fieldPolicies;
    }

    public void setFieldPolicies(List<FieldPolicy> fieldPolicies) {
        this.fieldPolicies = fieldPolicies;
    }

    public void addPolicy(FieldPolicy policy) {
        this.fieldPolicies.add(policy);
    }
}