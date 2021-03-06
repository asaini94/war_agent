/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.loggingToolsQS.exceptions;

import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageBundle;
import org.jboss.logging.Messages;

@MessageBundle(projectCode = "GREETER")
public interface GreeterExceptionBundle {
    GreeterExceptionBundle EXCEPTIONS = Messages.getBundle(GreeterExceptionBundle.class);

    @Message(id = 5, value = "Requested locale not valid: %s")
    LocaleInvalidException localeNotValid(String locale);

    @Message(id = 6, value = "This exception thrown on purpose.")
    Exception thrownOnPurpose(@Cause Throwable ex);

}
