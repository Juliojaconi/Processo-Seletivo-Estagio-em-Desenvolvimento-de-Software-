import java.util.ArrayList;
import java.util.List;

public class Main {

    private boolean senhaForteeDiferente(String senha, List<String> historicoSenhas, String nome){
        String caracteresEspeciais = "!@#$%&*";
        boolean temMaiuscula = false;
        boolean temNumero = false;
        boolean temMinuscula = false;
        boolean temEspecial = false;
        boolean diferenteAnteriores = false;
        List<String> ultimas3 = historicoSenhas.subList(Math.max(0, historicoSenhas.size() - 3), historicoSenhas.size());


        //Perconedo se tem maiuscula, numero e minúscula.  
        for (int i = 0; i < senha.length() ; i++) {
            char c = senha.charAt(i);
            if (Character.isUpperCase(c)) temMaiuscula = true;
            else if (Character.isDigit(c)) temNumero = true;
            else if (Character.isLowerCase(c)) temMinuscula = true;
        }
        //Percorrendo se tem caracteres especiais
        for (char s : senha.toCharArray()) {
           if (caracteresEspeciais.indexOf(s) >= 0) temEspecial = true;
        }
        //Verificando se é diferente das 3 anteriores senhas armazenadas.
        if (!ultimas3.contains(senha)) {
            diferenteAnteriores = true;
        }
        if (senha.toLowerCase().contains(nome.toLowerCase())) return false;
        if (senha.length() < 8) return false;
        return temMaiuscula && temNumero && temMinuscula && temEspecial && diferenteAnteriores ;


    }

    public static void main(String[] args)
    {
        Main main = new Main();
        List<String> historicoSenhas = new ArrayList<String>();
        historicoSenhas.add("123456");
        historicoSenhas.add("123456Carlos");
        historicoSenhas.add("Jgjsenha@123");
        historicoSenhas.add("Jgjsenha@1234");

        historicoSenhas.stream().forEach(System.out::println);
        System.out.println(main.senhaForteeDiferente("123456", historicoSenhas, "Carlos"));
        System.out.println(main.senhaForteeDiferente("Jgj900@", historicoSenhas, "Carlos"));
        System.out.println(main.senhaForteeDiferente("123Carlos@", historicoSenhas, "Carlos"));
        System.out.println(main.senhaForteeDiferente("Jgjsenha@123", historicoSenhas, "Carlos"));
        System.out.println(main.senhaForteeDiferente("Jgjsenha@1211", historicoSenhas, "teste"));

    }
}