package br.com.cafebinario.doccy.tools;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cafebinario.doccy.contracts.FormularioDocumentoDto;
import br.com.cafebinario.doccy.contracts.ImagemComprovanteDto;
import br.com.cafebinario.doccy.contracts.TipoDocumento;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonGen {

	private final FormularioDocumentoDto formularioDocumentoDto = new FormularioDocumentoDto() {
		
		@Override
		public String getValor() {
			return null;
		}
		
		@Override
		public ImagemComprovanteDto<TipoDocumento> getComprovanteDocumento() {
			return ImagemComprovanteDto
					.builder()
					.imagem("IMAGEM AQUI".getBytes())
					.build();
		}
	};

	@Test
	public void createFormularioDocumentoDto() throws JsonProcessingException {
		final ObjectMapper objectMapper = new ObjectMapper();
		log.info("m=createFormularioDocumentoDto, payload=", objectMapper.writeValueAsString(formularioDocumentoDto));
	}
}