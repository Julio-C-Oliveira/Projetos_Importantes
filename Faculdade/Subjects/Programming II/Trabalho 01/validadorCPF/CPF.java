package validadorCPF;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPF {
    private final String cpf; // Armazena o CPF validado

    // Construtor que valida o CPF ao criar um novo objeto
    public CPF(String cpf) throws Exception {
        // Verifica se o formato do CPF é válido (11 dígitos)
        if (!validateAmountOfNumbers(cpf)) {
            throw new Exception("CPF INVÁLIDO: FORMATO INVÁLIDO");
        }
        // Verifica a validade do CPF pelo cálculo dos dígitos verificadores
        if (!validateCPF(cpf)) {
            throw new Exception("CPF INVÁLIDO: CÁLCULO INCORRETO");
        } else {
            this.cpf = cpf; // Atribui o CPF se for válido
        }
    }

    // Valida se o CPF tem exatamente 11 números
    private boolean validateAmountOfNumbers(String cpf) {
        String padrao = "[0-9]{11}"; // Regex para 11 dígitos numéricos
        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(cpf);
        return matcher.find(); // Retorna true se o CPF está no formato esperado
    }

    // Converte os caracteres do CPF em uma lista de inteiros
    private ArrayList<Integer> getNumbersAsIntegers(String cpf) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (char number : cpf.toCharArray()) { // Itera por cada caractere
            numbers.add(Integer.parseInt(String.valueOf(number))); // Converte para inteiro e adiciona à lista
        }
        return numbers;
    }

    // Valida o CPF pelo cálculo dos dígitos verificadores
    private boolean validateCPF(String cpf) {
        ArrayList<Integer> numbers = getNumbersAsIntegers(cpf); // Obtém os números do CPF como inteiros
        int sum = 0; // Soma acumulada para o cálculo do dígito
        int digitVerifier; // Armazena o dígito verificador calculado

        // Realiza a validação para os dois dígitos verificadores (repetição 2 vezes)
        for (int i = 2; i > 0; i--) {
            int count = numbers.size() - i + 1; // Determina o peso inicial
            for (int j = 0; j < numbers.size() - i; j++) {
                sum += numbers.get(j) * (count - j); // Soma os produtos dos números pelos pesos
            }

            // Determina o dígito verificador baseado no resto da divisão por 11
            if (sum % 11 >= 10) {
                digitVerifier = 0; // Se o resto for >= 10, o dígito é 0
            } else {
                digitVerifier = 11 - (sum % 11); // Caso contrário, aplica a fórmula
            }

            // Verifica se o dígito calculado bate com o do CPF
            boolean isValid = numbers.get(numbers.size() - i) == digitVerifier;
            if (!isValid) {
                return false; // Retorna falso se um dos dígitos não é válido
            }
            sum = 0; // Reseta a soma para o próximo dígito
        }
        return true; // Retorna verdadeiro se ambos os dígitos são válidos
    }

    // Método para obter o CPF validado
    public String getCPF() {
        return cpf;
    }
}
