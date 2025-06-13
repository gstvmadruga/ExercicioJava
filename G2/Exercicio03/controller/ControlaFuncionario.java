package controller;

import modell.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioController() {
        this.funcionarios = new ArrayList<>();
    }

    public void cadastrarFuncionario(Funcionario funcionario) throws EntradaInvalidaException {
        if (funcionario == null) {
            throw new EntradaInvalidaException("Funcionário não pode ser nulo.");
        }
        // Validação de matrícula única
        for (Funcionario f : funcionarios) {
            if (f.getMatricula().equals(funcionario.getMatricula())) {
                throw new EntradaInvalidaException("Matrícula já existente.");
            }
        }
        this.funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public List<Funcionario> listarFuncionarios() {
        return new ArrayList<>(this.funcionarios);
    }

    public Funcionario buscarFuncionario(String termoBusca) throws FuncionarioNaoEncontradoException {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equalsIgnoreCase(termoBusca) || f.getMatricula().equals(termoBusca)) {
                return f;
            }
        }
        throw new FuncionarioNaoEncontradoException("Funcionário não encontrado: " + termoBusca);
    }

    public void atualizarFuncionario(String matricula, Funcionario funcionarioAtualizado) throws FuncionarioNaoEncontradoException, EntradaInvalidaException {
        Funcionario funcionarioExistente = null;
        int index = -1;
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getMatricula().equals(matricula)) {
                funcionarioExistente = funcionarios.get(i);
                index = i;
                break;
            }
        }

        if (funcionarioExistente == null) {
            throw new FuncionarioNaoEncontradoException("Funcionário com matrícula " + matricula + " não encontrado para atualização.");
        }

        if (funcionarioAtualizado == null) {
            throw new EntradaInvalidaException("Dados do funcionário atualizado não podem ser nulos.");
        }

        // Validação para garantir que a matrícula não seja alterada para uma já existente (exceto a própria)
        for (Funcionario f : funcionarios) {
            if (!f.getMatricula().equals(matricula) && f.getMatricula().equals(funcionarioAtualizado.getMatricula())) {
                throw new EntradaInvalidaException("Nova matrícula já existente para outro funcionário.");
            }
        }

        this.funcionarios.set(index, funcionarioAtualizado);
        System.out.println("Funcionário atualizado com sucesso!");
    }

    public void removerFuncionario(String matricula) throws FuncionarioNaoEncontradoException {
        Funcionario funcionarioParaRemover = null;
        for (Funcionario f : funcionarios) {
            if (f.getMatricula().equals(matricula)) {
                funcionarioParaRemover = f;
                break;
            }
        }

        if (funcionarioParaRemover == null) {
            throw new FuncionarioNaoEncontradoException("Funcionário com matrícula " + matricula + " não encontrado para remoção.");
        }

        this.funcionarios.remove(funcionarioParaRemover);
        System.out.println("Funcionário removido com sucesso!");
    }
}

