package br.com.cafebinario.doccy.exceptions;

public final class OCRDocumentosException extends RuntimeException {

	private static final long serialVersionUID = -7967404048287369778L;
	
	public OCRDocumentosException(final Exception e) {
		super(e);
	}

}
