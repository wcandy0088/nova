package com.onescorpin.metadata.datasource;

/*-
 * #%L
 * Nova Metadata Service API
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
 * A data source created and managed by a Nova user.
 */
public interface UserDatasource extends Datasource {

    /**
     * Gets the type name of this data source.
     *
     * @return the type name
     */
    String getType();

    /**
     * Sets the type name of this data source.
     *
     * @param type the type name
     */
    void setType(String type);
}
