package com.onescorpin.discovery.schema;

/*-
 * #%L
 * onescorpin-schema-discovery-api
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
 * Provides additional information about the data type
 */
public interface DataTypeDescriptor {

    /**
     * Represents a date
     *
     * @return true/false indicating a date or not
     */
    Boolean isDate();

    /**
     * Represents a numeric type
     *
     * @return true/false indicating a numeric type or not
     */
    Boolean isNumeric();

    /**
     * Whether the data type represents a complex type such as binary, structure, or array
     *
     * @return true/false indicating a type is complex or not
     */
    Boolean isComplex();

}