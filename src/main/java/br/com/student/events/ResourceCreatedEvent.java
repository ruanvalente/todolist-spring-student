package br.com.student.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class ResourceCreatedEvent extends ApplicationEvent {

	@Getter
	private final transient HttpServletResponse response;

	@Getter
	private final Long id;

	public ResourceCreatedEvent(Object source, HttpServletResponse response, Long id) {
		super(source);
		this.response = response;
		this.id = id;
	}
}
