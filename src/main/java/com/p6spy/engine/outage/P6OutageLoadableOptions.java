/**
 * P6Spy
 * <p>
 * Copyright (C) 2002 P6Spy
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.p6spy.engine.outage;

import com.p6spy.engine.spy.P6LoadableOptions;

public interface P6OutageLoadableOptions extends P6LoadableOptions, P6OutageOptionsMBean {

  long getOutageDetectionIntervalMS();

  void setOutageDetection(String outagedetection);

  void setOutageDetectionInterval(String outagedetectioninterval);
}
