package com.onescorpin.metadata.sla.alerts;

/*-
 * #%L
 * onescorpin-sla-core
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

import com.onescorpin.metadata.sla.api.ServiceLevelAgreementAction;
import com.onescorpin.metadata.sla.api.ServiceLevelAgreementActionConfiguration;

import java.util.List;

/**
 */
public class BaseServiceLevelAgreementActionConfiguration implements ServiceLevelAgreementActionConfiguration {

    private List<Class<? extends ServiceLevelAgreementAction>> actionClasses;

    public List<Class<? extends ServiceLevelAgreementAction>> getActionClasses() {
        return actionClasses;
    }

    public void setActionClasses(List<Class<? extends ServiceLevelAgreementAction>> actionClasses) {
        this.actionClasses = actionClasses;
    }

}
