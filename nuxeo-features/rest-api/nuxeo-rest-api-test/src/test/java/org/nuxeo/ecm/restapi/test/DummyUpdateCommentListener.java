/*
 * (C) Copyright 2017 Nuxeo (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Thomas Roger
 */

package org.nuxeo.ecm.restapi.test;

import org.nuxeo.ecm.core.event.Event;
import org.nuxeo.ecm.core.event.EventContext;
import org.nuxeo.ecm.core.event.EventListener;
import org.nuxeo.ecm.core.event.impl.DocumentEventContext;

/**
 * Dummy listener extracting the {@code comment} property from the event properties.
 *
 * @since 9.3
 */
public class DummyUpdateCommentListener implements EventListener {

    public static String comment = null;

    @Override
    public void handleEvent(Event event) {
        EventContext context = event.getContext();
        if (context instanceof DocumentEventContext) {
            DocumentEventContext docEventContext = (DocumentEventContext) context;
            comment = (String) docEventContext.getProperty("comment");
        }
    }
}
