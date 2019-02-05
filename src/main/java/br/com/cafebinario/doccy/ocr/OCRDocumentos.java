package br.com.cafebinario.doccy.ocr;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cafebinario.doccy.exceptions.OCRDocumentosExceptions;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;

@Component
public class OCRDocumentos {

	@Autowired
	private ITesseract iTesseract;

	public String lerImagem(final File imagem) {

		try {
			return iTesseract.doOCR(imagem);
		} catch (TesseractException e) {
			throw new OCRDocumentosExceptions(e);
		}
	}
}
