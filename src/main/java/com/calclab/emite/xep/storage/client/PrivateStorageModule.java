package com.calclab.emite.xep.storage.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

/**
 * Implements XEP http://xmpp.org/extensions/xep-0049.html
 */
public class PrivateStorageModule extends AbstractGinModule {

    @Override
    protected void configure() {
	bind(PrivateStorageManager.class).in(Singleton.class);
    }

}
