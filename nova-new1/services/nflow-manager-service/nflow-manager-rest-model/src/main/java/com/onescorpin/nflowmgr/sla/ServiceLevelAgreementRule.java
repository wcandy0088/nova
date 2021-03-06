package com.onescorpin.nflowmgr.sla;

/*-
 * #%L
 * onescorpin-nflow-manager-controller
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.onescorpin.metadata.sla.api.ObligationGroup;
import com.onescorpin.policy.rest.model.BaseUiPolicyRule;

/**
 * A User Interface object containing information about various Service Level Agreement Metrics that can be used to create a SLA
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceLevelAgreementRule extends BaseUiPolicyRule {

    private ObligationGroup.Condition condition = ObligationGroup.Condition.REQUIRED;

    public ObligationGroup.Condition getCondition() {
        return condition;
    }

    public void setCondition(ObligationGroup.Condition condition) {
        this.condition = condition;
    }
}
