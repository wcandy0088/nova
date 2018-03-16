package com.onescorpin.metadata.jobrepo.nifi.provenance;

/*-
 * #%L
 * onescorpin-operational-metadata-integration-service
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

public class JmsProcessingException extends  RuntimeException {

    public JmsProcessingException() {
    }

    public JmsProcessingException(String message) {
        super(message);
    }

    public JmsProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

    public JmsProcessingException(Throwable cause) {
        super(cause);
    }

    public JmsProcessingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}