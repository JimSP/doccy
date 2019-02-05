package br.com.cafebinario.doccy.ocr;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cafebinario.doccy.ocr.OCRDocumentos;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OCRDocumentosTest {

	@Autowired
	private OCRDocumentos ocrDocumentos;

	@Test
	public void test() throws IOException {
		log.info("m=test, ocrResult={}", ocrDocumentos.lerImagem(Paths.get("indice.jpeg").toFile()));
	}
}
