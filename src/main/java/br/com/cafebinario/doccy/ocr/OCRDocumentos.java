package br.com.cafebinario.doccy.ocr;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cafebinario.doccy.exceptions.OCRDocumentosException;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;

@Component
public class OCRDocumentos {

	@Autowired
	private ITesseract iTesseract;

	public String lerImagem(final Path imagem) {
		return lerImagem(imagem.toFile());
	}

	public String lerImagem(final InputStream inputStream) {
		try {
			final BufferedImage bufferedImage = ImageIO.read(inputStream);
			return iTesseract.doOCR(bufferedImage);
		} catch (IOException | TesseractException e) {
			throw new OCRDocumentosException(e);
		}
	}
	
	public String lerImagem(final byte[] imagem) {
		try {
			final BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagem));
			return iTesseract.doOCR(bufferedImage);
		} catch (IOException | TesseractException e) {
			throw new OCRDocumentosException(e);
		}
	}

	public String lerImagem(final File file) {
		try {
			return iTesseract.doOCR(file);
		} catch (TesseractException e) {
			throw new OCRDocumentosException(e);
		}
	}
}
