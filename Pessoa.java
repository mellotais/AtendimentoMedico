package AtendimentoMedico;

import java.util.Date;

public abstract class Pessoa {
    private String nome;
    private Date dataNasc;
    
    public Pessoa(String nome, Date dataNasc) {
    	this.nome = nome;
        this.dataNasc = dataNasc;
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [nome=");
		builder.append(nome);
		builder.append(", dataNasc=");
		builder.append(dataNasc);
		builder.append("]");
		return builder.toString();
	}

   
}
