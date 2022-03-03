package br.com.student.events.listener;

import br.com.student.events.ResourceCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
@Component
public class ResourceCreatedListener implements ApplicationListener<ResourceCreatedEvent> {

	@Override
	public void onApplicationEvent(ResourceCreatedEvent recursoCriadoEvent) {
		HttpServletResponse response = recursoCriadoEvent.getResponse();
		Long id = recursoCriadoEvent.getId();
		adicionarHeaderLocation(response, id);
	}

	private void adicionarHeaderLocation(HttpServletResponse response, Long id) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(id).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

}
