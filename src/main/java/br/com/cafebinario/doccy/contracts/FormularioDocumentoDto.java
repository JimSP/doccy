package br.com.cafebinario.doccy.contracts;

public interface FormularioDocumentoDto {
	
	public String getValor();
	public ImagemComprovanteDto<TipoDocumento> getComprovanteDocumento();
}
