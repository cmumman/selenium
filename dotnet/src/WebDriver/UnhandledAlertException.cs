// <copyright file="UnhandledAlertException.cs" company="WebDriver Committers">
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

using System;
using System.Collections.Generic;
using System.Runtime.Serialization;
using System.Text;

namespace OpenQA.Selenium
{
    /// <summary>
    /// The exception that is thrown when an unhandled alert is present.
    /// </summary>
    [Serializable]
    public class UnhandledAlertException : WebDriverException
    {
        private IAlert alert;

        /// <summary>
        /// Initializes a new instance of the <see cref="UnhandledAlertException"/> class.
        /// </summary>
        public UnhandledAlertException()
            : base()
        {
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="UnhandledAlertException"/> class with 
        /// a specified error message.
        /// </summary>
        /// <param name="message">The message that describes the error.</param>
        public UnhandledAlertException(string message)
            : base(message)
        {
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="UnhandledAlertException"/> class with 
        /// a specified error message and alert text.
        /// </summary>
        /// <param name="message">The message that describes the error.</param>
        /// <param name="alertText">The text of the unhandled alert.</param>
        public UnhandledAlertException(string message, string alertText)
            : base(message)
        {
            this.alert = new UnhandledAlert(alertText);
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="UnhandledAlertException"/> class with
        /// a specified error message and a reference to the inner exception that is the
        /// cause of this exception.
        /// </summary>
        /// <param name="message">The error message that explains the reason for the exception.</param>
        /// <param name="innerException">The exception that is the cause of the current exception,
        /// or <see langword="null"/> if no inner exception is specified.</param>
        public UnhandledAlertException(string message, Exception innerException)
            : base(message, innerException)
        {
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="UnhandledAlertException"/> class with serialized data.
        /// </summary>
        /// <param name="info">The <see cref="SerializationInfo"/> that holds the serialized 
        /// object data about the exception being thrown.</param>
        /// <param name="context">The <see cref="StreamingContext"/> that contains contextual 
        /// information about the source or destination.</param>
        protected UnhandledAlertException(SerializationInfo info, StreamingContext context)
            : base(info, context)
        {
        }
        
        /// <summary>
        /// Gets the <see cref="IAlert"/> that has not been handled.
        /// </summary>
        public IAlert Alert
        {
            get { return this.alert; }
        }

        /// <summary>
        /// Populates a SerializationInfo with the data needed to serialize the target object.
        /// </summary>
        /// <param name="info">The <see cref="SerializationInfo"/> that holds the serialized 
        /// object data about the exception being thrown.</param>
        /// <param name="context">The <see cref="StreamingContext"/> that contains contextual 
        /// information about the source or destination.</param>
        public override void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            base.GetObjectData(info, context);
        }

        private class UnhandledAlert : IAlert
        {
            private string alertText;

            public UnhandledAlert(string alertText)
            {
                this.alertText = alertText;
            }

            public string Text
            {
                get { return this.alertText; }
            }

            public void Dismiss()
            {
                ThrowAlreadyDismissed();
            }

            public void Accept()
            {
                ThrowAlreadyDismissed();
            }

            public void SendKeys(string keysToSend)
            {
                ThrowAlreadyDismissed();
            }

            private static void ThrowAlreadyDismissed()
            {
                throw new InvalidOperationException("Alert was already dismissed");
            }
        }
    }
}
