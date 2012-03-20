// Copyright 2012 Software Freedom Conservancy. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/** @fileoverview Defines the safaridriver.Command class. */

goog.provide('safaridriver.Command');

goog.require('webdriver.Command');


/**
 * Describes a command to execute.
 * @param {string} id The command identifier, used to synchronize between two
 *   end points in the WebDriver wire protocol.
 * @param {string} name The command name.
 * @param {!Object.<*>} parameters The command parameters.
 * @constructor
 * @extends {webdriver.Command}
 */
safaridriver.Command = function(id, name, parameters) {
  goog.base(this, name);

  /** @type {string} */
  this.id = id;

  this.setParameters(parameters);
};
goog.inherits(safaridriver.Command, webdriver.Command);
