package controller;

import model.*;
import java.util.*;

public class FuncionarioController {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public Funcionario buscarPorMatricula(String matricula) throws FuncionarioNaoEncontradoException {
        return funcionarios.stream()
                .filter(f -> f.getMatricula().equalsIgnoreCase(matricula))
                .findFirst()
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário não encontrado."));
    }

    public void removerFuncionario(String matricula) throws FuncionarioNaoEncontradoException {
        Funcionario f = buscarPorMatricula(matricula);
        funcionarios.remove(f);
    }

    public void atualizarFuncionario(String matricula, String... novosDados) throws FuncionarioNaoEncontradoException {
        Funcionario f = buscarPorMatricula(matricula);
        f.atualizarDados(novosDados);
    }
}
