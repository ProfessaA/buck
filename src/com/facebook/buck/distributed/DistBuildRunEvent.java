/*
 * Copyright 2017-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.facebook.buck.distributed;

import com.facebook.buck.distributed.thrift.BuildSlaveRunId;
import com.facebook.buck.distributed.thrift.StampedeId;
import com.facebook.buck.event.AbstractBuckEvent;
import com.facebook.buck.event.EventKey;

/** Captures information about a distributed build run. */
public class DistBuildRunEvent extends AbstractBuckEvent {
  private final StampedeId stampedeId;
  private final BuildSlaveRunId buildSlaveRunId;

  public DistBuildRunEvent(StampedeId stampedeId, BuildSlaveRunId buildSlaveRunId) {
    super(EventKey.unique());
    this.stampedeId = stampedeId;
    this.buildSlaveRunId = buildSlaveRunId;
  }

  @Override
  protected String getValueString() {
    return getEventName();
  }

  @Override
  public String getEventName() {
    return this.getClass().getName();
  }

  public StampedeId getStampedeId() {
    return stampedeId;
  }

  public BuildSlaveRunId getBuildSlaveRunId() {
    return buildSlaveRunId;
  }
}
