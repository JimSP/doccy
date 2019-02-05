package br.com.cafebinario.doccy.configurations;

import javax.imageio.ImageIO;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

@Configuration
public class ITesseractConfiguration {

	@Bean
	public ITesseract iTesseract() {
		final ITesseract iTesseract = new Tesseract();
		iTesseract.setDatapath("/cafebinario/carteira-virtual/tessdata");
		iTesseract.setLanguage("por");
		ImageIO.scanForPlugins();
		return iTesseract;
	}
}
