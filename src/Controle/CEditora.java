package Controle;

import java.util.ArrayList;
import Model.Editora;

public class CEditora {
    ArrayList<Editora> editoras = new ArrayList<>();
    int idEditora = 1;

    public int geraID() {
        return this.idEditora++;
    }

    public void addEditora(Editora e) {
        this.editoras.add(e);
    }

    public ArrayList<Editora> getEditoras() {
        return this.editoras;
    }

    public void removeEditora(Editora e) {
        this.editoras.remove(e);
    }

    public void mockEditora() {
        Editora e1 = new Editora();
        e1.setNomeEditora("Jovens Letras");
        e1.setCnpj("567890451");
        e1.setEndereco("Av. João Obino 300");
        e1.setTelefone("51291626718");
        e1.setGerente("Roberval da Silva");
        this.addEditora(e1);

        Editora e2 = new Editora();
        e2.setIdEditora(this.geraID());
        e2.setNomeEditora("Jair e Javir");
        e2.setCnpj("745087100");
        e2.setEndereco("Av. Bento Gonçalves 4169");
        e2.setTelefone("51201848048");
        e2.setGerente("Jair Ferraz");
        this.addEditora(e2);
    }

    public Editora getEditoraCNPJ(String cnpj) {
        Editora e = null;
        for (Editora editora : editoras) {
            if (editora.getcnpj().equals(cnpj)) {
                e = editora;
                break;
            }
        }
        return e;
    }
}