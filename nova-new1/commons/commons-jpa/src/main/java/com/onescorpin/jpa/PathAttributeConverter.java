/**
 *
 */
package com.onescorpin.jpa;

/*-
 * #%L
 * onescorpin-commons-jpa
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

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.persistence.AttributeConverter;

/**
 * Converts Path objects to String columns.
 */
public class PathAttributeConverter implements AttributeConverter<Path, String> {

    @Override
    public String convertToDatabaseColumn(Path path) {
        return path.toAbsolutePath().toString();
    }

    @Override
    public Path convertToEntityAttribute(String dbData) {
        return Paths.get(dbData);
    }


}
