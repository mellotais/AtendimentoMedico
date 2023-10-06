package AtendimentoMedico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaDeAtendimentos {
    private ArrayList<Atendimento> atendimentos;

    public ListaDeAtendimentos() {
        this.atendimentos = new ArrayList<Atendimento>();
    }

    public ArrayList<Atendimento> getAtendimentos() {
        return this.atendimentos;
    }

    public void addAtendimento(Atendimento atendimento) {
        this.atendimentos.add(atendimento);
    }

    public void removeAtendimento(Atendimento atendimento) {
        this.atendimentos.remove(atendimento);
    }

    public void ordenarPorPrioridade() {
        Collections.sort(this.atendimentos, new Comparator<Atendimento>() {
            @Override
            public int compare(Atendimento a1, Atendimento a2) {
                return a1.getPrioridade().compareTo(a2.getPrioridade());
            }
        });
    }
}
