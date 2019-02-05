package br.com.cafebinario.doccy.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CloudStorageService {

	public String salvarDocumento(final byte[] imagem, final UUID uuidParticipante) {
		log.debug("m=salvarDocumento, imagem.length={}, uuidParticipante={}", imagem.length, uuidParticipante);
		return String.format("http://dominio-storage.com/%s", uuidParticipante.toString());
	}
}
