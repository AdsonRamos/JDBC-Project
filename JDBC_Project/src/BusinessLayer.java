import java.io.File;

public class BusinessLayer {
	
	private String nome, cpf, dataNascimento, sexo, idEnd;
	private File fileImage;
	
	// tamb�m deve ter um metodo que recupera as informa��es do banco
	
	public BusinessLayer(String nome, String cpf, String dataNascimento, String sexo, String idEnd, File fileImage) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.idEnd = idEnd;
		this.fileImage = fileImage;
		
		// cadastra informa��es no banco - chama m�todo que vai cadastrar os dados no banco
		
	}
	
}
