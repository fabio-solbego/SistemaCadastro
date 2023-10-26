package br.ulbra.sistemacadastro;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaListagemUsuarios {
    MainActivity act;
    TelaPrincipal tela_principal;
    Button  btnAnterior, btnProximo, btnFechar;

    TextView txtNome, txtTelefone, txtEndereco, txtStatus;
    int index;

    public  TelaListagemUsuarios(MainActivity act, TelaPrincipal tela_principal){
        this.act = act;
        this.tela_principal = tela_principal;
        index = 0;
    }
    public void carregarTela(){
        if(act.getRegistros().size() == 0){
            new AlertDialog.Builder(act)
                    .setTitle("Aviso")
                    .setMessage("Não exite nenhum registro cadastrado.")
                    .setNeutralButton("Ok", null).show();
            return;
        }
        act.setContentView(R.layout.tela_listagem);
        btnAnterior = (Button) act.findViewById(R.id.btnAnterior);
        btnProximo = (Button)act.findViewById(R.id.btnProximo);
        btnFechar = (Button) act.findViewById(R.id.btnFechar);
        txtNome = (TextView) act.findViewById(R.id.txtNomeUsu);
        txtEndereco = (TextView) act.findViewById(R.id.txtEndUsu);
        txtTelefone = (TextView) act.findViewById(R.id.txtTelUsu);
        txtStatus = (TextView) act.findViewById(R.id.txtStatus);
        preencheCampos(index);
        atualizaStatus(index);
        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index > 0){
                    index--;
                    preencheCampos(index);
                    atualizaStatus(index);

                }
            }
        });
        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index < act.getRegistros().size() - 1){
                    index++;
                    preencheCampos(index);
                    atualizaStatus(index);
                }
            }
        });
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tela_principal.CarregarTela();
            }
        });
    }
    private void preencheCampos(int idx){
        txtNome.setText(act.getRegistros().get(idx).getNome());
        txtTelefone.setText(act.getRegistros().get(idx).getTelefone());
        txtEndereco.setText(act.getRegistros().get(idx).getEndereco());
    }
    private void atualizaStatus(int idx){
        int total = act.getRegistros().size();
        txtStatus.setText("Registros: " + (idx+1) + "/" + total);
    }
}
