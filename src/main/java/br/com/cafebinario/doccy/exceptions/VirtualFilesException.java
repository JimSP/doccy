package br.com.cafebinario.doccy.exceptions;

public final class VirtualFilesException extends RuntimeException{

	private static final long serialVersionUID = -731150943185331209L;

	public VirtualFilesException(final Exception e) {
		super(e);
	}
}
