package br.com.cafebinario.doccy.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cafebinario.doccy.contracts.FormularioDocumentoDto;
import br.com.cafebinario.doccy.contracts.ImagemComprovanteDto;
import br.com.cafebinario.doccy.contracts.TipoDocumento;
import br.com.cafebinario.doccy.contracts.TipoDocumentoEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonGen {

	private final ObjectMapper objectMapper = new ObjectMapper();

	private final FormularioDocumentoDto formularioDocumentoDto = new FormularioDocumentoDto() {

		@Override
		public String getValor() {
			return null;
		}

		@Override
		public ImagemComprovanteDto<TipoDocumento> getComprovanteDocumento() {
			return ImagemComprovanteDto.builder().tipoImagemComprovante(TipoDocumentoEnum.RG)
					.imagem("IMAGEM AQUI".getBytes()).build();
		}
	};

	@Test
	public void createFormularioDocumentoDto() throws JsonProcessingException {
		log.info("m=createFormularioDocumentoDto, payload={}", objectMapper.writeValueAsString(formularioDocumentoDto));
	}

	@Test
	public void criaImagemByteArray() throws IOException {
		final byte[] imagem = Files.readAllBytes(Paths.get("/cafebinario/doccy/imagens/receita.png"));
		log.info("m=criaImagemByteArray, payload={}", objectMapper.writeValueAsString(imagem));
	}
}
