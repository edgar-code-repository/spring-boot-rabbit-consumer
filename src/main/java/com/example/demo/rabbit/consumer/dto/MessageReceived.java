package com.example.demo.rabbit.consumer.dto;

public class MessageReceived {
	
	private int messageId;
	private String content;
	
	public MessageReceived() {
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	
	
	@Override
	public String toString() {
		return "MessageReceived [messageId=" + messageId + ", content=" + content + "]";
	}

}
