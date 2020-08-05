/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage.spi.v1;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import java.util.HashMap;
import java.util.Map;

class TestRequest extends LowLevelHttpRequest {
  private final LowLevelHttpResponse response;
  private final Map<String, String> addedHeaders = new HashMap<>();

  TestRequest(LowLevelHttpResponse response) {
    this.response = response;
  }

  @Override
  public void addHeader(String name, String value) {
    addedHeaders.put(name, value);
  }

  @Override
  public LowLevelHttpResponse execute() {
    return response;
  }
}
