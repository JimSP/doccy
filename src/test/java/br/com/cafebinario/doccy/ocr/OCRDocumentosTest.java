package br.com.cafebinario.doccy.ocr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OCRDocumentosTest {

	@Autowired
	private OCRDocumentos ocrDocumentos;
	
	@Test
	public void testReceita() throws IOException {
		final byte[] imagem = Files.readAllBytes(Paths.get("/cafebinario/doccy/imagens/receita.png"));
		log.info("m=testReceita, ocrResult={}", ocrDocumentos.lerImagem(imagem));
	}
	
	@Test
	public void testPlacas() throws IOException {
		final byte[] imagem = Files.readAllBytes(Paths.get("/cafebinario/doccy/imagens/Placas.jpg"));
		log.info("m=testPlacas, ocrResult={}", ocrDocumentos.lerImagem(imagem));
	}
}
