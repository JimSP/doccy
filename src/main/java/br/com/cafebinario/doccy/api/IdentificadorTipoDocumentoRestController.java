package br.com.cafebinario.doccy.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cafebinario.doccy.contracts.FormularioDocumentoDto;
import br.com.cafebinario.doccy.contracts.TipoDocumentoEnum;
import br.com.cafebinario.doccy.services.CriadorFormularioDocumentoDtoService;

@RestController
public class IdentificadorTipoDocumentoRestController {

	@Autowired
	private CriadorFormularioDocumentoDtoService criadorFormularioDocumentoDtoService;

	@PostMapping(path = "/identificadorDocumento", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody FormularioDocumentoDto post(
			@Valid @RequestBody final FormularioDocumentoDto formularioDocumentoDto,
			@RequestHeader(value = "UUID-Participante") final String uuidParticipante) {
		
		return criadorFormularioDocumentoDtoService
				.criar(formularioDocumentoDto.getComprovanteDocumento(),
				uuidParticipante == null ? UUID.randomUUID() : UUID.fromString(uuidParticipante));
	}
	
	@GetMapping(path="/obterUUID/{tipoDocumento}/{valor}")
	public List<String> obterUUIDporTipoDOcumentoEValor(@PathVariable(name="tipoDocumento", required=true) final String tipoDocumento, @PathVariable(name="valor", required=true) final String valor) {
		return criadorFormularioDocumentoDtoService.obterUUIDporTipoDOcumentoEValor(TipoDocumentoEnum.valueOf(tipoDocumento), valor);
	}
}
