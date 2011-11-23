/*
Copyright 2007-2011 WebDriver committers
Copyright 2007-2011 Google Inc.

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

package org.openqa.selenium.remote.server;

import com.google.common.base.Throwables;

import org.openqa.selenium.remote.server.handler.AcceptAlert;
import org.openqa.selenium.remote.server.handler.AddConfig;
import org.openqa.selenium.remote.server.handler.AddCookie;
import org.openqa.selenium.remote.server.handler.CaptureScreenshot;
import org.openqa.selenium.remote.server.handler.ChangeUrl;
import org.openqa.selenium.remote.server.handler.ClearElement;
import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.remote.server.handler.CloseWindow;
import org.openqa.selenium.remote.server.handler.DeleteCookie;
import org.openqa.selenium.remote.server.handler.DeleteNamedCookie;
import org.openqa.selenium.remote.server.handler.DeleteSession;
import org.openqa.selenium.remote.server.handler.DescribeElement;
import org.openqa.selenium.remote.server.handler.DismissAlert;
import org.openqa.selenium.remote.server.handler.ElementEquality;
import org.openqa.selenium.remote.server.handler.ExecuteAsyncScript;
import org.openqa.selenium.remote.server.handler.ExecuteScript;
import org.openqa.selenium.remote.server.handler.FindActiveElement;
import org.openqa.selenium.remote.server.handler.FindChildElement;
import org.openqa.selenium.remote.server.handler.FindChildElements;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.remote.server.handler.GetAlertText;
import org.openqa.selenium.remote.server.handler.GetAllCookies;
import org.openqa.selenium.remote.server.handler.GetAllSessions;
import org.openqa.selenium.remote.server.handler.GetAllWindowHandles;
import org.openqa.selenium.remote.server.handler.GetCssProperty;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.openqa.selenium.remote.server.handler.GetCurrentWindowHandle;
import org.openqa.selenium.remote.server.handler.GetElementAttribute;
import org.openqa.selenium.remote.server.handler.GetElementDisplayed;
import org.openqa.selenium.remote.server.handler.GetElementEnabled;
import org.openqa.selenium.remote.server.handler.GetElementLocation;
import org.openqa.selenium.remote.server.handler.GetElementLocationInView;
import org.openqa.selenium.remote.server.handler.GetElementSelected;
import org.openqa.selenium.remote.server.handler.GetElementSize;
import org.openqa.selenium.remote.server.handler.GetElementText;
import org.openqa.selenium.remote.server.handler.GetElementValue;
import org.openqa.selenium.remote.server.handler.GetPageSource;
import org.openqa.selenium.remote.server.handler.GetScreenOrientation;
import org.openqa.selenium.remote.server.handler.GetSessionCapabilities;
import org.openqa.selenium.remote.server.handler.GetTagName;
import org.openqa.selenium.remote.server.handler.GetTitle;
import org.openqa.selenium.remote.server.handler.GetWindowPosition;
import org.openqa.selenium.remote.server.handler.GetWindowSize;
import org.openqa.selenium.remote.server.handler.GoBack;
import org.openqa.selenium.remote.server.handler.GoForward;
import org.openqa.selenium.remote.server.handler.ImeActivateEngine;
import org.openqa.selenium.remote.server.handler.ImeDeactivate;
import org.openqa.selenium.remote.server.handler.ImeGetActiveEngine;
import org.openqa.selenium.remote.server.handler.ImeGetAvailableEngines;
import org.openqa.selenium.remote.server.handler.ImeIsActivated;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.remote.server.handler.NewSession;
import org.openqa.selenium.remote.server.handler.RefreshPage;
import org.openqa.selenium.remote.server.handler.Rotate;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.remote.server.handler.SetAlertText;
import org.openqa.selenium.remote.server.handler.SetScriptTimeout;
import org.openqa.selenium.remote.server.handler.SetWindowPosition;
import org.openqa.selenium.remote.server.handler.SetWindowSize;
import org.openqa.selenium.remote.server.handler.Status;
import org.openqa.selenium.remote.server.handler.SubmitElement;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
import org.openqa.selenium.remote.server.handler.UploadFile;
import org.openqa.selenium.remote.server.handler.html5.ClearAppCache;
import org.openqa.selenium.remote.server.handler.html5.ClearLocalStorage;
import org.openqa.selenium.remote.server.handler.html5.ClearSessionStorage;
import org.openqa.selenium.remote.server.handler.html5.ExecuteSQL;
import org.openqa.selenium.remote.server.handler.html5.GetAppCache;
import org.openqa.selenium.remote.server.handler.html5.GetAppCacheStatus;
import org.openqa.selenium.remote.server.handler.html5.GetLocalStorageItem;
import org.openqa.selenium.remote.server.handler.html5.GetLocalStorageKeys;
import org.openqa.selenium.remote.server.handler.html5.GetLocalStorageSize;
import org.openqa.selenium.remote.server.handler.html5.GetLocationContext;
import org.openqa.selenium.remote.server.handler.html5.GetSessionStorageItem;
import org.openqa.selenium.remote.server.handler.html5.GetSessionStorageKeys;
import org.openqa.selenium.remote.server.handler.html5.GetSessionStorageSize;
import org.openqa.selenium.remote.server.handler.html5.IsBrowserOnline;
import org.openqa.selenium.remote.server.handler.html5.RemoveLocalStorageItem;
import org.openqa.selenium.remote.server.handler.html5.RemoveSessionStorageItem;
import org.openqa.selenium.remote.server.handler.html5.SetBrowserConnection;
import org.openqa.selenium.remote.server.handler.html5.SetLocalStorageItem;
import org.openqa.selenium.remote.server.handler.html5.SetLocationContext;
import org.openqa.selenium.remote.server.handler.html5.SetSessionStorageItem;
import org.openqa.selenium.remote.server.handler.interactions.ClickInSession;
import org.openqa.selenium.remote.server.handler.interactions.DoubleClickInSession;
import org.openqa.selenium.remote.server.handler.interactions.MouseDown;
import org.openqa.selenium.remote.server.handler.interactions.MouseMoveToLocation;
import org.openqa.selenium.remote.server.handler.interactions.MouseUp;
import org.openqa.selenium.remote.server.handler.interactions.SendKeyToActiveElement;
import org.openqa.selenium.remote.server.handler.interactions.touch.DoubleTapOnElement;
import org.openqa.selenium.remote.server.handler.interactions.touch.Down;
import org.openqa.selenium.remote.server.handler.interactions.touch.Flick;
import org.openqa.selenium.remote.server.handler.interactions.touch.LongPressOnElement;
import org.openqa.selenium.remote.server.handler.interactions.touch.Move;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.openqa.selenium.remote.server.handler.interactions.touch.SingleTapOnElement;
import org.openqa.selenium.remote.server.handler.interactions.touch.Up;
import org.openqa.selenium.remote.server.renderer.ResourceCopyResult;
import org.openqa.selenium.remote.server.renderer.EmptyResult;
import org.openqa.selenium.remote.server.renderer.ForwardResult;
import org.openqa.selenium.remote.server.renderer.JsonErrorExceptionResult;
import org.openqa.selenium.remote.server.renderer.JsonResult;
import org.openqa.selenium.remote.server.renderer.JsonpResult;
import org.openqa.selenium.remote.server.renderer.RedirectResult;
import org.openqa.selenium.remote.server.resource.StaticResource;
import org.openqa.selenium.remote.server.rest.Handler;
import org.openqa.selenium.remote.server.rest.Result;
import org.openqa.selenium.remote.server.rest.ResultConfig;
import org.openqa.selenium.remote.server.rest.ResultType;
import org.openqa.selenium.remote.server.rest.UrlMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.EnumSet;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.google.common.base.Preconditions.checkNotNull;

public class DriverServlet extends HttpServlet {
  public static final String SESSIONS_KEY = DriverServlet.class.getName() + ".sessions";

  private static final String JSONP_PATH = "/jsonp";

  private static final String CALLBACK = ":callback";
  private static final String EXCEPTION = ":exception";
  private static final String RESPONSE = ":response";

  private UrlMapper getMapper;
  private UrlMapper postMapper;
  private UrlMapper deleteMapper;
  private SessionCleaner sessionCleaner;

  @Override
  public void init() throws ServletException {
    super.init();

    Object attribute = getServletContext().getAttribute(SESSIONS_KEY);
    if (attribute == null) {
      attribute = new DefaultDriverSessions();
    }

    DriverSessions driverSessions = (DriverSessions) attribute;

    Logger logger = getLogger();

    setupMappings(driverSessions, logger);

    int sessionTimeOut = Integer.parseInt(System.getProperty("webdriver.server.session.timeout", "1800"));
    if (sessionTimeOut > 0) {
      sessionCleaner = new SessionCleaner(driverSessions, logger, 1000 * sessionTimeOut);
      sessionCleaner.start();
    }
  }

  @Override
  public void destroy() {
    if (sessionCleaner != null) {
      sessionCleaner.stopCleaner();
    }
  }

  protected Logger getLogger() {
    return Logger.getLogger(getClass().getName());
  }

  private void addGlobalHandler(ResultType type, Result result) {
    getMapper.addGlobalHandler(type, result);
    postMapper.addGlobalHandler(type, result);
    deleteMapper.addGlobalHandler(type, result);
  }

  private void setupMappings(DriverSessions driverSessions, Logger logger) {
    final EmptyResult emptyResponse = new EmptyResult();
    final JsonResult jsonResponse = new JsonResult(RESPONSE);

    getMapper = new UrlMapper(driverSessions, logger);
    postMapper = new UrlMapper(driverSessions, logger);
    deleteMapper = new UrlMapper(driverSessions, logger);

    Result jsonErrorResult = new Result(MimeType.EMPTY,
        new JsonErrorExceptionResult(EXCEPTION, RESPONSE));
    addGlobalHandler(ResultType.EXCEPTION, jsonErrorResult);
    addGlobalHandler(ResultType.ERROR, jsonErrorResult);

    Result jsonpResult = new Result(MimeType.JSONP,
        new JsonpResult(RESPONSE, EXCEPTION, CALLBACK), true);
    for (ResultType resultType : EnumSet.allOf(ResultType.class)) {
      addGlobalHandler(resultType, jsonpResult);
    }

    // When requesting the command root from a JSON-client, just return the server
    // status. For everyone else, redirect to the web front end.
    getMapper.bind("/", Status.class)
        .on(ResultType.SUCCESS, new RedirectResult("/static/resource/hub.html"))
        .on(ResultType.SUCCESS, jsonResponse, "application/json");

    getMapper.bind("/static/resource/:file", StaticResource.class)
        .on(ResultType.SUCCESS, new ResourceCopyResult(RESPONSE))
        // Nope, JSON clients don't get access to static resources.
        .on(ResultType.SUCCESS, emptyResponse, "application/json");

    postMapper.bind("/config/drivers", AddConfig.class)
        .on(ResultType.SUCCESS, emptyResponse);

    getMapper.bind("/status", Status.class)
        .on(ResultType.SUCCESS, jsonResponse);

    getMapper.bind("/sessions", GetAllSessions.class)
        .on(ResultType.SUCCESS, jsonResponse);

    postMapper.bind("/session", NewSession.class)
        .on(ResultType.SUCCESS, new RedirectResult("/session/:sessionId"));
    getMapper.bind("/session/:sessionId", GetSessionCapabilities.class)
        .on(ResultType.SUCCESS, new ForwardResult("/WEB-INF/views/sessionCapabilities.jsp"))
        .on(ResultType.SUCCESS, jsonResponse, "application/json");

    deleteMapper.bind("/session/:sessionId", DeleteSession.class)
        .on(ResultType.SUCCESS, emptyResponse);

    getMapper.bind("/session/:sessionId/window_handle", GetCurrentWindowHandle.class)
        .on(ResultType.SUCCESS, jsonResponse);
    getMapper.bind("/session/:sessionId/window_handles", GetAllWindowHandles.class)
        .on(ResultType.SUCCESS, jsonResponse);

    postMapper.bind("/session/:sessionId/dismiss_alert", DismissAlert.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/accept_alert", AcceptAlert.class)
        .on(ResultType.SUCCESS, emptyResponse);
    getMapper.bind("/session/:sessionId/alert_text", GetAlertText.class)
        .on(ResultType.SUCCESS, jsonResponse);
    postMapper.bind("/session/:sessionId/alert_text", SetAlertText.class)
        .on(ResultType.SUCCESS, emptyResponse);

    postMapper.bind("/session/:sessionId/url", ChangeUrl.class)
        .on(ResultType.SUCCESS, emptyResponse);
    getMapper.bind("/session/:sessionId/url", GetCurrentUrl.class)
        .on(ResultType.SUCCESS, jsonResponse);

    postMapper.bind("/session/:sessionId/forward", GoForward.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/back", GoBack.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/refresh", RefreshPage.class)
        .on(ResultType.SUCCESS, emptyResponse);

    postMapper.bind("/session/:sessionId/execute", ExecuteScript.class)
        .on(ResultType.SUCCESS, jsonResponse);
    postMapper.bind("/session/:sessionId/execute_async", ExecuteAsyncScript.class)
        .on(ResultType.SUCCESS, jsonResponse);

    getMapper.bind("/session/:sessionId/source", GetPageSource.class)
        .on(ResultType.SUCCESS, jsonResponse);

    getMapper.bind("/session/:sessionId/screenshot", CaptureScreenshot.class)
        .on(ResultType.SUCCESS, jsonResponse);

    getMapper.bind("/session/:sessionId/title", GetTitle.class)
        .on(ResultType.SUCCESS, jsonResponse);

    postMapper.bind("/session/:sessionId/element", FindElement.class)
        .on(ResultType.SUCCESS, jsonResponse);
    getMapper.bind("/session/:sessionId/element/:id", DescribeElement.class)
        .on(ResultType.SUCCESS, jsonResponse);

    postMapper.bind("/session/:sessionId/elements", FindElements.class)
        .on(ResultType.SUCCESS, jsonResponse);
    postMapper.bind("/session/:sessionId/element/active", FindActiveElement.class)
        .on(ResultType.SUCCESS, jsonResponse);

    postMapper.bind("/session/:sessionId/element/:id/element", FindChildElement.class)
        .on(ResultType.SUCCESS, jsonResponse);
    postMapper.bind("/session/:sessionId/element/:id/elements", FindChildElements.class)
        .on(ResultType.SUCCESS, jsonResponse);


    postMapper.bind("/session/:sessionId/element/:id/click", ClickElement.class)
        .on(ResultType.SUCCESS, emptyResponse);
    getMapper.bind("/session/:sessionId/element/:id/text", GetElementText.class)
        .on(ResultType.SUCCESS, jsonResponse);
    postMapper.bind("/session/:sessionId/element/:id/submit", SubmitElement.class)
        .on(ResultType.SUCCESS, emptyResponse);

    postMapper.bind("/session/:sessionId/file", UploadFile.class)
        .on(ResultType.SUCCESS, jsonResponse);
    postMapper.bind("/session/:sessionId/element/:id/value", SendKeys.class)
        .on(ResultType.SUCCESS, emptyResponse);
    getMapper.bind("/session/:sessionId/element/:id/value", GetElementValue.class)
        .on(ResultType.SUCCESS, jsonResponse);
    getMapper.bind("/session/:sessionId/element/:id/name", GetTagName.class)
        .on(ResultType.SUCCESS, jsonResponse);

    postMapper.bind("/session/:sessionId/element/:id/clear", ClearElement.class)
        .on(ResultType.SUCCESS, emptyResponse);
    getMapper.bind("/session/:sessionId/element/:id/selected", GetElementSelected.class)
        .on(ResultType.SUCCESS, jsonResponse);
    getMapper.bind("/session/:sessionId/element/:id/enabled", GetElementEnabled.class)
        .on(ResultType.SUCCESS, jsonResponse);
    getMapper.bind("/session/:sessionId/element/:id/displayed", GetElementDisplayed.class)
        .on(ResultType.SUCCESS, jsonResponse);
    getMapper.bind("/session/:sessionId/element/:id/location", GetElementLocation.class)
        .on(ResultType.SUCCESS, jsonResponse);
    getMapper.bind("/session/:sessionId/element/:id/location_in_view",
        GetElementLocationInView.class)
        .on(ResultType.SUCCESS, jsonResponse);
    getMapper.bind("/session/:sessionId/element/:id/size", GetElementSize.class)
        .on(ResultType.SUCCESS, jsonResponse);
    getMapper.bind("/session/:sessionId/element/:id/css/:propertyName", GetCssProperty.class)
        .on(ResultType.SUCCESS, jsonResponse);

    getMapper.bind("/session/:sessionId/element/:id/attribute/:name", GetElementAttribute.class)
        .on(ResultType.SUCCESS, jsonResponse);
    getMapper.bind("/session/:sessionId/element/:id/equals/:other", ElementEquality.class)
        .on(ResultType.SUCCESS, jsonResponse);

    getMapper.bind("/session/:sessionId/cookie", GetAllCookies.class)
        .on(ResultType.SUCCESS, jsonResponse);
    postMapper.bind("/session/:sessionId/cookie", AddCookie.class)
        .on(ResultType.SUCCESS, emptyResponse);
    deleteMapper.bind("/session/:sessionId/cookie", DeleteCookie.class)
        .on(ResultType.SUCCESS, emptyResponse);
    deleteMapper.bind("/session/:sessionId/cookie/:name", DeleteNamedCookie.class)
        .on(ResultType.SUCCESS, emptyResponse);

    postMapper.bind("/session/:sessionId/frame", SwitchToFrame.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/window", SwitchToWindow.class)
        .on(ResultType.SUCCESS, emptyResponse);
    deleteMapper.bind("/session/:sessionId/window", CloseWindow.class)
        .on(ResultType.SUCCESS, emptyResponse);

    getMapper.bind("/session/:sessionId/window/:windowHandle/size", GetWindowSize.class)
        .on(ResultType.SUCCESS, jsonResponse);
    postMapper.bind("/session/:sessionId/window/:windowHandle/size", SetWindowSize.class)
        .on(ResultType.SUCCESS, emptyResponse);
    getMapper.bind("/session/:sessionId/window/:windowHandle/position", GetWindowPosition.class)
        .on(ResultType.SUCCESS, jsonResponse);
    postMapper.bind("/session/:sessionId/window/:windowHandle/position", SetWindowPosition.class)
        .on(ResultType.SUCCESS, emptyResponse);

    postMapper.bind("/session/:sessionId/timeouts/implicit_wait", ImplicitlyWait.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/timeouts/async_script", SetScriptTimeout.class)
        .on(ResultType.SUCCESS, emptyResponse);

    postMapper.bind("/session/:sessionId/execute_sql", ExecuteSQL.class)
        .on(ResultType.SUCCESS, jsonResponse);

    getMapper.bind("/session/:sessionId/location", GetLocationContext.class)
        .on(ResultType.SUCCESS, jsonResponse);
    postMapper.bind("/session/:sessionId/location", SetLocationContext.class)
        .on(ResultType.SUCCESS, emptyResponse);

    getMapper.bind("/session/:sessionId/application_cache", GetAppCache.class)
        .on(ResultType.SUCCESS, jsonResponse);
    getMapper.bind("/session/:sessionId/application_cache/status", GetAppCacheStatus.class)
        .on(ResultType.SUCCESS, jsonResponse);
    deleteMapper.bind("/session/:sessionId/application_cache/clear", ClearAppCache.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/browser_connection", SetBrowserConnection.class)
        .on(ResultType.SUCCESS, emptyResponse);
    getMapper.bind("/session/:sessionId/browser_connection", IsBrowserOnline.class)
        .on(ResultType.SUCCESS, jsonResponse);

    getMapper.bind("/session/:sessionId/local_storage/key/:key", GetLocalStorageItem.class)
        .on(ResultType.SUCCESS, jsonResponse);
    deleteMapper.bind("/session/:sessionId/local_storage/key/:key", RemoveLocalStorageItem.class)
        .on(ResultType.SUCCESS, jsonResponse);
    getMapper.bind("/session/:sessionId/local_storage", GetLocalStorageKeys.class)
        .on(ResultType.SUCCESS, jsonResponse);
    postMapper.bind("/session/:sessionId/local_storage", SetLocalStorageItem.class)
        .on(ResultType.SUCCESS, emptyResponse);
    deleteMapper.bind("/session/:sessionId/local_storage", ClearLocalStorage.class)
        .on(ResultType.SUCCESS, emptyResponse);
    getMapper.bind("/session/:sessionId/local_storage/size", GetLocalStorageSize.class)
        .on(ResultType.SUCCESS, jsonResponse);

    getMapper.bind("/session/:sessionId/session_storage/key/:key", GetSessionStorageItem.class)
        .on(ResultType.SUCCESS, jsonResponse);
    deleteMapper.bind("/session/:sessionId/session_storage/key/:key", RemoveSessionStorageItem.class)
        .on(ResultType.SUCCESS, jsonResponse);
    getMapper.bind("/session/:sessionId/session_storage", GetSessionStorageKeys.class)
        .on(ResultType.SUCCESS, jsonResponse);
    postMapper.bind("/session/:sessionId/session_storage", SetSessionStorageItem.class)
        .on(ResultType.SUCCESS, emptyResponse);
    deleteMapper.bind("/session/:sessionId/session_storage", ClearSessionStorage.class)
        .on(ResultType.SUCCESS, emptyResponse);
    getMapper.bind("/session/:sessionId/session_storage/size", GetSessionStorageSize.class)
        .on(ResultType.SUCCESS, jsonResponse);

    getMapper.bind("/session/:sessionId/orientation", GetScreenOrientation.class)
        .on(ResultType.SUCCESS, jsonResponse);
    postMapper.bind("/session/:sessionId/orientation", Rotate.class)
        .on(ResultType.SUCCESS, emptyResponse);

    postMapper.bind("/session/:sessionId/moveto", MouseMoveToLocation.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/click", ClickInSession.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/doubleclick", DoubleClickInSession.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/buttondown", MouseDown.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/buttonup", MouseUp.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/keys", SendKeyToActiveElement.class)
        .on(ResultType.SUCCESS, emptyResponse);

    getMapper.bind("/session/:sessionId/ime/available_engines", ImeGetAvailableEngines.class)
        .on(ResultType.SUCCESS, jsonResponse);
    getMapper.bind("/session/:sessionId/ime/active_engine", ImeGetActiveEngine.class)
        .on(ResultType.SUCCESS, jsonResponse);
    getMapper.bind("/session/:sessionId/ime/activated", ImeIsActivated.class)
        .on(ResultType.SUCCESS, jsonResponse);
    postMapper.bind("/session/:sessionId/ime/deactivate", ImeDeactivate.class)
        .on(ResultType.SUCCESS, jsonResponse);
    postMapper.bind("/session/:sessionId/ime/activate", ImeActivateEngine.class)
        .on(ResultType.SUCCESS, jsonResponse);

    // Advanced Touch API
    postMapper.bind("/session/:sessionId/touch/click", SingleTapOnElement.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/touch/down", Down.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/touch/up", Up.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/touch/move", Move.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/touch/scroll", Scroll.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/touch/doubleclick", DoubleTapOnElement.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/touch/longclick", LongPressOnElement.class)
        .on(ResultType.SUCCESS, emptyResponse);
    postMapper.bind("/session/:sessionId/touch/flick", Flick.class)
        .on(ResultType.SUCCESS, emptyResponse);
  }

  protected ResultConfig addNewGetMapping(String path, Class<? extends Handler> implementationClass) {
    return getMapper.bind(path, implementationClass);
  }

  protected ResultConfig addNewPostMapping(String path, Class<? extends Handler> implementationClass) {
    return postMapper.bind(path, implementationClass);
  }

  protected ResultConfig addNewDeleteMapping(String path,
      Class<? extends Handler> implementationClass) {
    return deleteMapper.bind(path, implementationClass);
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    if (request.getHeader("Origin") != null) {
      setAccessControlHeaders(response);
    }
    super.service(request, response);
  }

  /**
   * Sets access control headers to allow cross-origin resource sharing from
   * any origin.
   *
   * @param response The response to modify.
   * @see <a href="http://www.w3.org/TR/cors/">http://www.w3.org/TR/cors/</a>
   */
  private void setAccessControlHeaders(HttpServletResponse response) {
    response.setHeader("Access-Control-Allow-Origin", "*");  // Real safe.
    response.setHeader("Access-Control-Allow-Methods", "DELETE,GET,HEAD,POST");
    response.setHeader("Access-Control-Allow-Headers", "Accept,Content-Type");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Make sure our browser-clients never cache GET responses.
    response.setHeader("Expires", "Thu, 01 Jan 1970 00:00:00 GMT");
    response.setHeader("Cache-Control", "no-cache");

    if (JSONP_PATH.equalsIgnoreCase(request.getPathInfo())) {
      handleJsonpRequest(request, response);
    } else {
      handleRequest(getMapper, request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    handleRequest(postMapper, request, response);
  }

  @Override
  protected void doDelete(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    handleRequest(deleteMapper, request, response);
  }

  private void handleJsonpRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    UrlMapper urlMapper;
    try {
      String method = getRequiredJsonPParameter(request, "method")
          .toUpperCase();
      String path = getRequiredJsonPParameter(request, "path");
      String callback = getRequiredJsonPParameter(request, "callback");

      String body = request.getParameter("body");
      if (body == null) {
        body = "";
      }

      request = JsonpHttpServletRequestProxy.createProxy(request, method, path, body);
      request.setAttribute(CALLBACK, callback);
      urlMapper = getJsonPUrlMapper(method);
    } catch (RuntimeException rte) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      response.getOutputStream().println("Unknown method: " + rte.getMessage());
      response.getOutputStream().flush();
      return;
    }

    handleRequest(urlMapper, request, response);
  }

  private UrlMapper getJsonPUrlMapper(String method) {
    if ("DELETE".equals(method)) {
      return deleteMapper;
    } else if ("GET".equals(method)) {
      return getMapper;
    } else if ("POST".equals(method)) {
      return postMapper;
    } else {
      throw new IllegalArgumentException("Unknown method: " + method);
    }
  }

  private String getRequiredJsonPParameter(HttpServletRequest request,
      String parameterName) {
    String parameter = request.getParameter(parameterName);
    return checkNotNull(parameter,
        "Request is missing required JSONP parameter '%s'", parameterName);
  }

  protected void handleRequest(UrlMapper mapper, HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException {
    try {
      ResultConfig config = mapper.getConfig(request.getPathInfo());
      if (config == null) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      } else {
        config.handle(request.getPathInfo(), request, response);
      }
    } catch (Exception e) {
      log("Fatal, unhandled exception: " + request.getPathInfo() + ": " + e);
      throw new ServletException(e);
    }
  }

  private static interface MimeType {
    static final String EMPTY = "";
    static final String JSONP = "application/jsonp";
  }

  private static class JsonpHttpServletRequestProxy implements InvocationHandler {

    private final HttpServletRequest proxiedRequest;
    private final String method;
    private final String pathInfo;
    private final String body;

    private JsonpHttpServletRequestProxy(HttpServletRequest proxiedRequest,
        String method, String pathInfo, String body) {
      this.proxiedRequest = proxiedRequest;
      this.method = method;
      this.pathInfo = pathInfo;
      this.body = body;
    }

    public static HttpServletRequest createProxy(HttpServletRequest request,
        String method, String pathInfo, String body) {
      checkNotNull(request);
      return (HttpServletRequest) Proxy.newProxyInstance(
          request.getClass().getClassLoader(),
          request.getClass().getInterfaces(),
          new JsonpHttpServletRequestProxy(request, method, pathInfo, body));
    }

    private String trimJsonpPath(String str) {
      return str.substring(0, str.indexOf(JSONP_PATH));
    }

    public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable {
      if ("getMethod".equals(method.getName())) {
        return this.method;
      }

      if ("getRequestURL".equals(method.getName())) {
        return trimJsonpPath(proxiedRequest.getRequestURL().toString()) + pathInfo;
      }

      if ("getRequestURI".equals(method.getName())) {
        return trimJsonpPath(proxiedRequest.getRequestURI()) + pathInfo;
      }

      if ("getPathInfo".equals(method.getName())) {
        return pathInfo;
      }

      if ("getReader".equals(method.getName())) {
        return new BufferedReader(new StringReader(body));
      }

      if ("getHeader".equals(method.getName())) {
        String headerName = (String) args[0];
        if ("accept".equalsIgnoreCase(headerName)) {
          return MimeType.JSONP;
        }
      }

      try {
        return method.invoke(proxiedRequest, args);
      } catch (InvocationTargetException e) {
        throw e.getTargetException();
      } catch (Exception e) {
        throw Throwables.propagate(e);
      }
    }
  }
}
