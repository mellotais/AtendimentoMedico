package AtendimentoMedico;

import java.util.Date;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Atendimento {
    private Date horaChegadaNaUnidade;
    private Date inicioAtendimento;
    private Date fimAtendimento;
    private Date data;
    private boolean atestado;
    private String prioridade;
    private ArrayList<Perguntas> perguntas;
    private Paciente paciente; 
    private Medico medico;

    public Atendimento(Date horaChegadaNaUnidade, Date inicioAtendimento, Date fimAtendimento, Date data, boolean atestado, ArrayList<Perguntas> perguntas, Paciente paciente, Medico medico) {
        setHoraChegadaNaUnidade(horaChegadaNaUnidade);
        setInicioAtendimento(inicioAtendimento);
        setFimAtendimento(fimAtendimento);
        setData(data);
        setAtestado(atestado);
        setPerguntas(perguntas);
        setPaciente(paciente); 
        setMedico(medico);
        calcularPrioridade();
    }

   
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

	public Date getHoraChegadaNaUnidade() {
		return horaChegadaNaUnidade;
	}

	public void setHoraChegadaNaUnidade(Date horaChegadaNaUnidade) {
		this.horaChegadaNaUnidade = horaChegadaNaUnidade;
	}

	public Date getInicioAtendimento() {
		return inicioAtendimento;
	}

	public void setInicioAtendimento(Date inicioAtendimento) {
		this.inicioAtendimento = inicioAtendimento;
	}

	public Date getFimAtendimento() {
		return fimAtendimento;
	}

	public void setFimAtendimento(Date fimAtendimento) {
		this.fimAtendimento = fimAtendimento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isAtestado() {
		return atestado;
	}

	public void setAtestado(boolean atestado) {
		this.atestado = atestado;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public ArrayList<Perguntas> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(ArrayList<Perguntas> perguntas) {
		this.perguntas = perguntas;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	
	
	
	public void calcularPrioridade() {
	    this.prioridade = Perguntas.calcularPrioridade(this.perguntas);
	}

	public boolean emitirAtestado(String atestado) {
        this.atestado = !atestado.isEmpty();
        return this.atestado;
    }
	
	
	public String calcularDuracao() {
	    long diferenca = Math.abs(this.fimAtendimento.getTime() - this.inicioAtendimento.getTime());
	    long horas = TimeUnit.MILLISECONDS.toHours(diferenca);
	    long minutos = TimeUnit.MILLISECONDS.toMinutes(diferenca - TimeUnit.HOURS.toMillis(horas));
	    
	    return String.format("%02d:%02d", horas, minutos);
	}

	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Atendimento [horaChegadaNaUnidade=");
		builder.append(horaChegadaNaUnidade);
		builder.append(", inicioAtendimento=");
		builder.append(inicioAtendimento);
		builder.append(", fimAtendimento=");
		builder.append(fimAtendimento);
		builder.append(", atestado=");
		builder.append(atestado);
		builder.append(", prioridade=");
		builder.append(prioridade);
		builder.append(", perguntas=");
		builder.append(perguntas);
		builder.append("]");
		return builder.toString();
	}
 
    
}
