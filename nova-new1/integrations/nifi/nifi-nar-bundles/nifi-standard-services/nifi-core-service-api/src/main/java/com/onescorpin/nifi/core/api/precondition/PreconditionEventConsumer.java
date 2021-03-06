package com.onescorpin.nifi.core.api.precondition;

/*-
 * #%L
 * onescorpin-nifi-core-service-api
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
 * For adding listener's to precondition events
 */
public interface PreconditionEventConsumer {

    /**
     * Adds listener for acting on precondition events
     *
     * @param category The category of the nflow
     * @param nflowName The name of the nflow
     * @param listener The listener to be notified of precondition events
     */
    void addListener(String category, String nflowName, PreconditionListener listener);

    /**
     * Removes the listener on precondition events
     *
     * @param listener The listener to be removed
     */
    void removeListener(PreconditionListener listener);
}
