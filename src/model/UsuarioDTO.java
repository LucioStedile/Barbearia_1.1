package model;

public class UsuarioDTO {
	private int id_usuario, id_cliente;
	private String nome_usuario, senha_usuario, nome_cliente, telefone_cliente, tipo_de_corte, tipo_de_barba;
	private Float preco_corte, preco_barba, total;
	
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	public String getTelefone_cliente() {
		return telefone_cliente;
	}
	public void setTelefone_cliente(String telefone_cliente) {
		this.telefone_cliente = telefone_cliente;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public String getSenha_usuario() {
		return senha_usuario;
	}
	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}
	public String getTipo_de_corte() {
		return tipo_de_corte;
	}
	public void setTipo_de_corte(String tipo_de_corte) {
		this.tipo_de_corte = tipo_de_corte;
	}
	public String getTipo_de_barba() {
		return tipo_de_barba;
	}
	public void setTipo_de_barba(String tipo_de_barba) {
		this.tipo_de_barba = tipo_de_barba;
	}
	public Float getPreco_corte() {
		return preco_corte;
	}
	public void setPreco_corte(Float preco_corte) {
		this.preco_corte = preco_corte;
	}
	public Float getPreco_barba() {
		return preco_barba;
	}
	public void setPreco_barba(Float preco_barba) {
		this.preco_barba = preco_barba;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	
	
}
