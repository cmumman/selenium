/*
Copyright 2007-2009 WebDriver committers
Copyright 2007-2009 Google Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package org.openqa.selenium.remote.server.handler;

import org.openqa.selenium.remote.server.JsonParametersAware;
import org.openqa.selenium.remote.server.Session;
import org.openqa.selenium.remote.server.rest.ResultType;

import java.util.Map;

public class ChangeUrl extends WebDriverHandler implements JsonParametersAware {

  private volatile String url;

  public ChangeUrl(Session session) {
    super(session);
  }

  public void setJsonParameters(Map<String, Object> allParameters) throws Exception {
    url = (String) allParameters.get("url");
  }

  public ResultType call() throws Exception {
    getDriver().get(url);

    return ResultType.SUCCESS;
  }

  @Override
  public String toString() {
    return "[get: " + url + "]";
  }
}
