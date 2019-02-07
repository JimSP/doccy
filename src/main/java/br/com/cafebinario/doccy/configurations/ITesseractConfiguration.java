package br.com.cafebinario.doccy.configurations;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

@Configuration
public class ITesseractConfiguration {

	@Value("${cafebinario.doccy.datapath:/cafebinario/doccy/tessdata}")
	private String tessdata;
	
	@Value("${cafebinario.doccy.language:por}")
	private String language;
	
	@Bean
	public ITesseract iTesseract() {
		final ITesseract iTesseract = new Tesseract();
		iTesseract.setDatapath(tessdata);
		iTesseract.setLanguage(language);
		ImageIO.scanForPlugins();
		return iTesseract;
	}
}
