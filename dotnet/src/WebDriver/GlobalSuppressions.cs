// <copyright file="GlobalSuppressions.cs" company="WebDriver Committers">
// Copyright 2007-2011 WebDriver committers
// Copyright 2007-2011 Google Inc.
// Portions copyright 2011 Software Freedom Conservancy
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// </copyright>

// This file is used by Code Analysis to maintain SuppressMessage 
// attributes that are applied to this project. 
// Project-level suppressions either have no target or are given 
// a specific target and scoped to a namespace, type, member, etc. 
//
// To add a suppression to this file, right-click the message in the 
// Error List, point to "Suppress Message(s)", and click 
// "In Project Suppression File". 
// You do not need to add suppressions to this file manually. 
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1002:DoNotExposeGenericLists", Scope = "member", Target = "OpenQA.Selenium.Safari.Internal.ReadState.#Data", Justification = "Type is properly specified. A generic list provides the correct level of functionality.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1002:DoNotExposeGenericLists", Scope = "member", Target = "OpenQA.Selenium.Safari.Internal.Handlers.RequestHandler.#Data", Justification = "Type is properly specified. A generic list provides the correct level of functionality.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1006:DoNotNestGenericTypesInMemberSignatures", Scope = "member", Target = "OpenQA.Selenium.By.#FindElementsMethod", Justification = "Type is properly specified. It should be a Func<T, TResult> that returns a ReadOnlyCollection<IWebElement>")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1006:DoNotNestGenericTypesInMemberSignatures", Scope = "member", Target = "OpenQA.Selenium.By.#.ctor(System.Func`2<OpenQA.Selenium.ISearchContext,OpenQA.Selenium.IWebElement>,System.Func`2<OpenQA.Selenium.ISearchContext,System.Collections.ObjectModel.ReadOnlyCollection`1<OpenQA.Selenium.IWebElement>>)", Justification = "Type is properly specified. It should be a Func<T, TResult> that returns a ReadOnlyCollection<IWebElement>")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1020:AvoidNamespacesWithFewTypes", Scope = "namespace", Target = "OpenQA.Selenium.Android", Justification = "Namespaces are properly scoped.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1020:AvoidNamespacesWithFewTypes", Scope = "namespace", Target = "OpenQA.Selenium.IE", Justification = "Namespaces are properly scoped.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1020:AvoidNamespacesWithFewTypes", Scope = "namespace", Target = "OpenQA.Selenium.Interactions", Justification = "Namespaces are properly scoped.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1020:AvoidNamespacesWithFewTypes", Scope = "namespace", Target = "OpenQA.Selenium.Chrome", Justification = "Namespaces are properly scoped.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1024:UsePropertiesWhereAppropriate", Scope = "member", Target = "OpenQA.Selenium.ITakesScreenshot.#GetScreenshot()", Justification = "API specification demands method.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1027:MarkEnumsWithFlags", Scope = "type", Target = "OpenQA.Selenium.ProxyKind", Justification = "The ProxyKind enum is not a set of flags, but has values determined by an external API.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1027:MarkEnumsWithFlags", Scope = "type", Target = "OpenQA.Selenium.WebDriverResult", Justification = "The WebDriverResult enum is not a set of flags, but has values determined by an external API.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1027:MarkEnumsWithFlags", Scope = "type", Target = "OpenQA.Selenium.Safari.Internal.FrameType", Justification = "Enum is not a set of flags.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1031:DoNotCatchGeneralExceptionTypes", Scope = "member", Target = "OpenQA.Selenium.Safari.Internal.SocketWrapper.#OnAuthenticate(System.IAsyncResult)", Justification = "Providing event for all error types, so catching top-level exception is correct design.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1031:DoNotCatchGeneralExceptionTypes", Scope = "member", Target = "OpenQA.Selenium.Safari.Internal.SocketWrapper.#OnDataSend(System.IAsyncResult)", Justification = "Providing event for all error types, so catching top-level exception is correct design.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1031:DoNotCatchGeneralExceptionTypes", Scope = "member", Target = "OpenQA.Selenium.Safari.Internal.SocketWrapper.#OnDataReceive(System.IAsyncResult)", Justification = "Providing event for all error types, so catching top-level exception is correct design.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1031:DoNotCatchGeneralExceptionTypes", Scope = "member", Target = "OpenQA.Selenium.Safari.Internal.SocketWrapper.#OnClientConnect(System.IAsyncResult)", Justification = "Providing event for all error types, so catching top-level exception is correct design.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1056:UriPropertiesShouldNotBeStrings", Scope = "member", Target = "OpenQA.Selenium.IWebDriver.#Url", Justification = "Specification demands string value for property.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "CA1056:UriPropertiesShouldNotBeStrings", Scope = "member", Target = "OpenQA.Selenium.Proxy.#ProxyAutoConfigUrl", Justification = "Proxy configuration can be string instead of Uri.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Globalization", "CA1308:NormalizeStringsToUppercase", Scope = "member", Target = "OpenQA.Selenium.Firefox.FirefoxProfile.#UpdateUserPreferences()", Justification = "Strings are normalized to lower case by JSON wire protocol.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Globalization", "CA1308:NormalizeStringsToUppercase", Scope = "member", Target = "OpenQA.Selenium.Firefox.Preferences.#SetPreference(System.String,System.Boolean)", Justification = "Strings are normalized to lower case by JSON wire protocol.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Globalization", "CA1308:NormalizeStringsToUppercase", Scope = "member", Target = "OpenQA.Selenium.Remote.RemoteWebElement.#GetAttribute(System.String)", Justification = "Strings are normalized to lower case by JSON wire protocol.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Globalization", "CA1303:Do not pass literals as localized parameters", MessageId = "System.Console.WriteLine(System.String,System.Object)", Scope = "member", Target = "OpenQA.Selenium.IE.InternetExplorerDriverServer.#DeleteLibraryDirectory()", Justification = "Project does not use resource tables.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Globalization", "CA1303:Do not pass literals as localized parameters", MessageId = "System.Console.WriteLine(System.String,System.Object)", Scope = "member", Target = "OpenQA.Selenium.Internal.FileUtilities.#DeleteDirectory(System.String)", Justification = "Project does not use resource tables.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", MessageId = "OnScreen", Scope = "member", Target = "OpenQA.Selenium.Interactions.Internal.ICoordinates.#LocationOnScreen", Justification = "On Screen is properly used as two-word discrete term.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1702:CompoundWordsShouldBeCasedCorrectly", MessageId = "OnScreen", Scope = "member", Target = "OpenQA.Selenium.ILocatable.#LocationOnScreenOnceScrolledIntoView", Justification = "On Screen is properly used as two-word discrete term.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Firefox", Scope = "member", Target = "OpenQA.Selenium.Remote.DesiredCapabilities.#Firefox()", Justification = "Firefox is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Firefox", Scope = "member", Target = "OpenQA.Selenium.Firefox.FirefoxBinary.#StartFirefoxProcess(System.Diagnostics.Process)", Justification = "Firefox is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Firefox", Scope = "namespace", Target = "OpenQA.Selenium.Firefox", Justification = "Firefox is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Firefox", Scope = "type", Target = "OpenQA.Selenium.Firefox.FirefoxBinary", Justification = "Firefox is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Firefox", Scope = "type", Target = "OpenQA.Selenium.Firefox.FirefoxDriver", Justification = "Firefox is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Firefox", Scope = "type", Target = "OpenQA.Selenium.Firefox.FirefoxExtension", Justification = "Firefox is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Firefox", Scope = "type", Target = "OpenQA.Selenium.Firefox.FirefoxProfile", Justification = "Firefox is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Firefox", Scope = "type", Target = "OpenQA.Selenium.Firefox.FirefoxProfileManager", Justification = "Firefox is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Firefox", Scope = "type", Target = "OpenQA.Selenium.Firefox.FirefoxWebElement", Justification = "Firefox is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Firefox", Scope = "member", Target = "OpenQA.Selenium.Firefox.FirefoxBinary.#.ctor(System.String)", Justification = "Firefox is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Json", Scope = "member", Target = "OpenQA.Selenium.Remote.Command.#ParametersAsJsonString", Justification = "JSON is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Json", Scope = "member", Target = "OpenQA.Selenium.Remote.Response.#FromJson(System.String)", Justification = "JSON is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Json", Scope = "member", Target = "OpenQA.Selenium.Remote.Response.#ToJson()", Justification = "JSON is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "json", Scope = "member", Target = "OpenQA.Selenium.Remote.Command.#.ctor(OpenQA.Selenium.Remote.DriverCommand,System.String)", Justification = "JSON is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "Rotatable", Scope = "member", Target = "OpenQA.Selenium.Remote.CapabilityType.#Rotatable", Justification = "Rotatable is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "xpath", Scope = "member", Target = "OpenQA.Selenium.By.#XPath(System.String)", Justification = "XPath is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "xpath", Scope = "member", Target = "OpenQA.Selenium.Internal.IFindsByXPath.#FindElementByXPath(System.String)", Justification = "XPath is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", MessageId = "xpath", Scope = "member", Target = "OpenQA.Selenium.Internal.IFindsByXPath.#FindElementsByXPath(System.String)", Justification = "XPath is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Scope = "type", Target = "OpenQA.Selenium.Safari.Internal.Handlers.Hybi00Handler", Justification = "Hybi is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1704:IdentifiersShouldBeSpelledCorrectly", Scope = "type", Target = "OpenQA.Selenium.Safari.Internal.Handlers.Rfc6455Handler", Justification = "Rfc is spelled correctly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA1709:IdentifiersShouldBeCasedCorrectly", MessageId = "OSX", Scope = "member", Target = "OpenQA.Selenium.PlatformType.#MacOSX", Justification = "OS X is properly capitalized.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Naming", "CA2204:Literals should be spelled correctly", MessageId = "WebDriver", Scope = "member", Target = "OpenQA.Selenium.Remote.RemoteWebDriver.#ExecuteScriptInternal(System.String,System.Boolean,System.Object[])", Justification = "WebDriver is spelled correctly")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Performance", "CA1819:PropertiesShouldNotReturnArrays", Scope = "member", Target = "OpenQA.Selenium.Remote.ErrorResponse.#StackTrace", Justification = "Specification compliance demands use of an array.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Performance", "CA1819:PropertiesShouldNotReturnArrays", Scope = "member", Target = "OpenQA.Selenium.Screenshot.#AsByteArray", Justification = "Specification compliance demands use of an array.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Performance", "CA1819:PropertiesShouldNotReturnArrays", Scope = "member", Target = "OpenQA.Selenium.Safari.Internal.BinaryMessageHandledEventArgs.#Data", Justification = "Type is properly specified. It should be an array of bytes.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Performance", "CA1819:PropertiesShouldNotReturnArrays", Scope = "member", Target = "OpenQA.Selenium.Safari.Internal.ReceivedEventArgs.#Buffer", Justification = "Type is properly specified. It should be an array of bytes.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Performance", "CA1819:PropertiesShouldNotReturnArrays", Scope = "member", Target = "OpenQA.Selenium.Safari.Internal.WebSocketHttpRequest.#Payload", Justification = "Type is properly specified. It should be an array of bytes.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Performance", "CA1822:MarkMembersAsStatic", Scope = "member", Target = "OpenQA.Selenium.Firefox.FirefoxDriver.#PrepareEnvironment()", Justification = "Method is a hook method for subclasses to implement functionality, so it cannot be static.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2234:PassSystemUriObjectsInsteadOfStrings", Scope = "member", Target = "OpenQA.Selenium.Remote.CommandInfo.#CreateWebRequest(System.Uri,OpenQA.Selenium.Remote.Command)", Justification = "Must use strings to construct URL properly.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors", Scope = "member", Target = "OpenQA.Selenium.Remote.RemoteWebDriver.#.ctor(OpenQA.Selenium.Remote.ICommandExecutor,OpenQA.Selenium.ICapabilities)", Justification = "Class provides a hook for subclasses to modify functionality, so virtual method call in constructor is appropriate.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Reliability", "CA2000:Dispose objects before losing scope", Scope = "member", Target = "OpenQA.Selenium.Chrome.ChromeDriver.#.ctor()", Justification = "ChromeDriverService is properly disposed of during RemoteWebDriver.Dispose() via ChromeDriver.StopClient()")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Reliability", "CA2000:Dispose objects before losing scope", Scope = "member", Target = "OpenQA.Selenium.Chrome.ChromeDriver.#.ctor(System.String)", Justification = "ChromeDriverService is properly disposed of during RemoteWebDriver.Dispose() via ChromeDriver.StopClient()")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Reliability", "CA2000:Dispose objects before losing scope", Scope = "member", Target = "OpenQA.Selenium.Chrome.ChromeDriver.#.ctor(OpenQA.Selenium.ICapabilities)", Justification = "ChromeDriverService is properly disposed of in the StopClient() method.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Reliability", "CA2000:Dispose objects before losing scope", Scope = "member", Target = "OpenQA.Selenium.Chrome.ChromeDriver.#.ctor(System.String,OpenQA.Selenium.ICapabilities)", Justification = "ChromeDriverService is properly disposed of in the StopClient() method.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Reliability", "CA2000:Dispose objects before losing scope", Scope = "member", Target = "OpenQA.Selenium.Chrome.ChromeDriver.#.ctor(System.String,OpenQA.Selenium.ICapabilities,System.TimeSpan)", Justification = "ChromeDriverService is properly disposed of in the StopClient() method.")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Reliability", "CA2000:Dispose objects before losing scope", Scope = "member", Target = "OpenQA.Selenium.Firefox.FirefoxBinary.#CreateProfile(System.String)", Justification = "FirefoxBinary is properly disposed of during RemoteWebDriver.Dispose() via FirefoxDriver.StopClient()")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Reliability", "CA2000:Dispose objects before losing scope", Scope = "member", Target = "OpenQA.Selenium.Firefox.FirefoxBinary.#StartProfile(OpenQA.Selenium.Firefox.FirefoxProfile,System.String[])", Justification = "FirefoxBinary is properly disposed of during RemoteWebDriver.Dispose() via FirefoxDriver.StopClient()")]
[assembly: System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Security", "CA2104:DoNotDeclareReadOnlyMutableReferenceTypes", Scope = "member", Target = "OpenQA.Selenium.Safari.Internal.WebSocketStatusCodes.#ValidCloseCodes", Justification = "Type is properly immutable.")]
