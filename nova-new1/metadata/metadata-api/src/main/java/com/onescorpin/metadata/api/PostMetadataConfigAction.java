/**
 *
 */
package com.onescorpin.metadata.api;

/*-
 * #%L
 * onescorpin-metadata-api
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

import org.springframework.core.annotation.Order;

/**
 * Defines an action that should be performed once the metadata system has started and been configured.
 * Any Spring bean implementing this interface will automatically be detected and invoked once configuration
 * has completed successfully.
 */
@Order(PostMetadataConfigAction.DEFAULT_ORDER)
public interface PostMetadataConfigAction extends Runnable {

    public static final int DEFAULT_ORDER = 0;
    public static final int EARLY_ORDER = DEFAULT_ORDER - 100;
    public static final int LATE_ORDER = DEFAULT_ORDER + 100;
}
