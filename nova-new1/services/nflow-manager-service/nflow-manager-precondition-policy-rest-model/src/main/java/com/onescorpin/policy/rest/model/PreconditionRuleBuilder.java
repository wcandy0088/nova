package com.onescorpin.policy.rest.model;

/*-
 * #%L
 * onescorpin-nflow-manager-precondition-rest-model
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

/**
 * Help build a user interface precondition rule
 */
public class PreconditionRuleBuilder extends BasePolicyRuleBuilder<PreconditionRule, PreconditionRuleBuilder> {

    public PreconditionRuleBuilder(String name) {
        super(name);
    }


    public PreconditionRule build() {
        PreconditionRule rule = new PreconditionRule();
        rule.setName(this.name);
        rule.setDescription(this.description);
        rule.setShortDescription(this.shortDescription);
        rule.setDisplayName(this.displayName);
        rule.setProperties(this.properties);
        rule.setObjectClassType(this.objectClassType);
        rule.buildValueDisplayString();
        return rule;
    }

}
