/**
 *
 */
package com.onescorpin.metadata.jpa.nflow;

/*-
 * #%L
 * onescorpin-operational-metadata-jpa
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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AbandonNflowJobsStoredProcedureMock implements AutoCloseable {

    static class InvocationParameters {

        final String nflow, exitMessage, user;

        InvocationParameters(String nflow, String exitMessage, String user) {
            this.nflow = nflow;
            this.exitMessage = exitMessage;
            this.user = user;
        }
    }

    private static final List<InvocationParameters> REGISTERED_CALLS = Collections.synchronizedList(new LinkedList<>());

    @Override
    public void close() throws Exception {
        REGISTERED_CALLS.clear();
    }

    List<InvocationParameters> getInvocationParameters() {
        return Collections.unmodifiableList(REGISTERED_CALLS);
    }

    public static boolean call(String nflow, String exitMessage, String user) {
        // method has to be boolean, so that Hibernate can map the type

        REGISTERED_CALLS.add(new InvocationParameters(nflow, exitMessage, user));

        return false;
    }
}
