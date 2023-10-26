package br.ulbra.sistemacadastro;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

public class TelaCadastroUsuario {
    MainActivity act;
    EditText edtNome, edtEndereco, edtTelefone;

    Button btnCadastrar, btnCancelarCadastro;

    TelaPrincipal tela_principal;


    public  TelaCadastroUsuario(MainActivity act, TelaPrincipal tela_principal){
        this.act = act;
        this.tela_principal = tela_principal;
    }
    public void CarregarTela(){
        act.setContentView(R.layout.tela_cadastro);
        edtNome = (EditText)act.findViewById(R.id.edtNome);
        edtTelefone = (EditText)act.findViewById(R.id.edtTelefone);
        edtEndereco = (EditText)act.findViewById(R.id.edtEndereco);
        btnCadastrar = (Button) act.findViewById(R.id.btnCadastrar);
        btnCancelarCadastro = (Button) act.findViewById(R.id.btnCancelar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Cadastrar usuário? ");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nome = edtNome.getText().toString();
                        String telefone = edtTelefone.getText().toString();
                        String endereco = edtEndereco.getText().toString();
                        act.getRegistros().add(new Registro(nome, telefone, endereco));
                        act.exibirMensagem("Cadastro efetuado com sucesso.");
                        tela_principal.CarregarTela();
                    }
                });
    dialogo.show();
            }
        });
        
        btnCancelarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Sair do Cadastro");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tela_principal.CarregarTela();
                    }
                });
dialogo.show();
            }
        });
    }
}
