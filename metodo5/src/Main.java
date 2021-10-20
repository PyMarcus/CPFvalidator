import javax.swing.JOptionPane;

//validar um CPF via parâmetro
class Main {
    public static void main(String[] args) {
        String cpf = JOptionPane.showInputDialog("CPF: ");
        if (validaCpf(cpf)) {
            JOptionPane.showMessageDialog(null, "Válido");
        } else {
            JOptionPane.showMessageDialog(null, "Inválido");
        }
    }

    public static boolean validaCpf(String cpf) {
        int soma = 0, soma1 = 0;
        boolean v1 = false;
        boolean v2 = false;
        if (cpf.length() != 14) {
            return false;
        } else {
            int u = 0;
            int g = 10;
            while (cpf.charAt(u) != '-') {
                if (cpf.charAt(u) != '.') {
                    //System.out.println(g + " "+cpf.charAt(u));
                    soma = soma + Character.getNumericValue(cpf.charAt(u)) * g;
                    g--;
                }
                u++;

            }

            //System.out.println(soma);
            u = 0;
            g = 11;
            while (cpf.charAt(u) != '-') {
                if (cpf.charAt(u) != '.') {
                    soma1 = soma1 + Character.getNumericValue(cpf.charAt(u)) * g;
                    g--;
                }
                if (cpf.charAt(u + 1) == '-') {
                    soma1 = soma1 + Character.getNumericValue(cpf.charAt(u + 2)) * g;
                }
                u++;

            }

            int numero = 0;
            // verifica o primeiro número depois de -
            int valor = (soma * 10 % 11);

            for (int i = 0; i < cpf.length(); i++) {
                if (cpf.charAt(i) == '-') {
                    numero = Character.getNumericValue(cpf.charAt(i + 1));
                    //  System.out.print(numero);
                }
                if (numero == valor) {
                    v1 = true;
                }

            }
            int valor1 = (soma1 * 10 % 11);
            for (int i = 0; i < cpf.length(); i++) {
                if (cpf.charAt(i) == '-') {
                    numero = Character.getNumericValue(cpf.charAt(i + 2));
                    //  System.out.println(numero);
                    if (numero == valor1) v2 = true;
                }
            }

        }
        return v1 && v2;
    }
}



