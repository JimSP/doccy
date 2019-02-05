package br.com.cafebinario.doccy.contracts;

public interface FormularioDocumentoDto {
	
	public String getValor();
	public TipoDocumentoEnum getTipoDocumento();
	public ImagemComprovanteDto<TipoDocumentoEnum> getComprovanteDocumento();
}
