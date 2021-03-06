package com.onescorpin.ui;

/*-
 * #%L
 * nova-ui-app
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
 * Helper utility to create the constructor array injection for angular modules
 */
public class AngularParams {

    private static String defaultArgs = "$scope, $mdDialog, AccessControlService, HttpService,ServicesStatusData,OpsManagerNflowService";

    public static void main(String[] args) {
        String params = "";
        if (args == null || args.length == 0) {
            args = defaultArgs.split(",");
        }
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                if (params != "") {
                    params += ",";
                }
                params += "\"" + args[i].trim() + "\"";
            }
            System.out.println("["+params+",");
        }
    }
}
