package exemplos.banco;

import banco.entidades.ContaSimples;
import banco.entidades.util.RecebeDados;

/* Programa chamado Banco5
 * O usuário deve usar assim: java Banco5 <titular> <CPF> <numeroDaConta>
 * Crie a conta
 * (L) Peça para o usuário digitar a opcao desejada:
    1. Depositar
    2. Sacar
    3. Saldo
    4. Sair
     * Realize o desejo do usuário
    => se ele quer sacar, pergunte quanto e saque...
 * Fique neste loop (L) até que o usuário deseje sair do programa.
 * Antes de terminar o programa imprima o saldo final da conta. */
public class Banco5 {

    public static void main(String args[]) {
        //quando usamos final dizemos que essa variável não pode mudar de valor,
        // é uma constante
        final int DEPOSITAR = 1;
        final int SACAR = 2;
        final int SALDO = 3;
        final int SAIR = 4;
        // o caractere de fim de linha pode ser diferente de um sistema para
        // outro exemplo: "\r\n" no MSDOS/Windows, "\n" no UNIX, "\r" no
        // MacIntosh, etc. Por isso recuperamos o do sistema
        final String fimDeLinha = System.getProperty("line.separator");
        final String prompt = "Digite a opcao desejada:" + fimDeLinha + DEPOSITAR + ". Depositar" + fimDeLinha + SACAR
                + ". Sacar" + fimDeLinha + SALDO + ". Saldo" + fimDeLinha + SAIR + ". Sair" + fimDeLinha + "Opcao: ";

        if (args.length != 2) {
            System.err.println("Sintaxe: java Banco5 titular cpf");
            System.exit(1);
        }

        ContaSimples aConta = new ContaSimples(args[0], args[1]);
        int opção = RecebeDados.recebeInteiro(prompt);

        while (opção != SAIR) {
            switch (opção) {
                case DEPOSITAR:
                    double valorADepositar = RecebeDados.recebeValorMaiorQueZero("Entre com o valor a depositar: ");
                    aConta.depositar(valorADepositar);
                    break;
                case SACAR:
                    double valorASacar = RecebeDados.recebeValorMaiorQueZero("Entre com o valor a sacar: ");
                    aConta.sacar(valorASacar);
                    break;
                case SALDO:
                    System.out.println("Saldo: " + aConta.getSaldoMonetário());
                    break;
                default:
                    System.err.println("Opcao " + opção + " desconhecida");
                    break;
            }
            // leia novamente para voltar ao início do laço
            opção = RecebeDados.recebeInteiro(prompt);
        }

        System.out.println("Saldo final: " + aConta.getSaldoMonetário());
    } // main
}