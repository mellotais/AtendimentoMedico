package AtendimentoMedico;

import java.util.Date;

public class Medico extends Pessoa {
    private String especialidade;

    public Medico(String nome, Date dataNasc, String especialidade) {
        super(nome, dataNasc);
        setEspecialidade(especialidade);
    }

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Medico [especialidade=");
		builder.append(especialidade);
		builder.append("]");
		return builder.toString();
	}
    
}
