package controller;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioController() {
        funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario f) throws EntradaInvalidaException {
        if (f == null || f.getNome() == null || f.getNome().isEmpty() || f.getMatricula() <= 0) {
            throw new EntradaInvalidaException("Dados inválidos para o funcionário.");
        }
        funcionarios.add(f);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public Funcionario buscarPorMatricula(int matricula) throws FuncionarioNaoEncontradoException {
        return funcionarios.stream()
                .filter(f -> f.getMatricula() == matricula)
                .findFirst()
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário com matrícula " + matricula + " não encontrado."));
    }

    public List<Funcionario> buscarPorNome(String nome) {
        List<Funcionario> encontrados = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            if (f.getNome().toLowerCase().contains(nome.toLowerCase())) {
                encontrados.add(f);
            }
        }
        return encontrados;
    }

    public void atualizarFuncionario(int matricula, Funcionario novoFuncionario) throws FuncionarioNaoEncontradoException, EntradaInvalidaException {
        Funcionario antigo = buscarPorMatricula(matricula);
        if (novoFuncionario == null || novoFuncionario.getNome() == null || novoFuncionario.getNome().isEmpty()) {
            throw new EntradaInvalidaException("Dados inválidos para atualização.");
        }
        antigo.setNome(novoFuncionario.getNome());
        antigo.setMatricula(novoFuncionario.getMatricula());
        if (antigo instanceof Efetivo && novoFuncionario instanceof Efetivo) {
            ((Efetivo) antigo).setSalarioBase(((Efetivo) novoFuncionario).getSalarioBase());
        } else if (antigo instanceof Temporario && novoFuncionario instanceof Temporario) {
            ((Temporario) antigo).setValorHora(((Temporario) novoFuncionario).getValorHora());
            ((Temporario) antigo).setHorasTrabalhadas(((Temporario) novoFuncionario).getHorasTrabalhadas());
        } else if (antigo instanceof Terceirizado && novoFuncionario instanceof Terceirizado) {
            ((Terceirizado) antigo).setValorContrato(((Terceirizado) novoFuncionario).getValorContrato());
        }
    }

    public void removerFuncionario(int matricula) throws FuncionarioNaoEncontradoException {
        Funcionario f = buscarPorMatricula(matricula);
        funcionarios.remove(f);
    }
}

