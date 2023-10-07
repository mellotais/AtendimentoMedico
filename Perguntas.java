package AtendimentoMedico;

import java.util.ArrayList;

class Perguntas {
    private String pergunta;
    private int peso;

    public Perguntas(String pergunta, int peso) {
        this.pergunta = pergunta;
        this.peso = peso;
    }


    
    public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	
	public static String calcularPrioridade(ArrayList<Perguntas> perguntas) {
	    int somaPesos = 0;
	    int somaMaxima = 5; 

	    for (Perguntas pergunta : perguntas) {
	        somaPesos += pergunta.getPeso();
	    }

	    double percentual = ((double) somaPesos * 100.0)/somaMaxima;

	    //return  Double.toString(percentual);
	    
	    if (percentual >= 25.0) {
	        return "Não Urgente";
	    } else if (percentual >= 50.0 && percentual <= 25.0) {
	        return "Pouco Urgente";
	    } else if (percentual >= 75.0 && percentual <=50.0) {
	        return "Urgente";
	    } else {
	        return "Emergência";
	    }
	    
	    
	}

}
