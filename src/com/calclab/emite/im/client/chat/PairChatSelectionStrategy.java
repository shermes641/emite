package com.calclab.emite.im.client.chat;

import com.calclab.emite.core.client.packet.NoPacket;
import com.calclab.emite.core.client.xmpp.stanzas.BasicStanza;

/**
 * A simple chat provider strategy. It ignores the metadata and the resource of
 * the user. This is the default strategy for a ChatManager
 * 
 */
public class PairChatSelectionStrategy implements ChatSelectionStrategy {

    @Override
    public ChatProperties extractChatProperties(final BasicStanza stanza) {
	ChatProperties properties = new ChatProperties(stanza.getFrom());
	boolean messageHasBody = stanza.getFirstChild("body") != NoPacket.INSTANCE;
	properties.setShouldCreateNewChat(messageHasBody);
	return properties;
    }

    @Override
    public boolean isAssignable(final Chat chat, final ChatProperties properties) {
	return chat.getURI().equalsNoResource(properties.getUri());
    }

}