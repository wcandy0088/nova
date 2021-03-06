package com.onescorpin.metadata.api.nflow;


/*-
 * #%L
 * onescorpin-operational-metadata-api
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

import com.onescorpin.metadata.api.jobrepo.ExecutionConstants;
import com.onescorpin.metadata.api.jobrepo.job.BatchJobExecution;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.UUID;


public interface NflowSummary {

    String getNflowIdAsString();

    UUID getNflowId();

    String getNflowName();

    OpsManagerNflow.NflowType getNflowType();

    boolean isStream();

    Long getJobExecutionId();

    Long getJobInstanceId();

    DateTime getStartTime();

    DateTime getEndTime();

    BatchJobExecution.JobStatus getStatus();

    ExecutionConstants.ExitCode getExitCode();

    String getExitMessage();

    RunStatus getRunStatus();

    /**
     * Return the number of batch job executions that have been run for this nflow
     *
     * @return the number of batch job executions that have been run for this nflow
     */
    Long getAllCount();

    /**
     * Return the number of batch job executions that have a status {@link BatchJobExecution#getStatus()} of Failed
     *
     * @return the number of batch job executions that have Failed
     */
    Long getFailedCount();

    /**
     * Return the number of batch job executions that are not Abandoned and have a status, {@link BatchJobExecution#getStatus()}, or exit code {@link BatchJobExecution#getExitCode()} of Completed
     * indicating the Job is complete and has not failed.
     *
     * @return the number of batch job executions that have Completed.
     */
    Long getCompletedCount();

    /**
     * Return the number of batch job executions that have a status {@link BatchJobExecution#getStatus()} of Abandoned
     *
     * @return the number of batch job executions that have Abandoned.
     */
    Long getAbandonedCount();

    /**
     * Return the number of batch job executions that are running
     *
     * @return the number of batch job executions that are running
     */
    Long getRunningCount();


    /**
     * The ID for the Nflow
     */
    interface ID extends Serializable {

    }

    enum RunStatus {
        RUNNING, FINISHED, INITIAL, UNKNOWN
    }
}
