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

package org.openqa.selenium.lift.match;

import org.openqa.selenium.WebElement;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * {@link Matcher} for matching text content within {@link WebElement}s.
 * 
 * @author rchatley (Robert Chatley)
 */
public class TextMatcher extends TypeSafeMatcher<WebElement> {

  private final Matcher<String> matcher;

  TextMatcher(Matcher<String> matcher) {
    this.matcher = matcher;
  }

  @Override
  public boolean matchesSafely(WebElement item) {
    return matcher.matches(item.getText());
  }

  public void describeTo(Description description) {
    description.appendText("text ");
    matcher.describeTo(description);
  }

  @Factory
  public static Matcher<WebElement> text(final Matcher<String> textMatcher) {
    return new TextMatcher(textMatcher);
  }
}
